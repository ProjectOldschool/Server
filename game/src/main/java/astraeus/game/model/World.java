// Generated by delombok at Sat Feb 25 09:19:11 PST 2017
package astraeus.game.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;
import astraeus.game.GameConstants;
import astraeus.game.event.Event;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.UniversalEventProvider;
import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.MobList;
import astraeus.game.model.entity.mob.npc.Npc;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.event.RegisterPlayerEvent;
import astraeus.game.task.Task;
import astraeus.game.task.TaskManager;
import astraeus.plugin.PluginService;
import astraeus.util.LoggerUtils;

/**
 * Represents the game world.
 *
 * @author Vult-R
 */
public final class World {
  
  /**
   * The single logger for this class.
   */
  public final Logger logger = LoggerUtils.getLogger(World.class);
  
  /**
   * The collection of players in the game world.
   */
  private static final MobList<Player> players = new MobList<Player>(GameConstants.MAX_PLAYERS);
  
  /**
   * The collection of npcs in the game world.
   */
  private static final MobList<Npc> npcs = new MobList<Npc>(GameConstants.MAX_NPC_SPAWNS);
  
  /**
   * The {@link Set} of banned hosts.
   */
  private static final Set<String> ipBans = new HashSet<>();
  
  /**
   * The {@link Set} of banned mac addresses.
   */
  private static final Set<String> bannedUUIDs = new HashSet<>();
  
  /**
   * The {@link Player}s waiting to login.
   */
  private static final Queue<Player> logins = new ConcurrentLinkedQueue<>();
  
  /**
   * The {@link Player}s waiting to logout.
   */
  private static final Queue<Player> logouts = new ConcurrentLinkedQueue<>();
  
  /**
   * This worlds event provider.
   */
  private static final UniversalEventProvider eventProvider = new UniversalEventProvider();
  
  /**
   * The service for plugins.
   */
  private static final PluginService pluginService = new PluginService();
  
  /**
   * The tasks for this world.
   */
  private static final TaskManager tasks = new TaskManager();
  private final int id;
  private final int port;
  
  public World(int id) {
    this.id = id;
    this.port = 43593 + id;
  }
  
  /**
   * Registers and adds a {@code entity) into the game world.
   *
   * @param entity The entity to add.
   */
  public static void register(Mob entity) {
    // check to make this entity is not registered already, and is present.
    if (entity == null || entity.isRegistered()) {
      return;
    }
    if (entity.isPlayer()) {
      Player player = (Player)entity;
      player.setId(-1);
      players.add(player);
    }
  }
  
  /**
   * Deregisters a {@link Mob} from the game world.
   *
   * @param entity The entity to remove.
   */
  public static void deregister(Mob entity) {
    if (entity == null || !entity.isRegistered()) {
      return;
    }
    if (entity.isPlayer()) {
      players.remove(entity);
    } else {
      npcs.remove(entity);
    }
  }
  
  /**
   * The function that makes a player wait until they can be added into the game.
   *
   * @param player
   */
  public static void queueLogin(Player player) {
    if (player.getSession() != null && !logins.contains(player)) {
      logins.add(player);
    }
  }
  
  /**
   * The function that allows players to login.
   */
  public static void dequeueLogin() {
    for (int index = 0; index < GameConstants.LOGIN_LIMIT; index++) {
      Player player = logins.poll();
      if (player == null) {
        break;
      }
      post(player, new RegisterPlayerEvent(player));
    }
  }
  
  /**
   * The function that makes a player wait until they can be logged out in sync with the server.
   *
   * @param player
   */
  public static void queueLogout(Player player) {
    if (player != null && !logouts.contains(player)) {
      logouts.add(player);
    }
  }
  
  /**
   * The function that logs out players from the game world.
   */
  public static void dequeueLogout() {
    for (int index = 0; index < logouts.size(); index++) {
      Player player = logouts.poll();
      if (player == null || index >= GameConstants.LOGOUT_LIMIT) {
        break;
      }
      player.onDeregister();
    }
  }
  
  /**
   * Searches the collection of players and retrieves the player with the specified name
   *
   * @param name
   */
  public static Optional<Player> searchPlayer(String name) {
    return players.stream().filter(Objects::nonNull).filter(it -> name.equalsIgnoreCase(it.getUsername())).findFirst();
  }
  
  /**
   * Posts an event to this worlds event provider.
   *
   * @param player The player to post the event for.
   * @param event The event to post.
   */
  public static <E extends Event> void post(Player player, E event) {
    eventProvider.post(player, event);
  }
  
  /**
   * Provides an event subscriber to this worlds event provider.
   *
   * @param subscriber The event subscriber.
   */
  public static <E extends Event> void provideSubscriber(EventSubscriber<E> subscriber) {
    eventProvider.provideSubscriber(subscriber);
  }
  
  /**
   * Deprives an event subscriber to this worlds event provider.
   *
   * @param subscriber The event subscriber.
   */
  public static <E extends Event> void depriveSubscriber(EventSubscriber<E> subscriber) {
    eventProvider.depriveSubscriber(subscriber);
  }
  
  /**
   * Submits a new {@link Task}.
   *
   * @param task The task to execute.
   */
  public static void submit(Task task) {
    tasks.queue(task);
  }
  
  /**
   * The collection of players in the game world.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static MobList<Player> getPlayers() {
    return World.players;
  }
  
  /**
   * The collection of npcs in the game world.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static MobList<Npc> getNpcs() {
    return World.npcs;
  }
  
  /**
   * The {@link Set} of banned hosts.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static Set<String> getIpBans() {
    return World.ipBans;
  }
  
  /**
   * The {@link Set} of banned mac addresses.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static Set<String> getBannedUUIDs() {
    return World.bannedUUIDs;
  }
  
  /**
   * The {@link Player}s waiting to login.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static Queue<Player> getLogins() {
    return World.logins;
  }
  
  /**
   * The {@link Player}s waiting to logout.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static Queue<Player> getLogouts() {
    return World.logouts;
  }
  
  /**
   * This worlds event provider.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static UniversalEventProvider getEventProvider() {
    return World.eventProvider;
  }
  
  /**
   * The service for plugins.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static PluginService getPluginService() {
    return World.pluginService;
  }
  
  /**
   * The tasks for this world.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static TaskManager getTasks() {
    return World.tasks;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int getId() {
    return this.id;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int getPort() {
    return this.port;
  }
}
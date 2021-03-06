// Generated by delombok at Sat Feb 25 09:19:10 PST 2017
package astraeus.game.model.entity.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import astraeus.game.model.Position;
import astraeus.game.model.entity.item.Item;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.net.packet.out.AddObjectPacket;

/**
 * The class that provides static utility methods for {@link GameObject}s.
 *
 * @author Seven
 */
public final class GameObjects {

  
  /**
   * The list of global object spawned in the game world.
   */
  private static final List<GameObject> globalObjects = new ArrayList<>();
  
  /**
   * A map of ground items and their positions in the world.
   */
  private static final Map<Position, Item[]> groundItems = new HashMap<>();

  /**
   * The method that creates global objects for a user.
   *
   * @param player The player to create the global objects for.
   */
  public static final void createGlobalObjects(Player player) {
    globalObjects.stream().filter(Objects::nonNull).filter($it -> $it.getPosition().isWithinDistance(player.getPosition(), 32)).forEach($it -> player.queuePacket(new AddObjectPacket($it, true)));
  }

  /**
   * The list of global object spawned in the game world.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static List<GameObject> getGlobalObjects() {
    return GameObjects.globalObjects;
  }

  /**
   * A map of ground items and their positions in the world.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public static Map<Position, Item[]> getGroundItems() {
    return GameObjects.groundItems;
  }
}
package astraeus.game.model.entity.mob.combat.task;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import astraeus.game.model.Animation;
import astraeus.game.model.World;
import astraeus.game.model.entity.item.Item;
import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.combat.def.NpcCombatDefinition;
import astraeus.game.model.entity.mob.npc.NpcSpawn;
import astraeus.game.model.entity.mob.npc.Npcs;
import astraeus.game.model.entity.mob.npc.drop.NpcDrop;
import astraeus.game.model.entity.mob.npc.drop.NpcDrop.Drop;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.object.GameObjects;
import astraeus.game.task.Task;
import astraeus.net.packet.out.AddGroundItemPacket;
import astraeus.util.RandomUtils;

public final class MobDeathTask extends Task {

  private final Mob attacker;
  private final Mob victim;  
  
  private final NpcSpawn spawn;

  private final Optional<NpcCombatDefinition> npcCombatDef;
  
  private final int spawnTime;
  
  private final Optional<Drop[]> drop;
  
  private int timer = 0;
  
  public MobDeathTask(Mob attacker, Mob victim) {    
    super(0, true);
    this.attacker= attacker;
    this.victim = victim;
    this.spawn = victim.isNpc() ? new NpcSpawn(victim.getId(), victim.getCreatedPosition()) : null;
    this.npcCombatDef = victim.isNpc() ? NpcCombatDefinition.lookup(victim.getId()) : Optional.empty();
    this.spawnTime = victim.isNpc() ? npcCombatDef.isPresent() ? npcCombatDef.get().getRespawnTime() : 20 : 0;
    this.drop = victim.isNpc() ? NpcDrop.lookup(victim.getId()) : Optional.empty();
  }

  @Override
  public void execute() {
    
    System.out.println("tick: " + timer);
    
    switch (timer) {
      
      case 1:
        int deathAnimation = victim.getCombat().getDeathAnimation();
        victim.startAnimation(new Animation(deathAnimation));
        break;
        
      case 4:
       World.deregister(victim);
        break;
        
      case 5:
        drop.ifPresent(it -> {
          
          Set<Item> items = new HashSet<>();
          
          Arrays.stream(it).forEach(d -> {            
            
            int random = RandomUtils.random(1, d.getRate());
            
            if (random == d.getRate()) {
            
              if (attacker.isPlayer()) {
                
                Player player = attacker.getPlayer();
                
                Item item = new Item(d.getItemId(), d.isSingle() ? 1 : d.isFixed() ? d.getMaxAmount() : RandomUtils.random(1, d.getMaxAmount()));
                
                player.queuePacket(new AddGroundItemPacket(victim.getPosition().copy(), item));
                
                items.add(item);
              }
              
            }
            
          });
          
          GameObjects.getGroundItems().put(victim.getPosition().copy(), new ArrayList<Item>(items));
          
        });
        break;
        
        default:          
          break;
      
    }
    
    // respawn again
    if (timer >= spawnTime) {
      Npcs.createSpawn(spawn);
      stop();
    }

    timer++;

  }

}

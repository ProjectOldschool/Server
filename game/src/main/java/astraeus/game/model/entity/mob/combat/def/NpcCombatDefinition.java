// Generated by delombok at Sat Feb 25 09:19:06 PST 2017
package astraeus.game.model.entity.mob.combat.def;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import astraeus.game.model.entity.mob.player.skill.SkillData;

public final class NpcCombatDefinition {
  public static final Map<Integer, NpcCombatDefinition> definitions = new HashMap<>();
  
  public static enum ImmuneType {
    POISON,
    VENOM,
    BOTH,
    NONE;
    
  }
  private final int id;
  private final String name;
  private final int hitpoints;
  private final boolean aggressive;
  private final boolean poisonous;
  private final int attackSpeed;
  private final int[] hitDelays;
  private final int maxHit;
  private final int respawnTime;
  private final int defenceAnimation;
  private final int deathAnimation;
  private final int[] attackAnimations;
  private final ImmuneType immunity;
  private final SkillData[] weakness;
  private final NpcCombatBonus bonuses;
  
  public NpcCombatDefinition(int id, String name, int hitpoints, boolean aggressive, boolean poisonous, int attackSpeed, int[] hitDelays, int maxHit, int respawnTime, int defenceAnimation, int deathAnimation, int[] attackAnimations, ImmuneType immunity, SkillData[] weakness, NpcCombatBonus bonuses) {
    this.id = id;
    this.name = name;
    this.hitpoints = hitpoints;
    this.aggressive = aggressive;
    this.poisonous = poisonous;
    this.attackSpeed = attackSpeed;
    this.hitDelays = hitDelays;
    this.maxHit = maxHit;
    this.respawnTime = respawnTime;
    this.defenceAnimation = defenceAnimation;
    this.deathAnimation = deathAnimation;
    this.attackAnimations = attackAnimations;
    this.immunity = immunity;
    this.weakness = weakness;
    this.bonuses = bonuses;
  }
  
  public static Optional<NpcCombatDefinition> lookup(int id) {
    return Optional.ofNullable(definitions.get(id));
  }
  
  public static final class NpcCombatBonus {
    private final CombatBonus combat;
    private final AggressiveBonus aggressive;
    private final DefensiveBonus defensive;
    private final OtherBonus other;
    
    public NpcCombatBonus(CombatBonus combat, AggressiveBonus aggressive, DefensiveBonus defensive, OtherBonus other) {
      this.combat = combat;
      this.aggressive = aggressive;
      this.defensive = defensive;
      this.other = other;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CombatBonus getCombat() {
      return this.combat;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public AggressiveBonus getAggressive() {
      return this.aggressive;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public DefensiveBonus getDefensive() {
      return this.defensive;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public OtherBonus getOther() {
      return this.other;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof NpcCombatDefinition.NpcCombatBonus)) return false;
      final NpcCombatBonus other = (NpcCombatBonus)o;
      final java.lang.Object this$combat = this.getCombat();
      final java.lang.Object other$combat = other.getCombat();
      if (this$combat == null ? other$combat != null : !this$combat.equals(other$combat)) return false;
      final java.lang.Object this$aggressive = this.getAggressive();
      final java.lang.Object other$aggressive = other.getAggressive();
      if (this$aggressive == null ? other$aggressive != null : !this$aggressive.equals(other$aggressive)) return false;
      final java.lang.Object this$defensive = this.getDefensive();
      final java.lang.Object other$defensive = other.getDefensive();
      if (this$defensive == null ? other$defensive != null : !this$defensive.equals(other$defensive)) return false;
      final java.lang.Object this$other = this.getOther();
      final java.lang.Object other$other = other.getOther();
      if (this$other == null ? other$other != null : !this$other.equals(other$other)) return false;
      return true;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $combat = this.getCombat();
      result = result * PRIME + ($combat == null ? 0 : $combat.hashCode());
      final java.lang.Object $aggressive = this.getAggressive();
      result = result * PRIME + ($aggressive == null ? 0 : $aggressive.hashCode());
      final java.lang.Object $defensive = this.getDefensive();
      result = result * PRIME + ($defensive == null ? 0 : $defensive.hashCode());
      final java.lang.Object $other = this.getOther();
      result = result * PRIME + ($other == null ? 0 : $other.hashCode());
      return result;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "NpcCombatDefinition.NpcCombatBonus(combat=" + this.getCombat() + ", aggressive=" + this.getAggressive() + ", defensive=" + this.getDefensive() + ", other=" + this.getOther() + ")";
    }
  }
  
  public static final class AggressiveBonus {
    private final int stab;
    private final int slash;
    private final int crush;
    private final int magic;
    private final int range;
    
    public AggressiveBonus(int stab, int slash, int crush, int magic, int range) {
      this.stab = stab;
      this.slash = slash;
      this.crush = crush;
      this.magic = magic;
      this.range = range;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getStab() {
      return this.stab;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getSlash() {
      return this.slash;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getCrush() {
      return this.crush;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getMagic() {
      return this.magic;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getRange() {
      return this.range;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof NpcCombatDefinition.AggressiveBonus)) return false;
      final AggressiveBonus other = (AggressiveBonus)o;
      if (this.getStab() != other.getStab()) return false;
      if (this.getSlash() != other.getSlash()) return false;
      if (this.getCrush() != other.getCrush()) return false;
      if (this.getMagic() != other.getMagic()) return false;
      if (this.getRange() != other.getRange()) return false;
      return true;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + this.getStab();
      result = result * PRIME + this.getSlash();
      result = result * PRIME + this.getCrush();
      result = result * PRIME + this.getMagic();
      result = result * PRIME + this.getRange();
      return result;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "NpcCombatDefinition.AggressiveBonus(stab=" + this.getStab() + ", slash=" + this.getSlash() + ", crush=" + this.getCrush() + ", magic=" + this.getMagic() + ", range=" + this.getRange() + ")";
    }
  }
  
  public static final class DefensiveBonus {
    private final int stab;
    private final int slash;
    private final int crush;
    private final int magic;
    private final int range;
    
    public DefensiveBonus(int stab, int slash, int crush, int magic, int range) {
      this.stab = stab;
      this.slash = slash;
      this.crush = crush;
      this.magic = magic;
      this.range = range;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getStab() {
      return this.stab;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getSlash() {
      return this.slash;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getCrush() {
      return this.crush;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getMagic() {
      return this.magic;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getRange() {
      return this.range;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof NpcCombatDefinition.DefensiveBonus)) return false;
      final DefensiveBonus other = (DefensiveBonus)o;
      if (this.getStab() != other.getStab()) return false;
      if (this.getSlash() != other.getSlash()) return false;
      if (this.getCrush() != other.getCrush()) return false;
      if (this.getMagic() != other.getMagic()) return false;
      if (this.getRange() != other.getRange()) return false;
      return true;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + this.getStab();
      result = result * PRIME + this.getSlash();
      result = result * PRIME + this.getCrush();
      result = result * PRIME + this.getMagic();
      result = result * PRIME + this.getRange();
      return result;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "NpcCombatDefinition.DefensiveBonus(stab=" + this.getStab() + ", slash=" + this.getSlash() + ", crush=" + this.getCrush() + ", magic=" + this.getMagic() + ", range=" + this.getRange() + ")";
    }
  }
  
  public static final class CombatBonus {
    private final int attack;
    private final int strength;
    private final int defence;
    private final int range;
    private final int magic;
    
    public CombatBonus(int attack, int strength, int defence, int range, int magic) {
      this.attack = attack;
      this.strength = strength;
      this.defence = defence;
      this.range = range;
      this.magic = magic;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getAttack() {
      return this.attack;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getStrength() {
      return this.strength;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getDefence() {
      return this.defence;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getRange() {
      return this.range;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getMagic() {
      return this.magic;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof NpcCombatDefinition.CombatBonus)) return false;
      final CombatBonus other = (CombatBonus)o;
      if (this.getAttack() != other.getAttack()) return false;
      if (this.getStrength() != other.getStrength()) return false;
      if (this.getDefence() != other.getDefence()) return false;
      if (this.getRange() != other.getRange()) return false;
      if (this.getMagic() != other.getMagic()) return false;
      return true;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + this.getAttack();
      result = result * PRIME + this.getStrength();
      result = result * PRIME + this.getDefence();
      result = result * PRIME + this.getRange();
      result = result * PRIME + this.getMagic();
      return result;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "NpcCombatDefinition.CombatBonus(attack=" + this.getAttack() + ", strength=" + this.getStrength() + ", defence=" + this.getDefence() + ", range=" + this.getRange() + ", magic=" + this.getMagic() + ")";
    }
  }
  
  public static final class OtherBonus {
    private final int strength;
    private final int rangedStrength;
    private final int attack;
    
    public OtherBonus(int strength, int rangedStrength, int attack) {
      this.strength = strength;
      this.rangedStrength = rangedStrength;
      this.attack = attack;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getStrength() {
      return this.strength;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getRangedStrength() {
      return this.rangedStrength;
    }
    
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getAttack() {
      return this.attack;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof NpcCombatDefinition.OtherBonus)) return false;
      final OtherBonus other = (OtherBonus)o;
      if (this.getStrength() != other.getStrength()) return false;
      if (this.getRangedStrength() != other.getRangedStrength()) return false;
      if (this.getAttack() != other.getAttack()) return false;
      return true;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + this.getStrength();
      result = result * PRIME + this.getRangedStrength();
      result = result * PRIME + this.getAttack();
      return result;
    }
    
    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "NpcCombatDefinition.OtherBonus(strength=" + this.getStrength() + ", rangedStrength=" + this.getRangedStrength() + ", attack=" + this.getAttack() + ")";
    }
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int getId() {
    return this.id;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public String getName() {
    return this.name;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int getHitpoints() {
    return this.hitpoints;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public boolean isAggressive() {
    return this.aggressive;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public boolean isPoisonous() {
    return this.poisonous;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int getAttackSpeed() {
    return this.attackSpeed;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int[] getHitDelays() {
    return this.hitDelays;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int getMaxHit() {
    return this.maxHit;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int getRespawnTime() {
    return this.respawnTime;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int getDefenceAnimation() {
    return this.defenceAnimation;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int getDeathAnimation() {
    return this.deathAnimation;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int[] getAttackAnimations() {
    return this.attackAnimations;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public ImmuneType getImmunity() {
    return this.immunity;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public SkillData[] getWeakness() {
    return this.weakness;
  }
  
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public NpcCombatBonus getBonuses() {
    return this.bonuses;
  }
  
  @java.lang.Override
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public boolean equals(final java.lang.Object o) {
    if (o == this) return true;
    if (!(o instanceof NpcCombatDefinition)) return false;
    final NpcCombatDefinition other = (NpcCombatDefinition)o;
    if (this.getId() != other.getId()) return false;
    final java.lang.Object this$name = this.getName();
    final java.lang.Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
    if (this.getHitpoints() != other.getHitpoints()) return false;
    if (this.isAggressive() != other.isAggressive()) return false;
    if (this.isPoisonous() != other.isPoisonous()) return false;
    if (this.getAttackSpeed() != other.getAttackSpeed()) return false;
    if (!java.util.Arrays.equals(this.getHitDelays(), other.getHitDelays())) return false;
    if (this.getMaxHit() != other.getMaxHit()) return false;
    if (this.getRespawnTime() != other.getRespawnTime()) return false;
    if (this.getDefenceAnimation() != other.getDefenceAnimation()) return false;
    if (this.getDeathAnimation() != other.getDeathAnimation()) return false;
    if (!java.util.Arrays.equals(this.getAttackAnimations(), other.getAttackAnimations())) return false;
    final java.lang.Object this$immunity = this.getImmunity();
    final java.lang.Object other$immunity = other.getImmunity();
    if (this$immunity == null ? other$immunity != null : !this$immunity.equals(other$immunity)) return false;
    if (!java.util.Arrays.deepEquals(this.getWeakness(), other.getWeakness())) return false;
    final java.lang.Object this$bonuses = this.getBonuses();
    final java.lang.Object other$bonuses = other.getBonuses();
    if (this$bonuses == null ? other$bonuses != null : !this$bonuses.equals(other$bonuses)) return false;
    return true;
  }
  
  @java.lang.Override
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + this.getId();
    final java.lang.Object $name = this.getName();
    result = result * PRIME + ($name == null ? 0 : $name.hashCode());
    result = result * PRIME + this.getHitpoints();
    result = result * PRIME + (this.isAggressive() ? 79 : 97);
    result = result * PRIME + (this.isPoisonous() ? 79 : 97);
    result = result * PRIME + this.getAttackSpeed();
    result = result * PRIME + java.util.Arrays.hashCode(this.getHitDelays());
    result = result * PRIME + this.getMaxHit();
    result = result * PRIME + this.getRespawnTime();
    result = result * PRIME + this.getDefenceAnimation();
    result = result * PRIME + this.getDeathAnimation();
    result = result * PRIME + java.util.Arrays.hashCode(this.getAttackAnimations());
    final java.lang.Object $immunity = this.getImmunity();
    result = result * PRIME + ($immunity == null ? 0 : $immunity.hashCode());
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getWeakness());
    final java.lang.Object $bonuses = this.getBonuses();
    result = result * PRIME + ($bonuses == null ? 0 : $bonuses.hashCode());
    return result;
  }
  
  @java.lang.Override
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public java.lang.String toString() {
    return "NpcCombatDefinition(id=" + this.getId() + ", name=" + this.getName() + ", hitpoints=" + this.getHitpoints() + ", aggressive=" + this.isAggressive() + ", poisonous=" + this.isPoisonous() + ", attackSpeed=" + this.getAttackSpeed() + ", hitDelays=" + java.util.Arrays.toString(this.getHitDelays()) + ", maxHit=" + this.getMaxHit() + ", respawnTime=" + this.getRespawnTime() + ", defenceAnimation=" + this.getDefenceAnimation() + ", deathAnimation=" + this.getDeathAnimation() + ", attackAnimations=" + java.util.Arrays.toString(this.getAttackAnimations()) + ", immunity=" + this.getImmunity() + ", weakness=" + java.util.Arrays.deepToString(this.getWeakness()) + ", bonuses=" + this.getBonuses() + ")";
  }
}
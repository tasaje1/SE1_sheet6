package at.aau.serg.exercises.gamelogic;

public class Character {
    public String name;

    public Integer level;

    /**
     * Allowed classes: Mage, Tank, DamageDealer
     */
    public String characterClass;

    public double damage;

    /**
     * Used for range and magic damage types, melee ignores this value
     */
    public int damageRange;

    /**
     * 1 := melee (tank always has this)
     * 2 := range
     * 3 := magic (only mage has this, always)
     */
    public short damageType;

    /**
     * None (null), fire, poison, pierce
     */
    public String damageEffect;

    /**
     * Indicates if a tank currently has their shield equipped
     */
    public boolean hasShieldEquipped;

    /**
     * Available mana of mage
     */
    public int mana;

    public String getDescription() {
        switch (characterClass) {
            case "Mage":
                return "Mage: A spellcaster who wields powerful magic.";
            case "Tank":
                return "Tank: A sturdy protector who absorbs damage and defends allies.";
            case "DamageDealer":
                return "Damage Dealer: A swift attacker who deals heavy damage.";
            default:
                throw new IllegalStateException("Unexpected character class: " + characterClass);
        }
    }

    public boolean hasMaxLevel(){
        return level.equals(30);
    }

}

package at.aau.serg.exercises.gamelogic.gameboard;

public class Enemy {

    public double health;
    public EnemyType type;
    public double speedMult;
    public int speed;
    public double damageMult;
    public double damage;
    public Position pos;

    public enum EnemyType{
        NORMAL,
        BOSS
    }

    public void initializeStats(double fieldDamageMultiplier, double fieldSpeedMultiplier) {
        if (type == EnemyType.BOSS) {
            damageMult = fieldDamageMultiplier * 1.5;
            speedMult = fieldSpeedMultiplier * 1.5;
        } else {
            damageMult = fieldDamageMultiplier;
            speedMult = fieldSpeedMultiplier;
        }
    }

}

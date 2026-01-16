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
}

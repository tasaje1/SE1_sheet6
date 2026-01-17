package at.aau.serg.exercises.gamelogic.gameboard;

import java.util.List;
import java.util.Random;

public class GameBoard {

    private final Type[][] board;
    private final double[][] damageMultiplier, walkingmultiplier;
    private final List<Enemy> enemyList;

    public GameBoard(List<Enemy> enemies) {
        board = new Type[5][5];
        damageMultiplier = new double[5][5];
        walkingmultiplier = new double[5][5];

        enemyList = enemies;
        initialize(enemies);
    }


    /*
    Cyclomatic Complexity vor Refactoring:
        - For Schleifen: +3
        - Switch Cases:  +3
        - If statements: +2
                         +1
     -------------------------------
                         9

     */
    private void initialize(List<Enemy> enemies) {
        // Initialize the board with random field types
        Random random = new Random();
        for (int row = 0; row < 5; row++) { //+1
            for (int col = 0; col < 5; col++) { //+1

                initializeField(row, col, random);
                System.out.print(board[row][col] + ", ");
            }
            System.out.println();
        }

        // place the enemies
        for (int i = 0; i < enemies.size(); i++) { //+1
            Enemy enemy = enemies.get(i);
            initializeEnemy(enemy, random);
        }

    }
    private void initializeField(int row, int col, Random random) {
        board[row][col] = Type.values()[random.nextInt(Type.values().length)];

        switch (board[row][col]) {
            case GRASS:
            case ROCK:
                walkingmultiplier[row][col] = 1;
                damageMultiplier[row][col] = 1;
                break;
            case WOODS:
                walkingmultiplier[row][col] = .7;
                damageMultiplier[row][col] = 1.2;
                break;
            case SPECIAL:
                damageMultiplier[row][col] = 2;
                break;
            default:
                walkingmultiplier[row][col] = 1;
                damageMultiplier[row][col] = 1;
        }
    }
    private void initializeEnemy(Enemy enemy, Random random) {
        if (enemy.health == 0) {
            return;
        }

        int x = random.nextInt(5);
        int y = random.nextInt(5);
        enemy.pos = new Position(x, y);

        if (enemy.type == Enemy.EnemyType.BOSS) {
            enemy.damageMult = damageMultiplier[x][y] * 1.5;
            enemy.speedMult = walkingmultiplier[x][y] * 1.5;
        } else {
            enemy.damageMult = damageMultiplier[x][y];
            enemy.speedMult = walkingmultiplier[x][y];
        }
    }



    // Enum for the field types
    public enum Type {
        GRASS,
        WOODS,
        ROCK,
        SPECIAL
    }

}


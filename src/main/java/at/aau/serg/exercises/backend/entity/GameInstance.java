package at.aau.serg.exercises.backend.entity;

import at.aau.serg.exercises.backend.dao.EntityWithId;

import java.util.Collections;
import java.util.List;

public class GameInstance extends EntityWithId<Long> {
    private Long id;
    private final String name;
    private final List<Player> players;
    private final GameMode gameMode;
    private final int totalRounds;
    private final boolean playTutorial;

    private boolean isRunning = false;
    private int remainingRounds;
    private Player leadingPlayer = null;
    private Player winner = null;

    public GameInstance(String name, GameMode gameMode, List<Player> players, int totalRounds, boolean playTutorial) {
        this.name = name;
        this.players = players;
        this.gameMode = gameMode;
        this.totalRounds = totalRounds;
        this.playTutorial = playTutorial;

        this.remainingRounds = totalRounds;
    }

    public GameInstance(Long id, String name, GameMode gameMode, List<Player> players, int totalRounds, boolean playTutorial) {
        this(name, gameMode, players, totalRounds, playTutorial);
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getRemainingRounds() {
        return remainingRounds;
    }

    public void setRemainingRounds(int remainingRounds) {
        this.remainingRounds = remainingRounds;
    }

    public void decreaseRemainingRounds(int amount) {
        remainingRounds = remainingRounds - amount;
    }

    public Player getLeadingPlayer() {
        return leadingPlayer;
    }

    public void setLeadingPlayer(Player leadingPlayer) {
        this.leadingPlayer = leadingPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public boolean isPlayTutorial() {
        return playTutorial;
    }

    /**
     * Validates the constraints to start a game
     */
    public boolean canStartGame() {
        if (name == null || players == null || gameMode == null) {
            return false;
        }

        if (name.isBlank()) {
            return false;
        }

        if (totalRounds <= 0) {
            return false;
        }

        if (gameMode == GameMode.SINGLE && players.size() < 1) {
            return false;
        } else return players.size() >= 2;
    }

}

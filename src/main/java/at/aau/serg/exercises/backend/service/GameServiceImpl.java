package at.aau.serg.exercises.backend.service;

import at.aau.serg.exercises.backend.dao.GameInstanceDao;
import at.aau.serg.exercises.backend.dao.PlayerDao;
import at.aau.serg.exercises.backend.entity.GameMode;
import at.aau.serg.exercises.backend.gamelogic.GameRunner;
import at.aau.serg.exercises.backend.service.exception.GameServiceException;
import at.aau.serg.exercises.backend.entity.GameInstance;
import at.aau.serg.exercises.backend.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class GameServiceImpl implements GameService {

    private final GameInstanceDao gameInstanceDao;
    private final PlayerDao playerDao;
    private final GameRunner gameRunner;

    public GameServiceImpl(GameInstanceDao gameInstanceDao, PlayerDao playerDao, GameRunner gameRunner) {
        this.gameInstanceDao = gameInstanceDao;
        this.playerDao = playerDao;
        this.gameRunner = gameRunner;
    }

    @Override
    public GameInstance createGame(String name, GameMode gameMode, List<Player> players, int totalRounds, boolean playTutorial) throws GameServiceException {
        for (Player p : players) {
            checkPlayerExists(p);
        }

        GameInstance gameInstance = new GameInstance(name, gameMode, players, totalRounds, playTutorial);

        return gameInstanceDao.insert(gameInstance);
    }

    @Override
    public void deleteGameInstance(GameInstance gameInstance) throws GameServiceException {
        checkGameExists(gameInstance);

        gameInstanceDao.delete(gameInstance.getId());
    }

    @Override
    public List<GameInstance> findAllGamesByPlayer(Player player) throws GameServiceException {
        checkPlayerExists(player);

        return gameInstanceDao.findAll().stream().filter(game -> game.getPlayers().contains(player)).collect(Collectors.toList());
    }

    @Override
    public boolean startGame(GameInstance gameInstance) throws GameServiceException {
        checkGameExists(gameInstance);

        if (gameInstance.canStartGame()) {
            gameRunner.start(gameInstance);
            return true;
        }

        return false;
    }

    public void checkPlayerExists(Player player) throws GameServiceException {
        if (playerDao.findOne(player.getId()) == null) {
            throw new GameServiceException("Player does not exist (" + player.getId() + ").");
        }
    }

    public void checkGameExists(GameInstance gameInstance) throws GameServiceException {
        if (gameInstanceDao.findOne(gameInstance.getId()) == null) {
            throw new GameServiceException("Game does not exist (" + gameInstance.getId() + ").");
        }
    }

}

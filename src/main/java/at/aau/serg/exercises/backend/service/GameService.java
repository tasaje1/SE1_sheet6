package at.aau.serg.exercises.backend.service;

import java.util.List;

import at.aau.serg.exercises.backend.entity.GameMode;
import at.aau.serg.exercises.backend.service.exception.GameServiceException;
import at.aau.serg.exercises.backend.entity.GameInstance;
import at.aau.serg.exercises.backend.entity.Player;

public interface GameService {
    GameInstance createGame(String name, GameMode gameMode, List<Player> players, int totalRounds, boolean playTutorial)
            throws GameServiceException;

    void deleteGameInstance(GameInstance gameInstance) throws GameServiceException;

    List<GameInstance> findAllGamesByPlayer(Player player)
            throws GameServiceException;

    boolean startGame(GameInstance gameInstance) throws GameServiceException;
}
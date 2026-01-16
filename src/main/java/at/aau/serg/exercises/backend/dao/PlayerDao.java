package at.aau.serg.exercises.backend.dao;

import java.util.List;

import at.aau.serg.exercises.backend.entity.Player;

public interface PlayerDao extends Dao<Long, Player> {
	public List<Player> findPlayerByUsername(String username);
}

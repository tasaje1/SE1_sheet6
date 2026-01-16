package at.aau.serg.exercises.backend.dao.impl;

import at.aau.serg.exercises.backend.dao.PlayerDao;
import at.aau.serg.exercises.backend.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ListPlayerDao extends ListDao<Player> implements PlayerDao {
    public ListPlayerDao() {
        this.currentId = 1L;
    }

    @Override
    public List<Player> findPlayerByUsername(String username) {
        return entityList.stream()
                .filter(player -> username.equals(player.getUsername()))
                .collect(Collectors.toList());
    }

}

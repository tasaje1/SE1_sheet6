package at.aau.serg.exercises.backend.dao.impl;

import at.aau.serg.exercises.backend.dao.GameInstanceDao;
import at.aau.serg.exercises.backend.entity.GameInstance;

public class ListGameInstanceDao extends ListDao<GameInstance> implements GameInstanceDao {
    public ListGameInstanceDao() {
        this.currentId = 1L;
    }
}

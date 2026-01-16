package at.aau.serg.exercises.backend.dao.impl;

import at.aau.serg.exercises.backend.dao.Dao;
import at.aau.serg.exercises.backend.dao.EntityWithId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ListDao<T extends EntityWithId<Long>> implements Dao<Long, T> {
    protected List<T> entityList = new ArrayList<>();
    protected Long currentId;

    public List<T> findAll() {
        return this.entityList;
    }

    public T findOne(Long id) {
        for (T p : this.entityList) {
            if (Objects.equals(p.getId(), id)) {
                return p;
            }
        }
        return null;
    }

    public T insert(T element) {
        element.setId(currentId++);
        this.entityList.add(element);
        return element;
    }

    public boolean delete(Long id) {
        T element = null;
        for (T p : this.entityList) {
            if (Objects.equals(p.getId(), id)) {
                element = p;
                break;
            }
        }
        if (element != null) {
            this.entityList.remove(element);
        }
        return element != null;
    }

    public T update(T element) {
        delete(element.getId());
        return insert(element);
    }
}

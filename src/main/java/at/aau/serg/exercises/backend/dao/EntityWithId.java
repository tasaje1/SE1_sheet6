package at.aau.serg.exercises.backend.dao;

public abstract class EntityWithId<K> {

    public abstract K getId();

    public abstract void setId(K id);
}

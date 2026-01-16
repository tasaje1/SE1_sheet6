package at.aau.serg.exercises.backend.dao;

import java.util.List;


public interface Dao<S,T extends EntityWithId<S>> {
	T findOne(S id);
	List<T> findAll();
	T insert(T element);
	boolean delete(S id);
	T update(T element);
}

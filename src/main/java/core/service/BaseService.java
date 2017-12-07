package core.service;

import java.io.Serializable;

public interface BaseService<E> {
	
	public Serializable save(E e);
	
	public void deleteById(Serializable id);
	
	public void update(E e);
	
	public E getById(Serializable id);
	
	public E loadById(Serializable id);
	
}

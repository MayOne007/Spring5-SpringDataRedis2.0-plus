package core.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import core.dao.BaseDao;

@Transactional
public class BaseServiceImpl<E> implements BaseService<E>{
	
	@Autowired
	private BaseDao<E> baseDao;

	@Override
	public Serializable save(E e) {
		return baseDao.save(e);
	}

	@Override
	public void deleteById(Serializable id) {
		baseDao.deleteById(id);
	}

	@Override
	public void update(E e) {
		baseDao.update(e);
	}	
	
	@Override
	public E getById(Serializable id) {
		return baseDao.getById(id);
	}

	@Override
	public E loadById(Serializable id) {
		return baseDao.loadById(id);
	}
	
}

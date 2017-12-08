package core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl<E> implements BaseDao<E> {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Class<E> entityClass;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDaoImpl() {
		Class c = getClass();
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] parameterizedType = ((ParameterizedType) type)
					.getActualTypeArguments();
			this.entityClass = (Class<E>) parameterizedType[0];
		}
	}
	
	@Override
	public Serializable save(E e) {
		return sessionFactory.getCurrentSession().save(e);
	}
	
	@Override	
	public void deleteById(Serializable id) {
		sessionFactory.getCurrentSession().delete(getById(id));
	}
	
	@Override
	public void update(E e) {
		sessionFactory.getCurrentSession().update(e);
	}
	
	@Override
	public E getById(Serializable id) {
		return sessionFactory.getCurrentSession().get(entityClass,id);
	}
	
	@Override
	public E loadById(Serializable id) {
		return sessionFactory.getCurrentSession().load(entityClass,id);
	}
	
}

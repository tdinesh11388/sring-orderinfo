package org.ass.order.repository;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.ass.order.entity.OrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Query;


@Repository
public class OrderRepository
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveOrder(OrderEntity order)
	{
		Session session = sessionFactory.openSession();
		Transaction transcation = session.beginTransaction();
		Serializable save = session.save(order);
		System.out.println(save);
		transcation.commit();
	}
	
	public List<OrderEntity> getAllUser()
	{
		
		try {
			String hqlQuery="from OderEntity";
			Session session = sessionFactory.openSession();
			//OrderEntity orderEntity = session.get(OrderEntity.class, session);
			org.hibernate.query.Query query = session.createQuery(hqlQuery);
			return query.getResultList();
			
		}catch(Exception e) {
			
		}
		return Collections.EMPTY_LIST;
	}

}

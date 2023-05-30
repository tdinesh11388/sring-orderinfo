package org.ass.order.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.ass.order.dto.OrderDto;
import org.ass.order.entity.OrderEntity;
import org.ass.order.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService
{
	@Autowired
	private RestTemplate restemplete;
	
	@Autowired
	private SessionFactory factory;
	
	public String placeOrder(OrderDto orderDto)
	{
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setProductId(orderDto.getProductId());
		orderEntity.setPaymentMode(orderDto.getPayment_mode());
		orderEntity.setQuantity(orderDto.getQuantity());
		orderEntity.setSetDate(new Date());
		orderEntity.setTotalPrice(0);
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append("http://localhost:8080/SpringWeb2/findProductPriceByProductId/");
		urlBuilder.append(orderDto.getProductId());
		System.out.println(urlBuilder);
		
		Double productPrice=restemplete.getForObject(urlBuilder.toString(), Double.class);
		
		System.out.println("productPrice :"+productPrice);
		
		orderEntity.setTotalPrice(productPrice*orderDto.getQuantity());
		
		Session session = factory.openSession();
		Transaction transcation = session.beginTransaction();
		Serializable save = session.save(orderEntity);
		System.out.println(save);
		transcation.commit();
		
		return "Order Placed SucessFully";
	}
	
}
//spring intilizer

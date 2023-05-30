package org.ass.order.controller;

import org.ass.order.dto.OrderDto;
import org.ass.order.entity.OrderEntity;
import org.ass.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OrderController
{
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value="/InitateOrder")
	public String InitateOrder(@RequestBody OrderDto orderDto)
	{
		return orderService.placeOrder(orderDto);
	}
	
}

package com.example.os.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.os.api.common.TransactionResponse;
import com.example.os.api.domain.OrderDomain;
import com.example.os.api.service.OrderServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderServiceImpl; 
	
	@PostMapping(value = "/bookorder")
	public TransactionResponse bookOrder(@RequestBody OrderDomain order) throws JsonProcessingException {
		
		return orderServiceImpl.saveOrder(order);
	}
	
}

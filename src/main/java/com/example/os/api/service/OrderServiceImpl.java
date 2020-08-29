package com.example.os.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.os.api.common.PaymentDomain;
import com.example.os.api.common.TransactionResponse;
import com.example.os.api.domain.OrderDomain;
import com.example.os.api.entity.Order;
import com.example.os.api.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@RefreshScope
public class OrderServiceImpl implements OrderService{

	@Value("${microservice.SpringBooPaymentService.endpoints.endpoint.uri}")
	private String ENDPOINT_URL;
	
	private Logger log=LoggerFactory.getLogger(OrderServiceImpl.class);
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(OrderDomain orderdomain) throws JsonProcessingException {
		Order order = new Order();
		String response="";
		PaymentDomain payment =new PaymentDomain();
		BeanUtils.copyProperties(orderdomain, order);
		Order save = orderRepository.save(order);
		payment.setOrderId(save.getOrderId());
		payment.setAmount(save.getAmount());
		
		log.info("Order-Service request:",new ObjectMapper().writeValueAsString(orderdomain));
		//rest call
		ResponseEntity<PaymentDomain> paymentResponse= restTemplate.postForEntity(ENDPOINT_URL, payment, PaymentDomain.class);
	    //response in to log file
		log.info("Payment-Service response from Order-Service rest call :",new ObjectMapper().writeValueAsString(paymentResponse));
		
		if(paymentResponse.getBody().getPaymentStatus().equals("success")) {
			response="payment processing successful and order placed";
		}else {
			response="there is a problem in payment api ,order added to cart";
		}
		
		
		return new TransactionResponse(order,paymentResponse.getBody().getAmount(),paymentResponse.getBody().getTransactionId(),response);
	}
}

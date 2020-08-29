package com.example.os.api.service;

import com.example.os.api.common.TransactionResponse;
import com.example.os.api.domain.OrderDomain;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderService {
	public TransactionResponse saveOrder(OrderDomain orderdomain) throws JsonProcessingException;
}

package com.example.os.api.common;



import com.example.os.api.entity.Order;

public class TransactionResponse {
	
	private Order order;
	private Double amount;
	private String transactionId;
	private String message;
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrderEntry(Order order) {
		this.order = order;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TransactionResponse(Order order, Double amount, String transactionId, String message) {
		super();
		this.order = order;
		this.amount = amount;
		this.transactionId = transactionId;
		this.message = message;
	}
	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}

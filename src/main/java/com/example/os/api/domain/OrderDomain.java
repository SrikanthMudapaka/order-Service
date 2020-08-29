package com.example.os.api.domain;

public class OrderDomain {
	private Integer OrderId;
	private String name;
	private Integer qty;
	private Double amount;
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public OrderDomain(Integer orderId, String name, Integer qty, Double amount) {
		super();
		OrderId = orderId;
		this.name = name;
		this.qty = qty;
		this.amount = amount;
	}
	public OrderDomain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

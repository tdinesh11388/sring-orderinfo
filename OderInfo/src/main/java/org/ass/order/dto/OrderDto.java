package org.ass.order.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class OrderDto implements Serializable
{
	private long productId;
	
	private int quantity;
	
	private String paymentMode;

	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPayment_mode() {
		return paymentMode;
	}

	public void setPayment_mode(String payment_mode) {
		this.paymentMode = payment_mode;
	}
	
}

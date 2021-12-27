package com.java.retailer.bean;

import io.swagger.annotations.ApiModelProperty;

public class Transaction {

	@ApiModelProperty(required = true, example = "July")
	private String month;

	@ApiModelProperty(required = true, example = "120")
	private Integer spentAmount;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getSpentAmount() {
		return spentAmount;
	}

	public void setSpentAmount(Integer spentAmount) {
		this.spentAmount = spentAmount;
	}
}

package com.java.retailer.controller;

import java.util.List;
import java.util.Map;

import com.java.retailer.bean.Transaction;
import com.java.retailer.serviceimpl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(tags = "Reward Point APIs")
@RestController
@RequestMapping(value = "/")
public class TransactionController {
	
	@Autowired
	private TransactionServiceImpl challengeServiceImpl;

	
	@PostMapping(value="transactions",produces = {"application/json"})
	@ApiOperation(value = "Calculate rewards ", notes = "This API is used to calculate rewards based on customer spending.")
	 public ResponseEntity<Map<String, Integer>> createChallenges(@RequestBody(required = false) List<Transaction> transactions) {
		Map<String, Integer> msg = challengeServiceImpl.getRewardPoints(transactions);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

}

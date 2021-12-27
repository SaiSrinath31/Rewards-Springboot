package com.java.retailer.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.java.retailer.bean.Transaction;
import org.junit.Before;
import org.junit.Test;

public class TransactionServiceImplTest {

	private TransactionServiceImpl transactionServiceImpl;
	
	@Before
	public void setup() {
		transactionServiceImpl = new TransactionServiceImpl();
	}
	
	@Test
	public void transactionLessThan50() {
		Map<String, Integer> result = transactionServiceImpl.getRewardPoints(getSampleData(25));
		assertEquals("{NOVEMBER=0}", result.toString());
	}
	
	@Test
	public void transactionBetween50To100() {
		Map<String, Integer> result = transactionServiceImpl.getRewardPoints(getSampleData(75));
		assertEquals("{NOVEMBER=25}", result.toString());
	}
	
	@Test
	public void transactionGreaterThan100() {
		Map<String, Integer> result = transactionServiceImpl.getRewardPoints(getSampleData(110));
		assertEquals("{NOVEMBER=121}", result.toString());
	}
	
	

	private List<Transaction> getSampleData(int amount) {
		Transaction transaction = new Transaction();
		transaction.setSpentAmount(amount);
		transaction.setMonth("NOVEMBER");
		List<Transaction> transList = new ArrayList<Transaction>();
		transList.add(transaction);
		return transList;
	}
}

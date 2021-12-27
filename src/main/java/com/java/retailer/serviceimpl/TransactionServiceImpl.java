package com.java.retailer.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.retailer.bean.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl{
	
	public Map<String, Integer> getRewardPoints(List<Transaction> transactionList) {
		Map<String, Integer> rewards = new HashMap<>();
		
		transactionList.forEach(transaction -> {
			String month = transaction.getMonth();
			int rewardsPoints = 0;
			if(transaction.getSpentAmount() < 50) {
				rewardsPoints = 0;
			} else if(transaction.getSpentAmount() <=100 && transaction.getSpentAmount() > 50) {
				rewardsPoints = transaction.getSpentAmount() - 50;
			} else if(transaction.getSpentAmount() > 100) {
				rewardsPoints = ((transaction.getSpentAmount()-50)/50) + (2* transaction.getSpentAmount()-100);
			}

			if(rewards.containsKey(month)){
				
				int total = rewards.get(month) + rewardsPoints;
				rewards.put(month, total);
			} else {
				rewards.put(month, rewardsPoints);
			}
		});
		return rewards;
	}
}

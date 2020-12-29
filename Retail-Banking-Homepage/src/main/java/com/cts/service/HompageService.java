package com.cts.service;

import java.util.List;

import com.cts.entity.Account;
import com.cts.entity.Transaction;

public interface HompageService {

	List<Account> getAccounts(long custId);
	
	List<Transaction> getTransactions(long custId);
	
	int getCreditScore(long custId);
	
	int getNoOfRewards(long custId); 
}

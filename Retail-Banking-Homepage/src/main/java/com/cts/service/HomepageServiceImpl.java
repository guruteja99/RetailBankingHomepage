package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.cts.entity.Account;
import com.cts.entity.AccountList;
import com.cts.entity.Transaction;
import com.cts.entity.TransactionList;

public class HomepageServiceImpl implements HomepageService {

	@Autowired
	private RestTemplate rest;

	@Override
	public List<Account> getAccounts(long custId) {

		AccountList response =  rest.getForObject("http://ACCOUNT/getAccounts"+custId, AccountList.class);
		List<Account> accounts = response.getAccounts();
		return accounts;
	}

	@Override
	public List<Transaction> getTransactions(long custId) {
		TransactionList response =  rest.getForObject("http://TRANSACTIONS/getTransactions"+custId, TransactionList.class);
		List<Transaction> transactions = response.getTransactions();
		return transactions;
	}

	@Override
	public int getCreditScore(long custId) {
		int score = rest.getForObject("http://CREDITSCORE/getCreditScore"+custId, Integer.class);
		return score;
	}

	@Override
	public int getNoOfRewards(long custId) {
		int noOfRewards = rest.getForObject("http://REWARDS/getNoOfRewards"+custId, Integer.class);
		return noOfRewards;
	}

}

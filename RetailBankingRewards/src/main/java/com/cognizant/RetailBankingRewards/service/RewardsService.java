package com.cognizant.RetailBankingRewards.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.RetailBankingRewards.entity.Rewards;
import com.cognizant.RetailBankingRewards.entity.Wallet;

@Component
public interface RewardsService {
	public List<Rewards> getAllRewards(int id);

	public void addreward(Rewards r);

	public boolean ClaimReward(int rid,int cid);

	public Wallet getwallettopup(int id);


	
}

package com.cognizant.RetailBankingRewards.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.RetailBankingRewards.Exception.InvalidClaimRewardException;
import com.cognizant.RetailBankingRewards.entity.Rewards;
import com.cognizant.RetailBankingRewards.entity.Wallet;
import com.cognizant.RetailBankingRewards.helper.RewardHelper;
import com.cognizant.RetailBankingRewards.model.CustomerReward;
import com.cognizant.RetailBankingRewards.service.RewardsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rewards")
public class RewardsController {

	@Autowired
	RewardsService rewardservice;
	@Autowired
	RewardHelper helper;
	
	@PostMapping("/savereward/transactionamount")
	public String addeRewardsforCustomer(@RequestBody CustomerReward reward) {
		int amount=reward.getAmount();
		int cid=reward.getCid();
		log.info("Get Reward amount");
		if(amount<1000)
				return "Sorry!!! You are not eligible for Rewards";
		int rewardAmount = helper.getRewardAmount(amount);
		log.info("Saving reward amount and info in rewardsobject");
		Rewards r = new Rewards(cid, "tansactionFor" + amount, rewardAmount, "active",
				LocalDate.now().plusDays(15));
		rewardservice.addreward(r);
		return "Congrats!!! You are Rewarded with " +r.getRewardAmount()+ " Use this Reward ID: " +r.getRewardId()+ " To Claim";
	}

	@GetMapping("/getactiverewards/customerId/{cid}")
	public List<Rewards> showActiveRewards(@PathVariable String cid) {
		log.info("getAllRewards");
		List<Rewards> allRewards = rewardservice.getAllRewards(Integer.parseInt(cid));
		log.info("Sorting all active rewards");
		List<Rewards> activeRewards = helper.getActiveOrders(allRewards);
		return activeRewards;
	}
	@GetMapping("/getActiveRewards/{cid}")
	public int getNoOfRewards(@PathVariable String cid) {
		List<Rewards> allRewards = rewardservice.getAllRewards(Integer.parseInt(cid));
		List<Rewards> activeRewards = helper.getActiveOrders(allRewards);
		return activeRewards.size();
	}
	
	@GetMapping("/claimreward/{cid}/rewardid/{rid}")
	public void claimReward(@PathVariable int cid,@PathVariable int rid) throws InvalidClaimRewardException {
		
		boolean claimReward = rewardservice.ClaimReward(rid, cid);
		if(!claimReward)
			throw new InvalidClaimRewardException("Cannot Claim this reward");		
	}
	
	@GetMapping("/getwalletdeatils/customerId/{cid}")
	public Wallet showWalletDetails(@PathVariable String cid) {
		log.info("getting wallet amountofcustomer");
		Wallet w = rewardservice.getwallettopup(Integer.parseInt(cid));
		return w;
	}

}

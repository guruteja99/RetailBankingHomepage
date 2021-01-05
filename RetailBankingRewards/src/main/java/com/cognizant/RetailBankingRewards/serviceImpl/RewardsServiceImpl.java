package com.cognizant.RetailBankingRewards.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.RetailBankingRewards.entity.Rewards;
import com.cognizant.RetailBankingRewards.entity.Wallet;
import com.cognizant.RetailBankingRewards.repository.RewardsRepository;
import com.cognizant.RetailBankingRewards.repository.WalletRepository;
import com.cognizant.RetailBankingRewards.service.RewardsService;

@Component
public class RewardsServiceImpl implements RewardsService {

	@Autowired
	private RewardsRepository repository;

	@Autowired
	private WalletRepository walletrepository;

	@Override
	public List<Rewards> getAllRewards(int cid) {
		List<Rewards> Allactiverewards = repository.findByCustomerId(cid);
		return Allactiverewards;
	}

	@Override
	public void addreward(Rewards r) {
		// TODO Auto-generated method stub
		repository.save(r);
	}

	@Override
	public boolean ClaimReward(int rid, int cid) {
		// TODO Auto-generated method stub
		Optional<Rewards> reward = repository.findById(rid);
		if (reward.isEmpty() || reward.get().getRewardStatus().equals("inactive")) {
			return false;
		} else {
			LocalDate date1 = LocalDate.now();
			LocalDate date2 = reward.get().getRewardExpiryDate();
			int validdate = date2.compareTo(date1);
			if (validdate < 0) {
				reward.get().setRewardStatus("inactive");
				repository.save(reward.get());
				return false;
			} else {
				Optional<Wallet> findById2 = walletrepository.findById(cid);
				if (findById2.isEmpty()) {
					Wallet w = new Wallet(cid, reward.get().getRewardAmount());
					walletrepository.save(w);
				} else {
					findById2.get()
							.setWalletAmount(findById2.get().getWalletAmount() + reward.get().getRewardAmount());
					walletrepository.save(findById2.get());
				}
				reward.get().setRewardStatus("inactive");
				repository.save(reward.get());
				return true;
			}
		}
	}

	@Override
	public Wallet getwallettopup(int id) {
		// TODO Auto-generated method stub
		return walletrepository.findById(id).get();
	}

}

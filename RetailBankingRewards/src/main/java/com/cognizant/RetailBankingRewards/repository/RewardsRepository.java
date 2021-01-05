package com.cognizant.RetailBankingRewards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.RetailBankingRewards.entity.Rewards;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Integer>{

	List<Rewards> findByCustomerId(int cid);

}

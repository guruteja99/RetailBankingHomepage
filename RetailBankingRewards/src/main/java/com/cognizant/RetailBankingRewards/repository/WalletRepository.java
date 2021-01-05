
package com.cognizant.RetailBankingRewards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.RetailBankingRewards.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer>{


}

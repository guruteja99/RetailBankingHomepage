package com.retailBanking.accountsService.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailBanking.accountsService.Models.AccountsModel;
import com.retailBanking.accountsService.Models.TransactionMicroServiceModel;

//@FeignClient(name="transaction-service")
//@RibbonClient(name="transaction-service")
@Repository
public interface TransactionServiceProxy extends JpaRepository<AccountsModel, BigInteger> {
	
	//List<TransactionMicroServiceModel> getTransactionByAccount(BigInteger accNo);


}

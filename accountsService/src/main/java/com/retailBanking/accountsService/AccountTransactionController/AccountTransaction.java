package com.retailBanking.accountsService.AccountTransactionController;

import java.math.BigInteger;
import java.util.List;

import com.retailBanking.accountsService.Models.TransactionMicroServiceModel;

public interface AccountTransaction {

	List<TransactionMicroServiceModel> getTransactionByAccount(BigInteger accountNo);

}

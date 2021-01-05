package com.retailBanking.accountsService.Models;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountsModel {

	@Column(name = "userid")
	private Double userid;

	@Id
	@Column(name = "accountno")
	private BigInteger accountNo;

	@Column(name = " accounttype")
	private String accountType;

	@Column(name = "accountnickname")
	private String accountNickName;

	@Column(name = "accountbalance")
	private BigInteger accountBalance;

	public BigInteger getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(BigInteger accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNickName() {
		return accountNickName;
	}

	public void setAccountNickName(String accountNickName) {
		this.accountNickName = accountNickName;
	}

	public BigInteger getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigInteger accountBalance) {
		this.accountBalance = accountBalance;
	}

	public AccountsModel() {
		super();
	}

	/*
	 * @OneToMany(targetEntity = CreditCardModel.class, mappedBy = "accountNo")
	 * private List<CreditCardModel> cardModel;
	 * 
	 * public List<CreditCardModel> getCardModel() { return cardModel; }
	 * 
	 * public void setCardModel(List<CreditCardModel> cardModel) { this.cardModel =
	 * cardModel; }
	 */

	public AccountsModel(BigInteger accountNo, String accountType, String accountNickName, BigInteger accountBalance,
			List<CreditCardModel> cardModel) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountNickName = accountNickName;
		this.accountBalance = accountBalance;
		// this.cardModel = cardModel;
	}

}

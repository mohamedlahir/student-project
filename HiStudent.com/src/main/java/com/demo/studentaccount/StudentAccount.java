package com.demo.studentaccount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.demo.usermodel.UserModel;

@Entity
public class StudentAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountid;
	private int amountBalance;
	private boolean isCharged = false;
	private int amountCharged;
	private int amountRefunded;
	private boolean isRefunded;
	
//	@OneToOne
//	private UserModel model;
	
	
	
	/**
	 * @return the accountid
	 */
	public int getAccountid() {
		return accountid;
	}
	@Override
	public String toString() {
		return "StudentAccount [accountid=" + accountid + ", amountBalance=" + amountBalance + ", isCharged="
				+ isCharged + ", amountCharged=" + amountCharged + ", amountRefunded=" + amountRefunded
				+ ", isRefunded=" + isRefunded + "]";
	}
	/**
	 * @param accountid the accountid to set
	 */
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	/**
	 * @return the amountBalance
	 */
	public int getAmountBalance() {
		return amountBalance;
	}
	/**
	 * @param amountBalance the amountBalance to set
	 */
	public void setAmountBalance(int amountBalance) {
		this.amountBalance = amountBalance;
	}
	/**
	 * @return the isCharged
	 */
	public boolean isCharged() {
		return isCharged;
	}
	/**
	 * @param isCharged the isCharged to set
	 */
	public void setCharged(boolean isCharged) {
		this.isCharged = isCharged;
	}
	/**
	 * @return the amountCharged
	 */
	public int getAmountCharged() {
		return amountCharged;
	}
	/**
	 * @param amountCharged the amountCharged to set
	 */
	public void setAmountCharged(int amountCharged) {
		this.amountCharged = amountCharged;
	}
	/**
	 * @return the amountRefunded
	 */
	public int getAmountRefunded() {
		return amountRefunded;
	}
	/**
	 * @param amountRefunded the amountRefunded to set
	 */
	public void setAmountRefunded(int amountRefunded) {
		this.amountRefunded = amountRefunded;
	}
	/**
	 * @return the isRefunded
	 */
	public boolean isRefunded() {
		return isRefunded;
	}
	/**
	 * @param isRefunded the isRefunded to set
	 */
	public void setRefunded(boolean isRefunded) {
		this.isRefunded = isRefunded;
	}

	
	
	
	
	
}

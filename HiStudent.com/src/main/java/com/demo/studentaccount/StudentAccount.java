package com.demo.studentaccount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private long charged_at;
	private long refunded_at;
	@Override
	public String toString() {
		return "StudentAccount [accountid=" + accountid + ", amountBalance=" + amountBalance + ", isCharged="
				+ isCharged + ", amountCharged=" + amountCharged + ", amountRefunded=" + amountRefunded
				+ ", isRefunded=" + isRefunded + ", charged_at=" + charged_at + ", refunded_at=" + refunded_at + "]";
	}
	/**
	 * @return the accountid
	 */
	public int getAccountid() {
		return accountid;
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
	/**
	 * @return the charged_at
	 */
	public long getCharged_at() {
		return charged_at;
	}
	/**
	 * @param charged_at the charged_at to set
	 */
	public void setCharged_at(long charged_at) {
		this.charged_at = charged_at;
	}
	/**
	 * @return the refunded_at
	 */
	public long getRefunded_at() {
		return refunded_at;
	}
	/**
	 * @param refunded_at the refunded_at to set
	 */
	public void setRefunded_at(long refunded_at) {
		this.refunded_at = refunded_at;
	}
	
}

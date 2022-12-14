package com.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChargeModel {

	@Id
	private int id;
	private int basic_charge_amount;
	private int annual_charge;
	private int monthly_charge;
	@Override
	public String toString() {
		return "ChargeModel [id=" + id + ", basic_charge_amount=" + basic_charge_amount + ", annual_charge="
				+ annual_charge + ", monthly_charge=" + monthly_charge + "]";
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the basic_charge_amount
	 */
	public int getBasic_charge_amount() {
		return basic_charge_amount;
	}
	/**
	 * @param basic_charge_amount the basic_charge_amount to set
	 */
	public void setBasic_charge_amount(int basic_charge_amount) {
		this.basic_charge_amount = basic_charge_amount;
	}
	/**
	 * @return the annual_charge
	 */
	public int getAnnual_charge() {
		return annual_charge;
	}
	/**
	 * @param annual_charge the annual_charge to set
	 */
	public void setAnnual_charge(int annual_charge) {
		this.annual_charge = annual_charge;
	}
	/**
	 * @return the monthly_charge
	 */
	public int getMonthly_charge() {
		return monthly_charge;
	}
	/**
	 * @param monthly_charge the monthly_charge to set
	 */
	public void setMonthly_charge(int monthly_charge) {
		this.monthly_charge = monthly_charge;
	}
	
}

package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.accountmodelrepo.AccountRepo;
import com.demo.models.ChargeModel;
import com.demo.models.StudentAccount;

@Service
public class ChargerService {
	
	@Autowired
	AccountRepo repo;
	
	public StudentAccount annualcharge(int id) {  
		
		StudentAccount account =  new StudentAccount();
		
	int account1 = repo.findById(id).get().getAmountBalance();
	
	ChargeModel cmodel = new ChargeModel();
	
	int charge = cmodel.getAnnual_charge();
	
	int result = account1-charge;
	
	account.setAmountBalance(result);
	
	return repo.save(account);
	
	
	}

}

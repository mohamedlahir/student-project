package com.demo.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.accountmodelrepo.AccountRepo;
import com.demo.charge.ChargeModel;
import com.demo.studentaccount.StudentAccount;
import com.demo.usermodel.UserModel;
import com.demo.userrepo.ChargeRepo;
import com.demo.userrepo.UserRepo;

@Service
public class CrudServices {

	@Autowired
	private AccountRepo arepo;

	@Autowired
	private UserRepo repo;

	@Autowired
	private ChargeRepo crepo;

	private UserModel model;

	StudentAccount saccount;

	PasswordEncoder passwordencoder;

	public CrudServices(UserRepo repo) {
		this.repo = repo;
		this.passwordencoder = new BCryptPasswordEncoder();
	}

	public UserModel save(UserModel model, StudentAccount account) {

		String encodePassword = this.passwordencoder.encode(model.getPassword());
		model.setPassword(encodePassword);
		model.setAccount(account);
		repo.save(model);
		arepo.save(account);
		return model;
	}

	public Optional<UserModel> getelements(int id) {

		return repo.findById(id);
	}

	public int save1(UserModel model, StudentAccount account) {

		String encodePassword = this.passwordencoder.encode(model.getPassword());
		model.setPassword(encodePassword);
		account.setAccountid(model.getId());
		model.setAccount(account);
		this.repo.save(model);
		return account.getAccountid();
	}
	
	public ChargeModel savecharge(ChargeModel model) {
		
		crepo.save(model);
		return model;
	}

	public StudentAccount update(int id, StudentAccount saccount) {

		arepo.save(saccount);

		return saccount;

	}

	public Optional<ChargeModel> getChargeModel(int id) {

		return crepo.findById(id);
	}

//	public int accountBalance( StudentAccount account ) {
//	 	
//		
//		return account.setAmountBalance();
//	}

}
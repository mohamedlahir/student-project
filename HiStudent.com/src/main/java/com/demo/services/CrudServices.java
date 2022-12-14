package com.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.accountmodelrepo.AccountRepo;
import com.demo.authenticationrequest.AuthenticationRequest;
import com.demo.authenticationrequest.AuthenticationResponse;
import com.demo.jwtutil.JwtUtil;
import com.demo.models.ChargeModel;
import com.demo.models.StudentAccount;
import com.demo.models.UserModel;
import com.demo.myuserdetailservice.MyUserDetailService;
import com.demo.repository.ChargeRepo;
import com.demo.repository.UserRepo;

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
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailService userDetailsService;

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

	//********************************************************************************************************************************************
	
	
	
	
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		
		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

//***************************************************************************************************************************************

}
package com.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.My.MyUserPrincipal;
import com.demo.accountmodelrepo.AccountRepo;
import com.demo.authenticationrequest.AuthenticationRequest;
import com.demo.authenticationrequest.AuthenticationResponse;
import com.demo.charge.ChargeModel;
import com.demo.chargeservice.ChargerService;
import com.demo.jwtutil.JwtUtil;
import com.demo.myuserdetailservice.MyUserDetailService;
import com.demo.services.CrudServices;
import com.demo.studentaccount.StudentAccount;
import com.demo.usermodel.Post;
import com.demo.usermodel.StudentMate;
import com.demo.usermodel.UserModel;
import com.demo.userrepo.ChargeRepo;
import com.demo.userrepo.MateRepo;
import com.demo.userrepo.PostRepo;
import com.demo.userrepo.UserRepo;

@RestController
class HelloWorldController {

	@Autowired
	UserRepo repo;
	
	@Autowired
	PostRepo prepo;

	@Autowired
	AccountRepo arepo;

	@Autowired
	ChargeRepo crepo;

	@Autowired
	MateRepo mrepo;

	@Autowired
	CrudServices services;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	ChargerService chargeservice;

	MyUserPrincipal userDto;

	JwtUtil jwt;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

	@GetMapping("/current-user")
	public String getpay(HttpServletRequest request) {

		final String authorizationHeader = request.getHeader("Authorization");

		String username = null;
		String jwt = null;

		jwt = authorizationHeader.substring(7);
		username = jwtTokenUtil.extractUsername(jwt);

		return username;
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestBody UserModel model) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		repo.save(model);
		return mv;
	}

	@RequestMapping("/logout-success")
	@ResponseBody
	public String logout() {

		return "logged out";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
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

	@RequestMapping("/registration")
	@ResponseBody
	public ModelAndView reg(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registration");
		UserModel model = new UserModel();
		StudentAccount account = new StudentAccount();
		String username = request.getParameter("username");
		String firstname = request.getParameter("first_name");
		String middlename = request.getParameter("middle_name");
		String lastname = request.getParameter("last_name");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("Address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		model.setPassword(password);
		model.setCountry(country);
		model.setFirst_name(firstname);
		model.setMiddle_name(middlename);
		model.setLast_name(lastname);
		model.setUsername(username);
		model.setState(state);
		model.setZipcode(zipcode);
		model.setAddress(address);
		model.setPhone(phone);
		model.setEmail(email);
		if (model.getUsername() == null) {
			System.out.println("pls fill the form to save");
		} else {
			services.save(model, account);
		}

		return mv;
	}

	@RequestMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentAccount save(@RequestBody UserModel model, StudentAccount account) {
		services.save1(model, account);
		return account;
	}

	@DeleteMapping("/deletebyid/{id}")
	@ResponseBody
	public String deleteById(@PathVariable("id") int id) throws UsernameNotFoundException {

		repo.deleteById(id);
		return " ID" + " :" + id + "is deleted";
	}

	@DeleteMapping("/delete-account-byid/{id}")
	@ResponseBody
	public String deleteAccountById(@PathVariable("id") int id) throws UsernameNotFoundException {

		arepo.deleteById(id);
		return "Given Account ID" + " : " + id + "is deleted";
	}

	@GetMapping("/getall")
	@ResponseBody
	public List<UserModel> getall() throws UsernameNotFoundException {

		return repo.findAll();

	}

	@GetMapping("/getone/{id}")
	@ResponseBody
	public Optional<UserModel> getById(@PathVariable int id) {

		return repo.findById(id);
	}

	@RequestMapping("/charge/{id}")
	public StudentAccount charge(@PathVariable int id) {

		return chargeservice.annualcharge(id);
	}

	@PutMapping("/set-account-balance/{id}")
	public StudentAccount accountBalance(@PathVariable int id, @RequestBody StudentAccount saccount) {

		return services.update(id, saccount);

	}

	@RequestMapping(path = "/savecharge", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ChargeModel savecharge(@RequestBody ChargeModel model) {
		services.savecharge(model);
		return model;
	}

	@GetMapping(path = "/getCharge/{id}")
	public Optional<ChargeModel> getallChargeModel(@PathVariable int id) {

		return services.getChargeModel(id);
	}

	@PutMapping("/annualcharge/{id}")
	public StudentAccount accountBalance1(@PathVariable int id, @RequestBody StudentAccount saccount) {
		int availableBalance = arepo.findById(id).get().getAmountBalance();
		int value = crepo.findById(101).get().getAnnual_charge();
		int chargedamount = availableBalance - value;

		saccount.setAccountid(saccount.getAccountid());
		saccount.setAmountBalance(chargedamount);
		saccount.setAmountCharged(value);
		saccount.setCharged(true);
		saccount.setRefunded(false);
		arepo.save(saccount);
		return saccount;
	}

	@PutMapping("/monthlyCharge/{id}")
	public StudentAccount monthlyCharge(@PathVariable int id, @RequestBody StudentAccount saccount) {

		int availableBalance = arepo.findById(id).get().getAmountBalance();
		int value = crepo.findById(101).get().getMonthly_charge();
		int chargedamount = availableBalance - value;
		saccount.setAccountid(saccount.getAccountid());
		saccount.setAmountBalance(chargedamount);
		saccount.setAmountCharged(value);
		saccount.setCharged(true);
		saccount.setRefunded(false);
		arepo.save(saccount);
		return saccount;
	}

//	String name = repo.findById(id1).get().getUsername();
//	saccount.setStudentname(name);

	@PutMapping("/basicCharge/{id}")
	public StudentAccount basicCharge(@RequestBody StudentAccount saccount, @PathVariable int id) {
		int availableBalance = arepo.findById(id).get().getAmountBalance();
		int value = crepo.findById(101).get().getBasic_charge_amount();
		int chargedamount = availableBalance - value;
		saccount.setAccountid(saccount.getAccountid());
		saccount.setAmountBalance(chargedamount);
		saccount.setAmountCharged(value);
		saccount.setCharged(true);
		saccount.setRefunded(false);
		arepo.save(saccount);
		return saccount;
	}

	@PutMapping("/refund/{id}")
	public StudentAccount refund(@RequestBody StudentAccount saccount, @PathVariable int id) {
		int amountCharged = arepo.findById(id).get().getAmountCharged();
		int balance = arepo.findById(id).get().getAmountBalance();
		boolean ischarged = arepo.findById(id).get().isCharged();
		boolean isrefunded = arepo.findById(id).get().isRefunded();
		int value = balance + amountCharged;
		if (ischarged == true && isrefunded == false) {
			saccount.setAccountid(saccount.getAccountid());
			saccount.setAmountBalance(value);
			saccount.setRefunded(true);
			saccount.setAmountRefunded(amountCharged);
			saccount.setAmountCharged(amountCharged);
			saccount.setCharged(true);
			arepo.save(saccount);
		} else {
			System.out.println("This is not charged");
		}
		return saccount;
	}

	@DeleteMapping("/deleteaccountbyid/{id}")
	@ResponseBody
	public String deleteAccountById1(@PathVariable("id") int id) throws UsernameNotFoundException {

		arepo.deleteById(id);

		return " ID" + " :" + id + "is deleted";
	}

	@PostMapping("/addmate/{id}")
	public StudentMate addMate(@PathVariable int id, StudentMate mate,HttpServletRequest request) {
		
		final String authorizationHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwt = null;
		jwt = authorizationHeader.substring(7);
		username = jwtTokenUtil.extractUsername(jwt);
		Optional<UserModel> model = repo.findById(id);
		String friendName = model.get().getUsername();
		mate.setFriendName(friendName);
		mate.setUserName(username);
		UserModel model1 = repo.findByUsername(friendName);
		int id1 = model.get().getId();
		mate.setId(id1);
		mate.setUser(model1);
		mrepo.save(mate);
		return mate;
	}

	@PostMapping("addpost")
	public Post addPost(@RequestBody Post post, HttpServletRequest request) throws NullPointerException {
		final String authorizationHeader = request.getHeader("Authorization");
		String username = null;
		String jwt = null;
		jwt = authorizationHeader.substring(7);
		username = jwtTokenUtil.extractUsername(jwt);
		UserModel model = repo.findByUsername(username);
		post.setUser(model);
		prepo.save(post);
		return post;
	}

//	@PostMapping("/addmate/{id}")
//	public StudentMate addMate(@PathVariable int id, StudentMate mate, UserModel model) {
//		String username = repo.findById(id).get().getUsername();
//		int stuid = repo.findById(id).get().getId();
//		mate.setUserName(username);
//		mate.setId(stuid);
//       // int value = crepo.findById(101).get().getBasic_charge_amount();
//		mrepo.save(mate);
//		return mate;
//	}

}
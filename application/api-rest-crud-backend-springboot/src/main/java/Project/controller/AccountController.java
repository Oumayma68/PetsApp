package Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.exception.ResourceNotFoundException;
import Project.model.Account;
import Project.repository.AccountRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts()
	{
		return this.accountRepository.findAll();
	}
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable(value="id") Long accountId)
	throws ResourceNotFoundException
	{
		Account account=this.accountRepository.findById(accountId)
				.orElseThrow(()->new ResourceNotFoundException("Account"
						+ "not found for this id :"+ accountId));
		return ResponseEntity.ok().body(account);
	}
	
	@PostMapping("/accounts")
	public Account createAccount(@Validated @RequestBody Account account)
	{
		return this.accountRepository.save(account);
	}
	
	
	@PutMapping("/accounts/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value="id") Long accountId,
			@Validated @RequestBody Account accountDetails)
	throws ResourceNotFoundException
	{
		Account account=this.accountRepository.findById(accountId)
				.orElseThrow(()->new ResourceNotFoundException("Account not found for this id :"+ accountId));
		account.setCin(accountDetails.getCin());
		account.setAccountNumber(accountDetails.getAccountNumber());
		account.setAgency(accountDetails.getAgency());
		account.setAmount(accountDetails.getAmount());
		account.setLastName(accountDetails.getLastName());
		account.setFirstName(accountDetails.getFirstName());
		
		final Account updateAccount=this.accountRepository.save(account);
		return ResponseEntity.ok().body(updateAccount);
	}
	
	@DeleteMapping("/accounts/{id}")
	public Map<String,Boolean> deleteAccount(@PathVariable(value="id") long accountId)
	throws ResourceNotFoundException
	{
		Account account=this.accountRepository.findById(accountId)
				.orElseThrow(()->new ResourceNotFoundException("Account"
						+ "not found for this id :"+ accountId));
	this.accountRepository.delete(account);
	Map<String,Boolean> response=new HashMap<>();
	response.put("deleted",true);
	return response;
	}
	
	
}

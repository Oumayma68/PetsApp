package net.codejava;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AppController {
	@Autowired
	private UserRepository repo;

	@GetMapping(value="/process_register/{firstname}/{lastname}/{email}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> processRegistration(@PathVariable("firstname") String firstname,@PathVariable("lastname") String lastname,
			@PathVariable("email") String email,@PathVariable("password") String password) {
		repo.save(new User(email,password,firstname,lastname));
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	
	@GetMapping("/login/{email}/{password}")
	public boolean processlogin(@PathVariable("email") String email,@PathVariable("password") String password) {
		boolean res=false;
		User u=this.repo.findByEmail(email);
		System.out.println(u.getFirstName());
		if(u!=null)
		{
			
			if(u.getPassword().equals(password))
			{
				res=true;
			}
		}
		return res;
	}
	
	
	
	
	
}

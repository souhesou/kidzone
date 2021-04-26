package tn.esprit.kid.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.kid.entities.User;
import tn.esprit.kid.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService iac;
	
	
	@PostMapping("/add")
	@ResponseBody
	public void addUser(@RequestBody User u) {
		 iac.AddUser(u);
		
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void removeUser(@PathVariable("id") int id) {

		iac.DeleteUser(id);
	}

	@GetMapping("/")
	public void getAllUser() {
		iac.GetAllUser();
	}
	
	
	@PutMapping("update/{id}")
	@ResponseBody
	public void Update(@PathVariable int id, @RequestBody User act) {
		 iac.UpdateUser(act);
	}

}

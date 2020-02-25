
package org.ms.controller;

import java.util.List;

import org.ms.dao.CustomerDAO;
import org.ms.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO; //need to inject customer dao
	
	
	@RequestMapping ("/")
	public String showHomepage() {
		return "index";
	}
	
	@RequestMapping ("/home")
	public String showHomepage2() {
		return "index";
	}
	
	@RequestMapping ("/about")
	public String showAboutPage() {
		return "about";
	}
	
	@RequestMapping ("/listuser")
	public String listUser(Model model) {
		
		List<Customer> theCustomers= customerDAO.getCustomers();
		
		model.addAttribute("customers", theCustomers);
		
		
		return "listuser";
	}
	
	

}

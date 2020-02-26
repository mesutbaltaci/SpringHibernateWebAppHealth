
package org.ms.controller;

import java.util.List;

import org.ms.dao.CustomerDAO;
import org.ms.entity.Customer;
import org.ms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//need to inject customer service
	
	@Autowired
	private CustomerService customerService;
	
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
		
		List<Customer> theCustomers= customerService.getCustomers();
		
		model.addAttribute("customers", theCustomers);
		
		
		return "listuser";
	}
	
	

}

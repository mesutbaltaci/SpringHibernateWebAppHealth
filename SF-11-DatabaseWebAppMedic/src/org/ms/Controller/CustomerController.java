
package org.ms.controller;

import java.util.List;

import org.ms.dao.CustomerDAO;
import org.ms.entity.Customer;
import org.ms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@RequestMapping("/showFormForAdd") 
	public String showFormForAdd (Model model) {
		Customer theCustomer = new Customer();
		model.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer (@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/listuser";
				
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
		Customer theCustomer = customerService.getCustomer(theId);
		
		model.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	
	@GetMapping("/deleteUser")
	public String showFormForUpdate(@RequestParam("customerId") int theId) {
		customerService.deleteUser(theId);
		
		return "redirect:/customer/listuser";
	}
	
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("theCustomerName") String theCustomerName, Model model) {
		
		List<Customer> theCustomers = customerService.searchCustomer(theCustomerName);
		
		model.addAttribute("customers", theCustomers);
		return "listuser";
	}
}

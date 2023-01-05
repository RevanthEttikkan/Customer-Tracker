package revanth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import revanth.DAO.CustomerDAO;
import revanth.entity.Customer;
import revanth.service.CustomerService;

@Controller

@RequestMapping("/customer")
public class customerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		
		List<Customer> thecustomer=customerService.getCustomers();
		
		theModel.addAttribute("customerDetail",thecustomer);
		
		
		return "list-customer";
		
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model themodel) {
		Customer thecustomer=new Customer();
		themodel.addAttribute("theCustomer",thecustomer);
		return "add-customer";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("theCustomer") Customer thecustomer) {
		customerService.saveCustomer(thecustomer);
		System.out.println("The save Customer"+thecustomer.toString());
		return "redirect:/customer/list";
	
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerId") int id,Model theModel) {
		Customer theCustomer=customerService.getCustomer(id);
		
		theModel.addAttribute("theCustomer",theCustomer);
		return "add-customer";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id,Model themodel) {
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
		
	}
	
	

}

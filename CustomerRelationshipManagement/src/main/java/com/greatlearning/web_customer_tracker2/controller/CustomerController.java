package com.greatlearning.web_customer_tracker2.controller ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller ;
import org.springframework.ui.Model ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam ;

import com.greatlearning.web_customer_tracker2.entity.Customer ;
import com.greatlearning.web_customer_tracker2.service.CustomerService ;

@Controller
@RequestMapping( "/customers" )
public class CustomerController {
	
	@Autowired
	private CustomerService customerService ;
	
	// add mapping for "/list"
	@RequestMapping( "/list" )
    public String listCustomers( Model theModel ) {
    
	// get Customers from database
	List<Customer> theCustomers = customerService.findAll() ;
	
	// add to the spring model
	theModel.addAttribute( "ListofCustomers", theCustomers ) ;
    	
	return "list-customers" ;
    }
	
	
	@RequestMapping( "/showFormForAdd" )
  	public String showFormForAdd( Model theModel ) {

  	// create model attribute to bind form data
  	Customer theCustomer = new Customer() ;

  	// set Customer as a model attribute to pre-populate the form
  	theModel.addAttribute( "Customer", theCustomer ) ;

    return "customer-form" ;
  	     
    }
	

    @RequestMapping( "/showFormForUpdate" )
	public String showFormForUpdate(@RequestParam( "customerId" ) int theId, Model theModel ) {

	// get the Customer from the service
	Customer thecustomer = customerService.findById( theId );

	// set Customer as a model attribute to pre-populate the form
	theModel.addAttribute( "Customer", thecustomer );

	// send over to our form
	return "customer-form" ;
	     
    }
    
    
    @PostMapping( "/save" )
	public String saveCustomer( @RequestParam( "Id" ) int Id,
			   @RequestParam( "FirstName" ) String FirstName,
			   @RequestParam( "LastName" ) String LastName,
	           @RequestParam( "Email" ) String Email ) 
	           {
    	       System.out.println( Id ) ;
			   Customer theCustomers ;
					if ( Id!= 0 ) {
						theCustomers = customerService.findById( Id ) ;
						theCustomers.setFirstName( FirstName ) ;
		                theCustomers.setLastName( LastName ) ;
						theCustomers.setEmail( Email ) ;
					    } else
					    theCustomers = new Customer( Id, FirstName, LastName, Email ) ;
					    // save the Customers
				        customerService.save( theCustomers ) ;

					    // use a redirect to prevent duplicate submissions
					    return "redirect:/customers/list" ;
				     }
    
    @RequestMapping( "/delete" )
	public String delete( @RequestParam( "custId" ) int theId ) {

		// delete the Customer
		customerService.deleteById( theId ) ;

		// redirect to /customers/list
		return "redirect:/customers/list" ;
     }
	
    @RequestMapping( "/search" )
	public String search( @RequestParam( "FirstName" ) String FirstName, Model theModel ) {
        // check names, if both are empty then just give list of all Customers

		if ( FirstName != null ) {
			return "redirect:/customers/list" ;
		} else {
			// else, search by first name
			List<Customer> theCustomers = customerService.searchBy( FirstName ) ;

			// add to the spring model
			theModel.addAttribute( "Customers", theCustomers ) ; 

			// send to list-customers
			return "list-customers" ;
		}

    }

}


	
   

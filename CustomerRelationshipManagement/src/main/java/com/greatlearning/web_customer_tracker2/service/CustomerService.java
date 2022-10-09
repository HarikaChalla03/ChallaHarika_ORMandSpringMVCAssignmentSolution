package com.greatlearning.web_customer_tracker2.service ;

import java.util.List ;

import com.greatlearning.web_customer_tracker2.entity.Customer ;

public interface CustomerService {

	public List<Customer> findAll() ;
	
	public Customer findById( int theId ) ;
	
	public void save( Customer theCustomer ) ;
	
	public void deleteById( int theId ) ;
	
	public List<Customer> searchBy( String firstName );
	
}

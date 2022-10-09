package com.greatlearning.web_customer_tracker2.controller ;

import org.springframework.stereotype.Controller ;

import org.springframework.web.bind.annotation.RequestMapping ;

@Controller
@RequestMapping( "/" )
public class HomePage {
    	
   @RequestMapping( "/hello" )
    	
    public String showHomePage() {
    	
    System.out.println( "Working" ) ;
    	
    return "home" ;
    	
    }
 }
	


package com.greatlearning.web_customer_tracker2.service ;

import java.util.List ;

import javax.transaction.Transactional ;

import org.hibernate.HibernateException ;
import org.hibernate.Session ;
import org.hibernate.SessionFactory ;
import org.hibernate.Transaction ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Repository ;

import com.greatlearning.web_customer_tracker2.entity.Customer ;

@Repository
public class CustomerServiceImpl implements CustomerService{
         
	    // create sessionFactory
        @SuppressWarnings( "unused" )
	    private SessionFactory sessionFactory ;
        // create session
	    private Session session ;
	    
	    @Autowired
		CustomerServiceImpl( SessionFactory sessionfactory )
	    {
			this.sessionFactory = sessionfactory ;
			try {
				session = sessionfactory.getCurrentSession() ;
			}
			catch( HibernateException e ){
				session = sessionfactory.openSession() ;
			}
		}
	    
	    @Transactional
	    public List<Customer> findAll() 
	     {
		
	    	Transaction tx = session.beginTransaction() ;
	    	
	    	// find all the records from the database table(customers)
            @SuppressWarnings( "unchecked" )
		    List<Customer> customers = session.createQuery( "from Customer" ).list() ;
			
			tx.commit() ;
			return customers ;
	     }

	      @Transactional
	      public Customer findById( int theId ) 
	      {
	    	  
	    	  Customer customer = new Customer() ;
	    	  
	    	  Transaction tx = session.beginTransaction() ;
	    	  
	    	  // find record with Id from the database table
	    	  customer = session.get( Customer.class, theId ) ;
		 
	    	  tx.commit() ;
		 
		      return customer ;
	      }

	       @Transactional
	       public void save( Customer theCustomer ) {
		     
	    	   Transaction tx = session.beginTransaction() ;
	    	   
	    	   // save transaction
	    	   session.saveOrUpdate(theCustomer) ;
	    	   
	    	   tx.commit() ;
	    	   
	       }
	    	   
		
	       @Transactional
	       public void deleteById( int Id ) {
		       
	    	   Transaction tx = session.beginTransaction() ;
	    	   
	    	    // get transaction
				Customer customer = session.get( Customer.class, Id ) ;
		
				// delete record
				session.delete( customer ) ;

				tx.commit() ;
	        }
    
	       
	           @Transactional
	           public List<Customer> searchBy( String FirstName, String LastName, String Email ) {
			  
	    	   Transaction tx = session.beginTransaction() ;
	    	   String query = "" ;
	    	   
	    	   if ( FirstName.length() != 0 && Email.length() != 0 )
					query = "from Customer where FirstName like '%" + FirstName + "%' or Email like '%" + Email + "%'" ;
				else if (FirstName.length() != 0)
					query = "from Customer where FirstName like '%" + FirstName + "%'" ;
			    else if (Email.length() != 0)
					query = "from Student where  Email like '%" + Email + "%'" ;
				else
					System.out.println("Cannot search without input data") ;

				@SuppressWarnings( "unchecked" )
				List<Customer> customer = session.createQuery(query).list() ;
				
				tx.commit() ;

				return customer ;
				
	       }
	       
	       //print the loop
			@Transactional
			public void print( List<Customer> customer ) {

				for ( Customer c : customer ) {
					System.out.println(c) ;
				}
		}

		@Override
		public List<Customer> searchBy( String FirstName ) {
			// TODO Auto-generated method stub
			return null ;
		}
}



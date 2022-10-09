<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

   <head>
       <!-- Required meta tags -->
       <meta charset="UTF-8">
       <meta name= "viewport"  content="width=device-width, initial-scale=1, shrink-to-fit=no">
       
       <!-- Bootstrap CSS -->
       <link rel="stylesheet"
	    href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	    integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	    crossorigin="anonymous">
	    
	   <title> CUSTOMER DIRECTORY</title>
    </head>
      
      
    <body>
       <div class="container">
        <div class="p-3 mb-2 bg-success text-white"><h5> CUSTOMER RELATIONSHIP MANAGEMENT </h5> </div>
	    <!-- Add a search form -->
		<form method = "get" action="/CustomerRelationshipManagement/customers/search">
		
		<!-- Add a button -->
	    <a href="/CustomerRelationshipManagement/customers/showFormForAdd"  class="btn btn-warning"> Add Customer </a>
		</form>
	    
	    <table class="table table-bordered table-striped">
	        <thead class="p-3 mb-2 bg-info text-white">
				 <tr>
				    <th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				 </tr>
		    </thead>
		    
		    <tbody>
		        <c:forEach items="${ListofCustomers}" var="tempCustomer">
				   <tr>	
				       <td><c:out value="${tempCustomer.firstName}" /></td>
					   <td><c:out value="${tempCustomer.lastName}" /></td>
					   <td><c:out value="${tempCustomer.email}" /></td>
					   <td>
					   <!-- Add "update" button/link --> 
					    <a href= "/CustomerRelationshipManagement/customers/showFormForUpdate?customerId=${tempCustomer.id}" 
						 class="btn btn-warning btn-sm"> Update </a>
						     
					    
						<!-- Add "delete" button/link -->
						<a href="/CustomerRelationshipManagement/customers/delete?custId=${tempCustomer.id}"
						 class="btn btn-danger btn-sm" 
						 onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete </a>
						 
					   </td>
                   </tr>
                </c:forEach>
              </tbody>   
          </table>  
         
         <a href =/CustomerRelationshipManagement/customers/showFormForAdd>REGISTER NEW CUSTOMER</a>	
      
      </div>  
   </body> 
</html>
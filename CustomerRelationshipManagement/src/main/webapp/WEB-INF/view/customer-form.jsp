<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
      
       <head>
           <!-- Required meta tags -->
           <meta charset="UTF-8">
           <title>Required Meta Tags</title>
           <meta charset="utf-8">
           <meta name="viewport"
	       content="width=device-width, initial-scale=1, shrink-to-fit=no">
	       
	       <!-- Bootstrap CSS -->
	       
	       <link rel="stylesheet" 
	       href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css" 
	       integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" 
	       crossorigin="anonymous">
	       
	       <title>Save Customer</title>
        </head>
 
        <body>
                
               <div class="container">
                   <div class="p-3 mb-2 bg-success text-white"><h5>CUSTOMER DIRECTORY</h5></div>
		            <hr>
		              <p class="h4 mb-4">Customer Details</p>
		         
		               <form action="/CustomerRelationshipManagement/customers/save" method="POST">
		               
		               <!-- Add hidden form field to handle update -->
		               <input type="hidden" name="Id" value="${Customer.id}"/>
		      
		               <div class="form-inline">
		               <input type="text" name="FirstName" value="${Customer.firstName}"
		               class="form-control mb-4 col-4" placeholder="FirstName">
		               </div>
		               
		               <div class="form-inline">
                       <input type="text" name="LastName" value="${Customer.lastName}"
		               class="form-control mb-4 col-4" placeholder="LastName">
                       </div>
                       
                      <div class="form-inline">
                      <input type="text" name="Email" value="${Student.email}"
		              class="form-control mb-4 col-4" placeholder="Email">
                      </div>
                      
                      <button type="submit" class="btn btn-info col-2">Save</button>
                      
                      </form>
                   <hr>
                   <a href="/CustomerRelationshipManagement/customers/list">Back to Customers List</a>
              </div>
       </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Table</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<style><link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body>
     
     <nav class="navbar navbar-default">
<div class = "container-fluid">
<div class="navbar-header">
<img src = "C:\Users\koel.chowdhury\DT TTT\Images\logos.png" class="img-responsive" alt="No image" width="104" height="136">
    
  <ul class="nav navbar-nav">
     	
  		<li> <a href="index">Home</a></li>
  		
  </ul> 
  </div>
     </div>
     </nav>
     <br>
     
     </div>
<div class="container">
  <div class="row">
<div class = "col-lg-4">
<img src="C:\Users\koel.chowdhury\DT TTT\Images\pizza.png"  height = "100" width = "100" alt="pizza" class="img-responsive">
</div>
<div class = "col-lg-4">
<img src="C:\Users\koel.chowdhury\DT TTT\Images\chicken_wings.png"   height = "100" width = "100" alt="Chicken" class="img-responsive">
</div>
<div class = "col-lg-4">
<img src="C:\Users\koel.chowdhury\DT TTT\Images\choco.png"   height = "100" width = "100" alt="choco" class="img-responsive">
</div>
</div>
</div>
     <br>
     <br>
  <div class = "container">    
<table id="product" class="table table-striped" >
 
        <thead>  
          <tr>  
            <th>ID</th>  
            <th>Name</th>  
            <th>Phone</th>  
            <th>Email</th>
            <th>Password</th> 
            <th>Retype</th>   
          </tr>  
        </thead>  
        <tbody>  
          <c:forEach items="${custlist}" var="prod">
     <tr>
       <td>${prod.id}</td>
       <td>${prod.name}</td>
       <td>${prod.price}</td>
       <td>${prod.category}</td>
       <td><a href ="<c:url value= '/edit/${prod.id}'/>">Edit</td>
       <td><a href ="<c:url value= '/remove/${prod.id}'/>">Delete</td>
     </tr>
    </c:forEach> 
          
        </tbody>  
      </table>  
  
      </div>
      <script>
$(document).ready(function(){
    $('#product').dataTable();
});
</script>
 <nav class="navbar navbar-inverse navbar-fixed-bottom">

<h5><b><font color = "White">About</font> </b><span class="label label-default">Spreading cheesyness for decades</span></h5>
<div class = "container">

<div class = "navbar-text pull-right"> 

<a href ="https://www.facebook.com" ><i class="fa fa-facebook fa-4x" ></i></a>
<a href ="https://www.facebook.com" ><i class="fa fa-twitter fa-4x" ></i></a>
<a href ="https://www.facebook.com" ><i class="fa fa-github fa-4x" ></i></a>
</div>
</div>

</nav>

</body>
</html>
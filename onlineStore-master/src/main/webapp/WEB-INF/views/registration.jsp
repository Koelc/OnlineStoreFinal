<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

    <title>Be a Registered Customer - Enjoy super discounts</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <style type="text/css">
    body {
    background-color: #eee;
}

*[role="form"] {
    max-width: 530px;
    padding: 15px;
    margin: 0 auto;
    background-color: #fff;
    border-radius: 0.3em;
}

*[role="form"] h2 {
    margin-left: 5em;
    margin-bottom: 1em;
}


    </style>
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'http://bootsnipp.com');
        });
    </script>
</head>
<body>

<nav class="navbar navbar-inverse">
<div class = "container-fluid">
<div class="navbar-header">
<img src = "C:\Users\koel.chowdhury\DT TTT\Images\logos.png" class="img-responsive" alt="No image" width="104" height="136">

</div>
  <div>
  <ul class="nav navbar-nav">
     	
  		<li> <a href="index"><p class="text-primary"><span class="glyphicon glyphicon-home">Home</span></p></a></li>
  		
  </ul> 
  </div>
  </div>
  </nav>
  <center>
  <div style="color: teal; font-size: 30px">Customer |Registration Form</div>

  <form:form action="addCustomer" modelAttribute="customer" method="post">
   <table>
    <tr>
     <%-- <td>Id:</td>
     <td>
     <form:input path="id" />
     </td>
     <td style="color: red; font-style: italic;"><form:errors path="id" />
     </td> --%>
    </tr>
    <tr>
     <td>Name:</td>
     <td><form:input path="name" />
     </td>
     <td style="color: red; font-style: italic;"><form:errors
       path="name" />
     </td>
    </tr>
       <tr>
     <td>Email:</td>
     <td><form:input path="email" />
     </td>
     <td style="color: red; font-style: italic;"><form:errors
       path="email" />
     </td>
    </tr>
    <tr>
     <td>Phone:</td>
     <td><form:input path="phone" />
     </td>
     <td style="color: red; font-style: italic;"><form:errors
       path="phone" />
     </td>
    </tr>
    <tr>
     <td>Password:</td>
     <td><form:password path="password" />
     </td>
     <td style="color: red; font-style: italic;"><form:errors
       path="password" />
     </td>
    </tr>
    <tr>
     <td>Confirm Password:</td>
     <td><form:password path="re_type" />
     </td>
     <td style="color: red; font-style: italic;"><form:errors
       path="re_type" />
     </td>
    </tr>
    
     <tr>
     <td></td>
     <td><input type="submit" value="Save" />
     </td>
    </tr>
     </table>
  </form:form>
    </body>
</html>

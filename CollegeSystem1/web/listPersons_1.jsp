<%-- 
    Document   : lisstPersons
    Created on : 29-Nov-2022, 10:18:15 AM
    Author     : tlazr
--%>

<%@page import="java.util.List"%>
<%@page import="model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>  Creation de personne avec succes </h1>
        ${message}
        
        
         Liste des personnes
         
        <%
            List<Person> l =  (List<Person>) request.getAttribute("listPersons");
        for ( Person p: l) {
        %>
       <%= p.getId() %>   ||  <%= p.getName() %>    <br>
        
        <% } %>
    </body>
</html>

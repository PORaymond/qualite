<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
         
          <c:forEach var="p" items="${listPersons}" >
                     <table>    
                    <tr>
                        <td>  ${p.id} </td>  
                        <td>   ${p.name} </td>
                          <td>    <a href="<c:url value='/TestServlet?m=${p.id}&act=delete'/>">delete</a>   
                        </td>
                        
                        
                    </tr>
                    </table>
                </c:forEach>
    </body>
</html>

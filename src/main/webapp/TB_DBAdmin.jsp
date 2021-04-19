<%-- 
    Document   : PersonDBCollection - with EL & JSTL & SQL
    Created on : Nov 20, 2020, 09:13:04 PM
    Author     : kcook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CPS298 A-Team TicketBooker - SQL DB based</title>
    </head>
    <body>
        <h1>Ticket Booker SQL DB Administration</h1>
        <h3>Status: ${stsMsg}</h3>
        <a href="index.html">Back to Home Page</a>
        <hr>
        <c:if test="false" >
            <form action="TB_DBAdmin_Servlet">
                PERFORM DESTRUCTIVE ACTION?
                <label for="YES">YES</label>
                <input type="radio" id="YES" name="confirm" value="YES"/>
                <label for="NO">NO</label>
                <input type="radio" id="NO" name="confirm" value="NO" checked="x"/>
                <br><br>
                <input type="submit" name="action" value="DROP TABLE"/>
                <input type="submit" name="action" value="CREATE TABLE"/>
            </form>
            <br>
            <hr>
        </c:if>
         <form action="TB_DBAdmin_Servlet">
            <label for="sqltable">Choose SQL Table:</label>
            <select name="sqltable" id="sqltable">
                <option value="customer">customer</option> 
                <option value="movie">movie</option> 
                <option value="screen">screen</option> 
                <option value="seat">seat</option> 
                <option value="showing">showing</option> 
                <option value="ticket">ticket</option> 
                <option value="ticket_seat">ticket_seat</option> 
            </select>
            &nbsp;
            <input type="submit" name="action" value="DESCRIBE TABLE"/>
            <!--
            &nbsp;
            <input type="submit" name="action" value="SHOW TABLE"/>
            -->
        </form>
        <br>
        <hr>
        <br>
        <c:if test="false" >
        <form action="TB_DBAdmin_Servlet">
            <input type="text" name="name"   /> Name <br>
            <input type="text" name="eyes"   /> Eye Color <br>
            <input type="text" name="hair"   /> Hair Color <br>
            <input type="text" name="height" /> Height <br>
            <input type="text" name="weight" /> Weight <br>
            <input type="text" name="email"  /> E-mail address <br>
            <input type="text" name="dob"    /> Date of Birth <br>
            <input type="submit" name="action" value="add"/>
        </form>
        <hr>
        </c:if>
        <h3>${errMsg}</h3>
            <!-- Build table of describe table output -->
            <c:forEach var="fld" items="${FldLst}" varStatus="loopStatus">
                <c:if test="${loopStatus.first}" >
                <table border="3">
                <tr><th>Field</th><th>Type</th><th>Null</th><th>Key</th><th>Default</th><th>Extra</th></tr>
                </c:if>
                    <tr>
                        <td>${fld.fldName}</td>
                        <td>${fld.fldType}</td>
                        <td>${fld.fldNull}</td>
                        <td>${fld.fldKey}</td>
                        <td>${fld.fldDflt}</td>
                        <td>${fld.fldExtra}</td>
                        
                    </tr>
            <c:if test="${loopStatus.last}" >
                </table>
            </c:if>
            </c:forEach>
            
        
    </body>
</html>

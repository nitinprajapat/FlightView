<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.nagarro.dto.Flight"%>
    <%@page import ="java.util.List"  %>;
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <p align="center">Flight Results</p>
       
       <table width="100%"  border="1"  bgcolor="#ffb3ff" align="center">
				<tr>
					<th>Flight No.</th>
					<th>Departure Location</th>
					<th>Arrival Location</th>
					<th>Flight Time</th>
					<th>Flight Class</th>
					<th>Fare</th>
					<th>Duration</th>
				</tr>
				
				<%
				List<Flight>flights=(List<Flight>)request.getAttribute("flights");
				
				for(Flight flight:flights){
				%>
				<tr align="center">
				    <td><%=flight.getFlightNo()%></td>
				    <td><%=flight.getDepLoc()%></td>
				    <td><%=flight.getArrLoc()%></td>
				    <td><%=flight.getFlightTime()%></td>
				    <td><%=flight.getFlightClass()%></td>
				    <td><%=flight.getFare()%></td>
				    <td><%=flight.getFlightDuration()%></td>
				<%
					}
				%>
     </table>
</body>
</html>
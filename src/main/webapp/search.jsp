<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

      <form action="Search" method="get">
      
      <p align="center">Please Enter flight Details</p>
   
      <table width="100" bgcolor="#5cd65c" align="center">
   
         <tr>
         <td>Departure Location  </td>
         <td><input type="text" name="depLoc"></td></tr>
         <tr>
         <td>Arrival Location </td>
         <td><input type="text" name="arrLoc"></tr>
         <tr>
         <td>Flight Date </td>
         <td><input type="text" name="date"></td>
         </tr>
         <tr>
         <td>Class</td>
         <td><input type="radio" name="Class" value="E">E 
         <input type="radio"  name="Class" value="EB">EB</td>
         </tr>
         <tr>
         <td>Output Preference</td>
         <td><input type="radio" name="outPref" value="fare">Fare
         <input type="radio" name="outPref" value="duration">Duration</td>
         </tr>
         <tr>
         <td align="center" colspan="2"><input type="submit" value="Search"  ></td></tr>
         </table>    
            
    </form> 
</body>
</html>
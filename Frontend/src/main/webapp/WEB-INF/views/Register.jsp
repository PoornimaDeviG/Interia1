<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>
<form>
<fieldset>
<legend >Personal information</legend>
<table><tr><td>Name:</td>
<td><input type="text" name="name" placeholder="Enter your name"></td>
</tr>
<tr>
<td>Gender:</td>
<td><input type="radio" name="gender" value="male" checked>Male
<input type="radio" name="gender" value="female">Female</td>
</tr>
<tr>
<td>DOB</td>
<td><input type="date" name="date" required></td>
</tr>
</table>
</fieldset><br><br><br><br>
<fieldset>
<legend>Contact information</legend>
<table>
<tr>
<td>Address:</td>
<td> <textarea name="address" rows="4" cols="21">Enter your Address</textarea></td></tr>
<tr><td>city:</td><td><input type="text" name="city"></td></tr>
<tr><td>State:</td><td><input type="text" name="state"></td></tr>
<tr><td>Phone Number:</td><td><input type="tel" name="usrtel" required></td></tr>
</fieldset><br><br><br><br>

</form>
</body>
</html>
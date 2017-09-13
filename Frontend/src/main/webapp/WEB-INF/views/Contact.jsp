<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Contact Us</title>
<%@ include file="Nav.jsp"%>
</head>
<body>
<p>Please email us here for the fastest response or call during business hours 0800 436 654 or 021 306 022.</p>

<p>Email Id:<b>interia3071@gmail.com</b></p></div>	
	
	<form  style="padding:10px;">
		<fieldset style="width:500px;">
			<h3>Send a message</h3>
			<table>
			<tr><td><label for="id_contact">Subject Heading</label></td>
							<td><select id="id_contact" name="id_contact" onchange="showElemFromSelect('id_contact', 'desc_contact')">
									<option value="2" >Customer service</option>
								</select></td></tr>
			
	
					<tr>					
				<td><label for="first_name">Name</label></td>
				<td><input type="text" id="first_name" name="first_name" value=""/></td></tr>
			<tr>
			<p class="text">
				<td><label for="email">E-mail address</label></td>
									<td><input type="text" id="email" name="from" value="" /></td>
							</p></tr>
			
		
		<tr><p class="textarea">
			<td><label for="message">Message</label></td>
			 <td><textarea id="message" name="message" rows="8" cols="21" ></textarea></td></tr>
		</p>
		
				
		<tr><p class="submit">
			<td></td><td><input type="submit" name="submitMessage" id="submitMessage" value="Send" class="button_large" onclick="$(this).hide();" />
		</td></p></tr></table>
	</fieldset>
</form>


</body>
</html>
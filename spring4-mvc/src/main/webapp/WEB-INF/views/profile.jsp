
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
#data {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#data td, #data th {
    border: 1px solid #ddd;
    padding: 8px;
}

#data tr:nth-child(even){background-color: #f2f2f2;}

#data tr:hover {background-color: #ddd;}

#data th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}

</style>


<script >

function showDiv() {
	$("#changePasswordDiv").show()

}


</script>
</head>
<body>

<h5>${user.msg}</h5>
Welcome ${user.name}


<table id ="data">
  <tr>
    <th>Company Name</th>
    <th>Email Id</th>
    <th>Name</th>
  </tr>
  <tr>
    <td id ="company_name">${user.companyName}</td>
    <td id ="email_id">${user.email}</td>
    <td id="name">${user.name}</td>
  </tr>
</table>
<br/><br/>
<input type="button" value="Change Password" onclick="showDiv()">
<br/><br/>
<div id="changePasswordDiv" style="display: none;">
<form action="/springmvcapp/updatePassword" method="post">
	 Email : <input type="text" name="email" value="${user.email}" readonly="readonly"/><br/><br/>   
	Current password: <input type="password" name="password_old"/><br/><br/>  
	Change Password: <input type="text" name="password_new"/><br/><br/>
	Confirm Change Password: <input type="password" name="password_confirm"/><br/><br/>
<input type="submit" value="Save Changes"/>  <br/><br/>  

</form> 

</div>
<a href="/springmvcapp/logout">logout </a>
</body>
</html>
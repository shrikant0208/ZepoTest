
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
function validateEmail($email) {
	  var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	  return emailReg.test( $email );
	}
	
	

	


$(document).ready(function() {
	 $(':input[type="submit"]').prop('disabled', true);
	 $('#emailId').on('change keyup paste', function() {
		console.log("in");
	if( !validateEmail($("#emailId").val())) { 
		console.log("invalid email");
		$('#invalid_email_msg').empty();
		$('#invalid_email_msg').append("invalid email"); 
		 $(':input[type="submit"]').prop('disabled', true);
	}
	else{
		console.log("valid email");
		$('#invalid_email_msg').empty();
		 $(':input[type="submit"]').prop('disabled', false);
	}
});
});


</script>
</head>
<body>
<h3>Welcome Please SignUp...</h3>
<h5>${msg}</h5>
<form action="/springmvcapp/save" method="post">  
Name: <input type="text" name="name" required/><br/><br/>  
Company Name: <input type="text" name="companyName" required/><br/><br/>  
Email: <input type="text" name="email" id="emailId" required/><h5 id="invalid_email_msg" style="color:red;"></h5><br/><br/> 
Password: <input type="password" name="password" required/><br/><br/>  
<input type="submit" value="Save" />  <br/><br/>  
</form>  

</body>
</body>
</html>
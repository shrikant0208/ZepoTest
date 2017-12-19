
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h3>Welcome </h3> ${user.name} <h3> Please Login...</h3>
<h5>${msg}</h5>
<form action="/springmvcapp/login" method="post">  
Email: <input type="text" name="email"/><br/><br/>  
Password: <input type="password" name="password"/><br/><br/>  
<input type="submit" value="login"/>  <br/><br/>  

</form>
<a href="/springmvcapp/redirectSignup">New User?? </a>  
</body>
</body>
</html>
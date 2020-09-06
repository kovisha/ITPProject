function signinValidate()
{
	var username2 = documents.forms["signINform"]["uname"];
	var pass2      = document.forms["signINform"]["password"];
	
	if (username2.value == "")	
	{ 
	window.alert("Please enter your  username."); 
	username2.focus(); 
	return false; 
	}
	
	if (pass2.value == "")	
	{ 
	window.alert("Please enter your password."); 
	pass2.focus(); 
	return false; 
	}  
	
	

}




function validation()	
{ 
	var fname   = document.forms["signUPform"]["fname"];
	var lname   = document.forms["signUPform"]["lname"];
	var username1 = document.forms["signUPform"]["uname"];
	var email       = document.forms["signUPform"]["email"];
	var address       = document.forms["signUPform"]["address"];
	var dob = document.forms["signUPform"]["dob"];
	var anniversary = document.forms["signUPform"]["doa"];
	var occupation = document.forms["signUPform"]["job"];
	var phonenumber = document.forms["signUPform"]["phone"];
	var pass1        = document.forms["signUPform"]["pass"];
	var repass      = document.forms["signUPform"]["conpass"];
	
	
	  

if (fname.value == "")	
{ 
window.alert("Please enter your first name."); 
name.focus(); 
return false; 
} 

if (lname.value == "")	
{ 
window.alert("Please enter your last name."); 
name.focus(); 
return false; 
} 

if (username1.value == "")	
{ 
window.alert("Please enter a  username."); 
username1.focus(); 
return false; 
} 

if (email.value == "")	
{ 
window.alert("Please enter an  e-mail address."); 
email.focus(); 
return false; 
} 

if (email.value.indexOf("@", 0) < 0)	
{ 
window.alert("Please enter a valid e-mail address."); 
email.focus(); 
return false; 
} 

if (email.value.indexOf(".", 0) < 0)	
{ 
window.alert("Please enter a valid e-mail address."); 
email.focus(); 
return false; 
} 

if (address.value == "")	
{ 
window.alert("Please enter your address."); 
name.focus(); 
return false; 
}


if (phonenumber.value == "")	
{ 
window.alert("Please enter your telephone number."); 
phonenumber.focus(); 
return false; 
}  

if (pass1.value == "")	
{ 
window.alert("Please enter a password."); 
pass1.focus(); 
return false; 
}  


if (repass.value == "")	
{ 
window.alert("Please re enter  password."); 
repass.focus(); 
return false; 
}  

}


function onlyletter()
{
	var fname = document.forms["signUPform"]["fname"].value;
	var letter = /^[A-Za-z]+$/;
	
	if(fname.match( letter))
	{
		return true;
	}
	
	else{
		window.alert("Please enter a valid name");
		return false;
	}
}

function onlyletter1()
{
	var lname = document.forms["signUPform"]["lname"].value;
	var letter = /^[A-Za-z]+$/;
	
	if(lname.match(letter))
	{
		return true;
	}
	
	else{
		window.alert("Please enter a valid name");
		return false;
	}
}


function phoneNumber(){
	
	var phone = document.forms["signUPform"]["phone"];
	var num = /^[0-9]{10}$/;
	
	if(!num.test(phone.value))
	{
		alert("please enter a valid phone number");
		return false;
	}
	
	else{
		return true;
	}
}
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


function checkMail(){
	
	var email       = document.forms["signUPform"]["email"];
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
	
}


/**********************************************Start Category Stock And Item validation***************************************************************/ 

function onlyCategoryletter()
{
	var catname = document.forms["InsertCategory"]["categoryName"].value;
	var letter = /^[A-Za-z]+$/;
	
	if(catname.match( letter))
	{
		return true;
	}
	
	else{
		window.alert("Please enter a valid category name");
		return false;
	}
}


function onlyCategoryUpdateletter()
{
	var catupdatename = document.forms["categoryUpdate"]["categoryName"].value;
	var letter = /^[A-Za-z]+$/;
	
	if(catupdatename.match( letter))
	{
		return true;
	}
	
	else{
		window.alert("Please enter a valid category name");
		return false;
	}
}


function onlyItemletter()
{
	var itemname = document.forms["itemsForm"]["itemName"].value;
	var letter = /^[A-Za-z]+$/;
	
	if(itemname.match( letter))
	{
		return true;
	}
	
	else{
		window.alert("Please enter a valid item name");
		return false;
	}
}

function onlyItemUpdateletter()
{
	var itemupdatename = document.forms["itemUpdate"]["itemName"].value;
	var letter = /^[A-Za-z]+$/;
	
	if(itemupdatename.match( letter))
	{
		return true;
	}
	
	else{
		window.alert("Please enter a valid item name");
		return false;
	}
}

function onlyStockNameletter()
{
	var stockname = document.forms["stockForm"]["stockName"].value;
	var letter = /^[A-Za-z]+$/;
	
	if(stockname.match( letter))
	{
		return true;
	}
	
	else{
		window.alert("Please enter a valid stock name");
		return false;
	}
}

function onlyStockNameUpdateletter()
{
	var stockupdatename = document.forms["UpdateStock"]["stockName"].value;
	var letter = /^[A-Za-z]+$/;
	
	if(stockupdatename.match( letter))
	{
		return true;
	}
	
	else{
		window.alert("Please enter a valid stock name");
		return false;
	}
}

function onlyItemSize(){
	
	var iSize = document.forms["itemsForm"]["iSize"];
	var num = /^[0-9]+$/;
	
	
	
	if(!num.test(iSize.value))
	{
		alert("please enter a valid item size");
		return false;
	}
	
	else{
		return true;
	}
}

function onlyItemPrice(){
	
	var iPrice = document.forms["itemsForm"]["iPrice"];
	var num = /^[0-9]+$/;
	
	if(!num.test(iPrice.value))
	{
		alert("please enter a valid item price");
		return false;
	}
	
	else{
		return true;
	}
}

function onlyItemQty(){
	
	var iQty = document.forms["itemsForm"]["qty"];
	var num = /^[0-9]+$/;
	
	if(!num.test(iQty.value))
	{
		alert("please enter a valid item quantity");
		return false;
	}
	
	else{
		return true;
	}
}

function onlyStockSize(){
	
	var sSize = document.forms["stockForm"]["sSize"];
	var num = /^[0-9]+$/;
	
	if(!num.test(sSize.value))
	{
		alert("please enter a valid stock size");
		return false;
	}
	
	else{
		return true;
	}
}

function onlyStockQty(){
	
	var sQty = document.forms["stockForm"]["supQty"];
	var num = /^[0-9]+$/;
	
	if(!num.test(sQty.value))
	{
		alert("please enter a valid stock quantity");
		return false;
	}
	
	else{
		return true;
	}
}

function onlyStockStoreQty(){
	
	var storeQty = document.forms["stockForm"]["qtySent"];
	var num = /^[0-9]+$/;
	
	if(!num.test(storeQty.value))
	{
		alert("please enter a valid store quantity");
		return false;
	}
	
	else{
		return true;
	}
}


 

/**********************************************End Category Stock And Item validation***************************************************************/ 








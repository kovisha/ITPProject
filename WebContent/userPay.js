function confPayMonthInstall() {
    confirm("Are you sure you want pay monthly installment?");
}

function validateCardDetails() {
    var cardType= document.forms["pay2"]["cardType"].value;
    var cardNo= document.forms["pay2"]["cNum"].value;
    var visaNo = /^(?:4[0-9]{12}(?:[0-9]{3})?)$/;
    var mastCard = /^(?:5[1-5][0-9]{14})$/;
    var amerEx = /^(?:3[47][0-9]{13})$/;
    
    if(cardType === "VISA"){
    	if(!cardNo.match(visaNo)){
    		alert("Invalid Card Number!!!");
    		window.location ='userCardInput.jsp';
    		return false;
    	}
    }
    else if(cardType === "MCard"){
    	if(!cardNo.match(mastCard)){
    		alert("Invalid Card Number!!!");
    		window.location='userCardInput.jsp';
    		return false;
    	}
    }
    else if(cardType === "AmericanExp"){
    	if(!cardNo.match(amerEx)){
    		alert("Invalid Card Number!!!");
    		window.location='userCardInput.jsp';
    		return false;
    	}
    }
}
function confPayMonthInstall() {
	Swal.fire({
    			title: 'Confirm paying Monthly Installment?',
    			showCancelButton: true,
			  	confirmButtonText: `Yes`,
			}).then((result) => {
			  	if (result.isConfirmed) {
			    	window.location = "monthInstall";
			  	} 
			})
}

function validateCardDetails() {
    var cardType= document.forms["pay2"]["cardType"].value;
    var cardNo= document.forms["pay2"]["cNum"].value;
    var visaNo = /^(?:4[0-9]{12}(?:[0-9]{3})?)$/;
    var mastCard = /^(?:5[1-5][0-9]{14})$/;
    var amerEx = /^(?:3[47][0-9]{13})$/;
    
    if(cardType === "VISA"){
    	if(!cardNo.match(visaNo)){
    		Swal.fire({
    			title: 'Invalid Card Number!!!',
				text:'Enter the correct VISA Card Number',
    			icon: 'error',
			}).then(function() {
    			window.location = "userCardInput.jsp";
				});
			return false;
    	}
    }
    else if(cardType === "MCard"){
    	if(!cardNo.match(mastCard)){
    		Swal.fire({
    			title: 'Invalid Card Number!!!',
				text:'Enter the correct Master Card Number',
    			icon: 'error',
			}).then(function() {
    			window.location = "userCardInput.jsp";
				});
			return false;
    	}
    }
    else if(cardType === "AmericanExp"){
    	if(!cardNo.match(amerEx)){
    		Swal.fire({
    			title: 'Invalid Card Number!!!',
				text:'Enter the correct Amex Card Number',
    			icon: 'error',
			}).then(function() {
    			window.location = "userCardInput.jsp";
				});
			return false;	
    	}
    }
}

/*  ==========================================
    SHOW UPLOADED IMAGE
* ========================================== */
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imageResult')
                .attr('src', e.target.result)
                .height(300);
        };
        reader.readAsDataURL(input.files[0]);
    }
}

/*$(function () {
    $('#upload').on('change', function () {
        readURL(input);
    });
});*/

/*  ==========================================
    SHOW UPLOADED IMAGE NAME
* ========================================== */
/*var input = document.getElementById( 'upload' );
var infoArea = document.getElementById( 'upload-label' );

input.addEventListener( 'change', showFileName );
function showFileName( event ) {
  var input = event.srcElement;
  var fileName = input.files[0].name;
  infoArea.textContent = 'File name: ' + fileName;
}*/

/*  ==========================================
SHOW UPLOADED IMAGE NAME
* ========================================== */

/*$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});*/

//Enabling textarea when check bocx is checked
function EnableDisableTextBox(chkAddress) {
    
	var Address = document.getElementById("address");
    
	Address.disabled = chkAddress.checked ? false : true;
    
	if (!address.disabled) {
        address.focus();
    }

}

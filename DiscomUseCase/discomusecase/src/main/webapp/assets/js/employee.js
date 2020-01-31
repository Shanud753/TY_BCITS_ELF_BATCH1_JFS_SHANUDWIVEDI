function validation() {

	var empIdVal = document.getElementById('empId').value;
	var desigVal = document.getElementById('desig').value;
	var empIdValid = false;
	var desigValid = false;


	if (empIdVal === '') {
		document.getElementById('emp1').innerHTML = " ** Please fill the  field";
        return false;
	} else {
		document.getElementById('emp1').style.display = 'none';
		empIdValid = true;
	}


//	Designation Validation

	if (desigVal == "") {
		document.getElementById('desig1').innerHTML = " ** Please fill the Designation field";
		return false;
	} else {
		document.getElementById('desig1').style.display = 'none';
		desigValid = true;
	}



	if (empIdValid && desigValid) {
		document.body.appendChild(form);
		form.submit();
		return true;
	}
}
















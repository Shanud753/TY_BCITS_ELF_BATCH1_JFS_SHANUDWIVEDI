function validation() {

    var empIdVal = document.getElementById('empId').value;
    var desigVal = document.getElementById('desig').value;
    var empIdregx =  /^[0-9]{5}[A-Z]{2}$/;
    // var passregx = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
        var empIdValid = false;
        var desigValid = false;


if (empIdVal === '') {
    document.getElementById('emp1').innerHTML = " ** Please fill the RR-Number field";

    // return false;
} else {

    if (empIdregx.test(empIdVal)) {
        rrNumValid = true;
    } else {
        document.getElementById('emp1').innerHTML = " ** Please Enter the Correct RR-number";
        // return false;
    }

}

//Designation Validation

if (desigVal == "") {
document.getElementById('desig1').innerHTML = " ** Please fill the Designation field";
return false;
} else {
document.getElementById('desig1').style.display = 'none';
desigValid = true;
}

}

if (empIdValid && desigValid) {
//    return true;
    window.location.href = "index.jsp";
}
















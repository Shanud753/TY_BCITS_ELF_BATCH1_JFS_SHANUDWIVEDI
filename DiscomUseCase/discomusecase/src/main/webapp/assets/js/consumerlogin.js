function validation() {

    var rrNumVal = document.getElementById('rrnumber').value;
    var passwordVal = document.getElementById('pwd').value;
    
    var rrNumregx = /^[0-9]{5}[A-Z]{2}$/;
    
    var rrNumValid = false;
    var passValid = false;

  //RR-Number Validation
    if (rrNumVal === '') {
        document.getElementById('rrnum').innerHTML = " ** Please fill the RR-Number field";
        return false;

    } else if (!rrNumregx.test(rrNumVal)) {
        document.getElementById('rrnum').innerHTML = " ** Please Enter the Correct RR-number";
        return true;
    } else {
        document.getElementById('rrnum').style.display = 'none';
        rrNumValid = true;
    }


    //Password Validation
    if (passwordVal === "") {
        document.getElementById('userpass').innerHTML = " ** Please fill the password field";
        return false;
    } else {
        document.getElementById('userpass').style.display = 'none';
        passValid = true;
    }
 

    if (rrNumValid && passValid) {
    	document.body.appendChild(form);
    	form.submit();
      return true;
     }

}
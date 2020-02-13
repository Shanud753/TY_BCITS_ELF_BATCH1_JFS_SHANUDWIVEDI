function validation() {

    var emailVal = document.getElementById('emai').value;
    var passwordVal = document.getElementById('pwd').value;
    
 
    var emailregx = /^[A-Za-z_]{3,}@[A-Za-z]{3,}{.}{1}[A-Za-z]{2,6}$/;
    var passregx = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
    
    var emailValid = false;
    var passValid = false;

  //Email Validation
    if (emailVal == "") {
        document.getElementById('ema').innerHTML = " ** Please fill the  field";
        return false;
    } else if ((emailVal.length <= 2) || (emailVal.length > 20)) {
        document.getElementById('ema').innerHTML = " ** Please Enter Valid email-Id";
        return false;
    } else if (emailregx.test(emailVal)) {
        document.getElementById('ema').innerHTML = " ** Email must contain @ Symbol";
        return false;
    } else {
        document.getElementById('ema').style.display = 'none ';
        emailValid = true;
    }
    //Password Validation
    if (passwordVal == "") {
        document.getElementById('pwd1').innerHTML = " ** Please fill the  field";
        return false;
    } else if ((passwordVal.length <= 2) || (passwordVal.length > 20)) {
        document.getElementById('pwd1').innerHTML = " ** length must be between 2 & 10 ";
        return false;
    } else if (passregx.test(passwordVal)) {
        document.getElementById('pwd1').innerHTML = " ** Please Enter Valid password";
        return false;
    } else {
        document.getElementById('pwd1').style.display = 'none ';
        passValid = true;
    }
 

    if (emailValid && passValid) {
    	document.body.appendChild(form);
    	form.submit();
      return true;
     }

}
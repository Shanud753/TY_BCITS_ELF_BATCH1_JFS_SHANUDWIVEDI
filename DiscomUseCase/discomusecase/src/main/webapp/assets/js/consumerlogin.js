function validation() {

    var rrNumVal = document.getElementById('rrnumber').value;
    var passwordVal = document.getElementById('pwd').value;
    var rrNumregx = /^[0-9]{5}[A-Z]{2}$/;
    //   /^[0-9]{5}(?:AB)?$/;
    // /^ ( ? = .*[A - Z])( ? = .*[0 - 9])[A - Z0 - 9] * $/;
    // /^ [A - Z0 - 9] * [0 - 9][A - Z0 - 9] * [A - Z][A - Z0 - 9] * $/;
    //  /^[0-9A-Z]$/;
//    var passregx = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]$/;
    var rrNumValid = false;
    var passValid = false;
    var showError = false;

    if (rrNumVal === '') {
        document.getElementById('rrnum').innerHTML = " ** Please fill the RR-Number field";

         return false;
    } else if (rrNumregx.test(rrNumVal)) {
            rrNumValid = true;
        } else {
            document.getElementById('rrnum').innerHTML = " ** Please Enter the Correct RR-number";
            // return false;
        }


    //Password Validation

    if (passwordVal == "") {
        document.getElementById('userpass').innerHTML = " ** Please fill the password field";
         //return false;
    } else {
//    
//        if (passregx.test(passwordVal)) {
//        passValid = true;
//        }else{
        document.getElementById('userpass').display = 'none';
         //return false;
    }


    if (rrNumValid && passValid) {
    	document.body.appendChild(form);
    	form.submit();
      return true;
     }

}
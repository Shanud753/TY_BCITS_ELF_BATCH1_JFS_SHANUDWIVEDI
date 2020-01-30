function validation() {

    var userfirstNameVal = document.getElementById('fname').value;
    var userlastNameVal = document.getElementById('lname').value;
    var emailVal = document.getElementById('email').value;
    var mobileNumVal = document.getElementById('mobile').value;
    var passwordVal = document.getElementById('pwd').value;
    var cpasswordVal = document.getElementById('cpwd').value;
    var rrNumVal = document.getElementById('rrnumber').value;
    var address1Val = document.getElementById('address1').value;
    var address2Val = document.getElementById('address2').value;
    var cityVal = document.getElementById('city').value;
    
    var userfNameregx = /^[A-Za-z]{4,20}$/;
    var userlNameregx = /^[A-Za-z]{4,20}$/;
    var emailregx = /^[A-Za-z_]{3,}@[A-Za-z]{3,}{.}{1}[A-Za-z]{2,6}$/;
    var mobileregx = /^[6789]{1}[0-9]{9}$/;
    var passregx = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
    var cpassregx = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
    var rrNumregx = /^[0-9A-Z]$/;
    var address1regx = /^(?=.*[#][0-9][0-9][-][0-9])(?=.*[A-Za-z]){10,40}$/;
    var address2regx = /^(?=.*[#][0-9][0-9][-][0-9])(?=.*[A-Za-z]){10,40}$/;
    var cityregx = /^[A-Za-z]$/;
    
    var ufNameValid = false;
    var ulNameValid = false;
    var emailValid = false;
    var mobilValid = false;
    var passValid = false;
    var cpassValid = false;
    var rrNumValid = false;
    var address1Valid = false;
    var address2Valid = false;
    var cityValid = false;
    
    //First Name Validation
    
    if (userfirstNameVal == "") {
        document.getElementById('userfName').innerHTML = " ** Please fill the username field";
        return false;
    } else if ((userfirstNameVal.length <= 2) || (userfirstNameVal.length > 20)) {
        document.getElementById('userfName').innerHTML = " ** Username length must be between 2 and 20";
        return false;
    } else if (userfNameregx.test(userfirstNameVal)) {
        document.getElementById('userfName').innerHTML = " ** No Special Characters and Numbers Allowed";
        return false;
    } else {
        document.getElementById('userfName').style.display = 'none ';
        ufNameValid = true;
    }
    
    //Last Name Validation
    
    if (userlastNameVal == "") {
        document.getElementById('userlName').innerHTML = " ** Please fill the username field";
        return false;
    } else if ((userlastNameVal.length <= 2) || (userlastNameVal.length > 20)) {
        document.getElementById('userlName').innerHTML = " ** Username length must be between 2 and 20";
        return false;
    } else if (userlNameregx.test(userlastNameVal)) {
        document.getElementById('userlName').innerHTML = " ** No Special Characters and Numbers Allowed";
        return false;
    } else {
        document.getElementById('userlName').style.display = 'none';
        ulNameValid = true;
    }
    
    //Email Validation
    
    if (emailVal == "") {
        document.getElementById('emailid').innerHTML = " ** Please fill the email field";
        return false;
    
    } else if (emailregx.test(emailVal)) {
        document.getElementById('emailid').innerHTML = " ** Please Enter the Proper Email-id";
        return false;
    } else {
        document.getElementById('emailid').style.display = 'none';
        emailValid = true;
    }
    
    //Mobile Number Validation
    
    if (mobileNumVal == "") {
        document.getElementById('phnnumber').innerHTML = " ** Please fill the mobile field";
        return false;
    } else if (mobileregx.test(mobileNumVal)) {
        document.getElementById('phnnumber').innerHTML = " ** Please Enter the  Valid Number";
        return false;
    } else {
        document.getElementById('phnnumber').style.display = 'none';
        mobilValid = true;
    }
    
    //Password Validation
    
    if (passwordVal == "") {
        document.getElementById('userpass').innerHTML = " ** Please fill the password field";
        return false;
    } else if (passregx.test(passwordVal)) {
        document.getElementById('userpass').innerHTML = " ** Please Enter the Valid password";
        return false;
    } else {
        document.getElementById('userpass').style.display = 'none';
        passValid = true;
    }
    
    //Confirm Password Validation
    
    if (cpasswordVal == "") {
        document.getElementById('usercpass').innerHTML = " ** Please fill the password field";
        return false;
    }else if(passwordVal == cpasswordVal){
        document.getElementById('usercpass').innerHTML = " ** Both password Values must be Same";
        return false;

    } else if (cpassregx.test(cpasswordVal)) {
        document.getElementById('usercpass').innerHTML = " ** Please  confirm Your password";
        return false;
    } else {
        document.getElementById('usercpass').style.display = 'none';
        cpassValid = true;
    }
    
    //rr-Number Validation
    
    if (rrNumVal == "") {
        document.getElementById('rrnum').innerHTML = " ** Please fill the RR-number field";
        return false;
    } else if (rrNumregx.test(rrNumVal)) {
        document.getElementById('rrnum').innerHTML = " ** Please Enter the Correct RR-number";
        return false;
    } else {
        document.getElementById('rrnum').style.display = 'none';
        rrNumValid = true;
    }
    
    //Address1 validation
    if (address1Val == "") {
        document.getElementById('addressval1').innerHTML = " ** Please fill the Address field-1";
        return false;
    } else if (address1regx.test(address1Val)) {
        document.getElementById('addressval1').innerHTML = " ** Please Enter the valid address";
        return false;
    } else {
        document.getElementById('addressval1').style.display = 'none';
        address1Valid = true;
    }
    
    //Address2 validation
    
    if (address2Val == "") {
        document.getElementById('addressval2').innerHTML = " ** Please fill the Address field-2";
        return false;
    } else if (address2regx.test(address2Val)) {
        document.getElementById('addressval2').innerHTML = " ** Please Enter the valid address";
        return false;
    } else {
        document.getElementById('addressval2').style.display = 'none';
        address2Valid = true;
    }
    
    //City Validation
    if (cityVal == "") {
        document.getElementById('city1').innerHTML = " ** Please fill the field";
        return false;
    } else if (cityregx.test(cityVal)) {
        document.getElementById('city1').innerHTML = " ** Please Enter the correct city";
        return false;
    } else {
        document.getElementById('city1').style.display = 'none';
        cityValid = true;
    }
    
    if (ufNameValid && ulNameValid && emailValid && mobilValid && passValid && cpassValid && rrNumValid && address1Valid && address2Valid && cityValid) {
        window.location.href = "consumerlogin.html";
    }
    }
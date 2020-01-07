function validateForm() {
    var loginForm = document.forms['loginForm']
    var userMail = loginForm['userEmail'].value;
    var pwd = loginForm['userPwd'].value;

    console.log(loginForm);
    console.log('User Email ', userMail);
    console.log('User password ', pwd);

    if (userMail.trim().length > 10) {
        document.getElementById('emailErr').style.display = 'none'
        console.log('User mail is valid');
    } else {
        document.getElementById('emailErr').style.display = 'block'
        console.log('User mail is Invalid');
    }

    if (pwd.trim().length > 5) {
        console.log('User Password is valid');
    } else {
        document.getElementById('pwdErr').style.display = 'block'
        console.log('User Password is Invalid');
    }

}
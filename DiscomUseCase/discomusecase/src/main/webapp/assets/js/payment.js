function validation() {
    var cardNum = document.getElementById("cardNum").value;
    var name = document.getElementById("name").value;

   /* var cardRegx = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-zA-Z]+/;*/
    var nameRegx = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?0-9]+/;

 
    var cardNumValid = false;
    var nameValid = false;

    
    if (cardNum == 0) {
        document.getElementById("cdNum").innerHTML = " *Please fill the Card Number field";
        return false;
    } else if (cardNum < 1) {
        document.getElementById("cdNum").innerHTML = " *Please Enter the Valid Card Number";
        return false;
    }else {
        document.getElementById("cdNum").style.display = 'none';
        cardNumValid = true;
    }
    
    if (name == "") {
        document.getElementById("fname").innerHTML = " *Please fill the First name field";
        return false;
    } else if ((name.length < 3) || (name.length > 20)) {
        document.getElementById("fname").innerHTML = "*Length must be between 3 and 20";
        return false;
    } else if (nameRegx.test(name)) {
        document.getElementById("fname").innerHTML = "*Name Should Not contains Special character & Number";
        return false;
    } else {
        document.getElementById("fname").style.display = 'none';
        nameValid = true;
    }

    if(cvNumValid && nameValid){
        document.body.appendChild(form);
		form.submit();
		return true;
    }
}
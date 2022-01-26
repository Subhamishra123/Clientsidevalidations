/**
 * 
 */
let validate = (event, formObject) => {
	document.getElementById("unameErr").innerHTML = "";
	document.getElementById("uaddressErr").innerHTML = "";
	document.getElementById("uageErr").innerHTML = "";
	event.preventDefault();
	let pname = formObject.uname.value;
	let paddress = formObject.uaddress.value;
	let page = formObject.uage.value;

	let flag = true;

	if (pname == "") {

		document.getElementById("unameErr").innerHTML = " Person Name is required";
		document.getElementById("pname").focus();

		flag = false;
	}
	if (paddress == "") {

		document.getElementById("uaddressErr").innerHTML = " Person Address is required";
		document.getElementById("paddress").focus();
		flag = false;
	} else if (paddress.length < 10) {
		document.getElementById("uaddressErr").innerHTML = " Person Address min 10 characters";
		document.getElementById("paddress").focus();
		flag = false;
	}

	if (page == "") {

		document.getElementById("uageErr").innerHTML = " Person Age is required";
		document.getElementById("page").focus();
		flag = false;
	} else if (isNaN(page)) {
		document.getElementById("uageErr").innerHTML = " Person Age Must be a number";
		document.getElementById("page").focus();
		flag = false;
	}

	else {
		page = parseInt(page);
		if (page < 0 || page > 125) {
			document.getElementById("uageErr").innerHTML = " Person Age Must be Between 1 to 125";
			document.getElementById("page").focus();
			flag = false;
		}

	}
	formObject.vflag.value="yes";
	if (flag === true) {
		
		formObject.submit();
	}


}
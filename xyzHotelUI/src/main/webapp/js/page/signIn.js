$(document).ready(function () {

    (function () {
       // 'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        let forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms) .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    console.log("Inside Validation...!")
                    event.preventDefault()
                    event.stopPropagation()
                    if (form.checkValidity()) {
                        login();
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()


 function login(){
    let user = {
        username: $("#validationCustomUsername").val().trim(),
        email: $("#validationCustomUsername").val().trim(),
        password: $("#validationCustomerPassword").val().trim()
    }
    $.ajax({
        url: '/users/login',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(user),
        dataType: 'json',
        async: false,
        cache: false,
        success: function (response) {
            console.log(response)
            if (response.action === true) {
                swal("Success!", "Login success!", "success");
                window.open("http://localhost:9191/dashboard","_self")
            } else {
                swal("Fail!", response.data, "error");
            }
        }
    });
}



});








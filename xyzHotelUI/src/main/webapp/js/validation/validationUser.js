// Example starter JavaScript for disabling form submissions if there are invalid fields

// $( "#contact-form" ).submit(function( event ) {
//     alert( "Handler for .submit() called." );
//     event.preventDefault();
// });
$(document).ready(function () {

    (function () {
        // 'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        let forms = document.querySelectorAll('.needs-validation')
        var pw=document.getElementById('validationPassword');
        var cpw=document.getElementById('validationConfirmPassword');

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms) .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                console.log("Inside Validation...!")
                event.preventDefault()
                event.stopPropagation()
                if (form.checkValidity()) {
                    signup();
                }
                form.classList.add('was-validated')
            }, false)
        })
    })()


    function signup(){
        let user = {
            firstName: $("#validationFirstname").val(),
            lastName: $("#validationLastname").val(),
            username: $("#validationCustomUsername").val(),
            email: $("#validationEmail").val(),
            password: $("#validationPassword").val()
        }

    //     $.ajax({
    //         url: '/users',
    //         type: 'POST',
    //         contentType: "application/json",
    //         data: JSON.stringify(user),
    //         dataType: 'json',
    //         async: false,
    //         cache: false,
    //         success: function (response) {
    //             console.log(response)
    //             if (response.action === true) {
    //                 swal("Success!", "Registration success!", "success");
    //                 window.open("http://localhost:9191/signin","_self")
    //             } else {
    //                 swal("Fail!", response.data, "error");
    //             }
    //         }
    //     });
     }



});














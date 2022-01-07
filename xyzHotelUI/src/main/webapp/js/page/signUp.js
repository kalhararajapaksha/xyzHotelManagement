$(document).ready(function () {

    $("#signUp").click(function () {




        let user = {
            firstName: $("#validationFirstname").val(),
            lastName: $("#validationLastname").val(),
            username: $("#validationCustomUsername").val(),
            email: $("#validationEmail").val(),
            password: $("#validationPassword").val()
        }

        $.ajax({
            url: '/users',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(user),
            dataType: 'json',
            async: false,
            cache: false,
            success: function (response) {
                console.log(response)
                if (response.action === true) {
                    swal("Success!", "Registration success!", "success");
                    window.open("http://localhost:9191/signin","_self")
                } else {
                    swal("Fail!", response.data, "error");
                }
            }
        });


    });


});








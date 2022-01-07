$(document).ready(function () {

    $("#saveUserDetails").click(function () {


        let city = $("#validationCity").val();
        let country = $("#country-list").val();
        let email =$("#validationEmail").val();
        let lastName = $("#validationLastname").val();
        let firstName = $("#validationFirstname").val();

        console.log(firstName)
        console.log(country)


        let user = {
            firstName: $("#validationFirstname").val(),
            lastName: $("#validationLastname").val(),
            country: $("#country-list").val(),
            nic: $("#validationNIC").val(),
            email: $("#validationEmail").val(),
            customerID:1,
            phoneNumber:$("#validationContact").val(),
            //validationContact
        }

        $.ajax({
            url: '/users/editProfile',
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
                    window.open("http://localhost:9191/","_self")
                } else {
                    swal("Fail!", response.data, "error");
                }
            }
        });


    });


});

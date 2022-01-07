loadData()

function loadData(){



    let customerID = {
        "customerID": 1

    }

    $.ajax({
        url: '/users/userFindById',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(customerID),
        dataType: 'json',
        // async: false,
        // cache: false,
        success: function (response) {
            console.log(response);
            console.log(response.data[0].email);

            $("#validationFirstname").val(response.data[0].firstName);
            $("#validationLastname").val(response.data[0].lastName);
            $("#country-list").val(response.data[0].country);
            $("#validationEmail").val(response.data[0].email);
            $("#validationNIC").val(response.data[0].nic);
            $("#validationContact").val(response.data[0].phoneNumber);


            $("#FirstnameID").text(response.data[0].firstName);
            $("#LastnameID").text(response.data[0].lastName);
            $("#countryID").text(response.data[0].country);
            $("#emailID").text(response.data[0].email);
            $("#contactNoId").text(response.data[0].nic);
            $("#nicID").text(response.data[0].phoneNumber);
            //contactNoId
            //nicID

            // let user = {
            //     firstName: $("#validationFirstname").val(),
            //     lastName: $("#validationLastname").val(),
            //     country: $("#country-list").val(),
            //     city: $("#validationEmail").val(),
            //     email: $("#validationEmail").val(),
            //     customerID:1
            // }


        }
    });

}
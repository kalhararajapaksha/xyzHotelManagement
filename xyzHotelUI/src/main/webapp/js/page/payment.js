$("#paymentID").click(function () {

    // let adults = $("#adults").val();
    // let children = $("#children").val();
    // $("#adultAmount").text(adults);
    // $("#childrenAmount").text(children);
    // $("#checkInDate").text(checkingDate);
    // $("#checkOutDate").text(checkoutDate);

    // private double price;
    // private String currency;
    // private String method;
    // private String intent;
    // private String description;

    let orderDetails = {
        "price": 12000,
        "currency":"USD",
        "method":"paypal",
        "intent":"sale",
        "description": "checkoutDate"

    }
    console.log("start");


    $.ajax({
        url: '/pay',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(orderDetails),
        dataType: 'json',
        // async: false,
        // cache: false,
        success: function (response) {
            console.log(response);


            htmlRoom(response)


        }
    });

});
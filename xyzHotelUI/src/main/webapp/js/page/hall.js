$("#btnCheckAvailability").click(function () {
    let dateArray = $("#daterange").val().split(" - ");

    let startDateFormatingArray = dateArray[0].split("-");
    let endDateFormatingArray = dateArray[1].split("-");

    let startDate = startDateFormatingArray[2] + "-" + startDateFormatingArray[1] + "-" + startDateFormatingArray[0];
    let endDate = endDateFormatingArray[2] + "-" + endDateFormatingArray[1] + "-" + endDateFormatingArray[0];

    loadData(startDate, endDate);
});

let tableNamesArray = new Array();

$("#proceed").click(function () {


    let adults = $("#adults").val();
    let children = $("#children").val();



    //console.log(tableNamesArray)

    // var reservationRoomDetails = new Map();
    // map.set('name', 'John');
    // map.set('id', 11);
    let reservationRoomDetails = new Array();
    //let roomCountt = new  Array();

    $.each(tableNamesArray, function (index, value) {
        // console.log(index + ": " + value);


        let tableName = "#" + value + " " + "tr";

        let count = 0;
        $(tableName).each(function (a, b) {
            console.log("AAAA", a)
            console.log("BBBB", b)
            var roomType = $('.roomType', b).text();
            var roomCapacity = $('.roomCapacity', b).text();
            var mapKey = $('.mapKey', b).text();


            if (a !== 0) {
                let roomCount = Number(document.getElementById(mapKey).value)
                if (roomCount !== 0) {

                    //getAvailbleRoom
                    //availableRooms
                    let availableRoomsListRoomTypeAndRoomCapacity = new Array();

                    $.each( availableRooms, function( key, value ) {
                        let roomKey = roomType+""+roomCapacity;
                        console.log("Start .................................. Find ")
                        if(roomKey === key){
                            console.log( key + ": " + value );
                        }

                    });

                    reservationRoomDetails.push({
                        roomTypeId: roomType,
                        capacityID: roomCapacity,
                        roomCount: roomCount
                    });
                }
            }

        });
        //alert(JSON.stringify(ary));


    });

    console.log(reservationRoomDetails)
    let dateArray = $("#daterange").val().split(" - ");

    let startDateFormatingArray = dateArray[0].split("-");
    let endDateFormatingArray = dateArray[1].split("-");

    let startDate = startDateFormatingArray[2] + "-" + startDateFormatingArray[1] + "-" + startDateFormatingArray[0];
    let endDate = endDateFormatingArray[2] + "-" + endDateFormatingArray[1] + "-" + endDateFormatingArray[0];

    let totalBill=$("#totalBill").text();
    let reservation = {
        checkingDate: startDate,
        checkOutDate: endDate,
        roomDetail: reservationRoomDetails,
        guest: adults + children,
        totalBill:totalBill,
        customerID:"11",
        reservationType:"1",
        isActive:true
    }

    $.ajax({
        url: '/reservations/getRoomIdforReservaton',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(reservation),
        dataType: 'json',
        // async: false,
        // cache: false,
        success: function (response) {
            console.log(response);
            if (response.action === true) {
                swal("Success!", "Login success!", "success");
                window.open("http://localhost:9191/payment","_self")
            } else {
                swal("Fail!", response.data, "error");
            }


        }
    });


    //oceanViewTable
    //roomType
    //roomCapacity
    // alert( "Handler for .click() called." );
    //

});




//=====================
let roomCountMap = new Map();


let availableRooms = null;
function htmlRoom(roomType) {
    $("#roomsDiv").empty();
    console.log(roomType)
     let hallType = roomType.data;
     let roomCapacity = roomType.roomCapacity
     let roomChargers = roomType.roomChargers
     availableRooms = roomType.availableRooms


    $.each(hallType, function (hallTypeIndex, hallTypeValue) {
        console.log(hallTypeValue);
        let isAvailableRoomCapacity = false

        let htmString = '<div class="room-list-item">\n' +
            '        <div class="row">\n' +
            '            <div class="col-lg-4">\n' +
            '                <figure>\n' +
            '                    <img class="img-fluid room-img" src="images/p3.jpg">\n' +
            '                </figure>\n' +
            '\n' +
            '            </div>\n' +
            '            <div class="col-lg-4">\n' +
            '                <h4 id="roomType">' + hallTypeValue.conferenceHallType + '</h4>\n' +
            '                <span class="room-rates">\n' +
            '                <i class="fa fa-star" aria-hidden="true"></i>\n' +
            '                <i class="fa fa-star" aria-hidden="true"></i>\n' +
            '                <i class="fa fa-star" aria-hidden="true"></i>\n' +
            '                <i class="fa fa-star" aria-hidden="true"></i>\n' +
            '                <i class="fa fa-star" aria-hidden="true"></i>\n' +
            '                \n' +
            '              </span>\n' +
            '                <p>Enjoy your stay while experiencing the view of the ocean direct from your room</p>\n' +
            '                <div class="room-services">\n' +
            '                    <i class="fa fa-coffee" data-toggle="popover" data-placement="top" data-trigger="hover" data-content="Breakfast Included" data-original-title="Breakfast"></i>\n' +
            '                    <i class="fa fa-wifi" data-toggle="popover" data-placement="top" data-trigger="hover" data-content="Free WiFi" data-original-title="WiFi"></i>\n' +
            '                    <i class="fa fa-television" data-toggle="popover" data-placement="top" data-trigger="hover" data-content="Plasma TV with cable channels" data-original-title="TV"></i>\n' +
            '\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="col-lg-4 room-add">\n' +
            '                <table id=' + hallTypeValue.hallNo + ' class="room-add-info">\n' +
            '                    <tr class="table-header">\n' +
            '                        <td class="roomType" style="display:none;">' + hallTypeValue.hallNo + '</td>\n' +
            '                        <td class="roomCapacity" style="display:none;" >RC0</td>\n' +
            '                        <td class="roomCount" style="display:none;" >000</td>\n' +
            '                        <td class="availableRoomCount" style="display:none;" >000</td>\n' +
            '                        <td class="mapKey" style="display:none;" >000</td>\n' +
            '                        <td></td>\n' +
            '</tr>\n'+
            '                <tr class="price-tr">\n' +
            '                    <td>PRICE </td>\n' +
            '                    <td><span>LKR  0.00 </span></td>\n' +
            '                </tr>\n' +
            '                <tr class="price-tr">\n' +
            '                        <td>  \n' +
            '</td>\n' +
            '                        <td>  \n' +
            '<button  class="btn book-hall-btn" onclick="bookHall(\'' + hallTypeValue.hallNo + '\')" >BOOK NOW</button> \n'+
            '</td>\n' +
            '                </tr>\n' +
            '                </table>\n' +
            '\n' +
            '            </div>\n' +
            '        </div>\n' +
            '    </div>';


        // $.each(roomCapacity, function (roomCapacityIndex, roomCapacityValue) {
        //     let key = hallTypeValue.roomTypeId + "" + roomCapacityValue.roomCapacityID
        //     roomCharge = roomChargers[key];
        //     availableRoom = availableRooms[key];
        //     if (roomCharge !== undefined && Number(availableRoom) !== 0) {
        //         console.log(roomCharge)
        //         isAvailableRoomCapacity = true
        //         let htmlRoomCapacity = '';
        //
        //
        //         htmString = htmString + htmlRoomCapacity;
        //     }
        // });


        // let htmlEnd = '                </table>\n' +
        //     '\n' +
        //     '            </div>\n' +
        //     '        </div>\n' +
        //     '    </div>';


        // if (isAvailableRoomCapacity === false) {
        //     tableNamesArray.push(roomTypeValue.roomTypeId)
        //     htmString = htmString + htmlEnd
        //     $("#roomsDiv").append(htmString);
        // }
        $("#roomsDiv").append(htmString);

    });


}
function bookHall(hallNo){
    let dateArray = $("#daterange").val().split(" - ");

    let startDateFormatingArray = dateArray[0].split("-");
    let endDateFormatingArray = dateArray[1].split("-");

    let startDate = startDateFormatingArray[2] + "-" + startDateFormatingArray[1] + "-" + startDateFormatingArray[0];
    let endDate = endDateFormatingArray[2] + "-" + endDateFormatingArray[1] + "-" + endDateFormatingArray[0];
    console.log(startDate);
    console.log(endDate);
    console.log(hallNo);
    let hallNoID ={
     "hallNo" : hallNo,
     "checkingDate": startDate,
     "checkoutDate": endDate,
     "reservationType":2,
     "price":10000,
     "customerID":2,
     "isActive":1 ,
     "guest":100
    }

    $.ajax({
        url: '/reservationHallRest/getHallNoforReservation',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(hallNoID),
        dataType: 'json',
        // async: false,
        // cache: false,
        success: function (response) {
            console.log(response);
            console.log(response.data);
            htmlRoom(response)

        }
    });
}

function loadData(checkingDate, checkoutDate) {



    let checkingAndcheckoutDate = {
        "checkingDate": checkingDate,
        "checkoutDate": checkoutDate,
        "reservationType":2
    }
    console.log("start");


    $.ajax({
        url: '/reservationHallRest/availableHallList',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(checkingAndcheckoutDate),
        dataType: 'json',
        // async: false,
        // cache: false,
        success: function (response) {
            console.log(response);
            console.log(response.data);
            htmlRoom(response)

        }
    });

}







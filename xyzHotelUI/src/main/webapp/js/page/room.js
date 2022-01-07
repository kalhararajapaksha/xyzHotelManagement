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


function generateFinalBill() {

    let totalRoomCharge = 0;
    let totalRoomCount = 0
    $.each(tableNamesArray, function (index, value) {
        let tableName = "#" + value + " " + "tr";

        $(tableName).each(function (a, b) {
            let mapKey = $('.mapKey', b).text();

            if (a !== 0) {
                let roomCount = Number(document.getElementById(mapKey).value)
                if (roomCount !== 0) {
                    let roomCharge = roomCount * Number($('.roomCharge', b).text())
                    totalRoomCharge = totalRoomCharge + roomCharge
                    totalRoomCount = totalRoomCount+roomCount;
                }

            }
        });
    });

    console.log("Total Room Charge : ", totalRoomCharge);
    $("#totalBill").text(totalRoomCharge);
    $("#totalRoomsAmount").text(totalRoomCount);

}

//=====================
let roomCountMap = new Map();

//===============


$('body').on('click', '.increaseBtn', function () {
    var $row = $(this).closest("tr");    // Find the row
    //var roomCount = $row.find(".roomCount").text(); // Find the text
    var availableRoomCount = $row.find(".availableRoomCount").text(); // Find the text
    var mapKey = $row.find(".mapKey").text(); // Find the text

    console.log("mapKey ..............", mapKey)
    let roomCount = Number(document.getElementById(mapKey).value)
    let availableRooms = Number(availableRoomCount)

    console.log("Room Count :", roomCount)
    console.log("Available Room Count :", availableRooms)

    if (roomCount >= 0 && roomCount < availableRooms) {
        document.getElementById(mapKey).value = roomCount + 1;
    }

    generateFinalBill();
});


$('body').on('click', '.decreaseBtn', function () {
    console.log("Click")

    var $row = $(this).closest("tr");    // Find the row
    var roomCount = $row.find(".roomCount").text(); // Find the text
    var availableRoomCount = $row.find(".availableRoomCount").text(); // Find the text
    var mapKey = $row.find(".mapKey").text(); //

    // Let's test it out
    console.log("Room Count :", roomCount)
    console.log("Available Room Count :", availableRoomCount)
    if (Number(document.getElementById(mapKey).value) > 0) {
        document.getElementById(mapKey).value = Number(document.getElementById(mapKey).value) - 1;
    }

    generateFinalBill();
});

let availableRooms = null;
function htmlRoom(data) {
    $("#roomsDiv").empty();
    console.log(data)
    let roomType = data.roomTypes;
    let roomCapacity = data.roomCapacity
    let roomChargers = data.roomChargers
    availableRooms = data.availableRooms


    $.each(roomType, function (roomTypeIndex, roomTypeValue) {
        //console.log(roomTypeValue);
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
            '                <h4 id="roomType">' + roomTypeValue.roomTypeName + '</h4>\n' +
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
            '                <table id=' + roomTypeValue.roomTypeId + ' class="room-add-info">\n' +
            '                    <tr class="table-header">\n' +
            '                        <td class="roomType" style="display:none;">' + roomTypeValue.roomTypeId + '</td>\n' +
            '                        <td class="roomCapacity" style="display:none;" >RC0</td>\n' +
            '                        <td class="roomCount" style="display:none;" >000</td>\n' +
            '                        <td class="availableRoomCount" style="display:none;" >000</td>\n' +
            '                        <td class="mapKey" style="display:none;" >000</td>\n' +
            '                        <td></td>\n' +
            '                        <td class="roomCharge" >PRICE (LKR)</td>\n' +
            '                        <td>ROOMS</td>\n' +
            '                    </tr>\n';


        $.each(roomCapacity, function (roomCapacityIndex, roomCapacityValue) {
            let key = roomTypeValue.roomTypeId + "" + roomCapacityValue.roomCapacityID
            roomCharge = roomChargers[key];
            availableRoom = availableRooms[key];
            if (roomCharge !== undefined && Number(availableRoom) !== 0) {
                console.log(roomCharge)
                isAvailableRoomCapacity = true
                let htmlRoomCapacity = '                    <tr >\n' +
                    '                        <td class="roomType" style="display:none;">' + roomTypeValue.roomTypeId + '</td>\n' +
                    '                        <td class="roomCapacity" style="display:none;" >' + roomCapacityValue.roomCapacityID + '</td>\n' +
                    '                        <td class="roomCount" style="display:none;" >0</td>\n' +
                    '                        <td class="availableRoomCount" style="display:none;" >' + availableRoom + '</td>\n' +
                    '                        <td class="mapKey" style="display:none;" >' + key + '</td>\n' +
                    '                        <td><i class="fa fa-user"></i> ' + roomCapacityValue.capacity + '</td>\n' +
                    '                        <td class="roomCharge" > ' + roomCharge + '</td>\n' +
                    '                        <td  class="btn-td rowInput">\n' +
                    '                            <input type="button" name="decrease" value="-" class="addbtn decreaseBtn"  />\n' +
                    '                            <input type="text" name="rooms" value="0" id=' + key + ' class="inputbox"/>\n' +
                    '                            <input type="button" name="increase" value="+" class="addbtn  increaseBtn"  />\n' +


                    '                        </td>\n' +
                    '                    </tr>\n';


                htmString = htmString + htmlRoomCapacity;
            }
        });


        let htmlEnd = '                </table>\n' +
            '\n' +
            '            </div>\n' +
            '        </div>\n' +
            '    </div>'


        if (isAvailableRoomCapacity === true) {
            tableNamesArray.push(roomTypeValue.roomTypeId)
            htmString = htmString + htmlEnd
            $("#roomsDiv").append(htmString);
        }


    });


}

function loadData(checkingDate, checkoutDate) {

    let adults = $("#adults").val();
    let children = $("#children").val();
    $("#adultAmount").text(adults);
    $("#childrenAmount").text(children);
    $("#checkInDate").text(checkingDate);
    $("#checkOutDate").text(checkoutDate);

    let checkingAndcheckoutDate = {
        "checkingDate": checkingDate,
        "checkoutDate": checkoutDate

        // "reservationId": 0,
        // "customerID": 0
        // checkingDate: null,
        // checkingTime: null,
        // checkoutDate: null,
        // checkOutTime: null,
        // isActive: true,
        // reservationType: 0,
        // noOfGuest: 0,
        // reservationRoom: null,
    }
    console.log("start");


    $.ajax({
        url: '/reservations/roomDetailsForPageLoard',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(checkingAndcheckoutDate),
        dataType: 'json',
        // async: false,
        // cache: false,
        success: function (response) {
            console.log(response);
            console.log("Room Type ", response.roomTypes);
            console.log("Room Capacity ", response.roomCapacity);

            htmlRoom(response)


        }
    });

}







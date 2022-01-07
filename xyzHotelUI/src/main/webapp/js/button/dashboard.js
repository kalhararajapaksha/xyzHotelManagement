function adultsincreaseBtnOnclick() {
    if(Number(document.getElementById("adults").value)>=0)
    {
    document.getElementById("adults").value = Number(document.getElementById("adults").value) + 1;
    }
}
function adultsdecreaseBtnOnclick() {
    if(Number(document.getElementById("adults").value)>0)
    {
    document.getElementById("adults").value = Number(document.getElementById("adults").value) - 1;
    }
}

function childrenincreaseBtnOnclick() {
    if(Number(document.getElementById("children").value)>=0)
    {
    document.getElementById("children").value = Number(document.getElementById("children").value) + 1;
    }
}
function childrendecreaseBtnOnclick() {
    if(Number(document.getElementById("children").value)>0)
    {
    document.getElementById("children").value = Number(document.getElementById("children").value) - 1;
    }
}
function doubleroomsincreaseBtnOnclick() {
    if(Number(document.getElementById("double-rooms").value)>=0)
    {
    document.getElementById("double-rooms").value = Number(document.getElementById("double-rooms").value) + 1;
    }
}
function doubleroomsdecreaseBtnOnclick() {
    if(Number(document.getElementById("double-rooms").value)>0)
    {
    document.getElementById("double-rooms").value = Number(document.getElementById("double-rooms").value) - 1;
    }
}
function tripleroomsincreaseBtnOnclick() {
    if(Number(document.getElementById("triple-rooms").value)>=0)
    {
    document.getElementById("triple-rooms").value = Number(document.getElementById("triple-rooms").value) + 1;
    }
}
function tripleroomsdecreaseBtnOnclick() {
    if(Number(document.getElementById("triple-rooms").value)>0)
    {
    document.getElementById("triple-rooms").value = Number(document.getElementById("triple-rooms").value) - 1;
    }
}
function familyroomsincreaseBtnOnclick() {
    if(Number(document.getElementById("family-rooms").value)>=0)
    {
    document.getElementById("family-rooms").value = Number(document.getElementById("family-rooms").value) + 1;
    }
}
function familyroomsdecreaseBtnOnclick() {
    if(Number(document.getElementById("family-rooms").value)>0)
    {
    document.getElementById("family-rooms").value = Number(document.getElementById("family-rooms").value) - 1;
    }
}
function hallsincreaseBtnOnclick() {
    if(Number(document.getElementById("halls").value)>=0)
    {
    document.getElementById("halls").value = Number(document.getElementById("halls").value) + 1;
    }
}
function hallsdecreaseBtnOnclick() {
    if(Number(document.getElementById("halls").value)>0)
    {
    document.getElementById("halls").value = Number(document.getElementById("halls").value) - 1;
    }
} 
function guestsincreaseBtnOnclick() {
    if(Number(document.getElementById("guests").value)>=0)
    {
    document.getElementById("guests").value = Number(document.getElementById("guests").value) + 1;
    }
}
function guestsdecreaseBtnOnclick() {
    if(Number(document.getElementById("guests").value)>0)
    {
    document.getElementById("guests").value = Number(document.getElementById("guests").value) - 1;
    }
}

function bookroom()
{
    var room=document.getElementById("book-room-form");
    var hall=document.getElementById("book-hall-form");
   if(room.style.display=="none")
   {
       room.style.display="block";
       hall.style.display="none";
   }
   else
   {
       room.style.display="block";
   }
}

function bookhall()
{
    var room=document.getElementById("book-room-form");
    var hall=document.getElementById("book-hall-form");
   if(hall.style.display=="none")
   {
       hall.style.display="block";
       room.style.display="none";
   }
   else
   {
       hall.style.display="none";
   }
}
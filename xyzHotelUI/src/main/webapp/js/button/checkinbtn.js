function checkinOnclick()
{
   var checkin= document.getElementById("checkin");
   var checkout= document.getElementById("checkout");
  
   if(checkin.style.display=="block" && checkout.style.display=="none")
   {
    checkin.style.display="none";
    checkout.style.display="block";
   }
   
   
   
}
function checkoutOnclick()
{
   var checkout= document.getElementById("checkout");
   var checkmsg= document.getElementById("check-msg");
   
   if(checkout.style.display=="block" && checkmsg.style.display=="none")
   {
    checkout.style.display="none";
    checkmsg.style.display="block";
   }
  
}
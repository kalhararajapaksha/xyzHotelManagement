<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
    <!-- ========== SEO ========== -->
    <title>Dashboard</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
    <meta content="" name="author">
    <!-- ========== FAVICON ========== -->
    <link rel="apple-touch-icon-precomposed" href="images/favicon-apple.png"/>
    <link rel="icon" href="images/favicon.png">
    <!-- ========== STYLESHEETS ========== -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" href="css/jquery.mmenu.css">
    <link rel="stylesheet" href="revolution/css/layers.css">
    <link rel="stylesheet" href="revolution/css/settings.css">
    <link rel="stylesheet" href="revolution/css/navigation.css">
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/daterangepicker.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/userdashboard.css">
    <link rel="stylesheet" href="style/stylesignin.css">
    <link rel="stylesheet" href="style/rooms.css">
    <link rel="stylesheet" href="style/guestdetails.css">

    <!-- ========== ICON FONTS ========== -->
    <link href="fonts/font-awesome.min.css" rel="stylesheet">
    <link href="fonts/flaticon.css" rel="stylesheet">
    <!-- ========== GOOGLE FONTS ========== -->
    <link href="https://fonts.googleapis.com/css?family=Oswald:400,500,600,700%7CRoboto:100,300,400,400i,500,700"
          rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body class="light">
<!-- ========== MOBILE MENU ========== -->
<nav id="mobile-menu"></nav>
<!--Navbar-->

<header class="horizontal-header sticky-header transparent-header " data-menutoggle="991">

    <!--Header-->
    <div class="container">
        <!-- BRAND -->
        <div class="brand">
            <div class="logo">
                <a href="/">
                    <img src="images/logo.png" class="nav-logo" alt="Hotel Himara">
                </a>
            </div>
        </div>
        <!-- MOBILE MENU BUTTON -->
        <div id="toggle-menu-button" class="toggle-menu-button">
            <span class="line"></span>
            <span class="line"></span>
            <span class="line"></span>
        </div>
        <!-- MAIN MENU -->
        <nav id="main-menu" class="main-menu">
            <ul class="menu">
                <li class="menu-item dropdown  ">
                    <a href="/">HOME</a>

                </li>
                <li class="menu-item dropdown">
                    <a href="/dashboard">ROOMS</a>

                </li>
                <li class="menu-item dropdown">
                    <a href="/dashboard">CONFERENCE HALLS</a>

                </li>
                <li class="menu-item dropdown">
                    <a href="/dashboard">DINING</a>

                </li>

                <li class="menu-item">
                    <a href="/dashboard">CONTACT US</a>
                </li>
                <li class="menu-item menu-btn dropdown active">
                    <a href="#" class="username">

                        <image class="userdp" src="images/u1.png" alt="DP"></image>
                        Hello Bhagya,</a>
                    <ul class="submenu">
                        <li class="menu-item">
                            <a href="/profile">Profile</a>
                        </li>
                        <li class="menu-item">
                            <a href="#">Log Out</a>
                        </li>
                    </ul>
                </li>

            </ul>
        </nav>
    </div>
</header>

<section class="section-title">
    <div class="container-fluid ">
        <div class="bg-img"></div>
        <div class="row">
            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                <h1>OUR Hall</h1>
                <h4>Select from our wide range <br>of rooms and enjoy your vacation</h4>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <!-- ========== Hall BOOKING FORM ========== -->
                <div class="vertical-booking-form slider-booking-form book-form " id="book-room-form">
                    <h3 class="form-title">BOOK YOUR Hall</h3>

                    <!-- DATE -->
                    <div class="form-group">
                        <input type="text" class="datepicker form-control" id="daterange" name="booking-date" readonly="readonly">
                    </div>

                    <table>



                        <!-- <tr>

                              <td>
                                  <label for="rooms">Rooms
                                  </label>
                              </td>

                              <td  class="btn-td">
                                  <input type="button" name="decrease" value="-" class="addbtn" onclick="roomsdecreaseBtnOnclick()" /><input type="text" name="rooms" value="0" id="rooms" class="inputbox"/>
                                  <input type="button" name="increase" value="+" class="addbtn" onclick="roomsincreaseBtnOnclick()" />
                              </td>
                          </tr>
        -->
                    </table>
                    <!-- BOOKING BUTTON -->
                    <button type="button" id="btnCheckAvailability" class="btn btn-light btn-book">CHECK AVAILABILITY
                    </button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</section>
<section class="rooms-list">

    <div id="roomsDiv">

    </div>

    <%--    <div class="room-list-item">--%>
    <%--        <div class="row">--%>
    <%--            <div class="col-lg-4">--%>
    <%--                <figure>--%>
    <%--                    <img class="img-fluid room-img" src="images/p3.jpg">--%>
    <%--                </figure>--%>

    <%--            </div>--%>
    <%--            <div class="col-lg-4">--%>
    <%--                <h4>OCEAN VIEW ROOM</h4>--%>
    <%--                <span class="room-rates">--%>
    <%--                <i class="fa fa-star" aria-hidden="true"></i>--%>
    <%--                <i class="fa fa-star" aria-hidden="true"></i>--%>
    <%--                <i class="fa fa-star" aria-hidden="true"></i>--%>
    <%--                <i class="fa fa-star" aria-hidden="true"></i>--%>
    <%--                <i class="fa fa-star" aria-hidden="true"></i>--%>
    <%--                --%>
    <%--              </span>--%>
    <%--                <p>Enjoy your stay while experiencing the view of the ocean direct from your room</p>--%>
    <%--                <div class="room-services">--%>
    <%--                    <i class="fa fa-coffee" data-toggle="popover" data-placement="top" data-trigger="hover"--%>
    <%--                       data-content="Breakfast Included" data-original-title="Breakfast"></i>--%>
    <%--                    <i class="fa fa-wifi" data-toggle="popover" data-placement="top" data-trigger="hover"--%>
    <%--                       data-content="Free WiFi" data-original-title="WiFi"></i>--%>
    <%--                    <i class="fa fa-television" data-toggle="popover" data-placement="top" data-trigger="hover"--%>
    <%--                       data-content="Plasma TV with cable channels" data-original-title="TV"></i>--%>

    <%--                </div>--%>
    <%--            </div>--%>
    <%--            <div class="col-lg-4 room-add">--%>
    <%--                <table id="oceanViewTable" class="room-add-info">--%>
    <%--                    <tr class="table-header">--%>
    <%--                        <td class="roomType" style="display:none;">RT0</td>--%>
    <%--                        <td class="roomCapacity" style="display:none;">RC0</td>--%>
    <%--                        <td class="roomCount" style="display:none;">000</td>--%>
    <%--                        <td class="availableRoomCount" style="display:none;">000</td>--%>
    <%--                        <td class="mapKey" style="display:none;">000</td>--%>
    <%--                        <td></td>--%>
    <%--                        <td>PRICE (LKR)</td>--%>
    <%--                        <td>ROOMS</td>--%>
    <%--                    </tr>--%>
    <%--                    <tr>--%>
    <%--                        <td class="roomType" style="display:none;">RT1</td>--%>
    <%--                        <td class="roomCapacity" style="display:none;">RC1</td>--%>
    <%--                        <td class="roomCount" style="display:none;">0</td>--%>
    <%--                        <td class="availableRoomCount" style="display:none;">2</td>--%>
    <%--                        <td class="mapKey" style="display:none;">k1</td>--%>
    <%--                        <td><i class="fa fa-user"></i> 2</td>--%>
    <%--                        <td> 100,000</td>--%>
    <%--                        <td class="btn-td rowInput">--%>
    <%--                            <input type="button" name="decrease" value="-" class="addbtn decreaseBtn"/>--%>
    <%--                            <input type="text" name="rooms" value="0" id="k1" class="inputbox"/>--%>
    <%--                            <input type="button" name="increase" value="+" class="addbtn  increaseBtn"/>--%>
    <%--                        </td>--%>
    <%--                    </tr>--%>
    <%--                    <tr>--%>
    <%--                        <td class="roomType" style="display:none;">RT2</td>--%>
    <%--                        <td class="roomCapacity" style="display:none;">RC2</td>--%>
    <%--                        <td class="roomCount" style="display:none;">0</td>--%>
    <%--                        <td class="availableRoomCount" style="display:none;">3</td>--%>
    <%--                        <td class="mapKey" style="display:none;">k2</td>--%>
    <%--                        <td><i class="fa fa-user"></i> 3</td>--%>
    <%--                        <td> 120,000</td>--%>
    <%--                        <td class="btn-td">--%>
    <%--                            <input type="button" name="decrease" value="-" class="addbtn decreaseBtn"/>--%>
    <%--                            <input type="text" name="rooms" value="0" id="k2" class="inputbox"/>--%>
    <%--                            <input type="button" name="increase" value="+" class="addbtn increaseBtn"/>--%>
    <%--                        </td>--%>
    <%--                    </tr>--%>
    <%--                    <tr>--%>
    <%--                        <td class="roomType" style="display:none;">RT3</td>--%>
    <%--                        <td class="roomCapacity" style="display:none;">RC3</td>--%>
    <%--                        <td class="roomCount" style="display:none;">0</td>--%>
    <%--                        <td class="availableRoomCount" style="display:none;">4</td>--%>
    <%--                        <td class="mapKey" style="display:none;">k3</td>--%>
    <%--                        <td><i class="fa fa-user"></i> 4</td>--%>
    <%--                        <td> 150,000</td>--%>
    <%--                        <td class="btn-td inputtd">--%>
    <%--                            <input type="button" name="decrease" value="-" class="addbtn decreaseBtn"/>--%>
    <%--                            <input type="text" name="rooms" value="0" id="k3" class="inputbox"/>--%>
    <%--                            <input type="button" name="increase" value="+" class="addbtn increaseBtn"/></td>--%>
    <%--                    </tr>--%>
    <%--                </table>--%>

    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <%--    <div class="room-list-item">--%>
    <%--        <div class="row">--%>
    <%--            <div class="col-lg-4">--%>
    <%--                <figure>--%>
    <%--                    <img class="img-fluid room-img" src="images/p1.jpg">--%>
    <%--                </figure>--%>

    <%--            </div>--%>
    <%--            <div class="col-lg-4">--%>
    <%--                <h4>OCEAN VIEW ROOM</h4>--%>
    <%--                <span class="room-rates">--%>
    <%--              <i class="fa fa-star" aria-hidden="true"></i>--%>
    <%--              <i class="fa fa-star" aria-hidden="true"></i>--%>
    <%--              <i class="fa fa-star" aria-hidden="true"></i>--%>
    <%--              <i class="fa fa-star" aria-hidden="true"></i>--%>
    <%--              <i class="fa fa-star" aria-hidden="true"></i>--%>
    <%--              --%>
    <%--            </span>--%>
    <%--                <p>Enjoy your stay while experiencing the view of the ocean direct from your room</p>--%>
    <%--                <div class="room-services">--%>
    <%--                    <i class="fa fa-coffee" data-toggle="popover" data-placement="top" data-trigger="hover" data-content="Breakfast Included" data-original-title="Breakfast"></i>--%>
    <%--                    <i class="fa fa-wifi" data-toggle="popover" data-placement="top" data-trigger="hover" data-content="Free WiFi" data-original-title="WiFi"></i>--%>
    <%--                    <i class="fa fa-television" data-toggle="popover" data-placement="top" data-trigger="hover" data-content="Plasma TV with cable channels" data-original-title="TV"></i>--%>

    <%--                </div>--%>
    <%--            </div>--%>
    <%--            <div class="col-lg-4 room-add">--%>
    <%--                <table class="room-add-info">--%>
    <%--                    <tr class="table-header">--%>

    <%--                        <td></td>--%>
    <%--                        <td></td>--%>
    <%--                        <td>PRICE (LKR)</td>--%>
    <%--                        <td>ROOMS</td>--%>
    <%--                    </tr>--%>
    <%--                    <tr>--%>

    <%--                        <td><i class="fa fa-user"></i> 2</td>--%>
    <%--                        <td> 100,000</td>--%>
    <%--                        <td  class="btn-td">--%>
    <%--                            <input type="button" name="decrease" value="-" class="addbtn" onclick="doubleroomsdecreaseBtnOnclick()" /><input type="text" name="rooms" value="0" id="double-rooms1" class="inputbox"/>--%>
    <%--                            <input type="button" name="increase" value="+" class="addbtn" onclick="doubleroomsincreaseBtnOnclick()" />--%>
    <%--                        </td>--%>
    <%--                    </tr>--%>
    <%--                    <tr>--%>

    <%--                        <td><i class="fa fa-user"></i> 3</td>--%>
    <%--                        <td> 120,000</td>--%>
    <%--                        <td  class="btn-td">--%>
    <%--                            <input type="button" name="decrease" value="-" class="addbtn" onclick="tripleroomsdecreaseBtnOnclick()" /><input type="text" name="rooms" value="0" id="triple-rooms1" class="inputbox"/>--%>
    <%--                            <input type="button" name="increase" value="+" class="addbtn" onclick="tripleroomsincreaseBtnOnclick()" />--%>
    <%--                        </td>--%>
    <%--                    </tr>--%>
    <%--                    <tr>--%>

    <%--                        <td><i class="fa fa-user"></i> 4</td>--%>
    <%--                        <td> 150,000</td>--%>
    <%--                        <td  class="btn-td">--%>
    <%--                            <input type="button" name="decrease" value="-" class="addbtn" onclick="familyroomsdecreaseBtnOnclick()" /><input type="text" name="rooms" value="0" id="family-rooms1" class="inputbox"/>--%>
    <%--                            <input type="button" name="increase" value="+" class="addbtn" onclick="familyroomsincreaseBtnOnclick()" />--%>
    <%--                        </td>--%>
    <%--                    </tr>--%>
    <%--                </table>--%>
    <%--                <input type="button" value="ADD" class="add-btn"/>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
</section>



<section class="step-btn">

    <div class="btn-div">
        <p>Click proceed to add guest details</p>
        <button class="proceed-btn" id="proceed">PROCEED</button>
        <%--    <a href="index.html"></a>--%>
    </div>
</section>

<!--=========== FOOTER==========-->

<footer>
    <div class="footer-widgets">
        <div class="container">
            <div class="row">
                <!-- WIDGET -->
                <div class="col-md-4">
                    <div class="footer-widget">
                        <img src="images/logo.png" class="footer-logo" alt="Hotel Himara">
                        <div class="inner">
                            <p>We serve the best. Enjoy your dream vacation with us</p>

                        </div>
                    </div>
                </div>

                <!-- WIDGET -->
                <div class="col-md-4">
                    <div class="footer-widget">
                        <h3>USEFUL LINKS</h3>
                        <div class="inner">
                            <ul class="useful-links">
                                <li>
                                    <a href="about-us.html">About Us</a>
                                </li>
                                <li>
                                    <a href="contact.html">Contact Us</a>
                                </li>
                                <li>
                                    <a href="shop.html">Shop</a>
                                </li>
                                <li>
                                    <a href="gallery.html">Himara Gallery</a>
                                </li>
                                <li>
                                    <a href="location.html">Our Location</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- WIDGET -->
                <div class="col-md-4">
                    <div class="footer-widget">
                        <h3>Contact Info</h3>
                        <div class="inner">
                            <ul class="contact-details">
                                <li>
                                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                                    62A,High Level Road, Tangalle
                                </li>
                                <li>
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                    Phone: +94 775 123 456
                                </li>
                                <li>
                                    <i class="fa fa-fax"></i>
                                    Fax: +94 775 123 456
                                </li>
                                <li>
                                    <i class="fa fa-globe"></i>
                                    Web: www.heritance.com
                                </li>
                                <li>
                                    <i class="fa fa-envelope"></i>
                                    Email:
                                    <a href="mailto:info@site.com">contact@heritance.com</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- ========== JAVASCRIPT ========== -->
<%--<script src="js/jquery.min.js"></script>--%>
<%--<script src="http://maps.google.com/maps/api/js?key=YOUR_API_KEY"></script>--%>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-select.min.js"></script>
<script src="js/jquery.mmenu.js"></script>
<script src="js/jquery.inview.min.js"></script>
<script src="js/jquery.countdown.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/owl.carousel.thumbs.min.js"></script>
<script src="js/isotope.pkgd.min.js"></script>
<script src="js/imagesloaded.pkgd.min.js"></script>
<script src="js/masonry.pkgd.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/countup.min.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/daterangepicker.js"></script>
<script src="js/parallax.min.js"></script>
<script src="js/smoothscroll.min.js"></script>
<script src="js/instafeed.min.js"></script>
<script src="js/main.js"></script>
<script src="js/button/dashboard.js"></script>


<script src="js/page/hall.js"></script>
</body>
</html>
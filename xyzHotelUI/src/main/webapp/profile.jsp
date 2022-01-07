<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
    <!-- ========== SEO ========== -->
    <title>Profile</title>
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
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/daterangepicker.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/stylesignin.css">
    <link rel="stylesheet" href="style/userdashboard.css">

    <link rel="stylesheet" href="style/guestdetails.css">
    <link rel="stylesheet" href="style/profile.css">


    <!-- ========== ICON FONTS ========== -->
    <link href="fonts/font-awesome.min.css" rel="stylesheet">
    <link href="fonts/flaticon.css" rel="stylesheet">
    <!-- ========== GOOGLE FONTS ========== -->
    <link href="https://fonts.googleapis.com/css?family=Oswald:400,500,600,700%7CRoboto:100,300,400,400i,500,700" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body class="light">
<!-- ========== MOBILE MENU ========== -->
<nav id="mobile-menu"> </nav>
<!--Navbar-->

<header class="horizontal-header sticky-header transparent-header " data-menutoggle="991" >

    <!--Header-->
    <div class="container">
        <!-- BRAND -->
        <div class="brand">
            <div class="logo">
                <a href="index.html">
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
                    <a href="index.html" >HOME</a>

                </li>
                <li class="menu-item dropdown">
                    <a href="#" >ROOMS</a>

                </li>
                <li class="menu-item dropdown">
                    <a href="#" >CONFERENCE HALLS</a>

                </li>
                <li class="menu-item dropdown">
                    <a href="#">DINING</a>

                </li>

                <li class="menu-item">
                    <a href="contact.html" >CONTACT US</a>
                </li>
                <li class="menu-item menu-btn dropdown active">
                    <a href="#" class="username">

                        <image class="userdp" src="images/u1.png" alt="DP"></image> Hello Bhagya,</a>
                    <ul class="submenu">
                        <li class="menu-item">
                            <a href="#">Profile</a>
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
<section class="contact ">
    <div class="container full">
        <div class="row">
            <div class="bg-img"></div>
            <div class="col-lg-6 text ">
                <div class="section-title">
                    <h4>Welcome <br>NADEESH</h4>
                    <p class="section-subtitle">PLAN YOUR NEXT VACATION WITH US</p>
                </div>


            </div>
            <div class="col-lg-6 sign-form">

                <div id="contact-form" name="contact-form" >
                    <h4 class="form-title">PERSONAL DETAILS</h4>
                    <table class="guest-info">
                        <tr>
                            <td class="col-name">FIRST NAME</td>
                            <td><span class="first-name" id="FirstnameID"></span></td>
                        </tr>
                        <tr>
                            <td class="col-name">LAST NAME</td>
                            <td><span class="last-name" id="LastnameID"></span></td>
                        </tr>
                        <tr>
                            <td class="col-name">EMAIL</td>
                            <td><span class="email" id="emailID"></span></td>
                        </tr>

                        <tr>
                            <td class="col-name">COUNTRY OF RESIDENCE</td>
                            <td><span class="country" id="countryID"></span></td>
                        </tr>
                        <tr>
                            <td class="col-name">NIC/Passport</td>
                            <td><span class="city-amount" id="nicID"></span></td>
                        </tr>
                        <tr>
                            <td class="col-name">CONTACT NO. </td>
                            <td><span class="contact-no" id="contactNoId"></span></td>
                        </tr>
                    </table>

                    <a href="/editProfile"> <button class="btn btn-fw edit-btn" >
                        EDIT</button></a>



                </div>
            </div>


        </div>
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
                                    62A,High Level Road, Tangalle</li>
                                <li>
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                    Phone: +94 775 123 456
                                </li>
                                <li>
                                    <i class="fa fa-fax"></i>
                                    Fax: +94 775 123 456</li>
                                <li>
                                    <i class="fa fa-globe"></i>
                                    Web: www.heritance.com</li>
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

<script src="js/page/loadProfile.js"></script>
<script src="http://maps.google.com/maps/api/js?key=YOUR_API_KEY"></script>
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
<!-- ========== REVOLUTION SLIDER ========== -->

</body>
</html>

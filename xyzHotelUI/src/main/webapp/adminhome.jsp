<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
    <!-- ========== SEO ========== -->
    <title>Hotel Heritance- ADMIN</title>
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
    <link rel="stylesheet" href="style/rooms.css">
    <link rel="stylesheet" href="style/guestdetails.css">
    <link rel="stylesheet" href="style/adminhome.css">

    <!-- ========== ICON FONTS ========== -->
    <link href="fonts/font-awesome.min.css" rel="stylesheet">
    <link href="fonts/flaticon.css" rel="stylesheet">
    <!-- ========== GOOGLE FONTS ========== -->
    <link href="https://fonts.googleapis.com/css?family=Oswald:400,500,600,700%7CRoboto:100,300,400,400i,500,700" rel="stylesheet">
</head>
<body class="dark">
<!-- ========== MOBILE MENU ========== -->
<nav id="mobile-menu"> </nav>
<!--Navbar-->

<header class="horizontal-header sticky-header transparent-header " data-menutoggle="991" >

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
                    <a href="/#" >HOME</a>

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
                    <a href="#" >CONTACT US</a>
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

<section class="box">
    <div class="bg-img"></div>
    <h2>Admin Dashboard</h2>
    <h3 class="after">_________________</h3>
    <div class="container-fluid">
        <div class="row full-box ">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 container-box long">
                <a href="#">
                    <div class="inside">
                        <h3>
                            Book a Room
                        </h3>
                        <h4>
                            ___________
                        </h4>
                        <h6>Pick from our variety of rooms & villas</h6>
                        <h3>
                            Book a Conference Hall
                        </h3>
                        <h4>
                            ___________
                        </h4>
                        <h6>Number of halls to choose from</h6>
                    </div>
                </a>
            </div>

            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 four-container">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 container-box short">
                        <a href="#">
                            <div class="inside">
                                <h3>Check rooms<br> availability</h3>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 container-box short sec">
                        <a href="/registeredUsers">
                            <div class="inside">
                                <h3>Registered<br>Users</h3>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 container-box short">
                        <a href="/reservationsList">
                            <div class="inside">
                                <h3>Reservered Rooms<br>& halls</h3>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 container-box short sec">
                        <a href="/payments">
                            <div class="inside">
                                <h3>Payment <br>History</h3>
                            </div>
                        </a>
                    </div>
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
<script src="js/jquery.min.js"></script>
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
<script src="revolution/js/jquery.themepunch.tools.min.js"></script>
<script src="revolution/js/jquery.themepunch.revolution.min.js"></script>
<script src="revolution/js/extensions/revolution.extension.actions.min.js"></script>
<script src="revolution/js/extensions/revolution.extension.carousel.min.js"></script>
<script src="revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
<script src="revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script src="revolution/js/extensions/revolution.extension.migration.min.js"></script>
<script src="revolution/js/extensions/revolution.extension.navigation.min.js"></script>
<script src="revolution/js/extensions/revolution.extension.parallax.min.js"></script>
<script src="revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<script src="revolution/js/extensions/revolution.extension.video.min.js"></script>
</body>
</html>

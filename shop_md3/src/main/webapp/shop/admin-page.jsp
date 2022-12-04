<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Norda - Minimal eCommerce HTML Template</title>
  <meta name="robots" content="noindex, follow" />
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png">

  <!-- All CSS is here
  ============================================ -->

  <link rel="stylesheet" href="assets/css/vendor/bootstrap.min.css">
  <link rel="stylesheet" href="assets/css/vendor/signericafat.css">
  <link rel="stylesheet" href="assets/css/vendor/cerebrisans.css">
  <link rel="stylesheet" href="assets/css/vendor/simple-line-icons.css">
  <link rel="stylesheet" href="assets/css/vendor/elegant.css">
  <link rel="stylesheet" href="assets/css/vendor/linear-icon.css">
  <link rel="stylesheet" href="assets/css/plugins/nice-select.css">
  <link rel="stylesheet" href="assets/css/plugins/easyzoom.css">
  <link rel="stylesheet" href="assets/css/plugins/slick.css">
  <link rel="stylesheet" href="assets/css/plugins/animate.css">
  <link rel="stylesheet" href="assets/css/plugins/magnific-popup.css">
  <link rel="stylesheet" href="assets/css/plugins/jquery-ui.css">
  <link rel="stylesheet" href="assets/css/style.css">

</head>

<body>

<div class="main-wrapper">
  <header class="header-area">
    <div class="container">
      <div class="header-large-device">
        <div class="header-top header-top-ptb-1 border-bottom-1">
          <div class="row">
            <div class="col-xl-4 col-lg-5">
              <div class="header-offer-wrap">
                <p><i class="icon-user"></i> GROUP ONE  e-commerce shop <span>ADMIN</span> page</p>
              </div>
            </div>
            <div class="col-xl-8 col-lg-7">
              <div class="header-top-right">
                <div class="social-style-1 social-style-1-mrg">
                  <a href="#"><i class="icon-social-twitter"></i></a>
                  <a href="#"><i class="icon-social-facebook"></i></a>
                  <a href="#"><i class="icon-social-instagram"></i></a>
                  <a href="#"><i class="icon-social-youtube"></i></a>
                  <a href="#"><i class="icon-social-pinterest"></i></a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="header-bottom">
          <div class="row align-items-center">
            <div class="col-xl-2 col-lg-9">
              <div class="logo">
                <a href="index.jsp"><img src="assets/images/logo/logo.png" alt="logo"></a>
              </div>
            </div>
            <div class="col-xl-8 col-lg-7">
              <div class="main-menu main-menu-padding-1 main-menu-lh-1">
                <nav>
                  <ul>
                    <li><a ></a></li>
                  </ul>
                </nav>
              </div>
            </div>
            <div class="col-xl-2 col-lg-3">
              <div class="header-action header-action-flex header-action-mrg-right">
                <div class="same-style-2 header-search-1">
                  <a class="search-toggle" href="#">
                    <i class="icon-magnifier s-open"></i>
                    <i class="icon_close s-close"></i>
                  </a>
                  <div class="search-wrap-1">
                    <form action="#">
                      <input placeholder="Search product" type="text">
                      <button class="button-search"><i class="icon-magnifier"></i></button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  </header>
  <div class="breadcrumb-area bg-gray">
    <div class="container">
      <div class="breadcrumb-content text-center">
        <ul>
          <li class="active"><h3 style="color: red">ADMIN PAGE</h3> </li>
        </ul>
      </div>
    </div>
  </div>
  <!-- my account wrapper start -->
  <div class="my-account-wrapper pt-120 pb-120">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <!-- My Account Page Start -->
          <div class="myaccount-page-wrapper">
            <!-- My Account Tab Menu Start -->
            <div class="row">
              <div class="col-lg-3 col-md-4">
                <div class="myaccount-tab-menu nav" role="tablist">
                  <a href="#dashboad" class="active" data-bs-toggle="tab"><i class="fa fa-dashboard"></i>
                    Dashboard</a>
                  <a href="#orders" data-bs-toggle="tab"><i class="fa fa-cart-arrow-down"></i> Orders</a>
                  <a href="login-register.jsp"><i class="fa fa-sign-out"></i> Logout</a>
                </div>
              </div>
              <!-- My Account Tab Menu End -->
              <!-- My Account Tab Content Start -->
              <div class="col-lg-9 col-md-8">
                <div class="tab-content" id="myaccountContent">
                  <!-- Single Tab Content Start -->
                  <div class="tab-pane fade show active" id="dashboad" role="tabpanel">
                    <div class="myaccount-content">
                      <h3>Dashboard</h3>
                      <div class="welcome">
                        <p>Hello, <strong>Admin</strong> (If Not <strong>Admin !</strong><a href="login-register.jsp" class="logout"> Logout</a>)</p>
                      </div>
                      <p class="mb-0">From your Admin account dashboard. you can easily check & view your Database.</p>
                    </div>
                  </div>
                  <!-- Single Tab Content End -->
                  <!-- Single Tab Content Start -->
                  <div class="tab-pane fade" id="orders" role="tabpanel">
                    <div class="myaccount-content">
                      <h3>Orders</h3>
                      <div class="myaccount-table table-responsive text-center">
                        <table class="table table-bordered">
                          <thead class="thead-light">
                          <tr>
                            <th>Order</th>
                            <th>Date</th>
                            <th>Status</th>
                            <th>Total</th>
                            <th>Action</th>
                          </tr>
                          </thead>
                          <tbody>
                          <tr>
                            <td>1</td>
                            <td>Aug 22, 2022</td>
                            <td>Pending</td>
                            <td>$3000</td>
                            <td><a href="#">View</a></td>
                          </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                  <!-- Single Tab Content End -->
                </div>
              </div> <!-- My Account Tab Content End -->
            </div>
          </div> <!-- My Account Page End -->
        </div>
      </div>
    </div>
  </div>
  <!-- my account wrapper end -->
  <div class="subscribe-area bg-gray pt-15 pb-15">
  </div>
  <footer class="footer-area bg-gray pb-30">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-md-6">
          <div class="contact-info-wrap" id="contacInfo">
            <div class="footer-logo">
              <a href="#"><img src="assets/images/logo/logo.png" alt="logo"></a>
            </div>
            <div class="single-contact-info">
              <span>Our Location</span>
              <p>Kent Class, Code Gym My Dinh, HD Mon City</p>
            </div>
            <div class="single-contact-info">
              <span>24/7 hotline:</span>
              <p>(+84) 966778899</p>
            </div>
          </div>
        </div>
        <div class="col-lg-6 col-md-6">
          <div class="footer-right-wrap">
            <div class="social-style-2 social-style-2-mrg">
              <a href="#"><i class="social_twitter"></i></a>
              <a href="#"><i class="social_facebook"></i></a>
              <a href="#"><i class="social_googleplus"></i></a>
              <a href="#"><i class="social_instagram"></i></a>
              <a href="#"><i class="social_youtube"></i></a>
            </div>
            <div class="copyright">
              <p>Copyright @ 2022 HasThemes | <a href="https://hasthemes.com/">Built with <span>Norda</span> by HasThemes</a>.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
</div>

<!-- All JS is here
============================================ -->

<script src="assets/js/vendor/modernizr-3.11.7.min.js"></script>
<script src="assets/js/vendor/jquery-v3.6.0.min.js"></script>
<script src="assets/js/vendor/jquery-migrate-v3.3.2.min.js"></script>
<script src="assets/js/vendor/popper.min.js"></script>
<script src="assets/js/vendor/bootstrap.min.js"></script>
<script src="assets/js/plugins/slick.js"></script>
<script src="assets/js/plugins/jquery.syotimer.min.js"></script>
<script src="assets/js/plugins/jquery.nice-select.min.js"></script>
<script src="assets/js/plugins/wow.js"></script>
<script src="assets/js/plugins/jquery-ui.js"></script>
<script src="assets/js/plugins/magnific-popup.js"></script>
<script src="assets/js/plugins/sticky-sidebar.js"></script>
<script src="assets/js/plugins/easyzoom.js"></script>
<script src="assets/js/plugins/scrollup.js"></script>
<script src="assets/js/plugins/ajax-mail.js"></script>
<!-- Main JS -->
<script src="assets/js/main.js"></script>

</body>

</html>

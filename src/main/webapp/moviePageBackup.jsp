<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Now Playing</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
             
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
                background-color: #FFC300;
                border: none;
            }

            .navbar-inverse .navbar-brand {
                color: #000000;
            }

            .navbar-inverse .navbar-nav>li>a {
                color: #000000;
            }


            .col-half-offset{
                margin-left:4.166666667%
            }


            .no-gutters {
                margin-right: 0;
                margin-left: 0;





            </style>
        </head>
        <body>


            <!--NAVBAR-->

            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>                        
                        </button>
                        <a class="navbar-brand" href="#">Ticket Booker</a>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#">Movies</a></li>
                            <li><a href="#">Prices</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </ul>
                    </div>
                </div>
            </nav>


            <!--NOW PLAYING, IMAGES, SHOWTIMES-->

            <div class="container text-center">    
                <br><br><h1><strong>Now Playing</strong></h1>
                <p><strong>Click on a show time to buy tickets:</strong></p><br>
                <div class="row row-no-gutters">

                    <!--MOVIE 1-->

                    <div class="col-sm-2">
                        <img src="raya.jpg" class="img-responsive" style="width:100%" alt="Image">
                            <h4>Movie 1</h4>
                            <div class="well">
                                <p>Times:</p>
                                <div class="container-fluid">


                                    <div class="btn-toolbar" role="toolbar" aria-label="TimeButtons">
                                        <div class="btn-group-vertical btn-group-xs" role="group" aria-label="MovieTimes">
                                            <a class="btn btn-link" href="#" role="button">11:00am</a>
                                            <a class="btn btn-link" href="#" role="button">1:30pm</a>
                                            <a class="btn btn-link" href="#" role="button">4:00pm</a>
                                            <a class="btn btn-link" href="#" role="button">6:30pm</a>
                                            <a class="btn btn-link" href="#" role="button">9:00pm</a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    
                    <!--MOVIE 2-->
                    
                    <div class="col-sm-2 col-half-offset"> 
                            <img src="avengers.png" class="img-responsive" style="width:100%" alt="Image">
                            <h4>Movie 2</h4>
                            <div class="well">
                                <p>Times:</p>

                                <div class="btn-toolbar" role="toolbar" aria-label="TimeButtons">
                                    <div class="btn-group-vertical btn-group-xs" role="group" aria-label="MovieTimes">
                                        <a class="btn btn-link" href="#" role="button">11:00am</a>
                                        <a class="btn btn-link" href="#" role="button">1:30pm</a>
                                        <a class="btn btn-link" href="#" role="button">4:00pm</a>
                                        <a class="btn btn-link" href="#" role="button">6:30pm</a>
                                        <a class="btn btn-link" href="#" role="button">9:00pm</a>
                                    </div>
                                </div>

                            </div>
                        </div>
                    
                    <!--MOVIE 3-->
                    
                        <div class="col-sm-2 col-half-offset"> 
                            <img src="croods.png" class="img-responsive" style="width:100%" alt="Image">
                            <h4>Movie 3</h4>
                            <div class="well">
                                <p>Times:</p>

                                <div class="btn-toolbar" role="toolbar" aria-label="TimeButtons">
                                    <div class="btn-group-vertical btn-group-xs" role="group" aria-label="MovieTimes">
                                        <a class="btn btn-link" href="#" role="button">11:00am</a>
                                        <a class="btn btn-link" href="#" role="button">1:30pm</a>
                                        <a class="btn btn-link" href="#" role="button">4:00pm</a>
                                        <a class="btn btn-link" href="#" role="button">6:30pm</a>
                                        <a class="btn btn-link" href="#" role="button">9:00pm</a>
                                    </div>
                                </div>

                            </div>
                        </div>
                    
                    <!--MOVIE 4-->
                    
                        <div class="col-sm-2 col-half-offset"> 
                            <img src="lovebirds.png" class="img-responsive" style="width:100%" alt="Image">
                            <h4>Movie 4</h4>
                            <div class="well">
                                <p>Times:</p>

                                <div class="btn-toolbar" role="toolbar" aria-label="TimeButtons">
                                    <div class="btn-group-vertical btn-group-xs" role="group" aria-label="MovieTimes">
                                        <a class="btn btn-link" href="#" role="button">11:00am</a>
                                        <a class="btn btn-link" href="#" role="button">1:30pm</a>
                                        <a class="btn btn-link" href="#" role="button">4:00pm</a>
                                        <a class="btn btn-link" href="#" role="button">6:30pm</a>
                                        <a class="btn btn-link" href="#" role="button">9:00pm</a>
                                    </div>
                                </div>

                            </div>
                          
                        </div>
                    
                    <!--MOVIE 5-->
                    
                        <div class="col-sm-2 col-half-offset"> 
                            <img src="us.png" class="img-responsive" style="width:100%" alt="Image">
                            <h4>Movie 5</h4>
                            <div class="well">
                                <p>Times:</p>

                                <div class="btn-toolbar" role="toolbar" aria-label="TimeButtons">
                                    <div class="btn-group-vertical btn-group-xs" role="group" aria-label="MovieTimes">
                                        <a class="btn btn-link" href="#" role="button">11:00am</a>
                                        <a class="btn btn-link" href="#" role="button">1:30pm</a>
                                        <a class="btn btn-link" href="#" role="button">4:00pm</a>
                                        <a class="btn btn-link" href="#" role="button">6:30pm</a>
                                        <a class="btn btn-link" href="#" role="button">9:00pm</a>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>


                <!--PRICES-->

                <div class="container text-center" id="prices">
                    <h4>Prices:</h4>
                    <div class="row"> 
                        <div class="col-sm-3">
                        </div>
                        <div class="col-sm-6">
                            <div class="well well-lg text-center">
                                <p style="padding-top: 8px"><strong>Matinee (11am-3pm) </strong> $5.00 | <strong>Standard </strong> $10.00 </p>
                            </div>
                        </div>
                        <div class="col-sm-3">

                        </div>

                    </div>

                </div>



            </body>
        </html>

<head>
    <link rel="stylesheet" href="./style/error.css">
</head>
<?php
require "./controller/cookie.controller.php";
require "./controller/permission.controller.php";
require "./controller/error.controller.php";


if(isset($_GET['page'])){
    $page = $_GET['page'];
}else{
    $page = "index";
}
switch ($page){
    case "index":
        require "./view/view.menubar.php";
        require "./view/view.miniJarvis.html";
        require "./controller/miniJarvis.controller.php";
        break;

    case "agb":
        require "./view/view.agb.php";
        break;

    case "about":
        require "./view/view.about.php";
        break;

    case "support":
        require "./view/view.support.php";
        break;

    case "login":
        require "./controller/login.controller.php";
        require "./view/login/view.login.php";
        break;

    case "admin":
        session_start();
        if(getperms() == 1){
        session_write_close();
            require "./controller/admin.controller.php";
            require "./view/view.admin.php";
        }else{
            require "./view/view.404.php";
        }
        break;

    case "logout":
        require "./controller/logout.controller.php";
        break;

    default:
        require "./view/view.404.php";
        break;
}
printErrors($Errors);
?>
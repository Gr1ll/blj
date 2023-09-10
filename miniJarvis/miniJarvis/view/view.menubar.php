<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="./js/menu.js"></script>
<link rel="stylesheet" href="./style/menu.css">
<div class="rc_nav" id="centered_nav">
    <a href="?page=index" title="Home">Home</a>
    <a href="?page=agb" title="Services">AGB</a>
    <a href="?page=about" title="About">About</a>
    <a href="?page=support" title="Contact">Support</a>
    <?PHP
    session_start();
    if($_SESSION['loggedin'] == 1){
    session_write_close();
    if(getperms() == 1){
        echo ("<a href='?page=admin' title='admin'>control panel</a>");
    }
    echo ("<a href='?page=logout' title='logout'>logout</a>");
    }else{
        echo ("<a href='?page=login' title='Login'>Login/register</a>");
    }
    ?>
    <a href="javascript:void(0);" title="Menu" style="font-size:18px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>
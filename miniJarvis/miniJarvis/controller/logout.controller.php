<?php
session_start();
$_SESSION['loggedin'] = 0;
$_SESSION['username'] = "";
echo ("<script>window.location.href='index.php?page=index'</script>");
session_write_close();
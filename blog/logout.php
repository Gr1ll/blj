<?php
session_start();
$_SESSION['loggedin'] = false;
$_SESSION['username'] = "Not logged in";
session_write_close();
?>
<script type="text/javascript">
window.location = "./";
</script>
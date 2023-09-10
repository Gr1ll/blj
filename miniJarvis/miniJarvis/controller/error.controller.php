<?php
$Errors = [];

//print out the Errors in the array
function printErrors($errors){
    if(!empty($errors)){
        ?>
        <div class="errordiv">
        <div class="error">
        <ul>
        <?PHP
        foreach ($errors as $error) {
            echo "<li>$error</li>";
        }
        ?>
        </ul>
        </div>
        </div>
        <?php
    }
}

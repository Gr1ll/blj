<?php
require "./view/view.menubar.php";
?>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./style/login.css">
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>
<body>
<section class="forms-section">
    <div class="forms">
        <div class="form-wrapper is-active">
            <button type="button" class="switcher switcher-login">
                Login
                <span class="underline"></span>
            </button>
            <form class="form form-login" action="" method="post">
                <input type="hidden" name="formname" value="login">
                <fieldset>
                    <legend>Please, enter your email and password for login.</legend>
                    <div class="input-block">
                        <label for="login-username">username</label>
                        <input id="login-username" type="text" name="username" required>
                    </div>
                    <div class="input-block">
                        <label for="login-password">Password</label>
                        <input id="login-password" type="password" name="password" required>
                    </div>
                </fieldset>
                <button type="submit" class="btn-login">Login</button>
            </form>
        </div>
        <div class="form-wrapper">
            <button type="button" class="switcher switcher-signup">
                Register
                <span class="underline"></span>
            </button>
            <form class="form form-signup" action="" method="post">
                <input type="hidden" name="formname" value="register">
                <fieldset>
                    <legend>Please, enter your email, password and password confirmation for sign up.</legend>
                    <div class="input-block">
                        <label for="signup-username">Username</label>
                        <input id="signup-username" type="text" name="username" required>
                    </div>
                    <div class="input-block">
                        <label for="signup-email">Email</label>
                        <input id="signup-email" type="email" name="email" required>
                    </div>
                    <div class="input-block">
                        <label for="signup-password">Password</label>
                        <input id="signup-password" type="password" name="password" required>
                    </div>
                </fieldset>
                <button type="submit" class="btn-signup">Continue</button>
            </form>
        </div>
    </div>
</section>
<script>
    const switchers = [...document.querySelectorAll('.switcher')]

    switchers.forEach(item => {
        item.addEventListener('click', function() {
            switchers.forEach(item => item.parentElement.classList.remove('is-active'))
            this.parentElement.classList.add('is-active')
        })
    })
</script>
</body>
</html>
<?php

if (isset($_COOKIE['setCookieHinweis'])) {
    $showPopup = false;
} else {
    $showPopup = true;
}

?>
<?php if($showPopup) { ?>
    <div id="cookie-popup">
        <div class="hinweis">
            <p>We are using cookies to give you a better experience</p>
        </div>
        <span class="more">
      <a href="?page=agb">details</a>
    </span>
        <button onclick='cookieOk()'>OK, ich bin einverstanden.</button>
    </div>
<?php  }; ?>

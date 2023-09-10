function cookieOk() {
    createCookie("setCookieHinweis", "set", 31104000000);
    document.getElementById("cookie-popup").classList.add("hidden");
}

function createCookie(name, value, seconds) {
    var expires;

    if (seconds) {
        var date = new Date();
        date.setTime(date.getTime() + (seconds * 1000));
        expires = "; expires=" + date.toGMTString();
    }
    else {
        expires = "";
    }

    document.cookie = escape(name) + "=" +
        escape(value) + expires + "; path=/";
}
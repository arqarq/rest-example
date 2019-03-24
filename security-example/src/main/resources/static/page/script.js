// Sprawdzamy czy jesteśmy zalogowani
$.ajax({
    method: "post",
    url: "http://localhost:8080/login",
    success: function () {
        $("#form-login").hide();
    },
    error: function () {
        $("#div-logged-in").hide();
    }
});

// Logujemy się
$("#button-login").click(function () {
    const username = $("#input-username").val();
    const password = $("#input-password").val();
    $.ajax({
        method: "post",
        url: "http://localhost:8080/login",
        headers: {
            "Authorization": "Basic " + btoa(username + ":" + password)
        },
        success: function () {
            alert("Zalogowano!");
            $("#form-login").hide();
            $("#div-logged-in").show();
        },
        error: function () {
            alert("Niepoprawne dane!");
            $("#div-logged-in").hide();
        }
    });
});

$("#button-create").click(function () {
    const manufacturer = $("#manufacturer").val();
    const serialNo = $("#serialNo").val();
    const drawerCount = $("#drawerCount").val();
    const color = $("#color").val();
    const wooden = $("#wooden").prop("checked");
    const desk = {
        manufacturer: manufacturer,
        serialNo: serialNo,
        drawerCount: drawerCount,
        color: color,
        wooden: wooden
    };
    $.ajax({
        method: "post",
        url: "http://localhost:8080/desks",
        data: JSON.stringify(desk),
        contentType: "application/json",
        success: function () {
            alert("Utworzono biurko")
        },
        error: function (response) {
            // console.log(a, b, c);
            const propertyValidationErrors = response.responseJSON;
            displayValidationError(propertyValidationErrors);
            // console.log(propertyValidationErrors);
            alert("Błąd tworzenia biurka")
        }
    });
});

function displayValidationError(propertyValidationErrors) {
    for (let i = 0; i < propertyValidationErrors.length; i++) {
        const property = propertyValidationErrors[i].property;
        const message = propertyValidationErrors[i].message;

        const $message = $("#" + property).siblings(".message");
        $message.text(message)
    }
    const a = {
        a: 13, b: "abcc"
    };
    a.b = "zzz";
    console.log(a.b)
}

console.log("Hello console!");

function reloadTableRows() {
    $.ajax({
        url: "http://localhost:8080/windows",
        method: "get",
        success: function (windows) { // może być anonimowa, ale np. onSuccess() będzie nazwa wyświetlona przy stack trace
            $("#table-rows > tr:not(#row-template)").remove();
            const $rowTemplate = $("#row-template"); // jQuery obiekt reprezentujący obiekt DOM
            // console.log($rowTemplate);
            for (let i = 0; i < windows.length; i++) {
                const window = windows[i];
                const $row = $rowTemplate.clone();
                $row.removeAttr("id");
                $row.css("display", "table-row");
                $row.find(".cell-id").text(window.id);
                $row.find(".cell-width").text(window.width);
                $row.find(".cell-height").text(window.height);
                $row.find(".cell-button").click(function () {
                    buttonDeleteById(window.id)
                });
                $("#table-rows").append($row);
            }
            // $rowTemplate.remove()
        }
    });
}

$("#button-add").click(function () {
    console.log("klik");
    const width = $("#input-width").val();
    const height = $("#input-height").val();
    const window = {
        width: width,
        height: height
    };
    $.ajax({
        url: "http://localhost:8080/windows",
        method: "post",
        contentType: "application/json",
        data: JSON.stringify(window),
        success: function (window) {
            // alert("-" + window.id + " " + window.width + " " + window.height);
            reloadTableRows()
        }
    })
});

function buttonDeleteById(id) {
    console.log("usunięcie");
    $.ajax({
        url: `http://localhost:8080/windows/${id}`,
        // url: "http://localhost:8080/windows/" + id,
        method: "delete",
        success: function () {
            reloadTableRows()
        }
    })
}

$("#button-delete").click(function () {
    let $inputIdToDelete = $("#input-id-delete");
    const id = $inputIdToDelete.val();
    $inputIdToDelete.val("");
    buttonDeleteById(id);
});

reloadTableRows();

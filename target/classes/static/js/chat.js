$(document).ready(function() {
    getPosts();
});

function getPosts() {
    $.ajax({
        type: "GET",
        url: "/chat/all",
        success: function(response){
            drawChat(response);
        },
        error: function(response) {
            $("#infoMessage").html("<p class='alert alert-danger'>" + response.responseText + "</p>");
        }
    });
}

function drawChat(data) {
    let html = "";
    if(data) {
        for(let i=0; i<data.length; i++) {
            html += "<div class='alert alert-light' role='alert'>";
            html += "<p><i>" + data[i].author + " says:</i> <strong>" + data[i].title + "</strong> " + data[i].content + "</p>";
            html += "</div>";
        }
    }
    $("#chat").html(html);
}

$("#addbutton").on("click", function() {
    $.ajax({
            type: "POST",
            url: "/chat/submit",
            data: JSON.stringify(prepareData()),
            contentType: "application/json",
            success: function(response){
                location.reload();
            },
            error: function(response) {
                alert("could not load the chat");
            }
        });
});

function prepareData() {
    return {
        title: $("#title").val(),
        content: $("#content").val()
    }
}
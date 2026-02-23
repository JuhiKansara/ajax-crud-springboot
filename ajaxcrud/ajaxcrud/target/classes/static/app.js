function load(){
    $.get("/students",function(list){
        let html = "";

        list.forEach(s => {
            html += `
                <p>
                    ${s.name} - ${s.email} - ${s.course}
                    <button onclick="del(${s.id})">Delete</button>
                </p>
            `;
        });
        $("#data").html(html);
    });
}

function add(){
    if(!isValidEmail($("#email").val())){
        alert("Please Enter Valid Email.");
        return;
    }

    $.ajax({
        url: "/students",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            name: $("#name").val(),
            email: $("#email").val(),
            course: $("#course").val()
        }),
        success: function(){
            load();

            $("#name").val(""),
            $("#email").val(""),
            $("#course").val("")
        }
    });
}

function del(id){
    $.ajax({
        url: "/students/"+id,
        method: "DELETE",
        success: load
    });
}

load();

function isValidEmail(email){
    return /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email);
}
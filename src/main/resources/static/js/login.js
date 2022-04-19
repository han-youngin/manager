$("#btn-login").click(() => {
    login();
});

async function login(){

    let checked = $('#remember').is(':checked');

    let loginDto = {
        username: $("#username").val(),
        password: $("#password").val(),
        remember: checked ? "on" : "off"
    }

    let response = await fetch("/login", {
        method: "POST",
        body: JSON.stringify(loginDto),
        headers: {
            'Content-Type': 'application/json; charset=utf-8',
        }
    });
    let responseParse = await response.json();
    console.log(responseParse);

    if (responseParse.code == 1) {
        alert("로그인완료");
        location.href = "/";
    } else {
        alert('로그인실패');
    }
}
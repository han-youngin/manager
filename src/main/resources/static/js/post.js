// $("#btn-create").click(() => {
//     create();
// });

// async function create(){
//     let newDto = {
//         gamename: $("#gamename").val(),
//     }

//     let response = await fetch("/create",{
//         method: "POST",
//         body: JSON.stringify(newDto),
//         headers: {
//             "Content-Type": "application/json; charset=utf-8"
//         }
//     });
//     let responseParse = await response.json();

//     if (responseParse.code == 1) {
//         alert("등록 성공");
//         location.href = "/GameList";
//     } else {
//         alert("등록 실패");
//     }
// }
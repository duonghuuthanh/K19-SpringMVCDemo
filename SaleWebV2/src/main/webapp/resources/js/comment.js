/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function showSpinner(status) {
    let spinners = document.getElementsByClassName("spinner");
    for (let s of spinners)
        s.style.display = status;
} 

function loadComments(endpoint) {
    fetch(endpoint).then(res => res.json()).then(data => {
        let msg = "";
        for (let c of data) {
            msg += `
              <div class="row bg-light m-1">
                    <div class="col-md-1 col-xs-3">
                        <h5>${c.user.firstName} ${c.user.lastName}</h5>
                    </div>
                    <div class="col-md-10 col-xs-9">
                        <p>${c.content}</p>
                        <small>
                            Binh luan boi <a href="#">${c.user.username}</a> luc ${moment(c.createdDate).locale("vi").fromNow()}
                        </small>
                    </div>
                </div>
            `
        }
        
        let d = document.getElementById("comments");
        d.innerHTML = msg;
    });
}

function addComment(endpoint) {
    showSpinner("block")
    fetch(endpoint, {
        method: "POST",
        body: JSON.stringify({
            "content": document.getElementById("comment-content").value
        }), 
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(c => {
        showSpinner("none")
        let d = document.getElementById("comments");
        d.innerHTML = `
              <div class="row bg-light m-1">
                    <div class="col-md-1 col-xs-3">
                        <h5>${c.user.firstName} ${c.user.lastName}</h5>
                    </div>
                    <div class="col-md-10 col-xs-9">
                        <p>${c.content}</p>
                        <small>
                            Binh luan boi <a href="#">${c.user.username}</a> luc ${moment(c.createdDate).locale("vi").fromNow()}
                        </small>
                    </div>
                </div>
            ` + d.innerHTML;
    });
}
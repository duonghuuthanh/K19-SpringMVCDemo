/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function deleteProduct(endpoint, id) {
    if (confirm("Bạn chắc chắn xóa? Nó sẽ xóa luôn các hóa đơn liên quan?") === true) {
        let s = document.getElementById(`spinner${id}`);
        s.style.display = "block";
        
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            s.style.display = "none";
            console.info(res);
            if (res.status === 204) {
                document.getElementById(`product${id}`).style.display = "none";
            } else
                alert("Hệ thống đang có lỗi, vui lòng quay lại sau!");
        });
    }
}

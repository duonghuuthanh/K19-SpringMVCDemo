/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function deleteProduct(endpoint, id) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: 'delete'
        }).then(res => {
            if (res.status === 204) {
                document.getElementById(`product${id}`).style.display = "none";
            } else
                alert("Hệ thống đang có lỗi!!!");
        });
    }
}

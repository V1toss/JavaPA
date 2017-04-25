/**
 * Created by Karetko Victor on 20.04.17.
 */

/**
 * Load orders to page.
 */
function getOrders() {
    $.ajax('./getOrders', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            document.getElementById("orders").innerHTML = "";
            $.each(data, function (i, el) {
                var line = "<tr>"
                    + "<td>" + el.car.model.brand.name + "</td>"
                    + "<td>" + el.car.model.name + "</td>"
                    + "<td>" + el.description + "</td>"
                    + "<td>" + el.price + "</td>"
                    + "<td>" + el.sold + "</td>"
                    + "<td>" + new Date(el.date) + "</td>"
                    + "<td>" + el.user.login + "</td>";
                document.getElementById("orders").innerHTML += line;
            });
        }
    })
}

/**
 * Load user info.
 */
function loadUser() {
    $.ajax('./getUser', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            if (data == null) {
                document.getElementById("login").innerHTML = "<a href='login.html' style='float: right; padding-top: 10px'>Войти</a>";
            } else {
                document.getElementById("login").innerHTML = "<a href='login.html' style='float: right; padding-top: 10px'>" + data.login + "  Выйти</a>";
            }
        }
    })
}
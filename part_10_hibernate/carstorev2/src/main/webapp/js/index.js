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
 * Check if user is logged in before creating.
 */
function checkUser() {
    $.ajax('./getUser', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            if (data == null) {
                location.href = "./login.html";
            } else {
                location.href = "./new.html";
            }
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

/**
 * Validate user login and password.
 */
function validate() {
    $.ajax('./setUser', {
        method : 'post',
        data : {
            login : $('#login').val(),
            password : $('#password').val()
        },
        complete : function(data){
            var result = JSON.parse(data.responseText);
            if (result) {
                location.href = "./index.html";
            } else {
                alert("Please input correct login and password");
            }
        }
    });
}

function brandSelector() {
    $.ajax('./getBrands', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, el) {
                document.getElementById("brand").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function modelSelector() {
    var sel = document.getElementById("brand");
    $.ajax('./getModels', {
        method: 'get',
        data : {
            brand : sel.options[sel.selectedIndex].text
        },
        dataType: "json",
        success: function (data) {
            document.getElementById("model").innerHTML = "";
            $.each(data, function (i, el) {
                document.getElementById("model").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function engineSelector() {
    $.ajax('./getEngines', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, el) {
                document.getElementById("engine").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function transmissionSelector() {
    $.ajax('./getTransmissions', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, el) {
                document.getElementById("transmission").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function carBodiesSelector() {
    $.ajax('./getBodies', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, el) {
                document.getElementById("body").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function drivesSelector() {
    $.ajax('./getDrives', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, el) {
                document.getElementById("drive").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}


/**
 * Load selectors on form.
 */
function loadSelectors() {
    brandSelector();
    engineSelector();
    transmissionSelector();
    carBodiesSelector();
    drivesSelector();
}

/**
 * Add new order.
 */
function addNewOrder() {
    var selBrand = document.getElementById("brand");
    var selModel = document.getElementById("model");
    var selBody = document.getElementById("body");
    var selEngine = document.getElementById("engine");
    var selTransmission = document.getElementById("transmission");
    var selDrive = document.getElementById("drive");
    $.ajax('./addOrder', {
        method : 'post',
        data : {
            price : $('#price').val(),
            year : $('#year').val(),
            description : $('#description').val(),
            color : $('#color').val(),
            enginePower : $('#enginePower').val(),
            mileage : $('#mileage').val(),
            modelId : selModel.options[selModel.selectedIndex].value,
            transmissionId : selTransmission.options[selTransmission.selectedIndex].value,
            engineId : selEngine.options[selEngine.selectedIndex].value,
            bodyId : selBody.options[selBody.selectedIndex].value,
            driveId : selDrive.options[selDrive.selectedIndex].value
        },
        complete : function(data){
            location.href = "./index.html";
        }
    });
}

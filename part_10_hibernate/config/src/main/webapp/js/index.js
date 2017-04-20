/**
 * Created by Karetko Victor on 20.04.17.
 */

/**
 * Load items to page.
 */
function getItems() {
    $.ajax('./getItems', {
        method: 'get',
        dataType: "json",
        data: {
            'isDone': $("#status").prop('checked')
        },
        success: function (data) {
            document.getElementById("items").innerHTML = "";
            $.each(data, function (i, el) {
                var line = "<tr>"
                    + "<td>" + el.id + "</td>"
                    + "<td>" + el.desc + "</td>"
                    + "<td>" + new Date(el.created) + "</td>";
                if (el.done === true) {
                    line += "<td style='text-align: center'>" +
                        "<input type='checkbox' checked onchange='return updateStatus("+el.id+","+ el.done+")'/></td>";
                } else {
                    line += "<td style='text-align: center'>" +
                        "<input type='checkbox' onchange='return updateStatus("+el.id+","+ el.done+")'/></td>";
                }
                line += "<td><button class='btn btn-default btn-xs' style='border: none; color: red' " +
                    "onclick='return deleteItem("+el.id+")'> <i class=\"glyphicon glyphicon-remove\"></i></button></td></tr>";
                document.getElementById("items").innerHTML += line;
            });
        }
    })
}

/**
 * Update status of item.
 * @param id id of item to update.
 * @param status new status.
 */
function updateStatus(id, status) {
    $.ajax('./updateStatus', {
        method: 'post',
        data: {
            'id': id,
            'isDone': status
        }
    })
}

/**
 * Add new item to db.
 * @param description description of item.
 */
function addItem() {
    $.ajax('./addItem', {
        method: 'post',
        data: {
            'desc': $("#description").val()
        },
        success: location.reload()
    })
}

/**
 * Delete item from db.
 * @param id id of item.
 */
function deleteItem (id) {
    $.ajax('./deleteItem', {
        method: 'post',
        data: {
            'id': id
        },
        success: location.reload()
    })
}
$(function () {
    $('#create').click(function () {
        $.ajax({
            url: '/api/accounts',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'POST',
            // dataType: 'json',
            data: JSON.stringify({
                'id': $('#id').val(),
                'owner': $('#owner').val(),
                'balance': $('#balance').val()
            }),
            success: function () {
                alert('Создание успешно!');
            },
            error: function(xhr, status, error) {
                alert(xhr.responseJSON.error.message);
            }
        });
    });
});
$(function () {
    $('#calculate').click(function (){
        let arg1 = $('#arg1').val();
        let arg2 = $('#arg2').val();
        if (!arg1) {
            $('#arg1').css("border-color", "red");
        } else {
            $('#arg1').css("border", "");
        }

        if (!arg2) {
            $('#arg2').css("border-color", "red");
        } else {
            $('#arg2').css("border", "");
        }

        if (!arg1 || !arg2) {
            alert('Укажите значения!')
            return;
        }

        $.ajax({
            url: '/calculator/summa?arg1=' + arg1 + '&arg2=' + arg2,
            type: 'POST',
            success: function (result) {
                $('#result').text('Результат расчета суммы: ' + result.value);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                $('#result').text('Складывать значение большее 100 недопустимо!');
            }
        });
    });
});
$(document).ready(function() {
    $('#inputText').blur(function() {
        let val = $(this).val();
        if (!val) {
            // alert('Введите обязательное значение поля!');
            $('#errorLabel').attr('style', 'display: block');
        } else {
            $('#errorLabel').hide();
        }
    });
});
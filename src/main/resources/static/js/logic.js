// $(document).ready(function() {
$(function () {
    // document.getElementById('inputText')
    var element = {
        'field1' : 'example',
        'value' : 125
    };
    let elementAsString = JSON.stringify(element);
    JSON.parse(elementAsString);
    $('#inputText').blur(function() {
        let val = $(this).val();
        if (!val) {
            // alert('Введите обязательное значение поля!');
            // $('#errorLabel').attr('style', 'display: block');
            $('#errorLabel').css('display', 'block');
        } else {
            $('#errorLabel').hide();
        }
    });

    // $("a[id^='genre']").click(function (event) {
    //     if (confirm('Are you sure to delete this genre?')) {
    //         let genreCode = $(this).attr('name').replace('genre_', '');
    //         $.ajax({
    //             url: '/genres/' + genreCode,
    //             type: 'DELETE',
    //             success: function (result) {
    //                 if (result.success) {
    //                     location.href = '/genres';
    //                 }
    //             }
    //         });
    //     }
    //     event.preventDefault();
    // });
});
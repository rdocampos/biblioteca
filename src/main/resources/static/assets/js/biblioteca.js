$(document).on('submit', '.form-ajax', function (event) {
    var form = event.target;
    ajaxForm(form);
    return false;
});


function ajaxForm(form) {
    var container = $(form).attr('data-target');
    var containerId = '#' + container;
    var url = $(form).attr('action');

    $.ajax({
        type: "POST",
        url: url,
        data: $(form).serialize(), // serializes the form's elements.
        success: function (data) {
            $(containerId).html(data);
        }
    });
}

$(document).ready(function(){
    var SPMaskBehavior = function (val) {
            return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
        },
        spOptions = {
            onKeyPress: function(val, e, field, options) {
                field.mask(SPMaskBehavior.apply({}, arguments), options);
            }
        };

    $('.cpf').mask('000.000.000-00', {reverse: true});
    $('.mask-phone').mask(SPMaskBehavior, spOptions);
    $('.money').mask("#.##0,00", {reverse: true});
});
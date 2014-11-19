
$(document).ready(function() {
    $('.registerForm').bootstrapValidator({
        message: 'This value is not valid',
       
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            nome: {
                message: 'The name is not valid',
                validators: {
                    notEmpty: {
                        message: 'Riempire il campo nome.'
                    },
                    stringLength: {
                        min: 3,
                        max: 30,
                        message: 'Almeno 3 caratteri.'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'Solo lettere.'
                    }
                }
            },
            
            squadraReale: {
                message: 'The name is not valid',
                validators: {
                    notEmpty: {
                        message: 'Riempire il campo squadra.'
                    },
                    stringLength: {
                        min: 3,
                        max: 30,
                        message: 'Almeno 3 caratteri.'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'Solo lettere.'
                    }
                }
            }
           
        }
    });
});
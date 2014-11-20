
$(document).ready(function() {
    $('.registerForm').bootstrapValidator({
        message: 'This value is not valid',
       
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'Il campo username non può essere vuoto.'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'Almeno 4 caratteri.'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'Solo lettere e numeri.'
                    }
                }
            },
            userName: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'Il campo username non può essere vuoto.'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'Almeno 4 caratteri.'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'Solo lettere e numeri.'
                    }
                }
            },
            nome: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'Il campo nome non può essere vuoto.'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'Almeno 4 caratteri.'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'Solo lettere e numeri.'
                    }
                }
            },
            cognome: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'Il campo cognome non può essere vuoto.'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'Almeno 4 caratteri.'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'Solo lettere e numeri.'
                    }
                }
            },
            password: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'Il campo password non può essere vuoto.'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'Almeno 4 caratteri.'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'Solo lettere e numeri.'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Il campo email non può essere vuoto.'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            }
        }
    });
});
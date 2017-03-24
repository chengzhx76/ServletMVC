function ajaxHttpRequest(url, options) {
    var server_url = 'http://localhost:8080/wechat/';

    var opts = $.extend({
        'method': 'get',
        'data': null,
        'contentType': 'application/x-www-form-urlencoded',
        'success': function () {},
        'error': function () {}
    }, options);

    var allUrl = server_url + url;

    $.ajax({
        type: opts.method,
        url: allUrl,
        data: opts.data,
        contentType: opts.contentType,
        success: function(data, status) {
            console.log(data);
            opts.success && opts.success.apply(this, [data, status]);
        },
        error: function(errorType, error) {
            console.log(error);
            opts.error && opts.error.apply(this, [errorType, error]);
        }
    });
}

function callback(data) {
    //console.log("===>callback");
}


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>加载中</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, target-densityDpi=device-dpi" />
    <script src="static/js/zepto.min.js"></script>
    <script src="static/js/zepto.cookie.js"></script>
    <script src="static/js/main.js"></script>
</head>
<body>

<div class="loading">
    加载中...
</div>

<script>

    $(function(){
        var openId = $.fn.cookie('openId');
        var url = 'http://chengzhx76.wicp.net/ServletMVC/weixin?method='+getQueryparam('url');
        if (openId != null && openId != '') {
            console.log(openId);
            window.location.href = url;
        } else {
            var wxUrl = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxcabea2c14e5861ec&redirect_uri=' + encodeURIComponent(url) + '&response_type=code&scope=snsapi_base&state=123#wechat_redirect';
            window.location.href = wxUrl;
        }
    });











    /*window.onload=function(){
        var openId = $.fn.cookie('openId');
        var url = 'http://chengzhx76.wicp.net/ServletMVC/weixin?method='+getQueryparam('url');
        if (openId != '') {
            var jumUrl = url;
            window.location.href = jumUrl;
        }else {
            var wxUrl = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxcabea2c14e5861ec&redirect_uri=' + encodeURIComponent(url) + '&response_type=code&scope=snsapi_base&state=123#wechat_redirect';
            window.location.href = wxUrl;
        }
    }*/
</script>
</body>
</html>
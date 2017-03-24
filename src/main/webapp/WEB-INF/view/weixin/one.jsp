<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>test</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, target-densityDpi=device-dpi" />
    <script src="http://chengzhx76.wicp.net/ServletMVC/static/js/zepto.min.js"></script>
    <script src="http://chengzhx76.wicp.net/ServletMVC/static/js/main.js"></script>
</head>
<body>

<div class="loading">
    ${info}OPENID--${openId}
    <br>
    <br>
    <button id="btn">清除openId</button>
</div>

<script>
    $(function(){
        setLocVal('openId', '${openId}');

        $('#btn').click(function(){
            clearLocVal('openId');
            alert('清除SUCCCESS');
        });
    });
</script>
</body>
</html>
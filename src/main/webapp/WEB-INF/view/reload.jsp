<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <title>实施刷新数据</title>
  <link href="" rel="stylesheet">
  <script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
  <style>
    ul {
      height: 35px;
      width: 530px;
      background: #393D49;
    }
    ul li {
      width: 150px;
      height: 35px;
      float: left;
      text-align: center;
      line-height: 35px;
      margin-left: 8px;
      background: #FF5722;
      list-style-type:none;
    }
    .tools {
      height: 80px;
    }
  </style>
</head>
<body>
  <div class="tools">
    <button id="btn">追加文本</button>
    <h6 id="msg" style="color: red;"></h6>
  </div>
  <hr/>
  <ul>
    <li>1</li>
    <li>2</li>
    <li>3</li>
  </ul>

</body>
<script>
  var timer;
  $(function() {
    timer = setInterval('laod()', 1500);
//    $('#btn').click(function(){
//    });
  });

  function laod() {
    $.ajax({
      type: "get",
      dataType:'json',
      cache:false,
      url: "http://localhost/ServletMVC/reload?method=reloadData",
      beforeSend: function(XMLHttpRequest){
      },
      success: function(datas){
        console.dir(datas);
        if (datas.length>0) {
          $('#msg').html('');
          for(var index in datas) {
            var first = $('ul:first');
            var five = $('ul:eq(4)');
            first.before('<ul><li>'+datas[index].username+'</li><li>'+datas[index].sex+'</li><li>'+datas[index].birthday+'</li></ul>');
            five.remove();
          }
        }else {
          $('#msg').html('暂时没有新数据');
        }

      },
      error: function(){
        clearInterval(timer);
        alert("Error!");
      }
    });
  }
</script>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <title>上传图片</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="" rel="stylesheet">
</head>
<body>
<div>
  <form action="index?method=updata" method="POST" enctype="multipart/form-data">
    <table>
      <tr>
        <td><label for="file1">文件1：</label></td>
        <td><input type="file" id="file1" name="file"></td>
      </tr>
      <tr>
        <td><label for="file2">文件2：</label></td>
        <td><input type="file" id="file2" name="file"></td>
      </tr>
      <tr>
        <td><label for="file3">文件3：</label></td>
        <td><input type="file" id="file3" name="file"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="上传" name="upload"></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>

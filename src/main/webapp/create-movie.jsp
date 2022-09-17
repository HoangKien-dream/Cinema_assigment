<%@ page import="java.util.List" %>
<%@ page import="com.example.demojsp.model.Category" %><%--
  Created by IntelliJ IDEA.
  User: hoangtrungkien
  Date: 25/08/2022
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .m-t-b {
        margin-top: 10px;
        margin-bottom: 10px;
    }
    .main{
        margin: 200px 500px ;
        padding: 50px;
        border: 1px solid black;
        border-radius: 10px;
        margin-bottom: 0 !important;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
<div >
    <div class="main">
        <div style="text-align: center">
            <h5>Create Movie</h5>
        </div>
        <form action="CreateMovie" method="post">
            <%
                List<Category> categories = (List<Category>) request.getAttribute("categories");
            %>
            <div class="m-t-b">
                <label>Tên phim </label>
                <input name="name" type="text" class="form-control">
            </div>
            <div class="m-t-b">
                <label > Thể loại</label>
                <select class="form-select" name="categoryId" aria-label="Default select example">
                    <%
                        for (Category category : categories) {
                    %>
                    <option value="<%= category.getId()%>">
                        <%= category.getName()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div class="m-t-b">
                <label>Ảnh</label>
                <input type="text" name="thumbnail" class="form-control">
            </div>
            <div class="m-t-b">
                <div class="form-floating">
                    <textarea class="form-control" name="description" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
                    <label for="floatingTextarea2">Miêu tả</label>
                </div>
            </div>
            <div style="text-align: center">
                <button type="submit"  class="btn btn-primary">Create</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>

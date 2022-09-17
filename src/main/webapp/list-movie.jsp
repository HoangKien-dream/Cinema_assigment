<%@ page import="java.util.List" %>
<%@ page import="com.example.demojsp.model.Movie" %><%--
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
    .img-thumbnail{
        height: 275px !important;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
<div class="container">
    <div class="row">
        <%
            List<Movie> movies = (List<Movie>)request.getAttribute("movies");
        %>
        <%
            for (Movie movie:
                 movies) {
        %>
        <div class="col-3">
            <div class="card" style="width: 18rem;">
                <img class="img-thumbnail"   src="<%=movie.getThumbnail()%>" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5><%=movie.getName()%></h5>
                    <p class="card-text"><%=movie.getDescription()%></p>
                </div>
                <button class="btn btn-warning" onclick="buy(<%=movie.getId()%>)">Buy</button>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/GetListCategory', true);
    let data = 1;
    xhr.send(data);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = xhr.responseText;
            alert(data);
        }
    }
</script>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demojsp.model.Category" %>
<%@ page import="com.example.demojsp.model.Movie" %>
<%@ page import="com.example.demojsp.model.Cinema" %>
<%@ page import="com.example.demojsp.model.Room" %><%--
  Created by IntelliJ IDEA.
  User: hoangtrungkien
  Date: 24/08/2022
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateTicket</title>
</head>
<style>
    .form-signin {
        margin: 400px;
        border: 1px solid black;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
<div class="form-signin">
    <form action="CreateTicket" style="padding: 20px" method="post">
        <%
            List<Movie> movies = (List<Movie>) request.getAttribute("movies");
            List<Cinema> cinemas = (List<Cinema>) request.getAttribute("cinemas");
            List<Room> rooms = (List<Room>) request.getAttribute("rooms");
        %>
        <div class="row container-fluid" >
            <div style="text-align: center; margin-bottom: 10px">
               <h5> Create Ticket DreamCinema</h5>
            </div>
            <div>
                <select class="form-select" name="movieId" aria-label="Default select example">
                    <%
                        for (Movie movie : movies) {
                    %>
                    <option value="<%= movie.getId()%>">
                        <%= movie.getName()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div style="margin:20px 0">
                <select class="form-select" name="cinemaId" aria-label="Default select example">
                    <%
                        for (Cinema cinema : cinemas) {
                    %>
                    <option value="<%= cinema.getId()%>">
                        <%= cinema.getName()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div>
                <select class="form-select" name="roomId" aria-label="Default select example">
                    <%
                        for (Room room : rooms) {
                    %>
                    <option value="<%= room.getId()%>">
                        <%= room.getName()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div style="margin-top: 20px">
                <input name="price" class="form-control" type="number">
            </div>
            <div style="margin-top: 20px">
                <input type="time" class="form-control" name="time" step='1' min="00:00:00" max="24:00:00">
            </div>
            <div style="margin-top: 20px">
                <input type="date" class="form-control" name="date" >
            </div>
                <button type="submit" style="margin-top:10px " class="btn btn-primary">Create</button>
        </div>
    </form>
</div>
</body>
</html>

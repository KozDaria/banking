<%@ include file="../common/header.jspf" %>
<div class="container">
    <%
        session = request.getSession(false);
        if (session.getAttribute("login") == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <h3>
        ${welcome_name}:
        <%
            out.print("Welcome "+ session.getAttribute("name"));
        %>
    </h3>
    <br>
    <!-- Cards -->
    <p>My cards
        <a href="http://localhost:8080/cards/">Details</a>
    </p>
    <br>

    <!-- Accounts -->
    <p>My accounts
        <a href="http://localhost:8080/accounts/">Details</a>
    </p>

    <a class="btn btn-danger" href="/logout" role="button">Logout${welcome_logout}</a>

</div>

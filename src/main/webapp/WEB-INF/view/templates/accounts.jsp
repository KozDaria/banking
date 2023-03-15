<%@ include file="../common/header.jspf" %>
<div class="container">
    <%
        session = request.getSession(false);
        if (session.getAttribute("login") == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <h3>
        <%
            out.print("Operations with accounts: ");
        %>
    </h3>
    <br>
    <button class="btn btn-info my-4 btn-block" type="submit">${create_submit} create acc</button>
    <br>
    <br>
    <button class="btn btn-info my-4 btn-block" type="submit">${get_submit} get acc details</button>
    <br>
    <br>
    <button class="btn btn-info my-4 btn-block" type="submit">${delete_submit} delete acc</button>
    <br>
    <br>


    <a class="btn btn-danger" href="/logout" role="button">Logout${welcome_logout}</a>

</div>

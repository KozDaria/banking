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
            out.print("Operations with cards: ");
        %>
    </h3>
<br>
    <form class="text-center border border-light p-5" action=""
          method="post">
    <button class="btn btn-info my-4 btn-block" type="submit">${create_submit} createCard</button>
    </form>
    <br>
    <br>
    <button class="btn btn-info my-4 btn-block" type="submit">${reissue_submit} reissue </button>
    <br>
    <br>
    <button class="btn btn-info my-4 btn-block" type="submit">${get_submit} getCard"</button>
    <br>
    <br>
    <button class="btn btn-info my-4 btn-block" type="submit">${delete_submit} deleteCard</button>
    <br>
    <br>
    <button class="btn btn-info my-4 btn-block" type="submit">${add_submit} cardToAccount</button>
    <br>
    <br>

    <a class="btn btn-danger" href="/logout" role="button">Logout${welcome_logout}</a>

</div>

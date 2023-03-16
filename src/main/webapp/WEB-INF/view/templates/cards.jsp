<%@ include file="../common/header.jspf" %>
<div class="container">
<%--    <%--%>
<%--        session = request.getSession(false);--%>
<%--        if (session.getAttribute("login") == null) {--%>
<%--            response.sendRedirect("login.jsp");--%>
<%--        }--%>
<%--    %>--%>
    <h3>
        <%
            out.print("Operations with cards: ");
        %>
    </h3>
<br>
    <form class="text-center border border-light p-5" action="/cards/createCard"
          method="post">
    <button class="btn btn-info my-4 btn-block" type="submit">${createCard_submit} createCard</button>
    </form>
    <br>
    <form id="reissue_form" class="text-center border border-light p-5" action="/cards/reissue"
          method="post">
    <button class="btn btn-info my-4 btn-block" type="submit">${reissue_submit} reissue </button>
        <label>Bank card number:
            <input type="text" name="reissue_number" class="form-control mb-4" placeholder="${reissue_number}" required="required">
        </label>
    <br>
    </form>
    <br>
    <form class="text-center border border-light p-5" action="/cards/getCard"
          method="get">
        <button class="btn btn-info my-4 btn-block" type="submit">${get_submit} getCard</button>
        <label>Bank card number:
            <input type="text" name="number" class="form-control mb-4" placeholder="${number}" required="required">
        </label>
    </form>
    <br>
    <br>
    <form class="text-center border border-light p-5" action="/cards/deleteCard"
          method="post">
    <button class="btn btn-info my-4 btn-block" type="submit">${delete_submit} deleteCard</button>
        <label>Bank card number:
            <input type="text" name="delete_number" class="form-control mb-4" placeholder="${delete_number}" required="required">
        </label>
    </form>
    <br>
    <br>
    <button class="btn btn-info my-4 btn-block" type="submit">${add_submit} cardToAccount</button>
    <br>
    <br>

    <a class="btn btn-danger" href="/logout" role="button">Logout${welcome_logout}</a>

<%--    <script>--%>
<%--        $("#reissue_form").submit(function(event){--%>
<%--            event.preventDefault();--%>
<%--            var form = $(this);--%>
<%--            var reissue_number = form.find('input[name="reissue_number"]').val();--%>
<%--            var url = 'http://localhost:8080/cards/reissue'+reissue_number;--%>

<%--            $.ajax({--%>
<%--                type : 'PUT',--%>
<%--                url : url,--%>
<%--                contentType: 'application/x-www-form-urlencoded',--%>
<%--                data : "reissue_number="+reissue_number,--%>
<%--                success : function(data, status, xhr){--%>
<%--                    $("#result").html(data+--%>
<%--                        " link: <a href='"+url+"'>"+url+"</a>");--%>
<%--                },--%>
<%--                error: function(xhr, status, error){--%>
<%--                    alert(error);--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>

<%--    </script>--%>
</div>

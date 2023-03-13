Hi my little Friend!

<body>
<div class="container">
    <form class="text-center border border-light p-5" action="/login"
          method="post">
        <c:if test="${not empty error}" >
            <h3>
                <font color="red">${errorMessage}</font>
            </h3>
        </c:if>

        <p class="h4 mb-4">

        <h3>${login_signin}</h3>
        <h3> <%out.print(session.getAttributeNames()); %></h3>

        <!-- Email -->
        <Fieldset>
            <input type="text" name="login" class="form-control mb-4"
                   placeholder="${login_username}" required="required">

        </Fieldset>
        <!-- Password -->
        <FieldSet>
            <label>
                <input type="password" name="password" class="form-control mb-4"
                       placeholder="${login_password}" required="required">
            </label>
        </FieldSet>

        <!-- Sign in button -->
        <button class="btn btn-info btn-block my-4" type="submit">${login_submit}
        </button>
<%--<style>--%>
<%--    from{--%>
<%--        background-color: cadetblue;--%>
<%--        width: 250px;--%>
<%--        height: 200px;--%>
<%--        border-style: solid;--%>
<%--        border-color: cadetblue;--%>
<%--        padding: 10px;--%>
<%--    }--%>
<%--    </style>--%>
<%--<div>--%>
<%--    <br>--%>
<%--    <form action="/login" method="post">--%>
<%--        <div><label>Login:--%>
<%--            <input type="text" name="login" value="">--%>
<%--        </label></div>--%>
<%--        <br>--%>
<%--        <div><label>Password:--%>
<%--            <input type="text" name="password" value="">--%>
<%--        </label></div>--%>
<%--        <div><input type="submit" value="Login"></div>--%>l


<%--    </form>--%>
<%--</div>--%>


<!-- Default form login -->
<form class="text-center border border-light p-5" action="${pageContext.request.contextPath}/login/"
      method="post">
    <c:if test="${not empty error}" >
        <h3>
            <font color="red">${errorMessage}</font>
        </h3>
    </c:if>

    <p class="h4 mb-4">Sign in</p>

    <!-- Login -->
    <label>Login:   <input type="text" name="login" class="form-control mb-4" placeholder="${login_username}" required="required">
    </label>

    <!-- Password -->
    <label>Password:
    <input type="password" name="password" class="form-control mb-4" placeholder="${login_password}" required="required">
    </label>

    <div class="d-flex justify-content-around">

        <div>
            <!-- Forgot password -->
            <a href="">Forgot password?</a>
        </div>
    </div>

    <!-- Sign in button -->
    <button class="btn btn-info btn-block my-4" type="submit">${login_submit} Sign in</button>

    <!-- Register -->
    <p>Not a member?
        <a href="http://localhost:8080/registration/">Register</a>
    </p>

</form>
<!-- Default form login -->

<%--<body>--%>
<%--<div class="container">--%>
<%--    <form class="text-center border border-light p-5" action="${pageContext.request.contextPath}/login/"--%>
<%--          method="post">--%>
<%--        <c:if test="${not empty error}" >--%>
<%--            <h3>--%>
<%--                <font color="red">${errorMessage}</font>--%>
<%--            </h3>--%>
<%--        </c:if>--%>

<%--        <p class="h4 mb-4">--%>

<%--        <h3>${login_signin}</h3>--%>
<%--        <h3> LOGIN PAGE</h3>--%>

<%--        <!-- Email -->--%>
<%--        <Fieldset><label>Login:--%>
<%--            <input type="text" name="login" class="form-control mb-4"--%>
<%--                   placeholder="${login_username}" required="required">--%>
<%--                 </label>--%>
<%--        </Fieldset>--%>
<%--        <!-- Password -->--%>
<%--        <FieldSet>--%>
<%--            <label>Password:--%>
<%--                <input type="password" name="password" class="form-control mb-4"--%>
<%--                       placeholder="${login_password}" required="required">--%>
<%--            </label>--%>
<%--        </FieldSet>--%>

<%--        <!-- Sign in button -->--%>
<%--        <button class="btn btn-info btn-block my-4" type="submit" value="Continue">${login_submit}--%>
<%--        </button>--%>
<%--&lt;%&ndash;<style>&ndash;%&gt;--%>
<%--&lt;%&ndash;    from{&ndash;%&gt;--%>
<%--&lt;%&ndash;        background-color: cadetblue;&ndash;%&gt;--%>
<%--&lt;%&ndash;        width: 250px;&ndash;%&gt;--%>
<%--&lt;%&ndash;        height: 200px;&ndash;%&gt;--%>
<%--&lt;%&ndash;        border-style: solid;&ndash;%&gt;--%>
<%--&lt;%&ndash;        border-color: cadetblue;&ndash;%&gt;--%>
<%--&lt;%&ndash;        padding: 10px;&ndash;%&gt;--%>
<%--&lt;%&ndash;    }&ndash;%&gt;--%>
<%--&lt;%&ndash;    </style>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <form action="/login" method="post">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div><label>Login:&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="text" name="login" value="">&ndash;%&gt;--%>
<%--&lt;%&ndash;        </label></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <br>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div><label>Password:&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="text" name="password" value="">&ndash;%&gt;--%>
<%--&lt;%&ndash;        </label></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div><input type="submit" value="Login"></div>&ndash;%&gt;--%>


<%--&lt;%&ndash;    </form>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

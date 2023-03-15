<!-- Default form register -->
<form class="text-center border border-light p-5" action="${pageContext.request.contextPath}/registration/"
      method="post">

    <p class="h4 mb-4">Sign up</p>

    <div class="form-row mb-4">
        <div class="col">
            <!-- First name -->
            <label>First name:
            <input type="text" name="name" class="form-control" placeholder="${first_name}" required="required">
            </label>
        </div>
        <div class="col">
            <!-- Last name -->
            <label>Last name:
            <input type="text" name="lastName" class="form-control" placeholder="${last_name}" required="required">
            </label>
        </div>
    </div>

    <!-- E-mail -->
    <label>E-mail:
    <input type="email" name="email" class="form-control mb-4" placeholder="${email}" required="required">
    </label>

    <!--Login-->
    <label>Login:
    <input type="text" name="login" class="form-control mb-4" placeholder="${login}" required="required">
    </label>

    <!-- Password -->
    <label>Password:
    <input type="password" name="password" class="form-control" placeholder="${password}" required="required" aria-describedby="defaultRegisterFormPasswordHelpBlock">
    </label>
        <%--    <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">--%>
<%--        At least 8 characters and 1 digit--%>
<%--    </small>--%>

    <!-- Phone number -->
    <label>Phone number:
    <input type="text" name="phone" class="form-control" placeholder="${phone_number}" required="required" aria-describedby="defaultRegisterFormPhoneHelpBlock">
    </label>

    <!-- Sign up button -->
    <button class="btn btn-info my-4 btn-block" type="submit">${login_submit} Sign in</button>


    <hr>

    <!-- Terms of service -->
    <p>By clicking
        <em>Sign up</em> you agree to our
        <a href="" target="_blank">terms of service</a>

</form>
<!-- Default form register -->
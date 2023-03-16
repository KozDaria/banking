<%@ include file="../common/header.jspf" %>
<div class="container">
    <h3>
        <%
            out.print("Operations with cards: ");
        %>
    </h3>
    <br>
    <form class="text-center border border-light p-5" action="/accounts/createAcc"
          method="post">
        <button class="btn btn-info my-4 btn-block" type="submit">${createAcc_submit} createAcc</button>
    </form>
    <br>
    <br>
    <form class="text-center border border-light p-5" action="/accounts/getAcc"
          method="get">
        <button class="btn btn-info my-4 btn-block" type="submit">${getAcc_submit} getAcc</button>
        <label>Bank card number:
            <input type="text" name="number" class="form-control mb-4" placeholder="${number}" required="required">
        </label>
    </form>
    <br>
    <br>
    <form class="text-center border border-light p-5" action="/accounts/deleteAccount"
          method="post">
        <button class="btn btn-info my-4 btn-block" type="submit">${delete_submit} deleteAccount</button>
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

</div>

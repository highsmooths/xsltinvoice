<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

    <h1>Enter Invoice Details</h1>

    <form:form method="post" modelAttribute="invoices">

        <fieldset class="mb-3">
            <form:label path="username">Username</form:label>
            <form:input type="text" path="username" required="required"/>
            <form:errors path="username" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="done">Done</form:label>
            <form:checkbox path="done"/>
        </fieldset>

        <form:input type="hidden" path="id"/>

        <input type="submit" class="btn btn-success"/>

    </form:form>

</div>

<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>

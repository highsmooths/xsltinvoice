<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Your Invoices</h1>
    <div>
        <c:out value="${transformedHtml}" escapeXml="false" />
    </div>
</div>
<%@ include file="common/footer.jspf" %>

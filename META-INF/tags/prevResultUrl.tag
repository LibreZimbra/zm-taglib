<%@ tag body-content="empty" dynamic-attributes="dynattrs" %>
<%@ attribute name="var" rtexprvalue="false" required="true" type="java.lang.String" %>
<%@ attribute name="value" rtexprvalue="true" required="true" type="java.lang.String" %>
<%@ attribute name="index" rtexprvalue="true" required="true" %>
<%@ attribute name="context" rtexprvalue="true" required="true" type="com.zimbra.cs.jsp.tag.SearchContext" %>
<%@ attribute name="usecache" rtexprvalue="true" required="false"  %>
<%@ variable name-from-attribute="var" alias='urlVar' scope="AT_END" variable-class="java.lang.String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="zm" uri="com.zimbra.zm" %>

<c:url value="${value}" var="urlVar">
    <c:if test="${usecache}"><c:param name='su' value='1'/></c:if>
    <c:param name='si' value='${index}'/>
    <c:param name='so' value='${context.searchResult.prevOffset}'/>
    <c:if test="${!empty context}"><c:param name='sc' value='${context.id}'/></c:if>
    <c:if test="${!empty context.sq}"><c:param name='sq' value='${context}.sq}'/></c:if>
    <c:if test="${!empty context.sfi}"><c:param name='sfi' value='${context.sfi}'/></c:if>
    <c:if test="${!empty context.sti}"><c:param name='sti' value='${context.sti}'/></c:if>
    <c:forEach items="${dynattrs}" var="param">
        <c:param name='${param.key}' value='${param.value}'/>
    </c:forEach>
</c:url>

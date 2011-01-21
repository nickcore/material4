<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<sec:authorize ifAllGranted="ROLE_USER, ROLE_ADMIN">
    <c:redirect url="unit.html"/>
</sec:authorize>
<sec:authorize ifNotGranted="ROLE_USER, ROLE_ADMIN"><
    <c:redirect url="login.html"/>
</sec:authorize>

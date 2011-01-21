<%@ page language="java"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<sec:authorize ifNotGranted="ROLE_USER, ROLE_ADMIN">
    <img src="img/imsLogo2r50.png" alt="Logo">&nbsp;<img src="img/imsName1.png" alt="IMS">
</sec:authorize>
<sec:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN">
    <table class="header_table" cellpadding="0" cellspacing="0">
        <tr>
            <td class="header_logo_td">
                <img src="img/imsLogo2r50.png" alt="Logo">&nbsp;<img src="img/imsName1.png" alt="IMS">
            </td>
            <td class="header_panel" align="right">
            <table class="header_panel_table" cellpadding="5" cellspacing="0" align="right">
                <tr>
                    <td class="header_panel_sp_td">
                        <font color="#165089">
                        Logged in as 
                            <b> <sec:authentication property="principal.username" />
                                &nbsp;
                                <sec:authorize ifAllGranted="ROLE_USER" ifNotGranted="ROLE_ADMIN">
                                    (User)
                                </sec:authorize>
                                <sec:authorize ifAllGranted="ROLE_ADMIN">
                                    (Administrator)
                                </sec:authorize>
                            </b>
                        </font>
                    </td>
                    <td class="header_panel_td">
                        <font color="#165089">
                            <a href="j_spring_security_logout" id="logout">Logout</a>
                        </font>
                    </td>
                </tr>
            </table>
            </td>
        </tr>
    </table>
</sec:authorize>
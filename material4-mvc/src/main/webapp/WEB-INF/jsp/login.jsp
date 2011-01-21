<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form action="/j_spring_security_check" method="POST">
<table class="login_form_table">
    <tr class="login_form_table_tr">
        <td width="50%">
        </td>
        <td class="login_form_table_td">
            <c:if test="${not empty param.login_error}">
                <font color="red">
                  Your login attempt was not successful, try again.<br/><br/>
                  Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                </font>
            </c:if>
            <table class="login_form" cellpadding="0" cellspacing="0">
                <tr>
                    <td class="login_form_td"><font color="#165089"><c:out value="login.name"/></font></td>
                </tr>
                <tr>
                    <td align="left"><input type="text" name="j_username" class="login_input" maxlength="100"
                        id="loginfield"></td>
                </tr>
                <tr>
                    <td align="left"><font color="#165089">Password:</font></td>
                </tr>
                <tr>
                    <td align="left"><input type="password" name="j_password" class="login_input" maxlength="100"></td>
                </tr>
                <tr>
                    <td align="right"><br><button type="submit" class="login_submit">Sign in</button></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</form>
<script type="text/javascript">
    setTimeout("document.getElementById('loginfield').focus();", 100);
</script>

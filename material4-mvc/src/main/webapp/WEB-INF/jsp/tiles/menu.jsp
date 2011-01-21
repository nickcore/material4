<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
<div id="menu">
    <ul id="menu_ul" class="sf-menu" >
        <li>
            <a href="#guid">Справочники</a>
            <ul>
                <li>
                  <c:url value="unit.html" var="url"/>
                  <a href="${url}">Справочник ед. изм.</a>
                </li>
                <li>
                  <c:url value="mat.html" var="url"/>
                  <a href="${url}">Справочник материалов</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="./../instructor/summary.do">
                Summary
            </a>
        </li>
        <li id="createNewLi">
            <a href="./../instructor/createevent.do">
                Create new instruction
            </a>

            <ul id="eventTypes">
            </ul>
            
        </li>
        <sec:authorize ifAllGranted="ROLE_ADMIN, ROLE_USER">
            <li>
                <a href="./../admin/home.do">Administration</a>
                <ul>
                    <li>
                        <a href="./../admin/eventTypes.do">Manage event types</a>
                    </li>
                    <li>
                        <a href="./../admin/instructors.do">Manage instructors</a>
                    </li>
                </ul>
            </li>
        </sec:authorize>
    </ul>
</div>
<br/>
--%>
<div>
    <span id="toolbar" class="ui-widget-header-flyout ui-corner-all"> <!-- ui-widget-header -->
          <button>Справочники</button>
          <ul>
              <li>
                <c:url value="unit.html" var="url"/>
                <a href="${url}">Справочник ед. изм.</a>
              </li>
              <li>
                <c:url value="mat.html" var="url"/>
                <a href="${url}">Справочник материалов</a>
              </li>
          </ul>
          <a href="./../instructor/summary.do">Summary</a>

          <sec:authorize ifAllGranted="ROLE_ADMIN, ROLE_USER">
              <button>Administration</button>
              <ul>
                  <li>
                      <a href="./../admin/eventTypes.do">Manage event types</a>
                  </li>
                  <li>
                      <a href="./../admin/instructors.do">Manage instructors</a>
                  </li>
              </ul>
          </sec:authorize>
          <a href="#toolbar-anchor">Just a link</a>
    </span>
</div>
<script src="js/app/menu.js" type="text/javascript"></script>
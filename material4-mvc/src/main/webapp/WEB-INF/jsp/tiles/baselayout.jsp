<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%--
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv=pragma content=no-cache/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
            <title><tiles:getAsString name="pageTitle"/></title>
            <link href="css/redmond/jquery-ui-1.8.5.custom.css" rel="stylesheet" type="text/css" />
<%--
            <link href="css/smoothness/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css" />
 --%>
            <link href="css/ui.jqgrid.css" rel="stylesheet" type="text/css" />

            <link href="css/jdMenu.css" rel="stylesheet" type="text/css"/>
            <link href="css/superfish.css" rel="stylesheet" type="text/css"/>

            <link href="css/app/global.css" rel="stylesheet" type="text/css"/>
            <link href="css/app/header.css" rel="stylesheet" type="text/css"/>
<%--
            <link href="styles/journalbody.css" rel="stylesheet" type="text/css">
            <link href="styles/eventdetail.css" rel="stylesheet" type="text/css">
            <link href="styles/createevent.css" rel="stylesheet" type="text/css">
            <link href="styles/summary.css" rel="stylesheet" type="text/css">
--%>
            <script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
            <script src="js/jquery-ui-1.8.4.custom.min.js" type="text/javascript"></script>
            <script src="js/i18n/grid.locale-ru.js" type="text/javascript"></script>
            <script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
            <%--
            <script src="js/json2.js" type="text/javascript"></script>
            --%>

            <script src="js/jquery.blockUI.js" type="text/javascript"></script>
            <script src="js/hoverIntent.js" type="text/javascript"></script>
            <script src="js/superfish.js" type="text/javascript"></script>
            <script src="js/supersubs.js" type="text/javascript"></script>

            <script src="js/jquery-xqs-flyoutMenu.js" type="text/javascript"></script>
            <script src="js/jquery-xqs-menubar.js" type="text/javascript"></script>

            <script src="js/app/jquery.guide.js" type="text/javascript"></script>
            <script src="js/app/logout.js" type="text/javascript"></script>


<%--
            <script type="text/javascript" src="js/styles/input highlight/inputhighlight.js"></script>
            <script type="text/javascript" src="js/styles/blockUI/blockUIfuncs.js"></script>
            <script type="text/javascript" src="js/tables/check all/checkall.js"></script>
--%>
        <style>
            .menu-container{position:relative;}
            .ui-menu { width: 200px; position: absolute; }
            .ui-menu .ui-icon { float: right; }
            .ui-menu-flyout { z-index: 10; }
            .ui-widget-header-flyout { border: 1px solid #4297d7; background: #5c9ccc url(css/redmond/images/ui-bg_gloss-wave_55_5c9ccc_500x100.png) 50% 50% repeat-x; }
            #toolbar { padding: 10px 4px; position:relative; }
        </style>

    </head>
    <body>
        <div id="header"><tiles:insertAttribute name="header"/></div>
        <tiles:insertAttribute name="menu"/>
        <div id="body"><tiles:insertAttribute name="body"/></div>

        <div id="footer"><tiles:insertAttribute name="footer"/></div>

    </body>
</html>
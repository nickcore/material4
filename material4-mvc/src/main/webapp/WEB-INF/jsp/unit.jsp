<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>${message}</title>

    <link rel="stylesheet" type="text/css" media="screen" href="css/smoothness/jquery-ui-1.7.2.custom.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
    <style>
    html, body {
        margin: 0;
        padding: 0;
        font-size: 75%;
    }
    </style>

    <script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/i18n/grid.locale-ru.js" type="text/javascript"></script>
    <script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
</head>
<body>
    <table id="list" class="scroll"></table> 
    <div id="pager" class="scroll" style="text-align:center;"></div>

	<script type="text/javascript">
	jQuery(document).ready(function(){ 
	  jQuery("#list").jqGrid({
	    url:'units.json',
	    datatype: 'json',
	    mtype: 'GET',
	    colNames:['Id','Код', 'Имя'],
	    colModel :[ 
	      {name:'id', index:'invid', width:55}, 
	      {name:'unitId', index:'unitId', width:80, align:'right'},
          {name:'unitName', index:'unitName', width:90}
	    ],
	    jsonReader : {
		  root: "gridDataHolder.data",
		  page: "gridDataHolder.page",
		  total: "gridDataHolder.total",
		  records : "gridDataHolder.records",
          repeatitems:false
        },
	    pager: '#pager',
	    rowNum:30,
	    rowList:[10,20,30],
	    sortname: 'id',
	    sortorder: 'desc',
	    viewrecords: true,
	    caption: 'My first grid'
	  }); 
	}); 
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="jqgrid">
    <table id="list" class="scroll" style="width: 100%"></table> 
    <div id="pager" class="scroll" style="text-align:center;"></div>
</div>

<div id="dialog" title="Feature not supported" style="display:none">
    <p>That feature is not supported.</p>
</div>

<div id="dialogSelectRow" title="Warning" style="display:none">
    <p>Please select row</p>
</div>

<script type="text/javascript">

jQuery(document).ready(function(){
  /*
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
*/
  jQuery("#list").jqGuide({
      guide: "unit"
  });
});
</script>

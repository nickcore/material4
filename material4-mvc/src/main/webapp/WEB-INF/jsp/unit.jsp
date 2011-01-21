<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<table id="list" class="scroll" style="width: 100%"></table> 
<div id="pager" class="scroll" style="text-align:center;"></div>

<table id="list2" class="scroll" style="width: 100%"></table> 
<div id="pager2" class="scroll" style="text-align:center;"></div>

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

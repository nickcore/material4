(function($) {
    // plugin method for creation guide
    $.fn.jqGuide = function(options) {
       //defaults value
       var defaults = {
               guide: "unit",
               metaUrl: "/api/{guide}/info.json",
               pager: "#pager"
       },  opts = $.extend(defaults, options);
       opts.metaUrl = new String(opts.metaUrl).replace(/\{guide\}/g, opts.guide);

       return this.each(function(){
           //private field
           var $this = this, $guide = {
               guideInfo: null,
               createGuide : function(guideInfo, opts) {
                   var colNames = new Array(), colModel = new Array();
                   for (var propName in guideInfo.properties) {
                       $guide.guideInfo = guideInfo;

                       var prop = guideInfo.properties[propName];
                       colNames.push(prop.displayName);
                       colModel.push({name: propName, index: propName, width:prop.width});
                   }
                   jQuery($this).jqGrid({
                       url:'units.json',
                       datatype: 'json',
                       mtype: 'GET',
                       "colNames": colNames,
                       "colModel" : colModel,
                       jsonReader : {
                         root: "gridDataHolder.data",
                         page: "gridDataHolder.page",
                         total: "gridDataHolder.total",
                         records : "gridDataHolder.records",
                            repeatitems:false
                          },
                       "pager": opts.pager,
                       rowNum:30,
                       rowList:[10,20,30],
                       sortname: 'id',
                       sortorder: 'desc',
                       viewrecords: true,
                       caption: guideInfo.description
                   });
               }
           }
           this.guide = $guide;

           $.getJSON(opts.metaUrl, null, afterMetaCallback);

           function afterMetaCallback(data) {
               $guide.createGuide(data.guideInfo, opts);
           }
       });
    }

})(jQuery); 
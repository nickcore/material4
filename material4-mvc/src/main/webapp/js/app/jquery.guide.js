(function($) {
    // plugin method for creation guide
    $.fn.jqGuide = function(options) {
        //defaults value
        var defaults = {
                guide: "unit",
                urls: {
                    meta: "/api/{guide}/info.json",
                    add: "/api/{guide}/add.json",
                    del: "/api/{guide}/delete.json",
                    edit: "/api/{guide}/edit.json"
                },
                pager: "#pager"
        },  opts = $.extend(defaults, options), GUIDE_EXPR = /\{guide\}/g;
        for (var url in opts.urls) {
            opts.urls[url] = new String(opts.urls[url]).replace(GUIDE_EXPR, opts.guide);
        }
        return this.each(function(){
            //private field
            var $this = this, $guide = {
                guideInfo: null,
                opts : null,
                createGuide : function(guideInfo, opts) {
                    var colNames = new Array(), colModel = new Array();
                    for (var propName in guideInfo.properties) {
                        $guide.guideInfo = guideInfo;
                        $guide.opts = opts;
        
                        var prop = guideInfo.properties[propName];
                        colNames.push(prop.displayName);
                        colModel.push({name: propName, index: propName, width:prop.width, editable:true, editoptions:{size:10}}); //readonly:true,
                    }
                    $($this).jqGrid({
                        url:'units.json',
                        datatype: 'json',
                        mtype: 'GET',
                        ajaxEditOptions: { contentType: "application/json" },
                        "colNames": colNames,
                        "colModel" : colModel,
                        jsonReader : {
                          root: "baseResponse.data",
                          page: "baseResponse.page",
                          total: "baseResponse.total",
                          records : "baseResponse.records",
                             repeatitems:false
                           },
                        "pager": opts.pager,
                        rowNum:30,
                        rowList:[10,20,30],
                        sortname: 'id',
                        sortorder: 'desc',
                        viewrecords: true,
                        autowidth: true,
                        caption: guideInfo.description
                    });
                    $($this).jqGrid('navGrid', opts.pager,
                        {edit:false,add:false,del:false,search:true},
                        { },
                        { },
                        { },
                        {
                            sopt:['eq', 'ne', 'lt', 'gt', 'cn', 'bw', 'ew'],
                            closeOnEscape: true,
                            multipleSearch: true,
                            closeAfterSearch: true
                        }
                    );
                    $($this).navButtonAdd(opts.pager,
                        { caption:"Add",
                        buttonicon:"ui-icon-plus",
                        onClickButton: $guide.addRow,
                        position: "last",
                        title:"",
                        cursor: "pointer"
                    });
        
                    $($this).navButtonAdd(opts.pager,
                        {  caption:"Edit",
                         buttonicon:"ui-icon-pencil",
                         onClickButton: $guide.editRow,
                         position: "last",
                         title:"",
                         cursor: "pointer"
                        }
                    );

                    $($this).navButtonAdd(opts.pager,
                        {  caption:"Delete",
                         buttonicon:"ui-icon-trash",
                         onClickButton: $guide.deleteRow,
                         position: "last",
                         title:"",
                         cursor: "pointer"
                        }
                    );
        
                    $("#btnFilter").click(function(){
                        $($this).jqGrid('searchGrid', {multipleSearch: false, sopt:['eq']});
                    });
                    //Toolbar Search
                    $($this).jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true, defaultSearch:"cn"});
                },
                addRow : function() {
                    // Get the currently selected row
                    $($this).jqGrid('editGridRow','new',
                            {   url: opts.urls.add,
                                ajaxEditOptions : { contentType: "application/json", datatype: "json",
                                        beforeSend: function(req) { req.setRequestHeader("Accept", "application/json, text/javascript, */*"); }
                                },
                                serializeEditData: function (postData) {
                                    // just to put all parameters inside one object $.parseJSON
                                    postData.id = null;
                                    delete postData.oper;
                                    return JSON.stringify(postData);
                                },
        
                                /*editData: { },
                                recreateForm: true,
                                beforeShowForm: function(form) {
                                },
                                */
                                closeAfterAdd: true,
                                reloadAfterSubmit:false,
                                afterSubmit : function(response, postdata) {
                                    /*
                                    var result = eval('(' + response.responseText + ')');
                                    var errors = "";
                                    
                                    if (result.success == false) {
                                        for (var i = 0; i < result.message.length; i++) {
                                            errors +=  result.message[i] + "<br/>";
                                        }
                                    }  else {
                                        $("#dialog").text('Entry has been added successfully');
                                        $("#dialog").dialog( 
                                                {   title: 'Success',
                                                    modal: true,
                                                    buttons: {"Ok": function()  {
                                                        $(this).dialog("close");} 
                                                    }
                                                });
                                    }
                                    // only used for adding new records
                                    var new_id = null;
        
                                    return [result.success, errors, new_id];
                                    */
                                    alert(response.toSource());
        
                                    return [true, "", response.unitId]
                                }
                    });
                },
                editRow : function() {
                },
                deleteRow : function() {
                }
            }
            this.guide = $guide;

            $.getJSON(opts.urls.meta, null, afterMetaCallback);

            function afterMetaCallback(data) {
                $guide.createGuide(data.guideInfo, opts);
            }
        });
    }

})(jQuery); 
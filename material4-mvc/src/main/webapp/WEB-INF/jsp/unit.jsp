<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="notification">
</div>
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
    jQuery(document).ready(function() {
        jQuery('#notification').jnotifyInizialize( {
            oneAtTime : false,
            appendType : 'append'
        }).css( {
            'position' : 'absolute',
            'marginTop' : '20px',
            'right' : '20px',
            'width' : '250px',
            'z-index' : '9999'
        });
        jQuery("#list").jqGuide( {
            guide : "material"
        });
    });
</script>

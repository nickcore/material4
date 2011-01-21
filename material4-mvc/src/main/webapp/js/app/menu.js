$(document).ready(function() {
/*
$('#menu_ul').supersubs({ 
            minWidth: 11,   // minimum width of sub-menus in em units 
            maxWidth: 27,   // maximum width of sub-menus in em units 
            extraWidth: 1   // extra width can ensure lines don't sometimes turn over
        }).superfish({ 
            delay: 100, // one second delay on mouseout 
            animation:   {opacity:'show',height:'show'},  // fade-in and slide-down animation 
            speed:       'fast',                          // faster animation speed 
            autoArrows:  true,                           // disable generation of arrow mark-up 
            dropShadows: false                            // disable drop shadows
        });
$('li#createNewLi').mousemove(function(event) {
	$('select').hide();
});
$('li#createNewLi').mouseout(function(event) {
	$('select').show();
});
*/
$("#toolbar").menubar({
	select: function(event, ui) {
		var anchor = ui.item.children().first();
		$("#log").append("<div>Selected " + anchor.attr("id") + ":" + anchor.text() + "</div>");
		$(this).data("flyoutmenu").hide();
	}
});
});
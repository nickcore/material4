$(document).ready(function() {
	$('#logout').click(function() {
		if (!confirm("Do you really want to log out?")) {
			return false;
		}
	});
});
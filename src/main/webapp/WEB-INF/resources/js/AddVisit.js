$(document).ready(function() {

	var months = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
					"Aug", "Sep", "Oct", "Nov", "Dec" ];
	var date = new Date();
	$('#visitDate').val(date.getDate() 
			+ '-' 
			+ months[date.getMonth()] 
			+ '-'
			+ date.getFullYear());

			// $('#visitDate').datepicker({
			// format : 'dd-M-yyyy',
			// autoclose : true,
			// todayBtn : 'linked',
			// todayHighlight : true
			// });
	
});
$(document).ready(function() {

	$('#appntDate').datepicker({
		format : 'dd-M-yyyy',
		autoclose : true,
		startDate : new Date(),
		todayBtn : 'linked',
		todayHighlight : true
	})

	$('#appointmentTime').timepicker({
		minuteStep : 5
	});

	$.getJSON("appointmenttypes", function(data) {
		var items = [];
		for(var i=0;i<data.length;i++){
			var type = data[i];
			items.push("<li id='" + type.id + "' role=\"presentation\"><a role=\"menuitem\" tabindex=\"-1\" onclick=\"setAppointmentType('"+type.id+"','"+type.name+"')\" href=\"#\">"+type.name+"</a></li>");
		}
		$('#typesDD').append(items.join(""));
	});
});

function setAppointmentType(typeId,typeName){
	$('#typeId').val(typeId);
	$('#appointmentTypeDDVal').html(typeName);
}
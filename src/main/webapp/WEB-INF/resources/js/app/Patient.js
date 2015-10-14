$(document).ready(function(){
	
	$('#editBtn').click(function(event){
		var patId = parseInt(event.target.title);
		$('#pid').val(patId);
		$('#editPatientFrm').submit();
	});
	
});
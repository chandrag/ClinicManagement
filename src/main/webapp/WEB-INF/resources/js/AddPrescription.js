var rowId = 0;

$(document).ready(function() {
//	$('.medicine-name').keyup(function() {
//		var txt = this.value;
//		$.getJSON('medicines?text=' + txt, function(data) {
//			console.log(data);
//			var respData = data;
//			var content = "<ul><li>"+respData[0]+"</li></ul>";
//			$(this).after(content);
//		});
//		 
//	});
	
	$(".medicine-name").autocomplete({
		minLength : 5,
		source : function(request, response) {
			var term = request.term;
			$.getJSON('medicines?text='+term, request, function(data, status, xhr) {
				response(data);
			});
		}
	});

});

function fnAdd() {
	rowId++;
	var addTemplate = '<tr id="row_' + rowId + '">';
	addTemplate += '<td><input placeholder="Medicine" class="form-control medicine-name" name="prescriptions['
			+ rowId + '].medicine.name"></td>';
	addTemplate += '<td><input placeholder="Frequency" class="form-control" name="prescriptions['
			+ rowId + '].frequency"></td>';
	addTemplate += '<td><input placeholder="Quantity" class="form-control" name="prescriptions['
			+ rowId + '].medQuantity"></td>';
	addTemplate += '<td><input placeholder="Frequency Type" class="form-control" name="prescriptions['
			+ rowId + '].freqType"></td>';
	addTemplate += '<td style="width: 60px;">';
	addTemplate += '<div onclick="fnAdd(row_'
			+ rowId
			+ ')" class="add-presc-btn glyphicon glyphicon-plus add-prescription"></div>';
	addTemplate += '<div onclick="fnRemove(row_'
			+ rowId
			+ ')" class="remove-presc-btn glyphicon glyphicon-remove delete-prescription"></div>';
	addTemplate += '</td>';
	addTemplate += '</tr>';
	$('#presc-tab').append(addTemplate);
}

function fnRemove(currEle) {
	$(currEle).remove();
}

<%@ include file="/WEB-INF/taglib.jsp"%>

<script type="text/javascript">
	function deleteEquipmentType(id) {

		$.ajax({
			url : '${deleteUrl}/'+id,
			type : 'DELETE',
			contentType : 'application/json',
			success : function(result) {
				window.location.href = "${listUrl}";

			},
			error : function(error) {
				console.log(error);
			}
		});
	}
</script>
		

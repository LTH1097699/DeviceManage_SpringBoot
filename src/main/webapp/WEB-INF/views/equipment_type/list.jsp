<%@ include file="/WEB-INF/taglib.jsp"%>
<c:url value="/api/equipment-type" var="deleteEquipmentTypeUrl" />
<c:url value="/equipment-type/list" var="listEquipmentTypeUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Equipment Type List</title>
</head>
<body id="bodyChange">



	<!-- DataTales -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Equipment Type
				List</h6>
		</div>

		<div class="card-body">
			<div class="table-responsive">
				<div id="dataTableChange">


					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Code</th>
								<th>Name</th>
								<th>Action</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Code</th>
								<th>Name</th>
								<th>Action</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="item" items="${equipmentTypes}">
								<tr>
									


									<td>${item.code}</td>
									<td>${item.name}</td>

									<td>
									<c:url var="editUrl" value="/equipment-type/edit/${item.id}" /> 
									<a href='${urlEdit}' class="button">Edit</a>
									 
									<a href="javascript:undefined" onclick="deleteEquipmentType();"
										class="button" id="button-delete">Delete</a>
									
									</td>
								</tr>

							</c:forEach>

						</tbody>

					</table>
					<script type="text/javascript">
						
						var totalPage = ${totalPages};
						
						$(function() {
							window.pagObj = $('#pagination').twbsPagination({
								totalPages : totalPage,
								visiblePages : 5,
								onPageClick : function(event, page) {
									$.ajax({
										url : '${listEquipmentTypeUrl}/'+ page,
										type : 'GET',
										success : function(result) {
											$("#dataTable").html(result);
										},
										error : function(error) {
											console.log(error);
										}
									})
								}
						    })
						});
					</script>

					<div class="container">
						<nav aria-label="Page navigation">
							<ul class="pagination" id="pagination"></ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		function deleteEquipmentType() {
			var data = {};
			var id = $('#id').val();
			data["id"] = id;

			$.ajax({
				url : '${deleteUrl}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				success : function(result) {
					window.location.href = "${listEquipmentTypeUrl}";
				},
				error : function(error) {
					console.log(error);
				}
			});
		}
	</script>
</body>
</html>
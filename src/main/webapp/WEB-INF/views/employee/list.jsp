<%@ include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

</head>
<body id="bodyChange">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>


	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Students List</h6>
		</div>
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">
				<a class="button" id="button-search-customer-id" href="#">Search</a>
				<input id="search-customer-id" name="search-customer-id"
					placeholder="Search Customer Id">
			</h6>
		</div>
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">
				<a class="button" id="button-search-customer-name" href="#">Search</a>
				<input id="search-customer-name" name="search-customer-name"
					placeholder="Search First Name"> <select
					id="search-customer-city" name="search-customer-city">
					<option>${item.cityName}</option>
					<c:forEach var="item" items="${cityList}">
						<option value="${item.id}">${item.cityName}</option>
					</c:forEach>
				</select>
			</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Code</th>
							<th>Name</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${equipmentTypes}">
							<tr>
								<input type="hidden" value="${item.id}" id="id" />


								<td>${item.code}</td>
								<td>${item.name}</td>

								<td><c:url var="editUrl"
										value="/equipment-type/edit/${item.id}" /> <a
									href='${urlEdit}' class="button">Edit</a> <a
									href="javascript:undefined" onclick="deleteCustomer();"
									class="button" id="button-delete">Delete</a></td>
							</tr>

						</c:forEach>

					</tbody>

				</table>
				
				<hr>
				
				<c:if test="${totalPages <= 10}">
					<c:forEach var="i" begin="1" end="${totalPages}" step="1" varStatus="loop">
						<a href="#" class="page-link">${loop.count}</a>
					</c:forEach>
				</c:if>
				<c:if test="${totalPages > 10}">
				
				</c:if>
			</div>
		</div>

		<form:form action="/employee/sort">
			<form:select path="sort">
				<form:option value="id">Id</form:option>
				<form:option value="name">Name</form:option>
			</form:select>
			<form:button value="sort"></form:button>
		</form:form>
	</div>
	<c:url value="/customer/search-id" var="searchCustomerIdURL" />
	<c:url var="listUrl" value="/customer/list" />
	<c:url value="/api/customer" var="editURL" />

	<c:url value="/customer/search-name-or-city"
		var="searchCustomerNameURL" />

	<script>
		$("#button-search-customer-id").on("click", function() {
			var data = {};
			var id = $('#search-customer-id').val();
			data["id"] = id;
			$.ajax({
				url : '${searchCustomerIdURL}',
				type : 'GET',
				contentType : 'application/json',
				data : data,
				success : function(result) {
					$("#dataTableChange").html(result);
				},
				error : function(error) {
					console.log(error);
				}
			})
		});

		$("#button-search-customer-name").on(
				"click",
				function() {
					var data = {};
					data["searchName"] = $('#search-customer-name').val();
					;
					data["searchCity"] = $('#search-customer-city').find(
							":selected").val();
					console.log(data);
					$.ajax({
						url : '${searchCustomerNameURL}',
						type : 'GET',
						contentType : 'application/json',
						data : data,
						success : function(result) {
							console.log(result);
							$("#dataTableChange").html(result);
						},
						error : function(error) {
							console.log(error);
						}
					})

				});
	</script>
	<script>
		function deleteCustomer() {
			var data = {};
			var id = $('#id').val();
			data["id"] = id;
			console.log(data);
			$.ajax({
				url : '${editURL}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				success : function(result) {
					window.location.href = "${listUrl}";
				},
				error : function(error) {
					console.log(error);
				}
			});
		}
	</script>

</body>
</html>
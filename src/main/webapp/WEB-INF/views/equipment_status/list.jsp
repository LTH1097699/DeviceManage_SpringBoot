<%@ include file="/WEB-INF/taglib.jsp"%>
<c:url value="/equipmentstatus/delete/" var="deleteUrl" />
<c:url value="/equipmentstatus" var="listUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Equipment Status List</title>
</head>
<body>
	<div >

		<!-- DataTales -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Equipment Status
					List</h6>
			</div>

			<div class="card-header py-3">

				<form:form action='${listUrl}' method="GET">
					<div id="selectSort">
					<select  name="sort">
						<option value="id">Id</option>
						<option value="name">Name</option>
					</select>
					</div>
					<input type="submit">
				</form:form>
			</div>

			<div class="card-body">
				<div class="table-responsive">
				
					<!-- Table -->
					<%@ include file="table.jsp"%> 
					
					<div class="container">
						<nav aria-label="Page navigation">
							<ul class="pagination justify-content-center" id="pagination"></ul>

						</nav>
					</div>

					<%@ include file="../pagination.jsp"%> 
				</div>
			</div>
		</div>

		<script>
		
			var sort = "${pageDTO.getSort().get().findFirst().get().getProperty()}"
			$("#selectSort option:selected").removeAttr("selected");
			$("#selectSort option[value='"+sort +"']").attr('selected', 'selected'); 
		
			
		</script>
		
		<!-- Delete -->
		<%@ include file="../delete.jsp"%> 
	</div>
</body>
</html>
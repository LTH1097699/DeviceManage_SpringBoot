<%@ include file="/WEB-INF/taglib.jsp"%>
<div id="dataTableChange">
	
	<input id="currentPage" type="hidden" value="${ pageDTO.getPageable().getPageNumber() + 1}">

	<table class="table table-bordered" id="dataTable" width="100%"
		cellspacing="0">
		<thead>
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Email</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="item" items="${pageDTO.getContent()}">
				
				<tr>
					
					<td>${item.name}</td>
					<td>${item.getAccount().getRole().getRoleName()}</td>
					<td>${item.getAccount().getEmail()}</td>
					<td>${item.getStatus().getName()}</td>

					<td>
					<c:url var="editUrl" value="/employee/edit/${item.id}" /> 
						<a href='${editUrl}' class="button">Edit</a> 
						<a href="javascript:undefined" onclick="deleteEquipmentType();" class="button" id="button-delete">Delete</a></td>
				</tr>

			</c:forEach>

		</tbody>

	</table>



</div>
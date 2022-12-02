
<%@ include file="/WEB-INF/taglib.jsp"%>
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
				<input type="hidden" value="${item.id}" id="id" />


				<td>${item.code}</td>
				<td>${item.name}</td>
				
				<td>
				<c:url var="editUrl" value="/equipment-type/edit/${item.id}"/>
					<a href='${urlEdit}' class="button">Edit</a> 
					<a href="javascript:undefined" onclick="deleteEquipmentType();"
					class="button" id="button-delete">Delete</a>
				</td>
			</tr>

		</c:forEach>

	</tbody>

</table>
<input type="hidden" value="${page}" id="page1" />
<c:url value="/" var="contextPath" />

<script type="text/javascript">
    var linkUrl = '${url}';
    var totalPage = ${totalPages};
    var page1 = $('#page1').val();
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: 5,
            onPageClick: function (event, page) {
            console.log(page + "  "+page1);
            if(page!=page1){
                $.ajax({
                   url: '${contextPath}'+linkUrl+page,
                   type: 'GET',
                   success: function(result){
                   $("#dataTable").html(result);
                   },
                   error: function(error){
                       console.log(error);
                   }
               })
            }

            }
        })
    });
</script>


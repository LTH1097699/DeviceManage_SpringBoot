<%@ include file="/WEB-INF/taglib.jsp"%>
<c:url var="listUrl" value="/employee" />
<c:url var="saveUrl" value="/employee/edit" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Employee Status</title>
</head>
<body>
	<!-- Page Heading -->
	

	<div class="col-xl-8 col-lg-7 ">
	<!-- DataTales Example -->
	<div class="card shadow mb-4 ">
		<c:if test="${not empty employee.id}">
			<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Employee Edit</h6>
		</div>
		</c:if>
		
		<c:if test="${empty employee.id}">
			<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Employee Create</h6>
		</div>
		</c:if>


		<div class="col-lg-flex ">
			<div class="p-5 ">

				<form:form id="formSubmit"  modelAttribute="employee" method="post">
				    <form:hidden path="id"/>

					<div class="form-group">
					    <form:input path="name" cssClass="form-control form-control-user"
					           placeholder="Enter Name"/>
					</div>
					
					
					<div class="form-group">
						<form:input type="email" path="account.email" cssClass="form-control form-control-user"
                              placeholder="Enter Email"/>
					</div>
					
					<c:if test="${empty employee.id}">
						<div class="form-group">
							<form:input type="password" path="account.password" cssClass="form-control form-control-user"
	                              placeholder="Enter Password"/>
						</div>
					</c:if>
					<div class="form-group">
						<form:input path="account.phone" cssClass="form-control form-control-user"
                              placeholder="Enter Phone"/>
					</div>
					<div class="form-group">
						<form:select path="account.role.roleCode" cssClass="form-control form-control-user">
								<form:options items="${roles}" itemValue="roleCode" itemLabel="roleName" />
						</form:select>
					</div>
					
					<div class="form-group">
					    <form:select path="status.code">
					    	<form:options items="${employeeStatus}" itemLabel="code" itemValue="name" />
					    </form:select>
					</div>
					
					<c:if test="${not empty employee.id}">
						<div class="form-group">
					    	<img alt="" width="200" height="200" src="<c:url value='/assets/imageUpload/${employee.avatar}' />">
						</div>
					</c:if >
					
					<div class="form-group">
						
					    <input type="file" name="fileupload" id="fileupload" accept=".png,.jpeg,.jpg,.gif">
					    <input type="hidden" name="fileName" id="fileName">
					</div>
					
					<a id="btnSave" class="btn btn-primary btn-user btn-block">
						Save </a>
					<hr>

				</form:form>
				<hr>

			</div>
		</div>
	</div>
	</div>


<!-- ADD -->

<script>
$('#btnSave').on("click",function (e) {
    e.preventDefault();
   
    var formData = $('#formSubmit').serializeArray();
	
	var files = $("#fileupload").prop("files")[0];
	
	var oData = new FormData();
	
	$.each(formData, function (i, v) {
		oData.append(""+v.name+"", v.value);
   });
	
	oData.append('multipartFile', files);
	
	console.log(oData)
    
    addEmployee(oData);
});
    
    function addEmployee(data) {
        $.ajax({
            url: '${saveUrl}',
            type: 'POST',
            data: data,
            
            processData: false,
            contentType: false,
            success: function (result) {
            	window.location.href = "?message=success_save";
            },
            error: function (error) {
            	alert(error);
            }
        });
    }
</script>
</body>
</html>
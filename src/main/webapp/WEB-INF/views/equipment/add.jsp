<%@ include file="/WEB-INF/taglib.jsp"%>
<c:url var="listUrl" value="/equipment" />
<c:url var="saveUrl" value="/equipment/edit" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Page Heading -->
	

	<div class="col-xl-8 col-lg-7 ">
	<!-- DataTales Example -->
	<div class="card shadow mb-4 ">
		<c:if test="${not empty equipment.id}">
			<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Equipment Edit</h6>
		</div>
		</c:if>
		
		<c:if test="${empty equipment.id}">
			<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Equipment Create</h6>
		</div>
		</c:if>


		<div class="col-lg-flex ">
			<div class="p-5 ">

				<form:form id="formSubmit"  modelAttribute="equipment" method="post" enctype="multipart/form-data">
				    <form:hidden path="id"/>
					
					<div class="form-group">
					    <form:input path="equipId" cssClass="form-control form-control-user"
                        	   placeholder="Enter Equipment Id"/>
                    </div>

					<div class="form-group">
					    <form:input path="name" cssClass="form-control form-control-user"
					           placeholder="Enter Name"/>
					</div>
					
					<div class="form-group">
					    <form:select path="type.code">
					    	<form:options items="${equipmentTypeList}" itemLabel="code" itemValue="name" />
					    </form:select>
					</div>
					
					<div class="form-group">
					    <form:select path="status.code">
					    	<form:options items="${equipmentStatusList}" itemLabel="code" itemValue="name" />
					    </form:select>
					</div>
					
					<div class="form-group">
					    <form:textarea  path="description" cssClass="form-control form-control-user"
					           placeholder="Enter description"/>
					</div>
					
					
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
    
    addEquipment(oData);
});
    
    function addEquipment(data) {
    	
        $.ajax({
            url: '${saveUrl}',
            type: 'POST',
            data: data,
            
         	// prevent jQuery from automatically transforming the data into a query string
            processData: false,
            contentType: false,
            success: function (result) {
            	if(result == "Susccesfull"){
            		window.location.href = "?message=success_save";
            	}
            },
            error: function (error) {
            	alert(error);
            }
        });
    }
</script>
</body>
</html>
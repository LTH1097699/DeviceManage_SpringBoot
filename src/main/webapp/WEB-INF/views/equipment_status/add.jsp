<%@ include file="/WEB-INF/taglib.jsp"%>
<c:url var="listUrl" value="/equipmentstatus" />
<c:url var="saveEquipmentType" value="/equipmentstatus/edit" />
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
		<c:if test="${not empty equipmentStatus.id}">
			<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Equipment Status Edit</h6>
		</div>
		</c:if>
		
		<c:if test="${empty equipmentStatus.id}">
			<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Equipment Status Create</h6>
		</div>
		</c:if>


		<div class="col-lg-flex ">
			<div class="p-5 ">

				<form:form id="formSubmit" class="employee" modelAttribute="equipmentStatus" method="post">
				    <form:hidden path="id"/>
					
					<div class="form-group">
					    <form:input path="code" cssClass="form-control form-control-user"
                        	   placeholder="Enter Code"/>
                    </div>

					<div class="form-group">
					    <form:input path="name" cssClass="form-control form-control-user"
					           placeholder="Enter Name"/>
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
        var data = {};
       
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {  
           data[""+v.name+""] = v.value;
        });
        addEquipmentType(data);
    });
    
    function addEquipmentType(data) {
        $.ajax({
            url: '${saveEquipmentType}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
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
<%@ include file="/WEB-INF/taglib.jsp"%>
<c:url var="listEquipmentTypeUrl" value="/equipment-type/list" />
<c:url var="saveEquipmentType" value="/api/equipment-type" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Create</h1>

	<div class="col-xl-8 col-lg-7 ">
	<!-- DataTales Example -->
	<div class="card shadow mb-4 ">
		<c:if test="${not empty equipmentType.id}">
			<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Equipment Type Edit</h6>
		</div>
		</c:if>
		
		<c:if test="${empty equipmentType.id}">
			<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Equipment Type Create</h6>
		</div>
		</c:if>


		<div class="col-lg-flex ">
			<div class="p-5 ">

				<form:form id="formSubmit" class="employee" modelAttribute="equipmentType" method="post">
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
            	window.location.href = "${listUrl}?message=success_save";
            },
            error: function (error) {
            	alert(error);
            }
        });
    }
</script>
</body>
</html>
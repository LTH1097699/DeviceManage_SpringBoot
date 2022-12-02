<%@ include file="/WEB-INF/taglib.jsp"%>
<c:url var="APIurl" value="/api/equipment" />
<c:url var="listUrl" value="/customer/list" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Create</h1>


	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Students Create</h6>
		</div>


		<div class="col-lg-6">
			<div class="p-5">

				<form:form enctype="multipart/form-data" action="${saveURL}" id="formSubmit" class="equipment" modelAttribute="equipment" method="post">
				   <form:hidden path="id"></form:hidden>
				   <%--  <form:hidden path="address.id"></form:hidden>
				    <form:hidden path="address.city.id"></form:hidden>
				    <form:hidden path="address.city.country.id"></form:hidden> --%>
					
					<div class="form-group">
					    <form:input path="equipId" cssClass="form-control form-control-user"
					           id="equipId" placeholder="Enter Equipment Id"/>

					</div>

					<div class="form-group">
					    <form:input path="name" cssClass="form-control form-control-user"
					           id="name" placeholder="Enter Equipment Name"/>

					</div>

					<div class="form-group">
					    <form:input path="description" cssClass="form-control form-control-user"
                        	id="description" placeholder="Enter Description"/>

                    </div>
                    
                    <div class="form-group">
					    <input name="file" type="file"  onchange="encodeImageFileAsURL(this)" class="form-control form-control-user"
                        	id="file"/>

                    </div>


					<a id="btnAddOrUpdate" class="btn btn-primary btn-user btn-block">
						Create </a>
					<hr>


				</form:form>
				<hr>

			</div>
		</div>
	</div>
<c:url var="listCityUrl" value="/api/city/list" />

	<script>
	/*  var file = $('#file').prop('files'); */
	var imagebase64 = "";  
	  
	function encodeImageFileAsURL(element) {  
	    var file = element.files[0];  
	    var reader = new FileReader();  
	    reader.onloadend = function() {  
	        imagebase64 = reader.result;  
	    }  
	    reader.readAsDataURL(file);  
	}  
	
	
    $('#btnAddOrUpdate').on("click",function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
            
        });
  		data["file"] = imagebase64;
        console.log(data);
        addEquipment(data);
    });


    function addEquipment(data) {	
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: data,
          	processData: false,
            success: function (result) {
            	cosole.log(result)
            	/* window.location.href = "${listUrl}"; */
            },
            error: function (error) {
            	alert(error);
            }
        });
    }
</script>
</body>
</html>
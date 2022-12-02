<%@ include file="/WEB-INF/taglib.jsp"%>
<c:url var="APIurl" value="/api/customer" />
<c:url var="listUrl" value="/customer/list" />
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

				<form:form action="${saveURL}" id="formSubmit" class="employee" modelAttribute="employee" method="post">
				    <form:hidden path="id"/>
				    <form:hidden path="account.id"/>
				   <%-- <form:hidden path="address.city.id"></form:hidden>
				    <form:hidden path="address.city.country.id"></form:hidden> --%>
					
					<div class="form-group">
					    <form:input path="empId" cssClass="form-control form-control-user"
                        	   placeholder="Enter Employee Id"/>
                    </div>

					<div class="form-group">
					    <form:input path="name" cssClass="form-control form-control-user"
					           placeholder="Enter Name"/>

					</div>

					

					<div class="form-group">
						<form:input type="email" path="account.email" cssClass="form-control form-control-user"
                              placeholder="Enter Email"/>
					</div>
					
					<div class="form-group">
						<form:input type="password" path="account.password" cssClass="form-control form-control-user"
                              placeholder="Enter Password"/>
					</div>
					
					<div class="form-group">
						<form:input path="account.phone" cssClass="form-control form-control-user"
                              placeholder="Enter Phone"/>
					</div>
					
					<div class="form-group">
						 <form:select path="account.role.roleCode" cssClass="form-control form-control-user">
							<form:options items="${roles}" itemValue="roleCode" itemLabel="roleName" />
						</form:select>
						
						<%-- <select id="account.role.codeRole">
							<c:forEach var="item" items="${roles}">
								<option value="${item.roleCode}" >${item.roleName}</option>
							</c:forEach>
						</select>  --%>
					</div>

					<a id="btnEdit" class="btn btn-primary btn-user btn-block">
						Create </a>
					<hr>

				</form:form>
				<hr>

			</div>
		</div>
	</div>
	</div>

	<script>
    $('#btnAddOrUpdate').on("click",function (e) {
        e.preventDefault();
        var data = {};
        var address = {};
        var city = {};
        var country = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            if(v.name.includes("address.")){
                if(v.name.includes("address.city.")){
                    if(v.name.includes("address.city.country.")){
                        var countryN = v.name.replace("address.city.country.",'');
                            country[""+countryN+""] = v.value
                    }else{
                        var cityId = v.name.replace("address.city.",'');
                        city[""+cityId+""] = v.value;
                    }
                }else{
                var addressName = v.name.replace("address.",'');
                address[""+addressName+""] = v.value;
                }
            }else{
               data[""+v.name+""] = v.value;
            }
        });
        city["country"] = country;
        address["city"] = city;
        data["address"] = address;
        console.log(address);
        console.log(data);

        addCustomer(data);
    });


    function addCustomer(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${listUrl}";
            },
            error: function (error) {
            	alert(error);
            }
        });
    }
    $(document).ready(function(){
        $('select#country').change(function () {
          var data = {};
          var name = $("#country option.b:selected").val();
          data["name"] = name;
          if(name!=undefined)
            $.ajax({
                url: '${listCityUrl}',
                type: 'GET',
                contentType: 'application/json',
                data: data,
                success: function (result) {
                     $(".city-selector").html(result);
                },
                error: function (error) {
                    alert(error);
                }
            });

        });
    })


</script>


<!-- ADD EMPLOYEE -->
<c:url var="editEmployee" value="/api/employee" />
<script>
    $('#btnEdit').on("click",function (e) {
        e.preventDefault();
        var data = {};
        var account = {};
        var role = {};
       
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            if(v.name.includes("account.")){
                if(v.name.includes("account.role.")){
                    var roleCode = v.name.replace("account.role.",'');
                    role[""+roleCode+""] = v.value;
                }else{
                	var accountName = v.name.replace("account.",'');
                	account[""+ accountName +""] = v.value;
                }
            }else{
               data[""+v.name+""] = v.value;
            }
        });
        account["role"] = role;
        data["account"] = account;
        console.log(data);

        addEmployee(data);
    });
    
    function addEmployee(data) {
        $.ajax({
            url: '${editEmployee}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	console.log(result);
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
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
	<h1 class="h3 mb-2 text-gray-800">Create</h1>


	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Students Create</h6>
		</div>


		<div class="col-lg-6">
			<div class="p-5">

				<form:form action="${saveURL}" id="formSubmit" class="user" modelAttribute="customer" method="post">
				    <form:hidden path="id"></form:hidden>
				    <form:hidden path="address.id"></form:hidden>
				    <form:hidden path="address.city.id"></form:hidden>
				    <form:hidden path="address.city.country.id"></form:hidden>


					<div class="form-group">
					    <form:input path="firstName" cssClass="form-control form-control-user"
					           id="firstName" placeholder="Enter First Name"/>

					</div>

					<div class="form-group">
					    <form:input path="lastName" cssClass="form-control form-control-user"
                        	id="firstName" placeholder="Enter Last Name"/>

                    </div>

					<div class="form-group">
						<form:input type="email" path="email" cssClass="form-control form-control-user"
                             id="email" placeholder="Enter Email"/>
					</div>

					<div class="form-group">
                         <form:input path="address.address" cssClass="form-control form-control-user"
                               id="address" placeholder="Enter address"/>
                         <form:input path="address.address2" cssClass="form-control form-control-user"
                               id="address2" placeholder="Enter address2"/>
                         <form:input path="address.addressExtension" cssClass="form-control form-control-user"
                               id="addressExtension" placeholder="Enter addressExtension"/>
                    </div>

                    <div class="form-group">
                         <form:input path="address.district" cssClass="form-control form-control-user"
                               id="district" placeholder="Enter district"/>
                         <form:input path="address.postalCode" cssClass="form-control form-control-user"
                               id="postalCode" placeholder="Enter postalCode"/>
                         <form:input path="address.phone" cssClass="form-control form-control-user"
                               id="phone" placeholder="Enter phone"/>
                    </div>

					<div class="form-group">
                        <form:input path="address.city.cityName" cssClass="form-control form-control-user"
                               placeholder="Enter city name"/>
                         <form:input path="address.city.country.name" cssClass="form-control form-control-user"
                               placeholder="Enter country"/>
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
</body>
</html>
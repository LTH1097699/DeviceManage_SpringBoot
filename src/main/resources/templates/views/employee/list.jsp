<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

</head>
<body id="bodyChange">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>


	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Employee List</h6>
		</div>
		<div class="card-header py-3">
        	<h6 class="m-0 font-weight-bold text-primary">
        	    <a class="button" id="button-search-customer-id" href="#" >Search</a>
        	    <input id="search-customer-id" name="search-customer-id" placeholder="Search Customer Id">
        	</h6>
        </div>
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">
                <a class="button" id="button-search-customer-name" href="#" >Search</a>
                <input id="search-customer-name" name="search-customer-name" placeholder="Search First Name">
               
            </h6>
        </div>
		<div class="card-body">
			<div class="table-responsive">
                <div id="dataTableChange">
                                    
                </div>
			</div>
		</div>
	</div>


<!-- <script>
    $("#button-search-customer-id").on("click",function(){
        var data = {};
        var id = $('#search-customer-id').val();
        data["id"] = id;
        $.ajax({
            url: '${searchCustomerIdURL}',
            type: 'GET',
            contentType: 'application/json',
            data: data,
            success: function(result){
                   $("#dataTableChange").html(result);
            },
            error: function(error){
                console.log(error);
            }
        })
    });

     $("#button-search-customer-name").on("click",function(){
        var data = {};
        data["searchName"] = $('#search-customer-name').val();;
        data["searchCity"] = $('#search-customer-city').find(":selected").val();
        console.log(data);
        $.ajax({
            url: '${searchCustomerNameURL}',
            type: 'GET',
            contentType: 'application/json',
            data: data,
            success: function(result){
                    console.log(result);
                   $("#dataTableChange").html(result);
            },
            error: function(error){
                console.log(error);
            }
        })

    });


</script>
<script>
    function deleteCustomer(){
        var data = {};
            var id = $('#id').val();
            data["id"] = id;
            console.log(data);
            $.ajax({
                url: '${editURL}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function(result){
                       window.location.href = "${listUrl}";
                },
                error: function(error){
                    console.log(error);
                }
            });
    }
</script> -->

</body>
</html>
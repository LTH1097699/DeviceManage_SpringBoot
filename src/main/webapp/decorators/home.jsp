<%@ include file="/WEB-INF/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link href="<c:url value='/assets/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value='/assets/css/sb-admin-2.min.css'/>" rel="stylesheet">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Bootstrap core JavaScript-->
<script src="<c:url value='/assets/vendor/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='/assets/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
<!-- Core plugin JavaScript-->
<script src="<c:url value='/assets/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value='/assets/js/sb-admin-2.min.js'/>"></script>

<!-- Page level plugins -->
<script src="<c:url value='/assets/vendor/chart.js/Chart.min.js'/>"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="<c:url value='/assets/jquery.twbsPagination.js'/>" type="text/javascript"></script>
</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="/components/sidebar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<%@ include file="/components/header.jsp"%>
				<!-- End of Topbar -->

				<div class="container-fluid">
			        <sitemesh:write property='body'/>
				</div>
		

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@ include file="/components/footer.jsp"%>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Page level custom scripts -->
	<script src="<c:url value='/assets/js/demo/chart-area-demo.js'/>"></script>
	<script src="<c:url value='/assets/js/demo/chart-pie-demo.js'/>"></script>
	
	
</body>
</html>
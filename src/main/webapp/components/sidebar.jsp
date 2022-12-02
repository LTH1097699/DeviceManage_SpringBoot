<%@ include file="/WEB-INF/taglib.jsp"%>
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="index.html">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			SB Admin <sup>2</sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link" href="index.html">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Interface</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseEmployee"
		aria-expanded="false" aria-controls="collapseEmployee"> <i
			class="fas fa-fw fa-cog"></i> <span>Employee</span>
	</a>
		<div id="collapseEmployee" class="collapse"
			aria-labelledby="headingEmployee" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Components:</h6>
				<c:url var="employeeListURL" value="/employee/list">

				</c:url>
				<a class="collapse-item" href="${employeeListURL}">List</a>

				<c:url var="employeeEditURL" value="/employee/edit">
				</c:url>
				<a class="collapse-item" href="${employeeEditURL}">Add</a>

			</div>
		</div></li>


	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseEquipment"
		aria-expanded="false" aria-controls="collapseEquipment"> <i
			class="fas fa-fw fa-cog"></i> <span>Equipment</span>
	</a>
		<div id="collapseEquipment" class="collapse"
			aria-labelledby="headingEquipment" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Components:</h6>
				<c:url var="equipmentTypeListURL" value="/equipment/list">

				</c:url>
				<a class="collapse-item" href="${equipmentTypeListURL}">List</a>

				<c:url var="equipmentTypeEditURL" value="/equipment-type/edit">
				</c:url>
				<a class="collapse-item" href="${equipmentTypeEditURL}">Add</a>

			</div>
		</div></li>
		
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Type</div>

	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseEquipmentType"
		aria-expanded="false" aria-controls="collapseEquipmentType"> <i
			class="fas fa-fw fa-cog"></i> <span>Equipment Type</span>
	</a>
		<div id="collapseEquipmentType" class="collapse"
			aria-labelledby="headingEquipmentType"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Components:</h6>
				
				<c:url var="equipmentTypeListURL" value="/equipment-type/list">

				</c:url>
				<a class="collapse-item" href="${equipmentTypeListURL}">List</a>

				<c:url var="equipmentTypeEditURL" value="/equipment-type/edit">
				</c:url>
				<a class="collapse-item" href="${equipmentTypeEditURL}">Add</a>

			</div>
		</div></li>



	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Status</div>

	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseEmployeeStatus"
		aria-expanded="false" aria-controls="collapseEmployeeStatus"> <i
			class="fas fa-fw fa-cog"></i> <span>Employee Status</span>
	</a>
		<div id="collapseEmployeeStatus" class="collapse"
			aria-labelledby="headingEmployeeStatus"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Components:</h6>
				<c:url var="equipmentTypeListURL" value="/equipment-type/list">

				</c:url>
				<a class="collapse-item" href="${equipmentTypeListURL}">List</a>

				<c:url var="equipmentTypeEditURL" value="/equipment-type/edit">
				</c:url>
				<a class="collapse-item" href="${equipmentTypeEditURL}">Add</a>

			</div>
		</div></li>
		
		
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseEquipmentStatus"
		aria-expanded="false" aria-controls="collapseEquipmentStatus"> <i
			class="fas fa-fw fa-cog"></i> <span>Equipment Status</span>
	</a>
		<div id="collapseEquipmentStatus" class="collapse"
			aria-labelledby="headingEquipmentStatus"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Components:</h6>
				<c:url var="equipmentTypeListURL" value="/equipment-type/list">

				</c:url>
				<a class="collapse-item" href="${equipmentTypeListURL}">List</a>

				<c:url var="equipmentTypeEditURL" value="/equipment-type/edit">
				</c:url>
				<a class="collapse-item" href="${equipmentTypeEditURL}">Add</a>

			</div>
		</div></li>

</ul>
<!-- End of Sidebar -->
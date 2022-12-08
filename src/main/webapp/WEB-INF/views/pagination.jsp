<%@ include file="/WEB-INF/taglib.jsp"%>

<!-- 
  	url: (defalut) current url
  	https://api.jquery.com/jQuery.ajax/#jQuery-ajax-url-settings  
  	
  	convert to Integer for page class active in startPage
  -->
  
<script type="text/javascript">
 var currentPage = $("#currentPage").attr("value");
 var sort = $("#selectSort option:selected").attr("value");

 
$(function() {
	
	window.pagObj = $('#pagination').twbsPagination({
		totalPages: ${ pageDTO.getTotalPages() },
		startPage : parseInt(currentPage),
		initiateStartPageClick: true,
		visiblePages : 10,
		onPageClick : function(event, page) {
			if (page != currentPage) {
				$.ajax({
					url: "${listUrl}/pagination",
					type: "GET",
					data: {page: page, sort: sort},
					success: function(result) {
						/* window.location.href = "${listEquipmentTypeUrl}?page="+page; */
						
						window.history.pushState({}, null, "${listUrl}?page="+page+"&sort="+sort);
						$("#dataTableChange").html(result);
						
						/* update current page */
						currentPage = $("#currentPage").attr("value");
						
					}
				})
			}
		}
	})
});
</script>

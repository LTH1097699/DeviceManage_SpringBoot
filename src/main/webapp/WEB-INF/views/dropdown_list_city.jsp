<%@ include file="/WEB-INF/taglib.jsp"%>

<select id="address.city.id" name="address.city.id" class="city-selector">
    <c:forEach var="item" items="${cityList}">
        <option value="${item.id}">${item.cityName}</option>
    </c:forEach>

<select>

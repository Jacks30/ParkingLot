<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddCars">

    <a class="w-50 btn btn-primary btn-lg" href="{pageContext.request.contextPath}/EditCar">Edit Car</a>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCar">
        <div class="col-md-6 mb-3">
            <label for="license_plate">License Plate</label>
            <input type="text" class="form-control" id="license_plate" placeholder="" value="${car.licensePlate}" required>
            <div class="invalid-feedback">
                License Plate is required.
            </div>
        </div>
    </form>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCar">
        <div class="col-md-6 mb-3">
            <label for="parking_spot">Parking Spot</label>
            <input type="text" class="form-control" id="parking_spot" placeholder="" value="${car.parkingSpot}" required>
            <div class="invalid-feedback">
                Parking Spot is required.
            </div>
        </div>
    </form>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCar">
        <div class="col-md-6 mb-3">
            <label for="owner_id" class="form-label">Owner</label>
            <select class="form-select" id="owner_id" name="owner_id" required>
                <option value>Chose..</option>
                <c:forEach var="user" items="${users}" varStatus="status">
                    <option value="${user.id}"${car.ownerName eq user.username ? 'selected' : ''}>${user.username}</option>
                </c:forEach>
            </select>
        </div>
    </form>
    <hr class="mb-4">
    <a class="w-50 btn btn-primary btn-lg">Save</a>
    <input type="hidden" name="car_id" value="${car.id}"/>
</t:pageTemplate>

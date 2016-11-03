<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">

    <h3><fmt:message key="meals.title"/></h3>

    <div class="view-box">
    <form id="filter" role="form" class="form-horizontal" action="/meals" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="startDate"><fmt:message key="meals.startDate"/>:</label>
            <div class="col-sm-2">
            <input class="form-control" name="startDate" id="startDate" value="${param.startDate}">
            </div>
            <label class="control-label col-sm-2" for="endDate"><fmt:message key="meals.endDate"/>:</label>
            <div class="col-sm-2">
            <input class="form-control" name="endDate" id="endDate" value="${param.endDate}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="startTime"><fmt:message key="meals.startTime"/>:</label>
            <div class="col-sm-2">
            <input class="form-control time-picker" name="startTime" id="startTime" value="${param.startTime}">
            </div>
            <label class="control-label col-sm-2" for="endTime"><fmt:message key="meals.endTime"/>:</label>
            <div class="col-sm-2">
            <input class="form-control time-picker" name="endTime" id="endTime" value="${param.endTime}">
            </div>
        </div>
        <div class="col-sm-8">
        <button type="submit" class="btn btn-primary pull-right"><fmt:message key="meals.filter"/></button>
        </div>
    </form>
    <hr><hr><hr>
    <a class="btn btn-sm btn-info" onclick="add('meals.add')"><fmt:message key="meals.add"/></a>

    <div id="datatable_wrapper" class="dataTables_wrapper no-footer">
    <table class="table table-striped display dataTable no-footer" id="datatable" role="grid" aria-describedby="datatable_info" style="width: 1140px;">
        <thead>
        <tr>
            <th><fmt:message key="meals.dateTime"/></th>
            <th><fmt:message key="meals.description"/></th>
            <th><fmt:message key="meals.calories"/></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.MealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>
                        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                        ${fn:formatDateTime(meal.dateTime)}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a  class="btn btn-xs btn-primary" onclick="updateRow(${meal.id},'meals.edit');"><fmt:message key="common.update"/></a></td>
                <td><a class="btn btn-xs btn-danger" onclick="deleteRow(${meal.id});"><fmt:message key="common.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
    </div>
    </div>
    </div>
</div>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

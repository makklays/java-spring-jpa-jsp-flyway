<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<head>
    <title>View MyTasks</title>
    <!-- css -->
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
    <!-- js -->
    <script type="text/javascript" src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</head>
<body class="container">

    <h1>Queries</h1>
    <span>List of queries</span>

    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <caption>List of queries</caption>
            <thead class="table-light">
                <tr>
                    <th class="text-center">#</th>
                    <th class="text-center">Service ID</th>
                    <th class="text-center">Variation ID</th>
                    <th class="text-center">Question type ID</th>
                    <th class="text-center">Category ID</th>
                    <th class="text-center">Sub category ID</th>
                    <th class="text-center">Response type</th>
                    <th class="text-center">Date from</th>
                    <th class="text-center">Date to</th>
                    <th class="text-center">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${queries.size() > 0}">
                        <c:forEach items="${queries}" var="query">
                            <tr>
                                <td class="text-center">${query.id}</td>
                                <td class="text-center">${query.serviceId == null ? "*" : query.serviceId}</td>
                                <td class="text-center">${query.variationId}</td>
                                <td class="text-center">${query.questionTypeId == null ? "*" : query.questionTypeId}</td>
                                <td class="text-center">${query.categoryId}</td>
                                <td class="text-center">${query.subCategoryId}</td>
                                <td class="text-center">${query.responseType}</td>
                                <td class="text-center"><fmt:formatDate value="${query.dateFrom}" pattern="dd.MM.yyyy" /></td>
                                <td class="text-center"><fmt:formatDate value="${query.dateTo}" pattern="dd.MM.yyyy" /></td>
                                <td class="text-center"><a href="/list-timelines-one/${query.id}">timelines</a></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="10">Empty</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>

</body>
</html>


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

    <h1>Timelines</h1>

    <h4>For this query average time is = ${averageTime} minutes</h4>
    <span>Query: ${query.serviceId == null ? "*" : query.serviceId} ${query.variationId} ${query.questionTypeId == null ? "*" : query.questionTypeId} ${query.categoryId} ${query.subCategoryId} ${query.responseType} <fmt:formatDate value="${query.dateFrom}" pattern="dd.MM.yyyy" /> - <fmt:formatDate value="${query.dateTo}" pattern="dd.MM.yyyy" /></span>

    <br/><br/>

    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <caption>List of timelines</caption>
            <thead class="table-light">
                <tr>
                    <th class="text-center">#</th>
                    <th class="text-center">Service ID</th>
                    <th class="text-center">Variation ID</th>
                    <th class="text-center">Question type ID</th>
                    <th class="text-center">Category ID</th>
                    <th class="text-center">Sub category ID</th>
                    <th class="text-center">Response type</th>
                    <th class="text-center">Date</th>
                    <th class="text-center">Time</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${timelines.size() > 0}">
                        <c:forEach items="${timelines}" var="timeline">
                            <tr>
                                <td class="text-center">${timeline.id}</td>
                                <td class="text-center">${timeline.serviceId}</td>
                                <td class="text-center">${timeline.variationId}</td>
                                <td class="text-center">${timeline.questionTypeId}</td>
                                <td class="text-center">${timeline.categoryId}</td>
                                <td class="text-center">${timeline.subCategoryId}</td>
                                <td class="text-center">${timeline.responseType}</td>
                                <td class="text-center"><fmt:formatDate value="${timeline.date}" pattern="dd.MM.yyyy" /></td>
                                <td class="text-center">${timeline.time}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="9">Empty</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
            <!--tfoot>
                <tr>
                    <th class="text-center">#</th>
                    <th class="text-center">Service ID</th>
                    <th class="text-center">Variation ID</th>
                    <th class="text-center">Question type ID</th>
                    <th class="text-center">Category ID</th>
                    <th class="text-center">Sub category ID</th>
                    <th class="text-center">Response type</th>
                    <th class="text-center">Date</th>
                    <th class="text-center">Time</th>
                </tr>
            </tfoot-->
        </table>

        <br/><br/>

        <a href="/list-queries" class="btn btn-primary"><< back</a>

    </div>

</body>
</html>


<%@ page import="com.kgn.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${initParam.ProductName}</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="metro-bootstrap-master/css/metro-bootstrap.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="app.css" type="text/css">
</head>
<body>

    <%@include file="_header.jsp" %>

<section class="main container-fluid">
    <div class="container">
        <h1>Home</h1>

        <div class="row-fluid">
            <div class="col-md-3">Sidebar</div>
            <div class="col-md-9">
                <tabset>
                    <tab heading="Search">
                        <c:out value="Hello"/>
                        <div class="${app.formCssClass.name}">
                            <c:choose>
                                <c:when test="${!empty user.name}">
                                    <h2>Welcome: ${user.name} </h2>
                                </c:when>
                                <c:otherwise>
                                    <h2>Welcome: whoever you are </h2>
                                </c:otherwise>
                            </c:choose>
                            <form action="home" method="post">
                                <p>
                                    Name: <input type="text" name="name"/>
                                </p>

                                <p>
                                    <input type="submit" value="Enter name">
                                </p>
                            </form>
                        </div>
                    </tab>
                    <tab heading="Next">
                        Yet More Static content
                    </tab>
                </tabset>
            </div>
        </div>
    </div>
</section>
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>
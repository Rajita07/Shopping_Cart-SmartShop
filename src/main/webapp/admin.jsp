<%@page import="com.shop.model.User"%>
<%
    User auth = (User) session.getAttribute("auth");
    if (auth == null || !"ADMIN".equals(auth.getRole())) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard - SmartShop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <nav class="navbar navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="admin.jsp">Admin Panel</a>
            <a href="index.jsp" class="btn btn-outline-light btn-sm">View Store</a>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="card text-center shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">Product Management</h5>
                        <p class="card-text">Add new items to your inventory.</p>
                        <a href="add-product.jsp" class="btn btn-primary">Add New Product</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
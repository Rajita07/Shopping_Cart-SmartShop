<%@page import="com.shop.dao.OrderDAO"%>
<%@page import="com.shop.model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.NumberFormat"%> <%-- Added for Currency --%>
<%
    User auth = (User) session.getAttribute("auth");
    List<Order> orders = null;
    if (auth != null) {
        OrderDAO od = new OrderDAO();
        orders = od.userOrders(auth.getId());
    } else {
        response.sendRedirect("login.jsp");
    }

    // Setup Indian Currency Formatter
    Locale indiaLocale = new Locale("en", "IN");
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(indiaLocale);
%>
<!DOCTYPE html>
<html>
<head>
    <title>My Orders - SmartShop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <nav class="navbar navbar-dark bg-dark mb-4 shadow">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">SmartShop</a>
            <div class="navbar-nav ms-auto flex-row">
                <a class="nav-link me-3" href="index.jsp">Home</a>
                <a class="nav-link text-danger" href="LogoutServlet">Logout</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <h3 class="py-3">Your Purchase History</h3>
        <table class="table table-white shadow-sm rounded overflow-hidden">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Date</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Category</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Total Paid</th>
                </tr>
            </thead>
            <tbody>
                <% if (orders != null && !orders.isEmpty()) {
                    for (Order o : orders) { %>
                <tr>
                    <td><%= o.getDate() %></td>
                    <td><strong><%= o.getName() %></strong></td>
                    <td><%= o.getCategory() %></td>
                    <td><span class="badge bg-secondary"><%= o.getQuantity() %></span></td>
                    <%-- Updated Total Price Display --%>
                    <td class="text-success fw-bold"><%= currencyFormat.format(o.getPrice()) %></td>
                </tr>
                <% } } else { %>
                    <tr><td colspan="5" class="text-center py-4">You haven't placed any orders yet.</td></tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
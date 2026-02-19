<%@page import="com.shop.util.DBConnection"%>
<%@page import="com.shop.dao.ProductDAO"%>
<%@page import="com.shop.model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.NumberFormat"%> <%-- Added for Currency --%>
<%
    User auth = (User) session.getAttribute("auth");
    List<Cart> cart_list = (List<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    double total = 0;
    if (cart_list != null) {
        ProductDAO pDao = new ProductDAO();
        cartProduct = pDao.getCartProducts(cart_list);
        total = pDao.getTotalCartPrice(cart_list);
    }
    
    // Setup Indian Currency Formatter
    Locale indiaLocale = new Locale("en", "IN");
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(indiaLocale);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart - SmartShop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table tbody td { vertical-align: middle; }
        .btn-inc-dec { text-decoration: none; font-weight: bold; }
    </style>
</head>
<body class="bg-light">
    <nav class="navbar navbar-dark bg-dark mb-4 shadow">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">SmartShop</a>
            <a href="index.jsp" class="btn btn-outline-light btn-sm">Continue Shopping</a>
        </div>
    </nav>

    <div class="container">
        <div class="d-flex py-3 align-items-center">
            <%-- Updated Total Price Display --%>
            <h3>Total Amount: <span class="text-success"><%= currencyFormat.format(total) %></span></h3>
            <a class="btn btn-primary ms-auto px-4" href="check-out">Checkout Now</a>
        </div>
        
        <table class="table table-white table-hover shadow-sm rounded overflow-hidden">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Category</th>
                    <th scope="col">Price (Unit)</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <% if (cart_list != null && !cart_list.isEmpty() && cartProduct != null) {
                    for (Cart c : cartProduct) { %>
                <tr>
                    <td><strong><%= c.getName() %></strong></td>
                    <td><span class="badge bg-light text-dark border"><%= c.getCategory() %></span></td>
                    <%-- Updated Unit Price Display --%>
                    <td><%= currencyFormat.format(c.getPrice()) %></td>
                    <td>
                        <div class="d-flex align-items-center">
                            <a class="btn btn-sm btn-outline-secondary btn-inc-dec" 
                               href="QuantityIncDecServlet?action=dec&id=<%= c.getId() %>">-</a>
                            
                            <input type="text" name="quantity" value="<%= c.getQuantity() %>" 
                                   class="form-control form-control-sm text-center mx-2" 
                                   style="width: 50px;" readonly>
                            
                            <a class="btn btn-sm btn-outline-secondary btn-inc-dec" 
                               href="QuantityIncDecServlet?action=inc&id=<%= c.getId() %>">+</a>
                        </div>
                    </td>
                    <td>
                        <a class="btn btn-sm btn-danger" href="RemoveFromCartServlet?id=<%= c.getId() %>">Remove</a>
                    </td>
                </tr>
                <% } } else { %>
                    <tr>
                        <td colspan="5" class="text-center py-5 text-muted">
                            <h5 class="mb-3">Your cart is empty.</h5>
                            <a href="index.jsp" class="btn btn-primary btn-sm">Start Shopping</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
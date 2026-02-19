<%@page import="com.shop.dao.ProductDAO"%>
<%@page import="com.shop.model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.NumberFormat"%> <%-- Added for Currency --%>
<%
    User auth = (User) session.getAttribute("auth");
    ProductDAO pd = new ProductDAO();
    String search = request.getParameter("search");
    
    List<Product> products = (search != null && !search.trim().isEmpty()) 
                             ? pd.getSearchProducts(search) 
                             : pd.getAllProducts();
                             
    List<Cart> cart_list = (List<Cart>) session.getAttribute("cart-list");

    // Initialize Indian Currency Formatter
    Locale indiaLocale = new Locale("en", "IN");
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(indiaLocale);
%>
<!DOCTYPE html>
<html>
<head>
    <title>SmartShop - Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body class="bg-light">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow sticky-top">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">SmartShop</a>
            <form class="d-flex mx-auto w-50" action="index.jsp" method="get">
                <input class="form-control me-2" type="search" name="search" placeholder="Search products..." value="<%= (search!=null)?search:"" %>">
                <button class="btn btn-outline-warning" type="submit">Search</button>
            </form>
            <div class="navbar-nav ms-auto align-items-center">
               <a class="nav-link" href="cart.jsp">
                    Cart <span class="badge <%= (cart_list != null && !cart_list.isEmpty()) ? "bg-danger" : "bg-secondary" %>">
                        <%= (cart_list != null) ? cart_list.size() : 0 %>
                    </span>
               </a>
               <% if(auth != null) { %>
                    <% if("ADMIN".equals(auth.getRole())) { %>
                        <a class="nav-link text-warning me-2" href="admin.jsp">Admin Panel</a>
                    <% } %>
                    <a class="nav-link me-2" href="orders.jsp">My Orders</a>
                    <span class="nav-link text-white me-2">| Hello, 
                        <a href="orders.jsp" class="text-decoration-none text-info"><strong><%= auth.getName() %></strong></a>
                    </span>
                    <a class="btn btn-outline-danger btn-sm" href="LogoutServlet">Logout</a>
               <% } else { %>
                    <a class="nav-link" href="login.jsp">Login</a>
               <% } %>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <% if(search != null && !search.isEmpty()) { %>
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h3>Results for: "<%= search %>"</h3>
                <a href="index.jsp" class="btn btn-secondary btn-sm">Clear Search</a>
            </div>
        <% } else { %>
            <h2 class="text-center mb-5">Featured Products</h2>
        <% } %>

        <div class="row">
            <% if(products != null && !products.isEmpty()) { 
                for(Product p : products) { %>
                <div class="col-md-3 mb-4">
                    <div class="card h-100 shadow-sm product-card">
                        <img src="<%= p.getImageUrl() %>" 
                             class="card-img-top" 
                             alt="<%= p.getName() %>"
                             onerror="this.src='https://placehold.co/600x400?text=Product+Image'">
                        
                        <div class="card-body text-center">
                            <h5 class="card-title"><%= p.getName() %></h5>
                            <p class="text-muted small mb-1"><%= p.getCategory() %></p>
                            <p class="text-success" style="font-weight: 800; font-size: 1.2rem;">
                                <%= currencyFormat.format(p.getPrice()) %>
                            </p>
                        </div>
                        
                        <div class="card-footer bg-white border-top-0 pb-3">
                            <a href="AddToCartServlet?id=<%= p.getId() %>" class="btn btn-primary w-100 mb-2">Add to Cart</a>
                            
                            <% if(auth != null && "ADMIN".equals(auth.getRole())) { %>
                                <div class="btn-group w-100">
                                    <a href="edit-product.jsp?id=<%= p.getId() %>" class="btn btn-outline-warning btn-sm">Edit</a>
                                    <a href="DeleteProductServlet?id=<%= p.getId() %>" class="btn btn-outline-danger btn-sm" onclick="return confirm('Delete this product permanently?')">Delete</a>
                                </div>
                            <% } %>
                        </div>
                    </div>
                </div>
            <% } } else { %>
                <div class="col-12 text-center py-5">
                    <h4 class="text-muted">No products found.</h4>
                    <a href="index.jsp" class="btn btn-primary mt-3">View All Products</a>
                </div>
            <% } %>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
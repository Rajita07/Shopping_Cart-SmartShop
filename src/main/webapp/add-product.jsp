<!DOCTYPE html>
<html>
<head>
    <title>Add Product - SmartShop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow">
                    <div class="card-header bg-dark text-white"><h4>Add New Product</h4></div>
                    <div class="card-body">
                        <form action="AddProductServlet" method="post">
                            <div class="mb-3"><label>Name</label><input type="text" name="name" class="form-control" required></div>
                            <div class="mb-3"><label>Category</label><input type="text" name="category" class="form-control" required></div>
                            <div class="mb-3"><label>Price</label><input type="number" step="0.01" name="price" class="form-control" required></div>
                            <div class="mb-3"><label>Image Filename</label><input type="text" name="image" class="form-control" placeholder="e.g. laptop.jpg" required></div>
                            <div class="mb-3"><label>Description</label><textarea name="description" class="form-control"></textarea></div>
                            <button type="submit" class="btn btn-success w-100">Upload Product</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
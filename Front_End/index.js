const productList = document.getElementById('productList');

// Display products in a table
function displayProducts(products) {
    productList.innerHTML = '';

    products.forEach(product => {
        const row = document.createElement('tr');
        row.dataset.productId = product.productID; // Add data attribute for productID
        row.innerHTML = `
            <td>${product.productID}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.categoryName}</td>
        `;

        row.onclick = () => {
            // Toggle selected class
            if (row.classList.contains('selected')) {
                row.classList.remove('selected');
            } else {
                // Remove selection from any other row
                const selectedRow = document.querySelector('tr.selected');
                if (selectedRow) {
                    selectedRow.classList.remove('selected');
                }
                row.classList.add('selected');
            }
        };

        productList.appendChild(row);
    });

    // Initialize DataTables with FixedHeader
    const table = $('#productTable').DataTable({
        destroy: true, // Destroy any existing DataTables instances to avoid duplication
        paging: false, // Disable paging for better readability in small tables
        info: false, // Disable table information
        searching: true, // Disable built-in search box
        scrollY: 300,

        fixedHeader: true, // Enable FixedHeader
    });

    
}

// Fetch products from server
async function fetchProducts() {
    try {
        const response = await fetch('http://localhost:8080/api/products');
        if (response.ok) {
            const products = await response.json();
            displayProducts(products);
        } else {
            console.error('Failed to fetch products:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching products:', error);
    }
}

// Function to get selected product ID
function getSelectedProductId() {
    const selectedRow = document.querySelector('tr.selected');
    return selectedRow ? selectedRow.dataset.productId : null;
}

// Edit selected product
function editSelectedProduct() {
    const selectedProductId = getSelectedProductId();
    if (selectedProductId) {
        // Redirect to edit page or show edit form
        window.location.href = `/editProduct.html?id=${selectedProductId}`;
    } else {
        alert('Please select a product to edit.');
    }
}

// Delete selected product
async function deleteSelectedProduct() {
    const selectedProductId = getSelectedProductId();
    if (selectedProductId) {
        try {
            const response = await fetch(`http://localhost:8080/api/products/${selectedProductId}`, {
                method: 'DELETE'
            });
            if (response.ok) {
                alert('Product deleted successfully');
                fetchProducts(); // Refresh product list
            } else {
                console.error('Failed to delete product:', response.statusText);
            }
        } catch (error) {
            console.error('Error deleting product:', error);
        }
    } else {
        alert('Please select a product to delete.');
    }
}

// New product
function newProduct() {
    window.location.href = '/newProduct.html';
}

// Fetch products on page load
fetchProducts();

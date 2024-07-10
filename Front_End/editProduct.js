document.addEventListener('DOMContentLoaded', async () => {
    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get('id');
    
    if (productId) {
        await loadProductDetails(productId);
    }
    await loadCategories();
});

async function loadProductDetails(productId) {
    try {
        const response = await fetch(`http://localhost:8080/api/products/${productId}`);
        if (response.ok) {
            const product = await response.json();
            document.getElementById('name').value = product.name;
            document.getElementById('price').value = product.price;
            document.getElementById('description').value = product.description || '';
            document.getElementById('length').value = product.length;
            document.getElementById('weight').value = product.weight;
            document.getElementById('thickness').value = product.thickness;
            document.getElementById('category').value = product.category.categoryID;
        } else {
            console.error('Failed to fetch product details:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching product details:', error);
    }
}

async function loadCategories() {
    try {
        const response = await fetch('http://localhost:8080/api/categories');
        if (response.ok) {
            const categories = await response.json();
            console.log('Fetched categories:', categories); // Debugging

            displayCategories(categories);
        } else {
            console.error('Failed to fetch categories:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching categories:', error);
    }
}

function displayCategories(categories) {
    const categorySelect = document.getElementById('category');
    categorySelect.innerHTML = '<option value="">Select a category</option>';

    categories.forEach(category => {
        console.log('Adding category:', category.categoryName); // Debugging
        const option = document.createElement('option');
        option.value = category.categoryID;
        option.textContent = category.categoryName;
        categorySelect.appendChild(option);
    });
}

async function submitEdit() {
    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get('id');

    const name = document.getElementById('name').value;
    const price = parseFloat(document.getElementById('price').value);
    const description = document.getElementById('description').value;
    const length = parseFloat(document.getElementById('length').value);
    const weight = parseFloat(document.getElementById('weight').value);
    const thickness = parseFloat(document.getElementById('thickness').value);
    const categoryID = parseInt(document.getElementById('category').value);

    const productData = {
        name,
        price,
        description,
        length,
        weight,
        thickness,
        categoryID
    };

    try {
        const response = await fetch(`http://localhost:8080/api/products/${productId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(productData)
        });

        if (response.ok) {
            alert('Product updated successfully!');
            window.location.href = '/index.html';
        } else {
            console.error('Failed to update product:', response.statusText);
            alert('Failed to update product.');
        }
    } catch (error) {
        console.error('Error updating product:', error);
        alert('Error updating product.');
    }
}

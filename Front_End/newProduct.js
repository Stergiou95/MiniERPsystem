document.addEventListener('DOMContentLoaded', async () => {
    await loadCategories();
});

async function loadCategories() {
    try {
        const response = await fetch('http://localhost:8080/api/categories');
        if (response.ok) {
            const categories = await response.json();
            const categorySelect = document.getElementById('category');
            categorySelect.innerHTML = '<option value="">Select a category</option>'; // Προσθήκη αρχικής επιλογής

            categories.forEach(category => {
                const option = document.createElement('option');
                option.value = category.categoryID; // Χρησιμοποιούμε το ID για το value
                option.textContent = category.categoryName; // Χρησιμοποιούμε το όνομα για εμφάνιση
                categorySelect.appendChild(option);
            });
        } else {
            console.error('Failed to fetch categories:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching categories:', error);
    }
}

async function submitNewProduct() {
    const name = document.getElementById('name').value;
    const price = parseFloat(document.getElementById('price').value);
    const description = document.getElementById('description').value;
    const length = parseFloat(document.getElementById('length').value);
    const weight = parseFloat(document.getElementById('weight').value);
    const thickness = parseFloat(document.getElementById('thickness').value);
    const categoryID = parseInt(document.getElementById('category').value);

    if (!categoryID) {
        alert('Please select a category.');
        return;
    }

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
        const response = await fetch('http://localhost:8080/api/products', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(productData)
        });

        if (response.ok) {
            alert('Product added successfully!');
            window.location.href = '/index.html';
        } else {
            console.error('Failed to add product:', response.statusText);
            alert('Failed to add product.');
        }
    } catch (error) {
        console.error('Error adding product:', error);
        alert('Error adding product.');
    }
}

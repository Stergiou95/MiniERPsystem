document.addEventListener('DOMContentLoaded', async () => {
    try {
        const response = await fetch('http://localhost:8080/api/categories');
        if (response.ok) {
            const categories = await response.json();
            displayCategories(categories);
        } else {
            console.error('Failed to fetch categories:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching categories:', error);
    }
});

function displayCategories(categories) {
    const categoryList = document.getElementById('categoryList');
    categoryList.innerHTML = '';

    categories.forEach(category => {
        const row = document.createElement('tr');
        row.innerHTML = `<td>${category.categoryName}</td>`;
        categoryList.appendChild(row);
    });
}

document.addEventListener('DOMContentLoaded', async () => {
    await loadCustomers();
    await loadPartners();
    await loadProducts();
});

async function loadCustomers() {
    try {
        const response = await fetch('http://localhost:8080/api/customers');
        if (response.ok) {
            const customers = await response.json();
            const customerSelect = document.getElementById('customer');
            customerSelect.innerHTML = '<option value="">Select a customer</option>';

            customers.forEach(customer => {
                const option = document.createElement('option');
                option.value = customer.custID;
                option.textContent = customer.companyName;
                customerSelect.appendChild(option);
            });
        } else {
            console.error('Failed to fetch customers:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching customers:', error);
    }
}

async function loadPartners() {
    try {
        const response = await fetch('http://localhost:8080/api/partners');
        if (response.ok) {
            const partners = await response.json();
            const partnerSelect = document.getElementById('partner');
            partnerSelect.innerHTML = '<option value="">Select a partner</option>';

            partners.forEach(partner => {
                const option = document.createElement('option');
                option.value = partner.partnerID;
                option.textContent = partner.companyName;
                partnerSelect.appendChild(option);
            });
        } else {
            console.error('Failed to fetch partners:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching partners:', error);
    }
}

async function loadProducts() {
    try {
        const response = await fetch('http://localhost:8080/api/products');
        if (response.ok) {
            const products = await response.json();
            const productSelect = document.getElementById('product');
            productSelect.innerHTML = '<option value="">Select a product</option>';

            products.forEach(product => {
                const option = document.createElement('option');
                option.value = product.productID;
                option.textContent = product.name;
                productSelect.appendChild(option);
            });
        } else {
            console.error('Failed to fetch products:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching products:', error);
    }
}

const productList = document.getElementById('productList');
let cart = [];

function addProduct() {
    const productSelect = document.getElementById('product');
    const quantityInput = document.getElementById('quantity');

    const productID = parseInt(productSelect.value);
    const productName = productSelect.options[productSelect.selectedIndex].text;
    const quantity = parseInt(quantityInput.value);

    if (!productID || !quantity) {
        alert('Please select a product and enter a quantity.');
        return;
    }

    const existingProduct = cart.find(item => item.productID === productID);
    if (existingProduct) {
        existingProduct.quantity += quantity;
    } else {
        cart.push({ productID, productName, quantity });
    }

    updateProductTable();
}

function updateProductTable() {
    productList.innerHTML = '';

    cart.forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${item.productName}</td>
            <td>${item.quantity}</td>
            <td><button onclick="removeProduct(${item.productID})">Remove</button></td>
        `;

        productList.appendChild(row);
    });
}

function removeProduct(productID) {
    cart = cart.filter(item => item.productID !== productID);
    updateProductTable();
}

async function submitNewOrder() {
    const customerID = parseInt(document.getElementById('customer').value);
    const partnerID = parseInt(document.getElementById('partner').value);

    if (!customerID || !partnerID || cart.length === 0) {
        alert('Please fill out all fields and add at least one product.');
        return;
    }

    const orderData = {
        custID: customerID,
        partnerID: partnerID,
        cart: cart.map(item => ({
            productID: item.productID,
            units: item.quantity
        }))
    };

    try {
        const response = await fetch('http://localhost:8080/api/orders', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(orderData)
        });

        if (response.ok) {
            alert('Order created successfully!');
            window.location.href = '/orderManagement.html';
        } else {
            console.error('Failed to create order:', response.statusText);
            alert('Failed to create order.');
        }
    } catch (error) {
        console.error('Error creating order:', error);
        alert('Error creating order.');
    }
}

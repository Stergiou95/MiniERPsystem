const ordersList = document.getElementById('ordersList');

// Display orders in a table
function displayOrders(orders) {
    ordersList.innerHTML = '';

    orders.forEach(order => {
        const row = document.createElement('tr');
        row.dataset.orderId = order.rmorderID;
        row.innerHTML = `
            <td>${order.rmorderID}</td>
            <td>${order.supplierName}</td>
            <td>${order.totalCost.toFixed(2)}</td>
            <td>${order.currentStatus}</td>
            <td>${order.dateOrderStatusChanged}</td>
        `;

        row.onclick = () => {
            if (row.classList.contains('selected')) {
                row.classList.remove('selected');
            } else {
                const selectedRow = document.querySelector('tr.selected');
                if (selectedRow) {
                    selectedRow.classList.remove('selected');
                }
                row.classList.add('selected');
            }
        };

        ordersList.appendChild(row);
    });
}

// Fetch orders from server
async function fetchOrders() {
    try {
        const response = await fetch('http://localhost:8080/api/rawMaterialOrders');
        if (response.ok) {
            const orders = await response.json();
            displayOrders(orders);
            $('#ordersTable').DataTable();
        } else {
            console.error('Failed to fetch orders:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching orders:', error);
    }
}

// Get selected order ID
function getSelectedOrderId() {
    const selectedRow = document.querySelector('tr.selected');
    return selectedRow ? selectedRow.dataset.orderId : null;
}

// View order details
async function viewOrderDetails() {
    const orderId = getSelectedOrderId();
    if (!orderId) {
        alert('Please select an order to view details.');
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/api/rawMaterialOrders/${orderId}`);
        if (response.ok) {
            const order = await response.json();
            displayOrderDetails(order);
        } else {
            console.error('Failed to fetch order details:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching order details:', error);
    }
}

// Display order details in modal
function displayOrderDetails(order) {
    const orderDetails = document.getElementById('orderDetails');
    orderDetails.innerHTML = `
        <strong>Order ID:</strong> ${order.rmorderID}<br>
        <strong>Supplier:</strong> ${order.supplierName}<br>
        <strong>Total Cost:</strong> ${order.totalCost.toFixed(2)}<br>
        <strong>Current Status:</strong> ${order.currentStatus}<br>
        <strong>Date of Status Change:</strong> ${order.dateOrderRmatStatusChanged}<br>
        <strong>Raw Materials:</strong><br>
        ${order.rawMaterialsDetails.map(item => `${item.rawMatName} - ${item.units} units at ${item.pricePerUnit.toFixed(2)} each`).join('<br>')}<br>
        <strong>Status History:</strong><br>
        ${order.statusHistory.map(status => `${status.statusName} on ${status.dateOfStatusChange}`).join('<br>')}
    `;
    document.getElementById('orderDetailsModal').style.display = 'block';
}

// Close modal
function closeModal() {
    document.getElementById('orderDetailsModal').style.display = 'none';
}

// New order
function newOrder() {
    window.location.href = '/newOrderForRawMaterial.html';
}

// Fetch orders on page load
fetchOrders();

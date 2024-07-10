const customerList = document.getElementById('customerList');

// Display customers in a table
function displayCustomers(customers) {
    customerList.innerHTML = '';

    customers.forEach(customer => {
        const row = document.createElement('tr');
        row.dataset.custID = customer.custID;
        row.innerHTML = `
            <td>${customer.custID}</td>
            <td>${customer.companyName}</td>
            <td>${customer.email}</td>
            <td>${customer.locationName}</td>
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

        customerList.appendChild(row);
    });

    

    // Initialize DataTables with FixedHeader
    const table = $('#customerTable').DataTable({
    destroy: true, // Destroy any existing DataTables instances to avoid duplication
    paging: false, // Disable paging for better readability in small tables
    info: false, // Disable table information
    searching: true, // Disable built-in search box
    scrollY: 300,

    fixedHeader: true, // Enable FixedHeader
    });
}

// Fetch customers from server
async function fetchCustomers() {
    try {
        const response = await fetch('http://localhost:8080/api/customers');
        if (response.ok) {
            const customers = await response.json();
            displayCustomers(customers);
        } else {
            console.error('Failed to fetch customers:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching customers:', error);
    }
}

// Get selected customer ID
function getSelectedCustomerId() {
    const selectedRow = document.querySelector('tr.selected');
    return selectedRow ? selectedRow.dataset.custID : null;
}

// Edit selected customer
function editSelectedCustomer() {
    const selectedCustomerId = getSelectedCustomerId();
    if (selectedCustomerId) {
        window.location.href = `./editCustomer.html?id=${selectedCustomerId}`;
    } else {
        alert('Please select a customer to edit.');
    }
}

// Delete selected customer
async function deleteSelectedCustomer() {
    const selectedCustomerId = getSelectedCustomerId();
    if (selectedCustomerId) {
        try {
            const response = await fetch(`http://localhost:8080/api/customers/${selectedCustomerId}`, {
                method: 'DELETE'
            });
            if (response.ok) {
                alert('Customer deleted successfully');
                fetchCustomers();
            } else {
                console.error('Failed to delete customer:', response.statusText);
            }
        } catch (error) {
            console.error('Error deleting customer:', error);
        }
    } else {
        alert('Please select a customer to delete.');
    }
}

// Redirect to new customer page
function newCustomer() {
    window.location.href = '/newCustomer.html';
}

// Fetch customers on page load
fetchCustomers();

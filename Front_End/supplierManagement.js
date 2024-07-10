document.addEventListener('DOMContentLoaded', async () => {
    await fetchSuppliers();
});

// Φόρτωση προμηθευτών
async function fetchSuppliers() {
    try {
        const response = await fetch('http://localhost:8080/api/suppliers');
        if (response.ok) {
            const suppliers = await response.json();
            displaySuppliers(suppliers);
        } else {
            console.error('Failed to fetch suppliers:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching suppliers:', error);
    }
}

// Εμφάνιση προμηθευτών
function displaySuppliers(suppliers) {
    const supplierList = document.getElementById('supplierList');
    supplierList.innerHTML = '';

    suppliers.forEach(supplier => {
        const row = document.createElement('tr');
        row.dataset.supplierID = supplier.supplierID; // Προσθήκη data attribute για το supplierId
        row.innerHTML = `
            <td>${supplier.supplierID}</td>
            <td>${supplier.companyName}</td>
            <td>${supplier.email}</td>
            <td>${supplier.locationName}</td>
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

        supplierList.appendChild(row);
    });
}

// Λήψη επιλεγμένου supplier ID
function getSelectedSupplierId() {
    const selectedRow = document.querySelector('tr.selected');
    return selectedRow ? selectedRow.dataset.supplierID : null;
}

// Επεξεργασία επιλεγμένου προμηθευτή
function editSelectedSupplier() {
    const selectedSupplierId = getSelectedSupplierId();
    if (selectedSupplierId) {
        window.location.href = `/editSupplier.html?id=${selectedSupplierId}`;
    } else {
        alert('Please select a supplier to edit.');
    }
}

// Διαγραφή επιλεγμένου προμηθευτή
async function deleteSelectedSupplier() {
    const selectedSupplierId = getSelectedSupplierId();
    if (selectedSupplierId) {
        try {
            const response = await fetch(`http://localhost:8080/api/suppliers/${selectedSupplierId}`, {
                method: 'DELETE'
            });
            if (response.ok) {
                alert('Supplier deleted successfully');
                fetchSuppliers(); // Refresh supplier list
            } else {
                console.error('Failed to delete supplier:', response.statusText);
            }
        } catch (error) {
            console.error('Error deleting supplier:', error);
        }
    } else {
        alert('Please select a supplier to delete.');
    }
}

// Νέος προμηθευτής
function newSupplier() {
    window.location.href = '/newSupplier.html';
}

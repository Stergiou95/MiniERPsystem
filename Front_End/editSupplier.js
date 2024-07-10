document.addEventListener('DOMContentLoaded', async () => {
    const urlParams = new URLSearchParams(window.location.search);
    const supplierId = urlParams.get('id');
    
    if (supplierId) {
        await loadSupplierDetails(supplierId);
    }
    await loadLocations();
});

// Φόρτωση λεπτομερειών προμηθευτή
async function loadSupplierDetails(supplierId) {
    try {
        const response = await fetch(`http://localhost:8080/api/suppliers/${supplierId}`);
        if (response.ok) {
            const supplier = await response.json();
            document.getElementById('companyName').value = supplier.companyName;
            document.getElementById('email').value = supplier.email;
            document.getElementById('location').value = supplier.locationID; // Ρύθμιση του ID τοποθεσίας
        } else {
            console.error('Failed to fetch supplier details:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching supplier details:', error);
    }
}

// Φόρτωση τοποθεσιών
async function loadLocations() {
    try {
        const response = await fetch('http://localhost:8080/api/locations');
        if (response.ok) {
            const locations = await response.json();
            const locationSelect = document.getElementById('location');
            locationSelect.innerHTML = '<option value="">Select a location</option>'; // Προσθήκη αρχικής επιλογής

            locations.forEach(location => {
                const option = document.createElement('option');
                option.value = location.locationID; // Χρησιμοποιούμε το ID για το value
                option.textContent = location.locationName; // Χρησιμοποιούμε το όνομα για εμφάνιση
                locationSelect.appendChild(option);
            });
        } else {
            console.error('Failed to fetch locations:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching locations:', error);
    }
}

// Υποβολή αλλαγών
async function submitEdit() {
    const urlParams = new URLSearchParams(window.location.search);
    const supplierId = urlParams.get('id');

    const companyName = document.getElementById('companyName').value;
    const email = document.getElementById('email').value;
    const locationID = parseInt(document.getElementById('location').value);

    const supplierData = {
        companyName,
        email,
        locationID
    };

    try {
        const response = await fetch(`http://localhost:8080/api/suppliers/${supplierId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(supplierData)
        });

        if (response.ok) {
            alert('Supplier updated successfully!');
            window.location.href = '/supplierManagment.html'; // Redirect to supplier list page
        } else {
            console.error('Failed to update supplier:', response.statusText);
            alert('Failed to update supplier.');
        }
    } catch (error) {
        console.error('Error updating supplier:', error);
        alert('Error updating supplier.');
    }
}

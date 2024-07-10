document.addEventListener('DOMContentLoaded', async () => {
    await loadLocations();
});

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

// Υποβολή νέου προμηθευτή
async function submitNewSupplier() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const locationID = parseInt(document.getElementById('location').value);

    if (!locationID) {
        alert('Please select a location.');
        return;
    }

    const supplierData = {
        name,
        email,
        locationID
    };

    try {
        const response = await fetch('http://localhost:8080/api/suppliers', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(supplierData)
        });

        if (response.ok) {
            alert('Supplier added successfully!');
            window.location.href = '/supplierManagement.html'; // Redirect to supplier list page
        } else {
            console.error('Failed to add supplier:', response.statusText);
            alert('Failed to add supplier.');
        }
    } catch (error) {
        console.error('Error adding supplier:', error);
        alert('Error adding supplier.');
    }
}

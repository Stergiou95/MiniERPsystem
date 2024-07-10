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

// Υποβολή νέου πελάτη
async function submitNewCustomer() {
    const companyName = document.getElementById('companyName').value;
    const email = document.getElementById('email').value;
    const locationID = parseInt(document.getElementById('location').value);

    if (!locationID) {
        alert('Please select a location.');
        return;
    }

    const customerData = {
        companyName,
        email,
        locationID
    };

    try {
        const response = await fetch('http://localhost:8080/api/customers', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(customerData)
        });

        if (response.ok) {
            alert('Customer added successfully!');
            window.location.href = '/customers.html'; // Redirect to customer list page
        } else {
            console.error('Failed to add customer:', response.statusText);
            alert('Failed to add customer.');
        }
    } catch (error) {
        console.error('Error adding customer:', error);
        alert('Error adding customer.');
    }
}

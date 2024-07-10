document.addEventListener('DOMContentLoaded', async () => {
    const urlParams = new URLSearchParams(window.location.search);
    const customerId = urlParams.get('id');
    
    if (customerId) {
        await loadCustomerDetails(customerId);
    }
    await loadLocations();
});

// Φόρτωση λεπτομερειών πελάτη
async function loadCustomerDetails(customerId) {
    try {
        const response = await fetch(`http://localhost:8080/api/customers/${customerId}`);
        if (response.ok) {
            const customer = await response.json();
            document.getElementById('companyName').value = customer.companyName;
            document.getElementById('email').value = customer.email;
            document.getElementById('location').value = customer.location.locationID; // Ρύθμιση του ID τοποθεσίας
        } else {
            console.error('Failed to fetch customer details:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching customer details:', error);
    }
}

// Φόρτωση τοποθεσιών
// async function loadLocations() {
//     try {
//         const response = await fetch('http://localhost:8080/api/locations');
//         if (response.ok) {
//             const locations = await response.json();
//             const locationSelect = document.getElementById('location');
//             locationSelect.innerHTML = '<option value="">Select a location</option>'; // Προσθήκη αρχικής επιλογής
//             locations.forEach(location => {
//                 const option = document.createElement('option');
//                 option.value = location.locationID; // Χρησιμοποιούμε το ID για το value
//                 option.textContent = location.locationName; // Χρησιμοποιούμε το όνομα για εμφάνιση
//                 locationSelect.appendChild(option);
//             });
//         } else {
//             console.error('Failed to fetch locations:', response.statusText);
//         }
//     } catch (error) {
//         console.error('Error fetching locations:', error);
//     }
// }


async function loadLocations() {
    try {
        const response = await fetch('http://localhost:8080/api/locations');
        if (response.ok) {
            const locations = await response.json();
            console.log('Fetched locations:', locations); // Debugging

            displayLocations(locations);
        } else {
            console.error('Failed to fetch locations:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching locations:', error);
    }
}

function displayLocations(locations) {
    const locationSelect = document.getElementById('location');
    locationSelect.innerHTML = '<option value="">Select a location</option>'; // Προσθήκη αρχικής επιλογής

    locations.forEach(location => {
        console.log('Adding location:', location.locationName); // Debugging
        const option = document.createElement('option');
        option.value = location.locationID;
        option.textContent = location.locationName;
        locationSelect.appendChild(option);
    });
}


// Υποβολή αλλαγών
async function submitEdit() {
    const urlParams = new URLSearchParams(window.location.search);
    const customerId = urlParams.get('id');

    const companyName = document.getElementById('companyName').value;
    const email = document.getElementById('email').value;
    const locationID = parseInt(document.getElementById('location').value);

    const customerData = {
        companyName,
        email,
        locationID
    };

    try {
        const response = await fetch(`http://localhost:8080/api/customers/${customerId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(customerData)
        });

        if (response.ok) {
            alert('Customer updated successfully!');
            window.location.href = '/customer.html'; // Redirect to customer list page
        } else {
            console.error('Failed to update customer:', response.statusText);
            alert('Failed to update customer.');
        }
    } catch (error) {
        console.error('Error updating customer:', error);
        alert('Error updating customer.');
    }
}

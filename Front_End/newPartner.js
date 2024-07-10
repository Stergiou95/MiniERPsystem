document.addEventListener('DOMContentLoaded', async () => {
    await loadLocations();
});

// Load locations for the dropdown
async function loadLocations() {
    try {
        const response = await fetch('http://localhost:8080/api/locations');
        if (response.ok) {
            const locations = await response.json();
            const locationSelect = document.getElementById('location');
            locationSelect.innerHTML = '<option value="">Select a location</option>';
            locations.forEach(location => {
                const option = document.createElement('option');
                option.value = location.locationID;
                option.textContent = location.locationName;
                locationSelect.appendChild(option);
            });
        } else {
            console.error('Failed to fetch locations:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching locations:', error);
    }
}

// Submit new partner
async function submitNewPartner() {
    const companyName = document.getElementById('companyName').value;
    const email = document.getElementById('email').value;
    const locationID = parseInt(document.getElementById('location').value);

    const partnerData = {
        companyName,
        email,
        locationID
    };

    try {
        const response = await fetch('http://localhost:8080/api/partners', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(partnerData)
        });

        if (response.ok) {
            alert('Partner added successfully!');
            window.location.href = '/partnerManagement.html';
        } else {
            console.error('Failed to add partner:', response.statusText);
            alert('Failed to add partner.');
        }
    } catch (error) {
        console.error('Error adding partner:', error);
        alert('Error adding partner.');
    }
}

document.addEventListener('DOMContentLoaded', async () => {
    const urlParams = new URLSearchParams(window.location.search);
    const partnerId = urlParams.get('id');
    
    if (partnerId) {
        await loadPartnerDetails(partnerId);
    }
    await loadLocations();
});

// Load partner details
async function loadPartnerDetails(partnerId) {
    try {
        const response = await fetch(`http://localhost:8080/api/partners/${partnerId}`);
        if (response.ok) {
            const partner = await response.json();
            document.getElementById('companyName').value = partner.companyName;
            document.getElementById('email').value = partner.email;
            document.getElementById('location').value = partner.locationID;
        } else {
            console.error('Failed to fetch partner details:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching partner details:', error);
    }
}

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

// Submit edited partner
async function submitEditPartner() {
    const urlParams = new URLSearchParams(window.location.search);
    const partnerId = urlParams.get('id');

    const companyName = document.getElementById('companyName').value;
    const email = document.getElementById('email').value;
    const locationID = parseInt(document.getElementById('location').value);

    const partnerData = {
        companyName,
        email,
        locationID
    };

    try {
        const response = await fetch(`http://localhost:8080/api/partners/${partnerId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(partnerData)
        });

        if (response.ok) {
            alert('Partner updated successfully!');
            window.location.href = '/partnerManagement.html';
        } else {
            console.error('Failed to update partner:', response.statusText);
            alert('Failed to update partner.');
        }
    } catch (error) {
        console.error('Error updating partner:', error);
        alert('Error updating partner.');
    }
}

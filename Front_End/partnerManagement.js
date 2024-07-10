document.addEventListener('DOMContentLoaded', async () => {
    await fetchPartners();
    $('#partnerTable').DataTable({
        fixedHeader: true
    });
});

// Fetch partners from server
async function fetchPartners() {
    try {
        const response = await fetch('http://localhost:8080/api/partners');
        if (response.ok) {
            const partners = await response.json();
            displayPartners(partners);
        } else {
            console.error('Failed to fetch partners:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching partners:', error);
    }
}

// Display partners in a table
function displayPartners(partners) {
    const partnerList = document.getElementById('partnerList');
    partnerList.innerHTML = '';

    partners.forEach(partner => {
        const row = document.createElement('tr');
        row.dataset.partnerId = partner.partnerID;
        row.innerHTML = `
            <td>${partner.partnerID}</td>
            <td>${partner.companyName}</td>
            <td>${partner.email}</td>
            <td>${partner.locationName}</td>
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

        partnerList.appendChild(row);
    });
}

// Get selected partner ID
function getSelectedPartnerId() {
    const selectedRow = document.querySelector('tr.selected');
    return selectedRow ? selectedRow.dataset.partnerId : null;
}

// Edit selected partner
function editSelectedPartner() {
    const selectedPartnerId = getSelectedPartnerId();
    if (selectedPartnerId) {
        window.location.href = `/editPartner.html?id=${selectedPartnerId}`;
    } else {
        alert('Please select a partner to edit.');
    }
}

// Delete selected partner
async function deleteSelectedPartner() {
    const selectedPartnerId = getSelectedPartnerId();
    if (selectedPartnerId) {
        try {
            const response = await fetch(`http://localhost:8080/api/partners/${selectedPartnerId}`, {
                method: 'DELETE'
            });
            if (response.ok) {
                alert('Partner deleted successfully');
                fetchPartners();
            } else {
                console.error('Failed to delete partner:', response.statusText);
            }
        } catch (error) {
            console.error('Error deleting partner:', error);
        }
    } else {
        alert('Please select a partner to delete.');
    }
}

// New partner
function newPartner() {
    window.location.href = '/newPartner.html';
}

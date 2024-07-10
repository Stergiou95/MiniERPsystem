document.addEventListener('DOMContentLoaded', async () => {
    const urlParams = new URLSearchParams(window.location.search);
    const rawMaterialId = urlParams.get('id');
    
    if (rawMaterialId) {
        await loadRawMaterialDetails(rawMaterialId);
    }
});

// Load raw material details
async function loadRawMaterialDetails(rawMaterialId) {
    try {
        const response = await fetch(`http://localhost:8080/api/rawMaterials/${rawMaterialId}`);
        if (response.ok) {
            const rawMaterial = await response.json();
            document.getElementById('rawMaterialName').value = rawMaterial.rawMaterialName;
            document.getElementById('rawMaterialDescription').value = rawMaterial.rawMaterialDescription;
            document.getElementById('totalStockedQuantity').value = rawMaterial.totalStockedQuantity; // Set total stocked quantity
        } else {
            console.error('Failed to fetch raw material details:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching raw material details:', error);
    }
}

// Submit edited raw material
async function submitEdit() {
    const urlParams = new URLSearchParams(window.location.search);
    const rawMaterialId = urlParams.get('id');

    const rawMaterialName = document.getElementById('rawMaterialName').value;
    const rawMaterialDescription = document.getElementById('rawMaterialDescription').value;

    const rawMaterialData = {
        rawMaterialName,
        rawMaterialDescription
    };

    try {
        const response = await fetch(`http://localhost:8080/api/rawMaterials/${rawMaterialId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(rawMaterialData)
        });

        if (response.ok) {
            alert('Raw material updated successfully!');
            window.location.href = '/rawMaterialManagement.html'; // Redirect to raw material list page
        } else {
            console.error('Failed to update raw material:', response.statusText);
            alert('Failed to update raw material.');
        }
    } catch (error) {
        console.error('Error updating raw material:', error);
        alert('Error updating raw material.');
    }
}

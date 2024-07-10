const rawMaterialList = document.getElementById('rawMaterialList');

// Display raw materials in a table
function displayRawMaterials(rawMaterials) {
    rawMaterialList.innerHTML = '';

    rawMaterials.forEach(rawMaterial => {
        const row = document.createElement('tr');
        row.dataset.rawMaterialId = rawMaterial.rawMatID; // Add data attribute for rawMatID
        row.innerHTML = `
            <td>${rawMaterial.rawMatID}</td>
            <td>${rawMaterial.rawMaterialName}</td>
            <td>${rawMaterial.rawMaterialDescription}</td>
            <td>${rawMaterial.totalStockedQuantity}</td>
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

        rawMaterialList.appendChild(row);
    });

    // Initialize DataTables
    $('#rawMaterialTable').DataTable({
        destroy: true, // Ensure it initializes correctly on subsequent loads
        fixedHeader: true
    });
}

// Fetch raw materials from server
async function fetchRawMaterials() {
    try {
        const response = await fetch('http://localhost:8080/api/rawMaterials');
        if (response.ok) {
            const rawMaterials = await response.json();
            displayRawMaterials(rawMaterials);
        } else {
            console.error('Failed to fetch raw materials:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching raw materials:', error);
    }
}

// Function to get selected raw material ID
function getSelectedRawMaterialId() {
    const selectedRow = document.querySelector('tr.selected');
    return selectedRow ? selectedRow.dataset.rawMaterialId : null;
}

// Edit selected raw material
function editSelectedRawMaterial() {
    const selectedRawMaterialId = getSelectedRawMaterialId();
    if (selectedRawMaterialId) {
        // Redirect to edit page
        window.location.href = `/editRawMaterial.html?id=${selectedRawMaterialId}`;
    } else {
        alert('Please select a raw material to edit.');
    }
}

// Delete selected raw material
async function deleteSelectedRawMaterial() {
    const selectedRawMaterialId = getSelectedRawMaterialId();
    if (selectedRawMaterialId) {
        try {
            const response = await fetch(`http://localhost:8080/api/rawMaterials/${selectedRawMaterialId}`, {
                method: 'DELETE'
            });
            if (response.ok) {
                alert('Raw material deleted successfully');
                fetchRawMaterials(); // Refresh raw material list
            } else {
                console.error('Failed to delete raw material:', response.statusText);
            }
        } catch (error) {
            console.error('Error deleting raw material:', error);
        }
    } else {
        alert('Please select a raw material to delete.');
    }
}

// New raw material
function newRawMaterial() {
    window.location.href = '/newRawMaterial.html';
}

// Fetch raw materials on page load
fetchRawMaterials();

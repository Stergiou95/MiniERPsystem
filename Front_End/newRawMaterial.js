async function submitNewRawMaterial() {
    const rawMaterialName = document.getElementById('rawMaterialName').value;
    const rawMaterialDescription = document.getElementById('rawMaterialDescription').value;

    const rawMaterialData = {
        rawMaterialName,
        rawMaterialDescription
    };

    try {
        const response = await fetch('http://localhost:8080/api/rawMaterials', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(rawMaterialData)
        });

        if (response.ok) {
            alert('Raw material added successfully!');
            window.location.href = '/rawMaterialManagement.html';
        } else {
            console.error('Failed to add raw material:', response.statusText);
            alert('Failed to add raw material.');
        }
    } catch (error) {
        console.error('Error adding raw material:', error);
        alert('Error adding raw material.');
    }
}

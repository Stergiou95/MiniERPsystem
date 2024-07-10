document.addEventListener('DOMContentLoaded', async () => {
    await loadSuppliers();
});

let cart = [];

async function loadSuppliers() {
    try {
        const response = await fetch('http://localhost:8080/api/suppliers');
        if (response.ok) {
            const suppliers = await response.json();
            const supplierSelect = document.getElementById('supplier');
            supplierSelect.innerHTML = '<option value="">Select a supplier</option>';

            suppliers.forEach(supplier => {
                const option = document.createElement('option');
                option.value = supplier.supplierID;
                option.textContent = supplier.companyName;
                supplierSelect.appendChild(option);
            });

            supplierSelect.addEventListener('change', loadRawMaterials);
        } else {
            console.error('Failed to fetch suppliers:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching suppliers:', error);
    }
}

async function loadRawMaterials() {
    const supplierID = document.getElementById('supplier').value;
    if (!supplierID) {
        document.getElementById('rawMaterial').innerHTML = '<option value="">Select a raw material</option>';
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/api/supplierRawMaterials/bySupplier/${supplierID}`);
        if (response.ok) {
            const rawMaterials = await response.json();
            const rawMaterialSelect = document.getElementById('rawMaterial');
            rawMaterialSelect.innerHTML = '<option value="">Select a raw material</option>';

            rawMaterials.forEach(rawMaterial => {
                const option = document.createElement('option');
                option.value = rawMaterial.rawMatID;
                option.textContent = rawMaterial.rawMaterialName;
                rawMaterialSelect.appendChild(option);
            });
        } else {
            console.error('Failed to fetch raw materials:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching raw materials:', error);
    }
}

function addRawMaterial() {
    const rawMaterialSelect = document.getElementById('rawMaterial');
    const quantityInput = document.getElementById('quantity');

    const rawMatID = parseInt(rawMaterialSelect.value);
    const rawMaterialName = rawMaterialSelect.options[rawMaterialSelect.selectedIndex].text;
    const quantity = parseInt(quantityInput.value);

    if (isNaN(rawMatID) || rawMatID <= 0) {
        alert('Please select a raw material.');
        return;
    }
    if (isNaN(quantity) || quantity <= 0) {
        alert('Please enter a valid quantity.');
        return;
    }

    const existingRawMaterial = cart.find(item => item.rawMatID === rawMatID);
    if (existingRawMaterial) {
        existingRawMaterial.quantity += quantity;
    } else {
        cart.push({ rawMatID, rawMaterialName, quantity });
    }

    updateRawMaterialTable();
}

function updateRawMaterialTable() {
    const rawMaterialList = document.getElementById('rawMaterialList');
    rawMaterialList.innerHTML = '';

    cart.forEach((item, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${item.rawMaterialName}</td>
            <td>${item.quantity}</td>
            <td><button type="button" onclick="removeRawMaterial(${index})">Remove</button></td>
        `;
        rawMaterialList.appendChild(row);
    });
}

function removeRawMaterial(index) {
    cart.splice(index, 1);
    updateRawMaterialTable();
}

async function submitNewOrder() {
    const supplierID = parseInt(document.getElementById('supplier').value);
    console.log("Selected Supplier ID:", supplierID);
    console.log("Cart:", cart);

    if (!supplierID || cart.length === 0) {
        alert('Please fill out all fields and add at least one raw material.');
        return;
    }

    const orderData = {
        rmorderID: null,
        supplierID: supplierID,
        supplierName: document.getElementById('supplier').options[document.getElementById('supplier').selectedIndex].text,
        rawMaterialsDetails: cart.map(item => ({
            rawMaterialID: item.rawMatID,
            rawMaterialName: item.rawMaterialName,
            units: item.quantity,
            pricePerUnit: 0, // Δεδομένου ότι δεν έχουμε αυτή την πληροφορία, βάλτε 0 ή κατάλληλη τιμή
            totalCost: 0 // Υπολογίστε την κατάλληλη τιμή αν είναι διαθέσιμη
        })),
        dateOrderRmatStatusChanged: null,
        totalCost: 0, // Υπολογίστε την κατάλληλη τιμή αν είναι διαθέσιμη
        currentStatus: "Ordered",
        statusHistory: [
            {
                statusID: 1,
                statusName: "Ordered",
                rmorderID: null,
                dateOfStatusChange: new Date().toISOString()
            }
        ]
    };

    console.log("Order Data to be sent:", orderData);

    try {
        const response = await fetch('http://localhost:8080/api/rawMaterialOrders', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(orderData)
        });

        if (response.ok) {
            alert('Order created successfully!');
            window.location.href = '/ordersForRawMaterialsManagement.html';
        } else {
            const errorText = await response.text();
            console.error('Failed to create order:', response.statusText, errorText);
            alert('Failed to create order. ' + errorText);
        }
    } catch (error) {
        console.error('Error creating order:', error);
        alert('Error creating order.');
    }
}

document.addEventListener('DOMContentLoaded', async () => {
    await loadRoles();
});

// Load roles for the dropdown
async function loadRoles() {
    try {
        const response = await fetch('http://localhost:8080/api/roles');
        if (response.ok) {
            const roles = await response.json();
            const roleSelect = document.getElementById('role');
            roleSelect.innerHTML = '<option value="">Select a role</option>';
            roles.forEach(role => {
                const option = document.createElement('option');
                option.value = role.roleID;
                option.textContent = role.roleName;
                roleSelect.appendChild(option);
            });
        } else {
            console.error('Failed to fetch roles:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching roles:', error);
    }
}

// Submit new member
async function submitNewMember() {
    const firstname = document.getElementById('firstName').value;
    const lastname = document.getElementById('lastName').value;
    const roleID = parseInt(document.getElementById('role').value);

    const memberData = {
        firstname,
        lastname,
        roleID
    };

    try {
        const response = await fetch('http://localhost:8080/api/members', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(memberData)
        });

        if (response.ok) {
            alert('Member added successfully!');
            window.location.href = '/memberManagement.html';
        } else {
            console.error('Failed to add member:', response.statusText);
            alert('Failed to add member.');
        }
    } catch (error) {
        console.error('Error adding member:', error);
        alert('Error adding member.');
    }
}

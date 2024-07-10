document.addEventListener('DOMContentLoaded', async () => {
    const urlParams = new URLSearchParams(window.location.search);
    const memberId = urlParams.get('id');
    
    if (memberId) {
        await loadMemberDetails(memberId);
    }
    await loadRoles();
});

// Load member details
async function loadMemberDetails(memberId) {
    try {
        const response = await fetch(`http://localhost:8080/api/members/${memberId}`);
        if (response.ok) {
            const member = await response.json();
            document.getElementById('firstName').value = member.firstname;
            document.getElementById('lastName').value = member.lastname;
            document.getElementById('role').value = member.roleName; // Set role ID
        } else {
            console.error('Failed to fetch member details:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching member details:', error);
    }
}

// Load roles for the dropdown
async function loadRoles() {
    try {
        const response = await fetch('http://localhost:8080/api/roles');
        if (response.ok) {
            const roles = await response.json();
            console.log('fetched roles: ', roles);

            displayRoles(roles);
        } else {
            console.error('Failed to fetch roles:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching roles:', error);
    }
}

function displayRoles(roles) {
    const roleSelect = document.getElementById('role');
    roleSelect.innerHTML = '<option value="">Select a role</option>'; // Προσθήκη αρχικής επιλογής

    roles.forEach(role => {
        console.log('Adding role:', role.roleName); // Debugging
        const option = document.createElement('option');
        option.value = role.roleID;
        option.textContent = role.roleName;
        roleSelect.appendChild(option);
    });
}


// Submit changes
async function submitEdit() {
    const urlParams = new URLSearchParams(window.location.search);
    const memberId = urlParams.get('id');

    const firstname = document.getElementById('firstName').value;
    const lastname = document.getElementById('lastName').value;
    const roleID = parseInt(document.getElementById('role').value);

    const memberData = {
        firstname,
        lastname,
        roleID
    };

    try {
        const response = await fetch(`http://localhost:8080/api/members/${memberId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(memberData)
        });

        if (response.ok) {
            alert('Member updated successfully!');
            window.location.href = '/memberManagement.html'; // Redirect to member list page
        } else {
            console.error('Failed to update member:', response.statusText);
            alert('Failed to update member.');
        }
    } catch (error) {
        console.error('Error updating member:', error);
        alert('Error updating member.');
    }
}

const memberList = document.getElementById('memberList');

// Display members in a table
function displayMembers(members) {
    memberList.innerHTML = '';

    members.forEach(member => {
        const row = document.createElement('tr');
        row.dataset.memberId = member.memberID; // Add data attribute for memberID
        row.innerHTML = `
            <td>${member.memberID}</td>
            <td>${member.firstname}</td>
            <td>${member.lastname}</td>
            <td>${member.roleName}</td>
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

        memberList.appendChild(row);
    });

    $('#memberTable').DataTable({
        fixedHeader: true,
        searching: false // Hide the search box
    });
}

// Fetch members from server
async function fetchMembers() {
    try {
        const response = await fetch('http://localhost:8080/api/members');
        if (response.ok) {
            const members = await response.json();
            displayMembers(members);
        } else {
            console.error('Failed to fetch members:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching members:', error);
    }
}

// Function to get selected member ID
function getSelectedMemberId() {
    const selectedRow = document.querySelector('tr.selected');
    return selectedRow ? selectedRow.dataset.memberId : null;
}

// Edit selected member
function editSelectedMember() {
    const selectedMemberId = getSelectedMemberId();
    if (selectedMemberId) {
        // Redirect to edit page or show edit form
        window.location.href = `/editMember.html?id=${selectedMemberId}`;
    } else {
        alert('Please select a member to edit.');
    }
}

// Delete selected member
async function deleteSelectedMember() {
    const selectedMemberId = getSelectedMemberId();
    if (selectedMemberId) {
        try {
            const response = await fetch(`http://localhost:8080/api/members/${selectedMemberId}`, {
                method: 'DELETE'
            });
            if (response.ok) {
                alert('Member deleted successfully');
                fetchMembers(); // Refresh member list
            } else {
                console.error('Failed to delete member:', response.statusText);
            }
        } catch (error) {
            console.error('Error deleting member:', error);
        }
    } else {
        alert('Please select a member to delete.');
    }
}

// New member
function newMember() {
    window.location.href = '/newMember.html';
}


// Fetch members on page load
fetchMembers();

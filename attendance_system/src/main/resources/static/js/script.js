const apiUrl = "/api/notifications";

// Fetch and display notifications
async function fetchNotifications() {
    const response = await fetch(apiUrl);
    const notifications = await response.json();
    const tableBody = document.getElementById("notificationsTable");
    tableBody.innerHTML = ""; // Clear the table

    notifications.forEach(notification => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${notification.id}</td>
            <td>${notification.headline}</td>
            <td>${notification.description}</td>
            <td>
                <button onclick="editNotification(${notification.id})">Edit</button>
                <button onclick="deleteNotification(${notification.id})">Delete</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

// Save notification (Create/Update)
document.getElementById("notificationForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const id = document.getElementById("notificationId").value;
    const headline = document.getElementById("headline").value;
    const description = document.getElementById("description").value;

    const method = id ? "PUT" : "POST";
    const url = id ? `${apiUrl}/${id}` : apiUrl;

    await fetch(url, {
        method,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ headline, description })
    });

    document.getElementById("notificationForm").reset(); // Clear the form
    fetchNotifications(); // Refresh the table
});

// Edit notification
async function editNotification(id) {
    const response = await fetch(`${apiUrl}/${id}`);
    const notification = await response.json();

    document.getElementById("notificationId").value = notification.id;
    document.getElementById("headline").value = notification.headline;
    document.getElementById("description").value = notification.description;
}

// Delete notification
async function deleteNotification(id) {
    await fetch(`${apiUrl}/${id}`, { method: "DELETE" });
    fetchNotifications(); // Refresh the table
}

// Call fetchNotifications on page load
fetchNotifications();

// Logout button functionality (if needed)
function logout() {
    alert("Logged out!");
    // Redirect to login or other actions
}

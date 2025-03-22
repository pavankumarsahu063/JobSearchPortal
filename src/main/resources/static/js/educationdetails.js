
document.getElementById("educationForm").addEventListener("submit",async function submitForm(e) {
    e.preventDefault(); // Prevent default form submission

    let formdata = {
		
		    userId: document.getElementById("currentUserId").value, // ✅ Corrected field name
		    degree: document.getElementById("degree").value,
		    institution: document.getElementById("institution").value,
		    fieldOfStudy: document.getElementById("fieldOfStudy").value,
		    startYear: document.getElementById("startYear").value,
		    endYear: document.getElementById("endYear").value,
		    grade: document.getElementById("grade").value
	

    };

    console.log("Sending data:", formdata);

    try {
		const response = await fetch("http://localhost:8080/student/education/add", {

			method: "POST",
			        headers: {
			            "Content-Type": "application/json"
			        },
			        body: JSON.stringify(formdata)

        });

        if (response.ok) {
            alert("Education added successfully!");
            document.getElementById("educationForm").reset();
        } else {
            alert("Error adding education.");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("An error occurred while submitting the form.");
    }
});


document.addEventListener("DOMContentLoaded", function() {
    fetch("./courses.json") 
    .then(response => response.json())
    .then(data => {
        console.log(data);
        let courseList = document.getElementById("courses-list");

        function displayCourses(courses) {
            courseList.innerHTML = "";
            courses.forEach(course => {
                let div = document.createElement("div");
                div.classList.add("course-card");
                div.innerHTML = `
                    <img src="${course.image}" alt="${course.title}">
                    <h3>${course.title}</h3>
                    <p>${course.description}</p>
                    <a href="enrollment.html?course=${encodeURIComponent(course.title)}" class="btn">Enroll Now</a>
                `;
                courseList.appendChild(div);
            });
        }

        displayCourses(data.courses);


        document.getElementById("search").addEventListener("input", function(e) {
            let searchTerm = e.target.value.toLowerCase();
            let filteredCourses = data.courses.filter(course =>
                course.title.toLowerCase().includes(searchTerm)
            );
            displayCourses(filteredCourses);
        });
    });
});    
;

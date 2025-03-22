document.addEventListener("DOMContentLoaded", function () {
    const burger = document.querySelector(".burger");
    const navLinks = document.querySelector(".nav-links");

    if (burger && navLinks) {
        burger.addEventListener("click", () => {
            navLinks.classList.toggle("nav-active");
        });
    }

    document.querySelectorAll(".main-btns").forEach(button => {
        button.addEventListener("click", () => {
            alert("Please login");
        });
    });
});

const DEFAULT_USERNAME = "admin";
const DEFAULT_PASSWORD = "123456";
function login() {
    openLoginModal()
}
function openLoginModal() {
    let modal = document.getElementById("login-modal");
    modal.style.display = "block";
}
function closeLoginModal() {
    let modal = document.getElementById("login-modal");
    modal.style.display = "none";
}
function validateLogin() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if (username === DEFAULT_USERNAME && password === DEFAULT_PASSWORD) {
        document.getElementById("user").innerHTML = 'Admin';
        let buttons = document.querySelectorAll('.modify-btn');
        for (let btn of buttons) {
            btn.classList.remove('hidden');
        }
        closeLoginModal();
    }
}
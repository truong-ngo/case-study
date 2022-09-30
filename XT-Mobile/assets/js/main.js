// Slider
let index = 0;
carousel();

function carousel() {
    let x = document.getElementsByClassName("sliders");
    for (let i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    index++;
    if (index > x.length) {index = 1}
    x[index-1].style.display = "block";
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
// Dropdown click menu
function showSubMenu(id) {
    let x = document.getElementById(id);
    if (x.className.indexOf("sub-menu-show") === -1) {
        x.className += " sub-menu-show";
    } else {
        x.className = x.className.replace(" sub-menu-show", "");
    }
}

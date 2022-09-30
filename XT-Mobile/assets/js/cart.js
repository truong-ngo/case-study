function addToCart(i,brand) {
    document.getElementById("cart-container").innerHTML = '';
    switch (brand) {
        case "iPhone":
            cart.push(iPhoneArr[i]);
            break;
        case "Samsung":
            cart.push(samsungPhoneArr[i]);
            break;
        case "Pixel":
            cart.push(pixelPhoneArr[i]);
            break;
        case "iPad":
            cart.push(iPadArr[i]);
            break;
        case "Galaxy-Tab":
            cart.push(GalaxyTabArr[i]);
    }
    displayCart(cart)
    if (cart.length >=1 ) {
        document.getElementById("cart-number").innerHTML = cart.length.toString();
        document.getElementById("cart-number").style.display = "block";
    } else {
        document.getElementById("cart-number").style.display = "none";
    }
}
function displayCart(cart) {
    let htmlData = '<div class="container">';
    for (let i = 0; i < cart.length; i++) {
        htmlData += `<div class="product-box">`
        htmlData += `<div class="cart-image"><img src="${cart[i].getImage()}" alt="product"></div>`
        htmlData += `<div class="product-desc"><p class="name">${cart[i].getName()}</p><p class="price">${convertPrice(cart[i].getPrice())}</p></div>`
        htmlData += `<div class="remove-product"><button onclick="removeProduct(${i})"><i class="fa-solid fa-trash"></i></button></div>`
        htmlData += `</div>`;
    }
    function sum(cart) {
        let sum = cart[0].getPrice();
        for (let i = 1; i < cart.length; i++) {
            sum += cart[i].getPrice();
        }
        return sum;
    }
    htmlData += `<div class="product-box"><div class="cart-image"></div><div class="product-desc bold">Tổng chi phí</div><div class="remove-product bold">${convertPrice(sum(cart))}</div></div>`
    document.getElementById("cart-container").innerHTML = htmlData;
}
function clearCart() {
    document.getElementById("cart-container").innerHTML = '';
    document.getElementById("cart-number").innerHTML = '';
    document.getElementById("cart-number").style.display = "none";
    cart = [];
}
function removeProduct(i) {
    if (cart.length === 1) {
        clearCart();
    }
    cart.splice(i,1);
    displayCart(cart);
}
function openCartModal() {
    let modal = document.getElementById("cart-modal");
    modal.style.display = "block";
}
function closeCartModal() {
    let modal = document.getElementById("cart-modal");
    modal.style.display = "none";
}
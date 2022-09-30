function displayProduct(arrayProduct) {
    let dataHtml = '';
    if (document.getElementById("user").innerHTML === 'Admin') {
        for (let i = 0; i < arrayProduct.length; i++) {
            dataHtml += '<div class="product-item">';
            dataHtml += `<div class="product-cart" id="addProductToCart(${i},'${arrayProduct[i].getBrand()}')"><button><i class="fa-solid fa-cart-shopping"></i></button></div>`
            dataHtml += `<div class="image-container"><img class="product-image" alt="Product Image" src=${arrayProduct[i].getImage()}></div>`;
            dataHtml += `<p class="product-name">${arrayProduct[i].getName()}</p>`;
            dataHtml += `<p class="product-price">${convertPrice(arrayProduct[i].getPrice())} VNĐ</p>`;
            dataHtml += `<button onclick="editProduct(${i},'${arrayProduct[i].getBrand()}')" class="modify-btn" id="edit-${arrayProduct[i].getBrand()}-${i}">Sửa</button>`;
            dataHtml += `<button onclick="deleteProduct(${i},'${arrayProduct[i].getBrand()}')" class="modify-btn" id="delete-${arrayProduct[i].getBrand()}-${i}">Xóa</button>`;
            dataHtml += `</div>`
        }
    } else {
        for (let i = 0; i < arrayProduct.length; i++) {
            dataHtml += '<div class="product-item">';
            dataHtml += `<div class="product-cart" id="addProductToCart(${i},'${arrayProduct[i].getBrand()}')"><button><i class="fa-solid fa-cart-shopping"></i></button></div>`
            dataHtml += `<div class="image-container"><img class="product-image" alt="Product Image" src=${arrayProduct[i].getImage()}></div>`;
            dataHtml += `<p class="product-name">${arrayProduct[i].getName()}</p>`;
            dataHtml += `<p class="product-price">${convertPrice(arrayProduct[i].getPrice())} VNĐ</p>`;
            dataHtml += `<button onclick="editProduct(${i},'${arrayProduct[i].getBrand()}')" class="modify-btn hidden" id="edit-${arrayProduct[i].getBrand()}-${i}">Sửa</button>`;
            dataHtml += `<button onclick="deleteProduct(${i},'${arrayProduct[i].getBrand()}')" class="modify-btn hidden" id="delete-${arrayProduct[i].getBrand()}-${i}">Xóa</button>`;
            dataHtml += `</div>`
        }
    }
    document.getElementById("content-box").innerHTML = dataHtml;
}
function displayIPhone() {
    displayProduct(iPhoneArr);
}
function displaySamsung() {
    displayProduct(samsungPhoneArr);
}
function displayPixel() {
    displayProduct(pixelPhoneArr);
}
function displayIpad() {
    displayProduct(iPadArr);
}
function displayGalaxyTab() {
    displayProduct(GalaxyTabArr);
}
function convertPrice(price) {
    let int = (price/1000000).toFixed(3);
    let result = int + '.000';
    return result;
}
function displayProduct(arrayProduct) {
    let dataHtml = '';
    for (let i = 0; i < arrayProduct.length; i++) {
        dataHtml += '<div class="product-item">';
        dataHtml += `<div class="image-container"><img class="product-image" src=${arrayProduct[i].getImage()}></div>`;
        dataHtml += `<p class="product-name">${arrayProduct[i].getName()}</p>`;
        dataHtml += `<p class="product-price">${arrayProduct[i].getPrice()} VNĐ</p>`;
        dataHtml += `<button onclick="editProduct(${i},'${arrayProduct[i].getBrand()}')" class="modify-btn" id="edit-${arrayProduct[i].getBrand()}-${i}">Sửa</button>`;
        dataHtml += `<button onclick="deleteProduct(${i},'${arrayProduct[i].getBrand()}')" class="modify-btn" id="delete-${arrayProduct[i].getBrand()}-${i}">Xóa</button>`;
        dataHtml += `</div>`
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
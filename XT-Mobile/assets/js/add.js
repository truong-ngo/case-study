function addProduct() {
    openAddModal();
}
function openAddModal() {
    let modal = document.getElementById("add-modal");
    modal.style.display = "block";
}
function closeAddModal() {
    let modal = document.getElementById("add-modal");
    modal.style.display = "none";
}
function addModal() {
    let addName = document.getElementById("add-name").value;
    let addBrand = document.getElementById("add-brand").value;
    let addCategory = document.getElementById("add-category").value;
    let addPrice = document.getElementById("add-price").value;
    let addImage = document.getElementById("add-image").value;
    if (addName === '' || addPrice === '' || addBrand === '' || addCategory === '' || addImage === '') {
        alert("Vui lòng nhập đầy đủ thông tin");
        return;
    } else {
        switch (addBrand) {
            case "iPhone":
                let newIphone = new Product(addName,addCategory,addBrand,addPrice,addImage)
                iPhoneArr.push(newIphone);
                break;
            case "Samsung":
                let newSamsungPhone = new Product(addName,addCategory,addBrand,addPrice,addImage)
                samsungPhoneArr.push(newSamsungPhone);
                break;
            case "Pixel":
                let newPixelPhone = new Product(addName,addCategory,addBrand,addPrice,addImage)
                pixelPhoneArr.push(newPixelPhone);
                break;
            case "iPad":
                let newIpad = new Product(addName,addCategory,addBrand,addPrice,addImage)
                iPadArr.push(newIpad);
                break;
            case "Galaxy-Tab":
                let newTab = new Product(addName,addCategory,addBrand,addPrice,addImage)
                GalaxyTabArr.push(newTab);
        }
        reDisplay(editBrandOut);
        closeAddModal();
    }
}


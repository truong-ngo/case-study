let editIndex = 0;
let editBrandOut = 0;
function editProduct(i,brand) {
    editIndex = i;
    editBrandOut = brand;
    console.log(i)
    console.log(brand)
    openEditModal();
    displayEditValue (i,brand)
}
function openEditModal() {
    let modal = document.getElementById("edit-modal");
    modal.style.display = "block";
}
function closeEditModal() {
    let modal = document.getElementById("edit-modal");
    modal.style.display = "none";
}
function displayEditValue (i,brand) {
    let editName = 0;
    let editBrand = 0;
    let editCategory = 0;
    let editPrice = 0;
    let editImage = 0;
    switch (brand) {
        case "iPhone":
            editName = iPhoneArr[i].getName();
            editPrice = iPhoneArr[i].getPrice();
            editBrand = iPhoneArr[i].getBrand();
            editCategory = iPhoneArr[i].getCategory();
            editImage = iPhoneArr[i].getImage();
            break;
        case "Samsung":
            editName = samsungPhoneArr[i].getName();
            editPrice = samsungPhoneArr[i].getPrice();
            editBrand = samsungPhoneArr[i].getBrand();
            editCategory = samsungPhoneArr[i].getCategory();
            editImage = samsungPhoneArr[i].getImage();
            break;
        case "Pixel":
            editName = pixelPhoneArr[i].getName();
            editPrice = pixelPhoneArr[i].getPrice();
            editBrand = pixelPhoneArr[i].getBrand();
            editCategory = pixelPhoneArr[i].getCategory();
            editImage = pixelPhoneArr[i].getImage();
            break;
        case "iPad":
            editName = iPadArr[i].getName();
            editPrice = iPadArr[i].getPrice();
            editBrand = iPadArr[i].getBrand();
            editCategory = iPadArr[i].getCategory();
            editImage = iPadArr[i].getImage();
            break;
        case "Galaxy-Tab":
            editName = GalaxyTabArr[editIndex].setName();
            editPrice = GalaxyTabArr[editIndex].setPrice();
            editBrand = GalaxyTabArr[editIndex].setBrand();
            editCategory = GalaxyTabArr[editIndex].setCategory();
            editImage = GalaxyTabArr[editIndex].setImage();
    }
    document.getElementById("edit-name").value = editName;
    document.getElementById("edit-brand").value = editBrand;
    document.getElementById("edit-category").value = editCategory;
    document.getElementById("edit-price").value = editPrice;
    document.getElementById("edit-image").value = editImage;
}
function editModal() {
    let editName = document.getElementById("edit-name").value;
    let editBrand = document.getElementById("edit-brand").value;
    let editCategory = document.getElementById("edit-category").value;
    let editPrice = document.getElementById("edit-price").value;
    let editImage = document.getElementById("edit-image").value;
    if (editName === '' || editPrice === '' || editBrand === '' || editCategory === '' || editImage === '') {
        alert("Vui lòng nhập đầy đủ thông tin");
        return;
    } else {
        switch (editBrandOut) {
            case "iPhone":
                iPhoneArr[editIndex].setName(editName);
                iPhoneArr[editIndex].setPrice(editPrice);
                iPhoneArr[editIndex].setBrand(editBrand);
                iPhoneArr[editIndex].setCategory(editCategory);
                iPhoneArr[editIndex].setImage(editImage);
                break;
            case "Samsung":
                samsungPhoneArr[editIndex].setName(editName);
                samsungPhoneArr[editIndex].setPrice(editPrice);
                samsungPhoneArr[editIndex].setBrand(editBrand);
                samsungPhoneArr[editIndex].setCategory(editCategory);
                samsungPhoneArr[editIndex].setImage(editImage);
                break;
            case "Pixel":
                pixelPhoneArr[editIndex].setName(editName);
                pixelPhoneArr[editIndex].setPrice(editPrice);
                pixelPhoneArr[editIndex].setBrand(editBrand);
                pixelPhoneArr[editIndex].setCategory(editCategory);
                pixelPhoneArr[editIndex].setImage(editImage);
                break;
            case "iPad":
                iPadArr[editIndex].setName(editName);
                iPadArr[editIndex].setPrice(editPrice);
                iPadArr[editIndex].setBrand(editBrand);
                iPadArr[editIndex].setCategory(editCategory);
                iPadArr[editIndex].setImage(editImage);
                break;
            case "Galaxy-Tab":
                GalaxyTabArr[editIndex].setName(editName);
                GalaxyTabArr[editIndex].setPrice(editPrice);
                GalaxyTabArr[editIndex].setBrand(editBrand);
                GalaxyTabArr[editIndex].setCategory(editCategory);
                GalaxyTabArr[editIndex].setImage(editImage);
        }
        reDisplay(editBrandOut);
        closeEditModal();
    }
}


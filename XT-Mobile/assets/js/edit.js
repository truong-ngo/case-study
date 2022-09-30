let editIndex = 0;
let editBrandOut = 0;
function editProduct(i,brand) {
    editIndex = i;
    editBrandOut = brand;
    openEditModal();
}
function openEditModal() {
    let modal = document.getElementById("edit-modal");
    modal.style.display = "block";
}
function closeEditModal() {
    let modal = document.getElementById("edit-modal");
    modal.style.display = "none";
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


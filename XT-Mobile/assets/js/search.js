function searchProduct() {
    let searchArr = [];
    let searchInput = document.getElementById("search-content").value;
    let search = searchInput.toLowerCase()
    getProduct(search,iPhoneArr,searchArr);
    getProduct(search,samsungPhoneArr,searchArr);
    getProduct(search,pixelPhoneArr,searchArr);
    getProduct(search,iPadArr,searchArr);
    getProduct(search,GalaxyTabArr,searchArr);
    displayProduct(searchArr);
}
function getProduct(search,arr,searchArr) {
    for (let i = 0; i < arr.length; i++) {
        let searchName = arr[i].getName().toLowerCase()
        if (searchName.indexOf(search) !== -1) {
            searchArr.push(arr[i])
        }
    }
}
function searchKeyPress() {
    let keyCode = event.keyCode;
    if (keyCode === 13) {
        searchProduct();
    }
}
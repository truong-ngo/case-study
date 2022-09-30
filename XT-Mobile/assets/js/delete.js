function reDisplay(brand) {
    switch (brand) {
        case "iPhone":
            displayIPhone();
            break;
        case "Samsung":
            displaySamsung();
            break;
        case "Pixel":
            displayPixel();
            break;
        case "iPad":
            displayIpad();
            break;
        case "Galaxy-Tab":
            displayGalaxyTab();
    }
}
function deleteProduct(i,brand) {
    switch (brand) {
        case "iPhone":
            if (confirm(`Bạn chắc chắn muốn xóa sản phẩm ${iPhoneArr[i].getName()}?`)) {
                iPhoneArr.splice(i,1)
            }
            break;
        case "Samsung":
            if (confirm(`Bạn chắc chắn muốn xóa sản phẩm ${samsungPhoneArr[i].getName()}?`)) {
                samsungPhoneArr.splice(i,1)
            }
            break;
        case "Pixel":
            if (confirm(`Bạn chắc chắn muốn xóa sản phẩm ${pixelPhoneArr[i].getName()}?`)) {
                pixelPhoneArr.splice(i,1)
            }
            break;
        case "iPad":
            if (confirm(`Bạn chắc chắn muốn xóa sản phẩm ${iPadArr[i].getName()}?`)) {
                iPadArr.splice(i,1)
            }
            break;
        case "Galaxy-Tab":
            if (confirm(`Bạn chắc chắn muốn xóa sản phẩm ${GalaxyTabArr[i].getName()}?`)) {
                GalaxyTabArr.splice(i,1)
            }
    }
    reDisplay(brand);
}
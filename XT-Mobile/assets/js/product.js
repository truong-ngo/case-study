class Product {
    name
    category
    brand
    price
    image
    constructor(name,category,brand,price,image) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.image = image;
    }
    getName() {return this.name};
    getCategory() {return this.category};
    getBrand() {return this.brand};
    getPrice() {return this.price};
    getImage() {return this.image};
    setName(name) {return this.name = name};
    setCategory(category) {return this.category = category};
    setBrand(brand) {return this.brand = brand};
    setPrice(price) {return this.price = price};
    setImage(image) {return this.image = image};
}
let iPhone11 = new Product("iPhone 11","Phone","iPhone",11000000,'assets/img/product/phone/iphone/iphone-11.jpg')
let iPhone11Pro = new Product("iPhone 11 Pro","Phone","iPhone",12000000,'assets/img/product/phone/iphone/iphone-11-pro.jpg')
let iPhone11ProMax = new Product("iPhone 11 Pro Max","Phone","iPhone",13000000,'assets/img/product/phone/iphone/iphone-11-pro-max.jpg')
let iPhone12 = new Product("iPhone 12","Phone","iPhone",15000000,'assets/img/product/phone/iphone/iphone-12.jpg')
let iPhone12Mini = new Product("iPhone 12 Mini","Phone","iPhone",11000000,'assets/img/product/phone/iphone/iphone-12-mini.jpg')
let iPhone12Pro = new Product("iPhone12 Pro","Phone","iPhone",17600000,'assets/img/product/phone/iphone/iphone-12-pro.jpg')
let iPhone12ProMax = new Product("iPhone 12 Pro Max","Phone","iPhone",19000000,'assets/img/product/phone/iphone/iphone-12-pro-max.jpg')
let iPhone13 = new Product("iPhone 13","Phone","iPhone",18000000,'assets/img/product/phone/iphone/iphone-13.jpg')
let iPhone13Mini = new Product("iPhone 13 Mini","Phone","iPhone",11000000,'assets/img/product/phone/iphone/iphone-13-mini.jpg')
let iPhone13Pro = new Product("iPhone13 Pro","Phone","iPhone",23000000,'assets/img/product/phone/iphone/iphone-13-pro.jpg')
let iPhone13ProMax = new Product("iPhone 13 Pro Max","Phone","iPhone",17000000,'assets/img/product/phone/iphone/iphone-13-pro-max.jpg')

let iPhoneArr = [iPhone11,iPhone11Pro,iPhone11ProMax,iPhone12,iPhone12Mini,iPhone12Pro,iPhone12ProMax,iPhone13,iPhone13Mini,iPhone13Pro,iPhone13ProMax];

let samsungS20 = new Product("Galaxy S20","Phone","Samsung",9000000,'assets/img/product/phone/samsung/galaxy-s20.jpg')
let samsungS20Plus = new Product("Galaxy S20 Plus","Phone","Samsung",11000000,'assets/img/product/phone/samsung/galaxy-s20+.jpg')
let samsungS20Ultra = new Product("Galaxy S20 Ultra","Phone","Samsung",13000000,'assets/img/product/phone/samsung/galaxy-s20ultra.jpg')
let samsungS21 = new Product("Galaxy S21","Phone","Samsung",11000000,'assets/img/product/phone/samsung/galaxy-s21.jpg')
let samsungS21Plus = new Product("Galaxy S21 Plus","Phone","Samsung",13000000,'assets/img/product/phone/samsung/galaxy-s21+.jpg')
let samsungS21Ultra = new Product("Galaxy S21 Ultra","Phone","Samsung",15000000,'assets/img/product/phone/samsung/galaxy-s21ultra.jpg')
let samsungS22 = new Product("Galaxy S22","Phone","Samsung",16000000,'assets/img/product/phone/samsung/galaxy-s22.jpg')
let samsungS22Plus = new Product("Galaxy S22 Plus","Phone","Samsung",19000000,'assets/img/product/phone/samsung/galaxy-s22+.jpg')
let samsungS22Ultra = new Product("Galaxy S22 Ultra","Phone","Samsung",24000000,'assets/img/product/phone/samsung/galaxy-s22ultra.jpg')

let samsungPhoneArr = [samsungS20,samsungS20Plus,samsungS20Ultra,samsungS21,samsungS21Plus,samsungS21Ultra,samsungS22,samsungS22Plus,samsungS22Ultra];

let pixel4 = new Product("Pixel 4","Phone","Pixel",4000000,"assets/img/product/phone/pixel/google-pixel-4.jpg")
let pixel4Xl = new Product("Pixel 4XL","Phone","Pixel",5000000,"assets/img/product/phone/pixel/google-pixel-4xl.jpg")
let pixel4a = new Product("Pixel 4a","Phone","Pixel",4500000,"assets/img/product/phone/pixel/google-pixel-4a.jpg")
let pixel4a5g = new Product("Pixel 4a 5g","Phone","Pixel",4500000,"assets/img/product/phone/pixel/google-pixel-4a-5g.jpg")
let pixel5 = new Product("Pixel 5","Phone","Pixel",7500000,"assets/img/product/phone/pixel/google-pixel-5.jpg")
let pixel5a = new Product("Pixel 5a","Phone","Pixel",8000000,"assets/img/product/phone/pixel/google-pixel-5a.jpg")

let pixelPhoneArr = [pixel4,pixel4Xl,pixel4a,pixel4a5g,pixel5,pixel5a];

let iPadGen10 = new Product("Ipad Gen 10","Tablet","iPad",8000000,"assets/img/product/tablet/ipad/ipad-gen10.jpg")
let iPadAir5 = new Product("Ipad Air 5","Tablet","iPad",15000000,"assets/img/product/tablet/ipad/ipad-air-5.jpg")
let iPadMini6 = new Product("Ipad Mini 6","Tablet","iPad",13000000,"assets/img/product/tablet/ipad/ipad-mini-6.jpg")
let iPadProM1 = new Product("Ipad Pro M1","Tablet","iPad",19000000,"assets/img/product/tablet/ipad/ipad-pro-m1.jpeg")

let iPadArr = [iPadGen10,iPadAir5,iPadMini6,iPadProM1];

let GalaxyTabS7 = new Product("Galaxy Tab S7","Tablet","Galaxy-Tab",18000000,"assets/img/product/tablet/samsung/samsung-galaxy-tab-s7.jpg")
let GalaxyTabS8 = new Product("Galaxy Tab S8","Tablet","Galaxy-Tab",26000000,"assets/img/product/tablet/samsung/samsung-galaxy-tab-s8.jpg")

let GalaxyTabArr = [GalaxyTabS7,GalaxyTabS8];

let cart = [];
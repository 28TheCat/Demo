package com.wyt;

public class ProductMain extends  Product{
    public static void main(String[] args)
    {
        Product p1 = new Product("电脑", 5000, 1);
        Product p2 = new Product("数码相机", 200, 100);
        Product p3 = new Product("香肠", 19, 19);
        Product p4 = new Product("洗发露", 69, 17);
        Product p5 = new Product("炒锅", 34, 160);

        Product[] products = new Product[5];
        products[0] = p1;
        products[1] = p2;
        products[2] = p3;
        products[3] = p4;
        products[4] = p5;
        for (int i = 0; i < products.length; i++) {
            products[i].show();
        }
    }
}

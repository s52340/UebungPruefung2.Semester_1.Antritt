package org.campus02.FileIO.u8ProduktBsp;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private String productName;
    private double price;
    private String ProductCategory;

    public Product(String productName, double price, String productCategory) {
        this.productName = productName;
        this.price = price;
        ProductCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String productCategory) {
        ProductCategory = productCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(productName, product.productName) && Objects.equals(ProductCategory, product.ProductCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price, ProductCategory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", ProductCategory='" + ProductCategory + '\'' +
                '}';
    }
}

package com.geekhub.hw3.goods;

/**
 * Created by Fedich on 06.11.2016.
 */
abstract class Product {

    private String name;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Product product = (Product) o;

        return price == product.price && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price;
        return result;
    }
}

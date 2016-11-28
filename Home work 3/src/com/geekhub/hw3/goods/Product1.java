package com.geekhub.hw3.goods;

/**
 * Created by Fedich on 06.11.2016.
 */
class Product1 extends Product {

    private String name;
    private int price;

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    Product1 (String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Product1 product1 = (Product1) o;

        return price == product1.price && name.equals(product1.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price;
        return result;
    }
}

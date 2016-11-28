package com.geekhub.hw3.goods;

/**
 * Created by Fedich on 06.11.2016.
 */
class Product3/* extends Product*/ {

    private int price;
    private String name;

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    Product3 (String name, int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Product3 product3 = (Product3) o;

        return price == product3.price && name.equals(product3.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price;
        return result;
    }
}

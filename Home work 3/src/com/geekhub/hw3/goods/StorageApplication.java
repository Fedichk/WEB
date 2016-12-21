package com.geekhub.hw3.goods;

import java.util.ArrayList;
import java.util.Iterator;

public class StorageApplication {
    public static void main(String[] args) {

        int count = 1;
        int valueOfProductOne = 0;
        int valueOfProductTwo = 0;
        int valueOfProductThree = 0;

        if (count == 1) {
            ArrayList<Product1> productOneList = Inventory.listOfProductOne();
            Iterator<Product1> iter = productOneList.iterator();
            while(iter.hasNext()){
                valueOfProductOne += (iter.next().getPrice());
            }
            System.out.println("Total amount of " + productOneList.get(0).getName() + " = " + valueOfProductOne);
            count ++;
        }if (count == 2) {
            ArrayList<Product2> productTwoList = Inventory.listOfProductTwo();
            Iterator<Product2> iter = productTwoList.iterator();
            while(iter.hasNext()){
                valueOfProductTwo += (iter.next().getPrice());
            }
            System.out.println("Total amount of " + productTwoList.get(0).getName() + " = " + valueOfProductTwo);
            count ++;
        }if (count == 3) {
            ArrayList<Product3> productThreeList = Inventory.listOfProductThree();
            Iterator<Product3> iter = productThreeList.iterator();
            while(iter.hasNext()){
                valueOfProductThree += (iter.next().getPrice());
            }
            System.out.println("Total amount of " + productThreeList.get(0).getName() + " = " + valueOfProductThree);
            count++;
        }

        System.out.println("Total amount of all goods = " + (valueOfProductOne + valueOfProductTwo + valueOfProductThree));
    }
}

package com.geekhub.hw3.goods;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Fedich on 06.11.2016.
 */
class Inventory {

    static ArrayList<Product1> listOfProductOne (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter product one name:");
        String nameOfProductOne = sc.nextLine();
        System.out.println("Please, enter product one price:");
        int priceOfProductOne = Integer.parseInt(sc.nextLine());
        System.out.println("Please, enter product one quantity:");
        int quantityOfProductOne = Integer.parseInt(sc.nextLine());

        ArrayList<Product1> listOne = new ArrayList<>();
        for (int i = 0; i < quantityOfProductOne; i++ ) {
            Product1 product = new Product1(nameOfProductOne, priceOfProductOne);
            listOne.add(product);
        }
        return listOne;
    }

    static ArrayList<Product2> listOfProductTwo (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter product two name:");
        String nameOfProductTwo = sc.nextLine();
        System.out.println("Please, enter product two price:");
        int priceOfProductTwo = Integer.parseInt(sc.nextLine());
        System.out.println("Please, enter product two quantity:");
        int quantityOfProductTwo = Integer.parseInt(sc.nextLine());

        ArrayList<Product2> listTwo = new ArrayList<>();
        for (int i = 0; i < quantityOfProductTwo; i++ ) {
            Product2 product = new Product2(nameOfProductTwo, priceOfProductTwo);
            listTwo.add(product);
        }
        return listTwo;
    }

    static ArrayList<Product3> listOfProductThree (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter product three name:");
        String nameOfProductThree = sc.nextLine();
        System.out.println("Please, enter product three price:");
        int priceOfProductThree = Integer.parseInt(sc.nextLine());
        System.out.println("Please, enter product three quantity:");
        int quantityOfProductThree = Integer.parseInt(sc.nextLine());

        ArrayList<Product3> listThree = new ArrayList<>();
        for (int i = 0; i < quantityOfProductThree; i++ ) {
            Product3 product = new Product3(nameOfProductThree, priceOfProductThree);
            listThree.add(product);
        }
        return listThree;
    }
}

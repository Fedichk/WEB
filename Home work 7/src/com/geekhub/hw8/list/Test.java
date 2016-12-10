package com.geekhub.hw8.list;

public class Test {
    public static void main(String[] args) {
        LinkedListImpl<Object> list = new LinkedListImpl<>();
      //  System.out.println(list.isEmpty());
        list.add("p");
      //  System.out.println(list.isEmpty());
       list.add("a");
        list.add("e");
        list.add("h");
        System.out.println(list.contains("x"));
        System.out.println(list.size());
       list.delete(2);
       IteratorImpl<Object> iter = (IteratorImpl<Object>) list.iterator();
        while(iter.hasNext())
            System.out.println(iter.next() + " ");
        // System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(2));
      //  System.out.println(list.contains("a"));
        //System.out.println(list.clean());
        //System.out.println(list.size());







    }
}

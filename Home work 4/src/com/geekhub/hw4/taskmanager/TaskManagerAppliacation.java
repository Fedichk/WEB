/*package com.geekhub.hw4.taskmanager;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskManagerAppliacation {
    public static void main(String[] args) {

        TaskManagerImpl test = new TaskManagerImpl();
        Task task1 = new Task ("Hello", "writing");
        Task task2 = new Task ("HI", "writing");
        Task task3 = new Task ("By", "writing");
        Task task4 = new Task ("Sum", "calculating");
        Task task5 = new Task ("Del", "calculating");
        Task task6 = new Task ("Minus", "calculating");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy/MM/dd HH:mm");

        String input1 = "2012/10/09 11:00";
        LocalDateTime localDateTime1 = LocalDateTime.parse (input1, formatter);

        String input2 = "2005/11/15 15:20";
        LocalDateTime localDateTime2 = LocalDateTime.parse (input2, formatter);

        String input3 = "2016/11/13 17:30";
        LocalDateTime localDateTime3 = LocalDateTime.parse (input3, formatter);

        String input4 = "2016/12/08 11:00";
        LocalDateTime localDateTime4 = LocalDateTime.parse (input4, formatter);

        String input5 = "2016/11/13 17:28";
        LocalDateTime localDateTime5 = LocalDateTime.parse (input5, formatter);

        String input6 = "2016/11/13 17:25";
        LocalDateTime localDateTime6 = LocalDateTime.parse (input6, formatter);

        test.add(localDateTime1, task1);
        test.add(localDateTime2, task2);
        test.add(localDateTime3, task3);
        test.add(localDateTime4, task4);
        test.add(localDateTime5, task5);
        test.add(localDateTime6, task6);

        Map<String, List<Task>> get = new HashMap<>(test.getTasksByCategories("writing", "calculating"));
        List<Task> tes = test.getTasksByCategory("writing");


        System.out.println(test.getCategories());
        System.out.println(get.entrySet());
        Iterator<Task> iter = tes.iterator();
        while(iter.hasNext()){
            System.out.println(iter.getCategory());;
        }
        System.out.println(tes);
        for (Map.Entry<String, List<Task>> element : get.entrySet()) {
            if (element.getValue().getCategory().equals(category)) {
                tasks.add(element.getValue());
            }




    }
}
*/
package CollegeAdministrationSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void SMS() {
        ArrayList<Student> list = new ArrayList<>();
        loop:while(true){
            System.out.println("--------Welcome to the student information administration system--------");
            System.out.println("1:Add student");
            System.out.println("2:Delete student");
            System.out.println("3:Modify student");
            System.out.println("4:Query student");
            System.out.println("5:Exit");
            System.out.println("Please type your choice");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch(choose){
                case "1" -> add(list);
                case "2" -> delete(list);
                case "3" -> modify(list);
                case "4" -> query(list);
                case "5" -> {
                    System.out.println("Exit");
                    break loop;
                }
                default  -> System.out.println("Error!");
            }
        }
    }

    public static void add(ArrayList<Student> list) {
        Student stu = new Student();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Please type in the student's id.");
            String id = sc.next();
            if(contains(list,id)){
                System.out.println("Duplicate id information!");
            }else {
                stu.setId(id);
                break;
            }
        }
        System.out.println("Please type in the student's name.");
        String name = sc.next();
        stu.setName(name);
        System.out.println("Please type in the student's age.");
        int age = sc.nextInt();
        stu.setAge(age);
        System.out.println("Please type in the student's address.");
        String address = sc.next();
        stu.setAddress(address);
        list.add(stu);
        System.out.println("Add successfully.");
    }

    public static void delete(ArrayList<Student> list) {
        System.out.println("Please type in the ID that you want to delete.");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        if (contains(list,id)){
            list.remove(getIndex(list,id));
            System.out.println("Delete successfully.");
        }else {
            System.out.println("ID error!");
        }
    }

    public static void modify(ArrayList<Student> list) {
        System.out.println("Please type in the ID that you want to modify.");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        if(getIndex(list,id)>=0){
            System.out.println("Please type in the new name.");
            String newName = sc.next();
            list.get(getIndex(list,id)).setName(newName);
            System.out.println("Please type in the new age.");
            int newAge = sc.nextInt();
            list.get(getIndex(list,id)).setAge(newAge);
            System.out.println("Please type in the new address.");
            String newAddress = sc.next();
            list.get(getIndex(list,id)).setAddress(newAddress);
            System.out.println("Modify successfully.");
        }else {
            System.out.println("ID error!");
        }
    }

    public static void query(ArrayList<Student> list) {
        if (list.size()==0){
            System.out.println("None information.Please query after adding information.");
        }else {
            System.out.println("ID\t\tName\tAge\tAddress");
            for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId()+'\t'+'\t'+stu.getName()+'\t'+stu.getAge()+'\t'+stu.getAddress());
            }
        }
    }

    public static boolean contains(ArrayList<Student> list,String id) {
        for (int i = 0; i < list.size(); i++) {
            String sid = list.get(i).getId();
            if (sid.equals(id)){
                return true;
            }
        }
        return false;
    }

    public static int getIndex(ArrayList<Student> list ,String id) {
        for (int i = 0; i < list.size(); i++) {
            if (contains(list,id)){
                return i;
            }
        }
        return -1;
    }
}

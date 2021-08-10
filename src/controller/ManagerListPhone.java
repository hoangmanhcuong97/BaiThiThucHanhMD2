package controller;

import Storage.FileListPhone;
import model.ListPhone;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ManagerListPhone {
    private List<ListPhone>  listPhones;

    {
        try {
            listPhones = FileListPhone.readFileListPhone();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ListPhone creatListPhone(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Họ và tên:");
        String name = sc.nextLine();

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhóm");
        String group = sc1.nextLine();

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Số điện thoại:");
        int phoneNumber = sc2.nextInt();

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Giới tính:");
        String gender = sc3.nextLine();

        Scanner sc4 = new Scanner(System.in);
        System.out.println("Ngày sinh:");
        String dateOfBirth = sc4.nextLine();

        Scanner sc5 = new Scanner(System.in);
        System.out.println("Địa chỉ:");
        String address = sc5.nextLine();

        Scanner sc6 = new Scanner(System.in);
        System.out.println("email:");
        String email = sc6.nextLine();

        ListPhone listPhone = new ListPhone(name,group,phoneNumber,gender,dateOfBirth,address,email);
        return listPhone;
    }
    public void addListPhone(){
        listPhones.add(creatListPhone());
        try {
            FileListPhone.writeFileListPhone(listPhones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void editListPhone(int numberPhone) {
        for (int i = 0; i < listPhones.size(); i++) {
            if(listPhones.get(i).getPhoneNumber() == numberPhone){
                listPhones.set(i, creatListPhone());
            }
        }
        try {
            FileListPhone.writeFileListPhone(listPhones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteListPhone(String name) {
        for (int i = 0; i < listPhones.size(); i++) {
            if(name.equals(listPhones.get(i).getName())){
                listPhones.remove(i);
                break;
            }
        }
        try {
            FileListPhone.writeFileListPhone(listPhones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void findName(String name){
        try {
            List<ListPhone> list = FileListPhone.readFileListPhone();
            for (int i = 0; i < listPhones.size(); i++) {
                if(name.equals(listPhones.get(i).getName())){
                    System.out.println(listPhones.get(i));
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    public void showAll(){
        try {
            List<ListPhone> list = FileListPhone.readFileListPhone();
            for (ListPhone p : list) {
                System.out.println(p);
            }
        }  catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

package view;

import Storage.FileListPhone;
import controller.ManagerListPhone;
import model.ListPhone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerListPhone managerListPhone = new ManagerListPhone();
        int chose = -1;
        while (chose != 8){
            Scanner scanner = new Scanner(System.in);
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1.Xem danh sách");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xoá");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Đọc từ file");
            System.out.println("7.Ghi vào file");
            System.out.println("8.Thoát");
            System.out.print("Chọn chức năng:");
            chose = scanner.nextInt();
            switch (chose){
                case 1:
                    managerListPhone.showAll();
                    break;
                case 2:
                    managerListPhone.addListPhone();
                    break;
                case 3:
                    System.out.println("Nhập số điện thoại cần sửa:");
                    Scanner scanner1 = new Scanner(System.in);
                    int numberPhone = scanner1.nextInt();
                    managerListPhone.editListPhone(numberPhone);
                    break;
                case 4:
                    System.out.println("Nhập tên cần xoá:");
                    Scanner scanner2 = new Scanner(System.in);
                    String name2 = scanner2.nextLine();
                    managerListPhone.deleteListPhone(name2);
                    break;
                case 5:
                    System.out.println("Nhập tên cần tìm kiếm:");
                    Scanner scanner3 = new Scanner(System.in);
                    String name3= scanner3.nextLine();
                    managerListPhone.findName(name3);
                    break;
                case 6:
                    try {
                        FileListPhone.readFileListPhone();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                case 7:
                    List<ListPhone> listPhones = new ArrayList<>();
                    try {
                        FileListPhone.writeFileListPhone(listPhones);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }

}

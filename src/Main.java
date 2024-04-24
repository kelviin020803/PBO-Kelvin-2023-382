import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<Student> userStudent = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== PERPUS MAHAL =====");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilihen CAKK" +
                    " (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    inputNim(scanner);
                    break;
                case "2":
                    Admin admin = new Admin();
                    admin.menuAdmin(scanner);
                    break;
                case "3":
                    System.out.println("Thank you. KELUAR DARI PROGRAM.");
                    System.exit(0);
                default:
                    System.out.println("INVALID.");
            }
        }
    }

    public static void inputNim(Scanner scanner) {
        System.out.print("Masukkan NIM (KETIK 00 UNTUK KEMBALI): ");
        String nim = scanner.nextLine();
        if (nim.equals("00")) {
            return;
        } else if (checkNim(nim)) {
            Student student = new Student(nim);
            student.menuStudent(scanner); // Panggil menuStudent dari objek student yang sudah dibuat
        } else {
            System.out.println("SALAH!!!, MASUKKAN LAGI.");
            inputNim(scanner);
        }
    }

    public static boolean checkNim(String nim) {
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public static void initializeData() {

        bookList.add(new Book("1", "MTK", "Mr. Kelvin", "A", 1));
        bookList.add(new Book("2", "ITM", "Mr Yoyok", "B", 2));
        bookList.add(new Book("3", "IPA", "Ms Alyssa", "C", 3));
        bookList.add(new Book("4", "IPS", "Mr Kemenyogeh", "D", 4));


        userStudent.add(new Student("Leo", "202310370311333", "Teknik Jaya Jaya", "IT"));
        userStudent.add(new Student("Messi", "202310370311444", "Teknik Jaya Jaya", "Infor"));
        userStudent.add(new Student("GOAT", "202310370311555", "Teknik Jaya Jaya", "Infor"));
    }

}






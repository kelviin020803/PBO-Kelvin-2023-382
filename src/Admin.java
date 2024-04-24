import java.util.Scanner;

public class Admin extends User{
    // Tambahkan informasi username dan password admin
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "kelvin382";
    public void menuAdmin(Scanner scanner) {
        if (loginAdmin(scanner)) {
            while (true) {
                System.out.println("=== Admin Menu ===");
                System.out.println("1. Tambah Mahasiswa");
                System.out.println("2. Lihat Daftar Mahasiswa");
                System.out.println("3. Tambah Buku");
                System.out.println("4. Lihat Daftar Buku");
                System.out.println("5. Keluar");
                System.out.print("Pilih (1-5): ");
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        addStudent(scanner);
                        break;
                    case "2":
                        displayStudent();
                        break;
                    case "3":
                        addBook(scanner);
                        break;
                    case "4":
                        displayBookList();
                        break;
                    case "5":
                        System.out.println("LogOut.");
                        return;
                    default:
                        System.out.println("Invalid.");
                }
            }
        }else {
            System.out.println("Admin login Gagal.");
        }
    }

    private boolean loginAdmin(Scanner scanner) {
        System.out.print("Masukkan username Admin: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();


        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    public void addStudent(Scanner scanner) {
        System.out.println("Masukkan Mhs detail:");
        System.out.print("NAMA: ");
        String name = scanner.nextLine();
        String nim;
        do {
            System.out.print("Masukkan NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("15 DIGIT NIM.");
            }
        } while (nim.length() != 15);
        System.out.print("Fakultas: ");
        String faculty = scanner.nextLine();
        System.out.print("Prodi: ");
        String program = scanner.nextLine();
        Main.userStudent.add(new Student(name, nim, faculty, program));
        System.out.println("BERHASIL REGISTER.");
    }

    public void displayStudent() {
        System.out.println("Daftar MHS:");
        for (Student student : Main.userStudent) {
            System.out.println("Nama: " + student.getName());
            System.out.println("Fakultas: " + student.getFaculty());
            System.out.println("NIM: " + student.getNim());
            System.out.println("Prodi: " + student.getProgram());
            System.out.println();
        }
    }
    public void addBook(Scanner scanner) {
        System.out.println("Pilih Kategori:");
        System.out.println("1. A");
        System.out.println("2. B");
        System.out.println("3. C");
        System.out.println("4. Keluar");
        System.out.print("Enter choice (1-4): ");
        String categoryChoice = scanner.nextLine();

        String category;
        switch (categoryChoice) {
            case "1":
                category = "A";
                break;
            case "2":
                category = "B";
                break;
            case "3":
                category = "C";
                break;
            case "4":
                System.out.println("Logout");
                return;
            default:
                System.out.println("Invalid .");
                category = "A";
                break;
        }
        System.out.println("Masukkan detail buku:");
        System.out.print("ID Buku: ");
        String id = scanner.nextLine();
        System.out.print("Judul Buku: ");
        String title = scanner.nextLine();
        System.out.print("Penulis: ");
        String author = scanner.nextLine();
        System.out.print("Stok: ");
        int stock = Integer.parseInt(scanner.nextLine());

        Main.bookList.add(new Book(id, title, author, category, stock));
        System.out.println("Buku Sukses Ditambah.");
    }
    public void displayBookList() {
        System.out.println("List Buku:");
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Penulis || Kategori || Stok ||");
        int index = 1;
        for (Book book : Main.bookList) {
            System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + "  || " + book.getStock() + " ||");
            index++;
        }
        System.out.println("================================================================");
    }
}
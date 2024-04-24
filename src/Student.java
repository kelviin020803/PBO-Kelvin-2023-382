import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User{
    private String name;
    private String nim;
    private String faculty;
    private String program;
    private ArrayList<Book> borrowedBooks;
    private int loanDuration;


    public Student(String name, String nim, String faculty, String program) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
        this.borrowedBooks = new ArrayList<>();
        // this.loanDuration = loanDuration;
    }


    public Student(String nim) {

        for (Student student : Main.userStudent) {
            if (student.getNim().equals(nim)) {
                this.name = student.getName();
                this.nim = student.getNim();
                this.faculty = student.getFaculty();
                this.program = student.getProgram();
                this.borrowedBooks = student.getBorrowedBooks();
                break;
            }
        }
    }


    public String getNim() { return nim; }

    public void menuStudent(Scanner scanner) {
        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Kalau tdk mau pinjam pilih 3 saja");
            System.out.print("Pilih (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Buku terpinjam:");
                    displayBorrowedBooks();
                    // Implementasi logika untuk menampilkan buku yang sedang dipinjam
                    break;
                case "2":
                    displayBooks();
                    borrowBook(scanner);
                    // Implementasi logika untuk pinjam buku
                    break;
                case "3":
                    System.out.println("logout");
                    return;
                default:
                    System.out.println("Invalid!!!.");
            }
        }
    }
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // MENGEMBALIKAN BUKU
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Tidak ada.");
        } else {
            System.out.println("=================================================================================");
            System.out.println("|| No. || Id Buku        || Nama Buku    || Penulis       || Kategori   || Durasi ||");
            System.out.println("=================================================================================");
            int index = 1;
            for (Book book : borrowedBooks) {
                System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + " || " + book.getLoanDuration() + " ||" );
                index++;
            }
            System.out.println("=================================================================================");
        }
    }
    @Override
    public void displayBooks() {
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Penulis || Category || Stok ||");
        int index = 1;
        for (Book book : Main.bookList) {
            System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + "  || " + book.getStock() + " ||");
            index++;
        }
        System.out.println("================================================================");
    }
    public void borrowBook(Scanner scanner) {
        System.out.print("PILIH: ");
        int bookIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (bookIndex < 0 || bookIndex >= Main.bookList.size()) {
            System.out.println("Invalid.");
            return;
        }

        Book selectedBook = Main.bookList.get(bookIndex);
        System.out.print("Berapa lama: ");
        int loanDuration = Integer.parseInt(scanner.nextLine());

        if (selectedBook.getStock() > 0) {

            selectedBook.setStock(selectedBook.getStock() - 1);
            selectedBook.setLoanDuration(loanDuration); // Set loan duration for the book
            borrowBook(selectedBook);
            System.out.println("Pinjam Buku '" + selectedBook.getTitle() + "' Selama " + loanDuration + " hari.");
        } else {
            System.out.println("HABIS CAK.");
        }
    }


    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }


    public int getLoanDuration() {
        return loanDuration;
    }
    public String getName() { return name; }
    public String getFaculty() { return faculty; }
    public String getProgram() { return program; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }
}
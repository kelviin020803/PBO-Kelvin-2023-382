import java.util.ArrayList;

public class User {
    protected static ArrayList<Book> bookList = new ArrayList<>();

    public void displayBooks() {
        System.out.println("List Buku:");
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Penulis|| Kategori || Stok ||");
        int index = 1;
        for (Book book : bookList) {
            System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + "  || " + book.getStock() + " ||");
            index++;
        }
        System.out.println("================================================================");
    }
}
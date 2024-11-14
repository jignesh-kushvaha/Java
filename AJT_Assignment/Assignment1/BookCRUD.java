package AJT_Assignment.Assignment1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class BookCRUD {
    private static final String FILE_NAME = "AJT_Assignment/Assignment1/Books.dat";
    public static void saveBook(Book book) {
        try {
            File file = new File(FILE_NAME);
            boolean append = file.exists();

            try (FileOutputStream fos = new FileOutputStream(file, append);
                 ObjectOutputStream oos = append ? new AppendObjectOutputStream(fos) : new ObjectOutputStream(fos)) {
                oos.writeObject(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Custom ObjectOutputStream to prevent header write for append
    static class AppendObjectOutputStream extends ObjectOutputStream {
        public AppendObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }
        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }

    public static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        File file = new File(FILE_NAME);
        if(!file.exists()){
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                try {
                    Book book = (Book) ois.readObject();
                    books.add(book);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static Book searchBook(String query) {
        for (Book book : readBooks()) {
            if (String.valueOf(book.getBookId()).equals(query) ||
                    book.getTitle().equalsIgnoreCase(query) ||
                    book.getAuthor().equalsIgnoreCase(query) ||
                    book.getPublisher().equalsIgnoreCase(query)) {
                return book;
            }
        }
        return null;
    }
}

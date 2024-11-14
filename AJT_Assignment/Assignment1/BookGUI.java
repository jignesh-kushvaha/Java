package AJT_Assignment.Assignment1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class BookGUI extends JFrame{
    private JTextField txtBookId,txtTitle, txtAuthorName, txtPublication, txtPrice, txtSearch;
    private JTable table;
    private DefaultTableModel tableModel;

    public BookGUI() {
        setTitle("Book Management System");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(7, 3, 5, 5));
        txtBookId = new JTextField();
        txtTitle = new JTextField();
        txtAuthorName = new JTextField();
        txtPublication = new JTextField();
        txtPrice = new JTextField();
        txtSearch = new JTextField();

        inputPanel.add(new JLabel("Book Id:"));
        inputPanel.add(txtBookId);
        inputPanel.add(new JLabel("Book Name:"));
        inputPanel.add(txtTitle);
        inputPanel.add(new JLabel("Author Name:"));
        inputPanel.add(txtAuthorName);
        inputPanel.add(new JLabel("Publication:"));
        inputPanel.add(txtPublication);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(txtPrice);

        JButton btnAdd = new JButton("Add");
        JButton btnDisplay = new JButton("Display");
        JButton btnSearch = new JButton("Search");

        inputPanel.add(btnAdd);
        inputPanel.add(btnDisplay);

        inputPanel.add(txtSearch);
        inputPanel.add(btnSearch);

        add(inputPanel, BorderLayout.NORTH);

        // Right Table Panel
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Author", "Publication", "Price"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        add(tableScrollPane, BorderLayout.CENTER);

        // Button Actions
        btnAdd.addActionListener(e -> addBook());
        btnDisplay.addActionListener(e -> displayBooks());
        btnSearch.addActionListener(e -> searchBook());
//        btnDelete.addActionListener(e -> deleteBook());

        setVisible(true);
    }

    private void addBook() {
        try {
            int bookid = Integer.parseInt(txtBookId.getText());
            String title = txtTitle.getText();
            String authorName = txtAuthorName.getText();
            String publication = txtPublication.getText();
            double price = Double.parseDouble(txtPrice.getText());
            System.out.println(title + " "+ authorName +" ");

            Book book = new Book(bookid,title, authorName, publication, price);
            BookCRUD.saveBook(book);
            clearFields();
            JOptionPane.showMessageDialog(null, "Added Successfully...");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Input");
        }
    }

    private void displayBooks() {
        List<Book> books = BookCRUD.readBooks();
        if(books == null) {
            JOptionPane.showMessageDialog(null, "File not found");
        }else{
            tableModel.setRowCount(0);
            for (Book book : books) {
                tableModel.addRow(new Object[]{
                        book.getBookId(), book.getTitle(),
                        book.getAuthor(), book.getPublisher(),
                        book.getPrice()
                });
            }
        }
    }

    private void searchBook() {
        String query = txtSearch.getText();
        Book book = BookCRUD.searchBook(query);
        if (book != null) {
            JOptionPane.showMessageDialog(null,
                    "Found: " + book.getTitle() + " by " + book.getAuthor());
        } else {
            JOptionPane.showMessageDialog(null, "Book Not Found");
        }
    }
    private void clearFields() {
        txtTitle.setText("");
        txtAuthorName.setText("");
        txtPublication.setText("");
        txtPrice.setText("");
        txtSearch.setText("");
    }

    public static void main(String[] args) {
        new BookGUI();
    }
}

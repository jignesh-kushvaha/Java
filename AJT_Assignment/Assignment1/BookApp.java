package AJT_Assignment.Assignment1;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class BookApp extends JFrame {
    private JTextField titleField, authorField, publisherField, priceField;
    private JButton saveButton, displayButton;
    private JTable table;
    private ArrayList<Book> books;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public BookApp(){
        books = new ArrayList<>();
        setTitle("Books Information");
        setSize(1000,1000);
        setLayout(new BorderLayout());

        JPanel inputWrapperPanel = new JPanel();
        inputWrapperPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel inputPanel = new JPanel(new GridLayout(5,5));

        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField(20);
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField(20);
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("Publisher:"));
        publisherField = new JTextField(20);
        inputPanel.add(publisherField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField(20);
        inputPanel.add(priceField);

        saveButton = new JButton("Save Book");
        displayButton = new JButton("Display All Books");
        inputPanel.add(saveButton);
        inputPanel.add(displayButton);

        add(inputPanel, BorderLayout.EAST);

        inputPanel.setPreferredSize(new Dimension(400, 200));
        inputWrapperPanel.add(inputPanel);
        add(inputWrapperPanel, BorderLayout.WEST);

        //second container
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setPreferredSize(new Dimension(getWidth(), 200));

        JScrollPane scrollPane = new JScrollPane(); // Initially empty scroll pane
        displayPanel.add(scrollPane, BorderLayout.CENTER);

        add(displayPanel, BorderLayout.CENTER);

        saveButton.addActionListener(e -> saveBook());
        displayButton.addActionListener(e -> displayBooks(scrollPane));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void saveBook(){
        try {
            String title = titleField.getText();
            String author = authorField.getText();
            String publisher = publisherField.getText();
            double price = Double.parseDouble(priceField.getText());

            books.add(new Book(title, author, publisher, price));

            oos = new ObjectOutputStream(new FileOutputStream("AJT_Assignment/Assignment1/Books.dat"));
            oos.writeObject(books);


            JOptionPane.showMessageDialog(this, "Book saved successfully!");
            clearFields();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    private void displayBooks(JScrollPane scrollPane) {
        try{
            ois = new ObjectInputStream(new FileInputStream("AJT_Assignment\\Assignment1\\Books.dat"));
            ArrayList<Book> books = (ArrayList<Book>) ois.readObject();

            String[] colHeads = { "No.", "Title", "Author", "Publication", "Price" };

            Object[][] data = new Object[books.size()][5];
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                data[i][0] = book.getBookId();
                data[i][1] = book.getTitle();
                data[i][2] = book.getAuthor();
                data[i][3] = book.getPublisher();
                data[i][4] = book.getPrice();
            }

            table = new JTable(data,colHeads);
            scrollPane.setViewportView(table); // Set table in scroll pane

            revalidate();  // Revalidate the frame to refresh the display
            repaint();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"error : "+e);
        }finally {
            try {
                if (ois != null) ois.close(); // Always close the stream
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"error : "+e);
            }
        }
    }

    private void clearFields() {
        titleField.setText("");
        authorField.setText("");
        publisherField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        new BookApp();
    }
}

import javax.swing.*;
import java.awt.*;
import java.io.RandomAccessFile;

public class RandProductSearch extends JFrame
{
    private JTextField txtSearch;
    private JTextArea txtResults;

    private JButton btnSearch;
    private JButton btnQuit;

    public RandProductSearch()
    {
        setTitle("Random Product Search");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        buildGUI();

        setVisible(true);
    }

    private void buildGUI()
    {
        JPanel topPanel = new JPanel();

        topPanel.add(new JLabel("Partial Product Name:"));

        txtSearch = new JTextField(20);
        topPanel.add(txtSearch);

        btnSearch = new JButton("Search");
        topPanel.add(btnSearch);

        add(topPanel, BorderLayout.NORTH);

        txtResults = new JTextArea();
        txtResults.setEditable(false);

        JScrollPane scrollPane =
                new JScrollPane(txtResults);

        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        btnQuit = new JButton("Quit");

        bottomPanel.add(btnQuit);

        add(bottomPanel, BorderLayout.SOUTH);

        btnSearch.addActionListener(e -> searchProducts());

        btnQuit.addActionListener(e -> System.exit(0));
    }

    private void searchProducts()
    {
        txtResults.setText("");

        String searchText =
                txtSearch.getText().trim().toLowerCase();

        try
        {
            RandomAccessFile file =
                    new RandomAccessFile("products.dat", "r");

            long recordCount =
                    file.length() / Product.RECORD_SIZE;

            for(int i = 0; i < recordCount; i++)
            {
                file.seek(i * Product.RECORD_SIZE);

                Product p =
                        Product.readFromFile(file);

                if(p.getName()
                        .toLowerCase()
                        .contains(searchText))
                {
                    txtResults.append(
                            p.toString() + "\n"
                    );
                }
            }

            file.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,
                    "Error reading file.");
        }
    }

    public static void main(String[] args)
    {
        new RandProductSearch();
    }
}
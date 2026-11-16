import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandProductMaker extends JFrame
{
    private JTextField txtName;
    private JTextField txtDescription;
    private JTextField txtID;
    private JTextField txtCost;
    private JTextField txtCount;

    private JButton btnAdd;
    private JButton btnQuit;

    private RandomAccessFile productFile;

    private int recordCount = 0;

    public RandProductMaker()
    {
        setTitle("Random Product Maker");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try
        {
            productFile = new RandomAccessFile("products.dat", "rw");

            recordCount =
                    (int)(productFile.length() / Product.RECORD_SIZE);
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,
                    "Error opening file");
        }

        buildGUI();

        setVisible(true);
    }

    private void buildGUI()
    {
        JPanel inputPanel = new JPanel(new GridLayout(5,2));

        inputPanel.add(new JLabel("Product Name"));
        txtName = new JTextField();
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Description"));
        txtDescription = new JTextField();
        inputPanel.add(txtDescription);

        inputPanel.add(new JLabel("ID"));
        txtID = new JTextField();
        inputPanel.add(txtID);

        inputPanel.add(new JLabel("Cost"));
        txtCost = new JTextField();
        inputPanel.add(txtCost);

        inputPanel.add(new JLabel("Record Count"));
        txtCount = new JTextField("" + recordCount);
        txtCount.setEditable(false);
        inputPanel.add(txtCount);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        btnAdd = new JButton("Add");
        btnQuit = new JButton("Quit");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnQuit);

        add(buttonPanel, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> addProduct());

        btnQuit.addActionListener(e ->
        {
            try
            {
                productFile.close();
            }
            catch(Exception ex)
            {
            }

            System.exit(0);
        });
    }

    private void addProduct()
    {
        try
        {
            String name = txtName.getText().trim();
            String description = txtDescription.getText().trim();
            String id = txtID.getText().trim();

            if(name.isEmpty() ||
                    description.isEmpty() ||
                    id.isEmpty())
            {
                JOptionPane.showMessageDialog(null,
                        "All fields are required.");
                return;
            }

            double cost =
                    Double.parseDouble(txtCost.getText());

            Product p =
                    new Product(
                            name,
                            description,
                            id,
                            cost);

            productFile.seek(productFile.length());

            p.writeToFile(productFile);

            recordCount++;

            txtCount.setText("" + recordCount);

            txtName.setText("");
            txtDescription.setText("");
            txtID.setText("");
            txtCost.setText("");

            txtName.requestFocus();

            JOptionPane.showMessageDialog(null,
                    "Product Added!");
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Cost must be numeric.");
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "File write error.");
        }
    }

    public static void main(String[] args)
    {
        new RandProductMaker();
    }
}
package ui;
import javax.swing.*;
import java.awt.*;
import model.Expense;
import service.BudgetManager;
import javax.swing.table.DefaultTableModel;


public class BudgetFrame extends JFrame {

    public BudgetFrame() {

        setTitle("Budget Tracker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        manager = new BudgetManager();
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        nameField = new JTextField();
        amountField = new JTextField();
        categoryBox = new JComboBox<>(Expense.Category.values());
        addButton = new JButton("Add Expense");

        setLayout(new BorderLayout());

        inputPanel.add(new JLabel("Expense Name:"));
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryBox);

        inputPanel.add(new JLabel("Planned Amount (R):"));
        inputPanel.add(amountField);

        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        addButton.addActionListener(e -> addExpense());
        


        String[] columns = {
            "Expense",
            "Category",
            "Planned Amount",
            "Actual Amount",
            "Purchased"
        };

       tableModel = new DefaultTableModel(columns, 0) {

          @Override
          public boolean isCellEditable(int row, int column) {
              return false;
          }
       };

       expenseTable = new JTable(tableModel);

       JScrollPane scrollPane = new JScrollPane(expenseTable);
       add(scrollPane, BorderLayout.CENTER);

    }
    private JTextField nameField;
    private JTextField amountField;
    private JComboBox<Expense.Category> categoryBox;
    private JButton addButton;
    private BudgetManager manager;
    private JTable expenseTable;
    private DefaultTableModel tableModel;

    private void addExpense() {
        System.out.println("addExpense method started!");

    String name = nameField.getText();

    Expense.Category category =
            (Expense.Category) categoryBox.getSelectedItem();

    try {

        double amount = Double.parseDouble(amountField.getText());

        Expense expense = new Expense(name, category, amount);

        manager.addExpense(expense);
        tableModel.addRow(new Object[] {
        expense.getExpenseName(),
        expense.getCategory(),
        expense.getPlannedAmount(),
        expense.getActualAmount(),
        expense.isPurchased() ? "Yes" : "No"
        });

        JOptionPane.showMessageDialog(this,
                "Expense added successfully!");

        nameField.setText("");
        amountField.setText("");

    } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(this,
                "Please enter a valid amount.");

    } catch (IllegalArgumentException ex) {

        JOptionPane.showMessageDialog(this,
                ex.getMessage());

    }
}

}

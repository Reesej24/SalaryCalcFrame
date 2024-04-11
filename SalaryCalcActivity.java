import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryCalcActivity extends JFrame implements ActionListener {
    private JLabel hourLabel;       // Label for hours worked
    private JLabel salLabel;        // Label for yearly salary
    private JLabel wageLabel;       // Label for hourly wage
    private JTextField hourField;   // Displays hours worked
    private JTextField salField;    // Displays yearly salary
    private JTextField wageField;   // Displays hourly wage
    private JButton calcButton;     // Triggers salary calculation


    /* Constructor creates GUI components and adds GUI components
       using a GridBagLayout. */

    SalaryCalcActivity() {
        // Used to specify GUI component layout
        GridBagConstraints layoutConst = null;

        // Set frame's title
        setTitle("Salary Calculator");

        wageLabel = new JLabel("Hourly wage:");
        salLabel = new JLabel("Yearly salary:");
        hourLabel = new JLabel("Hours worked per week:");

        // Set hourly wage, hours worked and yearly salary
        wageField = new JTextField(15);
        wageField.setEditable(true);
        wageField.setText("0");

        hourField = new JTextField(15);
        hourField.setEditable(true);
        hourField.setText("0");

        salField = new JTextField(15);
        salField.setEditable(false);

        // Create a "Calculate" button
        calcButton = new JButton("Calculate");
        // Use "this" class to handle button presses
        calcButton.addActionListener(this);

        // Use a GridBagLayout
        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();

        // Specify component's grid location
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        // 10 pixels of padding around component
        layoutConst.insets = new Insets(10, 10, 10, 10);
        // Add component using the specified constraints
        add(wageLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(wageField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(hourLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(hourField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(salLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(salField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(calcButton, layoutConst);
    }

    /* Method is automatically called when an event occurs
       (e.g, Enter key is pressed) */
    @Override
    public void actionPerformed(ActionEvent event) {
        String userWage;        // User specified hourly wage
        String userHours;       // User specified hours worked
        int hourlyWage;         // Hourly wage
        int hoursWorked;        // Hours per week

        // Get user's wage input
        userWage = wageField.getText();
        // Convert from String to an integer
        hourlyWage = Integer.parseInt(userWage);

        // Get user's input for hours worked per week
        userHours = hourField.getText();
        // Convert from String to an integer
        hoursWorked = Integer.parseInt(userHours);

        // Display calculated salary
        salField.setText(Integer.toString(hourlyWage * hoursWorked * 50));
    }

    // Creates a SalaryCalculatorFrame and makes it visible
    public static void main(String[] args) {
        SalaryCalcActivity salaryCalcFrame = new SalaryCalcActivity();

        salaryCalcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        salaryCalcFrame.pack();
        salaryCalcFrame.setVisible(true);
    }
}


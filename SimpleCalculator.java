import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JPanel panel;
    private double num1, num2, result;
    private char operator;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            buttonPanel.add(numberButtons[i]);
        }

        functionButtons = new JButton[6];
        functionButtons[0] = new JButton("+");
        functionButtons[1] = new JButton("-");
        functionButtons[2] = new JButton("*");
        functionButtons[3] = new JButton("/");
        functionButtons[4] = new JButton(".");
        functionButtons[5] = new JButton("=");

        for (JButton button : functionButtons) {
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                displayField.setText(displayField.getText() + i);
            }
        }
        if (e.getSource() == functionButtons[4]) {
            displayField.setText(displayField.getText() + ".");
        }
        if (e.getSource() == functionButtons[5]) {
            num2 = Double.parseDouble(displayField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            displayField.setText(String.valueOf(result));
        }
        if (e.getSource() == functionButtons[0]) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '+';
            displayField.setText("");
        }
        if (e.getSource() == functionButtons[1]) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '-';
            displayField.setText("");
        }
        if (e.getSource() == functionButtons[2]) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '*';
            displayField.setText("");
        }
        if (e.getSource() == functionButtons[3]) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '/';
            displayField.setText("");
        }
    }
}

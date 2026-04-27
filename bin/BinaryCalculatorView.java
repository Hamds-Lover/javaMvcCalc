import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BinaryCalculatorView extends JFrame {
    private JTextField display;
    private JButton[] digitButtons; // 0, 1
    private JButton btnAdd, btnSub, btnMul, btnDiv, btnClear, btnEquals;

    public BinaryCalculatorView() {
        setTitle("Binary Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Courier New", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Digits 0 and 1 only
        digitButtons = new JButton[2];
        digitButtons[0] = createButton("0");
        digitButtons[1] = createButton("1");
        
        btnAdd = createButton("+");
        btnSub = createButton("-");
        btnMul = createButton("*");
        btnDiv = createButton("/");
        btnClear = createButton("C");
        btnEquals = createButton("=");

        // Layout arrangement
        panel.add(digitButtons[0]);
        panel.add(digitButtons[1]);
        panel.add(btnClear);
        
        panel.add(btnAdd);
        panel.add(btnSub);
        panel.add(btnMul);
        
        panel.add(btnDiv);
        panel.add(btnEquals);
        // Empty cell filler
        panel.add(new JLabel()); 

        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Courier New", Font.BOLD, 18));
        return btn;
    }

    public void addListener(ActionListener listener) {
        for (JButton btn : digitButtons) btn.addActionListener(listener);
        btnAdd.addActionListener(listener);
        btnSub.addActionListener(listener);
        btnMul.addActionListener(listener);
        btnDiv.addActionListener(listener);
        btnClear.addActionListener(listener);
        btnEquals.addActionListener(listener);
    }

    public String getDisplayText() { return display.getText(); }
    public void setDisplayText(String text) { display.setText(text); }
    public void clearDisplay() { display.setText(""); }
}

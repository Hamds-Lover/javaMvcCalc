import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StandardCalculatorView extends JFrame {
    private JTextField display;

    private JButton btnAdd, btnSub, btnMul, btnDiv, btnEquals, btnClear;
    private JButton[] numButtons = new JButton[10];
    private JButton btnDecimal;

    public StandardCalculatorView() {
        setTitle("Standard Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setPreferredSize(new Dimension(250, 50));
        add(display, BorderLayout.NORTH);

        btnAdd     = createButton("+");
        btnSub     = createButton("-");
        btnMul     = createButton("*");
        btnDiv     = createButton("/");
        btnEquals  = createButton("=");
        btnClear   = createButton("C");
        btnDecimal = createButton(".");

        for (int i = 0; i <= 9; i++) {
            numButtons[i] = createButton(String.valueOf(i));
        }

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Row 1: C, /, *, -
        buttonPanel.add(btnClear);
        buttonPanel.add(btnDiv);
        buttonPanel.add(btnMul);
        buttonPanel.add(btnSub);

        // Row 2: 7, 8, 9, +
        buttonPanel.add(numButtons[7]);
        buttonPanel.add(numButtons[8]);
        buttonPanel.add(numButtons[9]);
        buttonPanel.add(btnAdd);

        // Row 3: 4, 5, 6, (filler)
        buttonPanel.add(numButtons[4]);
        buttonPanel.add(numButtons[5]);
        buttonPanel.add(numButtons[6]);
        buttonPanel.add(new JLabel());

        // Row 4: 1, 2, 3, =
        buttonPanel.add(numButtons[1]);
        buttonPanel.add(numButtons[2]);
        buttonPanel.add(numButtons[3]);
        buttonPanel.add(btnEquals);

        // Row 5: 0, ., (fillers)
        buttonPanel.add(numButtons[0]);
        buttonPanel.add(btnDecimal);
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 18));
        return btn;
    }

    public void addListener(ActionListener listener) {
        for (JButton btn : numButtons) {
            btn.addActionListener(listener);
        }
        btnAdd.addActionListener(listener);
        btnSub.addActionListener(listener);
        btnMul.addActionListener(listener);
        btnDiv.addActionListener(listener);
        btnEquals.addActionListener(listener);
        btnClear.addActionListener(listener);
        btnDecimal.addActionListener(listener);
    }

    public String getDisplayText() { return display.getText(); }
    public void setDisplayText(String text) { display.setText(text); }
    public void clearDisplay() { display.setText(""); }
}
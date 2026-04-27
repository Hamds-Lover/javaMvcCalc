import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ScientificCalculatorView extends JFrame {
    private JTextField display;
    private JButton[] buttons;

    public ScientificCalculatorView() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        add(display, BorderLayout.NORTH);

        String[] labels = {
            "sin", "cos", "tan", "log",
            "sqrt",  "^",   "C",   "/",
               "7",  "8",   "9",   "*",
               "4",  "5",   "6",   "-",
               "1",  "2",   "3",   "+",
               "0",  ".",   "=",    ""
        };

        JPanel panel = new JPanel(new GridLayout(6, 4, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buttons = new JButton[labels.length];
        for (int i = 0; i < labels.length; i++) {
            if (labels[i].isEmpty()) {
                panel.add(new JLabel());
            } else {
                buttons[i] = createButton(labels[i]);
                panel.add(buttons[i]);
            }
        }

        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        return btn;
    }

    public void addListener(ActionListener listener) {
        for (JButton btn : buttons) {
            if (btn != null) btn.addActionListener(listener);
        }
    }

    public String getDisplayText() { return display.getText(); }
    public void setDisplayText(String text) { display.setText(text); }
    public void clearDisplay() { display.setText(""); }
}
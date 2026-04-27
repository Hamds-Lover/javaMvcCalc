import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StandardCalculatorView extends JFrame {
    private JTextField display;
    
    // Operator buttons
    private JButton btnAdd, btnSub, btnMul, btnDiv, btnEquals, btnClear;
    
    // Number buttons array for easy management
    private JButton[] numButtons = new JButton[10]; 
    private JButton btnDecimal;

    public StandardCalculatorView() {
        setTitle("Standard Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 1. Display Setup
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setPreferredSize(new Dimension(250, 50));
        add(display, BorderLayout.NORTH);

        // 2. Button Panel Setup (Grid 4x4)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Initialize Operators
        btnAdd = createButton("+");
        btnSub = createButton("-");
        btnMul = createButton("*");
        btnDiv = createButton("/");
        btnEquals = createButton("=");
        btnClear = createButton("C");
        btnDecimal = createButton(".");

        // Initialize Numbers 0-9
        for (int i = 0; i <= 9; i++) {
            numButtons[i] = createButton(String.valueOf(i));
        }

        // --- Arrange Buttons in Grid ---
        // Row 1: 7, 8, 9, /
        buttonPanel.add(numButtons[7]);
        buttonPanel.add(numButtons[8]);
        buttonPanel.add(numButtons[9]);
        buttonPanel.add(btnDiv);

        // Row 2: 4, 5, 6, *
        buttonPanel.add(numButtons[4]);
        buttonPanel.add(numButtons[5]);
        buttonPanel.add(numButtons[6]);
        buttonPanel.add(btnMul);

        // Row 3: 1, 2, 3, -
        buttonPanel.add(numButtons[1]);
        buttonPanel.add(numButtons[2]);
        buttonPanel.add(numButtons[3]);
        buttonPanel.add(btnSub);

        // Row 4: C, 0, ., +
        buttonPanel.add(btnClear);
        buttonPanel.add(numButtons[0]);
        buttonPanel.add(btnDecimal);
        buttonPanel.add(btnAdd);

        // Note: The '=' button usually spans or sits below. 
        // For a simple 4x4 grid, we might need to adjust or add a 5th row.
        // Let's add a 5th row just for '=' to make it look better, or replace '+' logic.
        // To keep it simple 4x4, let's put '=' where '+' was and move '+'? 
        // Actually, standard calculators often have '=' span two rows or sit at bottom right.
        // Let's re-arrange slightly to include '=' properly in a 4x5 grid or replace one.
        
        // RE-ARRANGING FOR A CLEANER 4x4 LAYOUT INCLUDING '='
        // We will remove the panel above and rebuild it cleanly.
        buttonPanel.removeAll();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        // Row 1
        buttonPanel.add(numButtons[7]);
        buttonPanel.add(numButtons[8]);
        buttonPanel.add(numButtons[9]);
        buttonPanel.add(btnDiv);

        // Row 2
        buttonPanel.add(numButtons[4]);
        buttonPanel.add(numButtons[5]);
        buttonPanel.add(numButtons[6]);
        buttonPanel.add(btnMul);

        // Row 3
        buttonPanel.add(numButtons[1]);
        buttonPanel.add(numButtons[2]);
        buttonPanel.add(numButtons[3]);
        buttonPanel.add(btnSub);

        // Row 4 (C, 0, ., =) -> We'll put Add in a different spot or use a 5th row.
        // Let's do a 5-row layout for better UX.
        
        // Switching to 5 rows to accommodate all comfortably
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        
        // Row 1
        buttonPanel.add(btnClear); 
        buttonPanel.add(btnDiv);
        buttonPanel.add(btnMul);
        buttonPanel.add(btnSub);

        // Row 2
        buttonPanel.add(numButtons[7]);
        buttonPanel.add(numButtons[8]);
        buttonPanel.add(numButtons[9]);
        buttonPanel.add(btnAdd);

        // Row 3
        buttonPanel.add(numButtons[4]);
        buttonPanel.add(numButtons[5]);
        buttonPanel.add(numButtons[6]);
        // Placeholder or combine operations? Let's leave empty or add nothing
        
        // Row 4
        buttonPanel.add(numButtons[1]);
        buttonPanel.add(numButtons[2]);
        buttonPanel.add(numButtons[3]);
        buttonPanel.add(btnEquals); // Equals takes the corner

        // Row 5
        buttonPanel.add(numButtons[0]);
        buttonPanel.add(btnDecimal);
        buttonPanel.add(new JLabel()); // Filler
        buttonPanel.add(new JLabel()); // Filler

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
        // Add listeners to numbers
        for (JButton btn : numButtons) {
            btn.addActionListener(listener);
        }
        // Add listeners to operators/special
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
package EstiCalc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * Visual calculator
 */
public class Calculator extends JFrame implements ActionListener {

    /**
     * Sizes to display
     */
    private static String[] sizes = {"KiB (KB)", "MiB (MB)", "GiB (GB)"};

    /**
     * Rates to display
     */
    private static String[] rates = {"Kbps", "Mbps", "KB/s"};

    /**
     * The ETA calculator
     */
    private EstiCalc ec = new EstiCalc();

    
    private JPanel panel = new JPanel();
    private GridLayout layout = new GridLayout(0, 3, 10, 10);
    private JComboBox cbSizes = new JComboBox(sizes);
    private JComboBox cbRates = new JComboBox(rates);
    private JTextField tfSize = new JTextField("0");
    private JTextField tfRate = new JTextField("0");
    private JButton button = new JButton("Calculate");

    /**
     * Displays the pane
     */
    public Calculator() {
        // Configure layout
        super("ETA Calculator");
        setLayout(new BorderLayout());

        // Configure components
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        cbSizes.setSelectedIndex(1);
        cbRates.setSelectedIndex(2);
        button.addActionListener(Calculator.this);

        // Add components
        panel.add(new JLabel("File size:"));
        panel.add(tfSize);
        panel.add(cbSizes);
        panel.add(new JLabel("Speed:"));
        panel.add(tfRate);
        panel.add(cbRates);
        panel.add(new JLabel(""));
        panel.add(button);

        // Pack it
        setResizable(false);
        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("resources/appointment-new-2.png")).getImage());
        pack();
        setLocationRelativeTo(Calculator.this);
    }

    /**
     * Applies the system's look and feel
     */
    public static void style() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException |
                InstantiationException | IllegalAccessException e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ec.setSize(Double.parseDouble(tfSize.getText()), cbSizes.getSelectedIndex())
                .setRate(Double.parseDouble(tfRate.getText()), cbRates.getSelectedIndex());
//            System.out.println(ec);
        JOptionPane.showMessageDialog(Calculator.this, ec.message());
    }
}

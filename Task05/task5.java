import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class task5 extends JFrame {
    private final JTextField amount = new JTextField(10);
    private final JComboBox<String> from = new JComboBox<>(new String[]{"INR", "USD", "EUR"});
    private final JComboBox<String> to = new JComboBox<>(new String[]{"USD", "EUR", "INR"});
    private final JLabel result = new JLabel("Result appears here");
    private final int style;

    private static final double INR_PER_UNIT[] = {1.0, 83.0, 90.0};

    public task5(int style) {
        super("Currency Converter – Event Style " + style);
        this.style = style;
        setLayout(new FlowLayout());
        add(new JLabel("Amount")); add(amount);
        add(from); add(new JLabel("to")); add(to);
        JButton convert = new JButton("Convert");
        add(convert); add(result);

        switch (style) {
            case 1: // Frame itself implements the action through an adapter callback.
                convert.addActionListener(this::convertAction);
                amount.addActionListener(this::convertAction);
                break;
            case 2: // Named inner class.
                ConvertHandler handler = new ConvertHandler();
                convert.addActionListener(handler);
                amount.addActionListener(handler);
                break;
            case 3: // Anonymous inner class.
                ActionListener anonymous = new ActionListener() {
                    @Override public void actionPerformed(ActionEvent e) { convertAction(e); }
                };
                convert.addActionListener(anonymous); amount.addActionListener(anonymous);
                break;
            default: // One lambda listener shared by both event sources.
                ActionListener lambda = e -> convertAction(e);
                convert.addActionListener(lambda); amount.addActionListener(lambda);
        }

        addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) { dispose(); }
        });
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        pack(); setLocationRelativeTo(null);
    }

    private void convertAction(ActionEvent event) {
        try {
            double value = Double.parseDouble(amount.getText().trim());
            if (!Double.isFinite(value) || value < 0) throw new NumberFormatException();
            int f = from.getSelectedIndex(), t = to.getSelectedIndex();
            double converted = value * INR_PER_UNIT[f] / INR_PER_UNIT[t];
            String message = String.format("%.2f %s", converted, to.getSelectedItem());
            result.setText(message);
            JOptionPane.showMessageDialog(this, message, "Conversion", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            result.setText("Invalid amount");
            JOptionPane.showMessageDialog(this, "Invalid amount", "Input error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class ConvertHandler implements ActionListener {
        @Override public void actionPerformed(ActionEvent e) { convertAction(e); }
    }

    public static void main(String[] args) {
        int style = args.length == 0 ? 4 : Integer.parseInt(args[0]);
        if (style < 1 || style > 4) throw new IllegalArgumentException("Choose style 1 to 4");
        SwingUtilities.invokeLater(() -> new task5(style).setVisible(true));
    }
}
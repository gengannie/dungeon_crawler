package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TextInput extends JFrame implements ActionListener {
    private JButton submit;
    private JTextField inputField;
    private JLabel label;
    private String name;

    public TextInput() {
        JPanel contentPanel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);

        submit = new JButton("Done!");
        submit.addActionListener(this);

        inputField = new JTextField(20);
        Font bigFont = inputField.getFont().deriveFont(Font.PLAIN, 50);
        inputField.setFont(bigFont);
        contentPanel.add(inputField);
        inputField.setBounds(50, 100, 200, 100);
        contentPanel.add(submit);
        add(contentPanel);
        setSize(400, 400);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new TextInput();

    }

    public String getName(String name) {
        return name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Done!")) {
            // set the text of the label to the text of the field
            name = inputField.getText();
            try {
                new GraphicInterface(name);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}

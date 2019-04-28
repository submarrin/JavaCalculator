package calculator;

import calculator.console.Program;

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {

    private static Calculator calc;


    public static void main(String[] args) {

        JPanel windowContent = new JPanel();

        GridLayout gl = new GridLayout(6, 2);
        windowContent.setLayout(gl);

        JLabel label0 = new JLabel("Type:");
        JLabel label1 = new JLabel("Number 1:");
        JTextField field1 = new JTextField(10);
        JLabel label2 = new JLabel("Number 2:");
        JTextField field2 = new JTextField(10);
        JLabel label3 = new JLabel("Operation");
        JButton getResultButton = new JButton("RESULT");
        JTextField resultField = new JTextField(10);

        String[] operations = new String[]{"+", "-", "*", "/"};
        JComboBox operationSelector = new JComboBox(operations);

        Program program = new Program();
        JComboBox typeSelector = new JComboBox<AbstractValueParser>();
        for (int i = 0; i < program.getValueParsers().length; i++) {
            typeSelector.addItem(program.getValueParsers()[i]);
        }
        program.setCurrentValueParser((AbstractValueParser)typeSelector.getSelectedItem());
        typeSelector.addActionListener((event) -> {
            if (event.getActionCommand().equals("comboBoxChanged")) {
                program.setCurrentValueParser((AbstractValueParser)typeSelector.getSelectedItem());
            }
        });


        getResultButton.addActionListener((event) -> {
            try {
                calc = new Calculator(program.getCurrentValueParser());
                String arg1 = field1.getText();
                String arg2 = field2.getText();
                String op = (String)operationSelector.getSelectedItem();
                String res = calc.calculate(arg1, op, arg2);
                resultField.setText(res);
                System.out.println(res);
            }
            catch (Exception exception) {
                System.out.println(exception.getLocalizedMessage());
            }
        });

        windowContent.add(label0);  windowContent.add(typeSelector);
        windowContent.add(label1);  windowContent.add(field1);
        windowContent.add(label3);  windowContent.add(operationSelector);
        windowContent.add(label2);  windowContent.add(field2);
        windowContent.add(getResultButton);      windowContent.add(resultField);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem createNew =  new JMenuItem("New calculation");
        JMenuItem save = new JMenuItem("Save");
        menu.add(createNew); menu.add(save);
        menuBar.add(menu);



        JFrame frame = new JFrame("My Sweet Calculator");
        frame.setContentPane(windowContent);

        JFrame.setDefaultLookAndFeelDecorated(true);

        frame.setSize(400, 300);
        frame.setVisible(true);

        frame.setJMenuBar(menuBar);
        menuBar.setSize(400, 200);
        menuBar.setVisible(true);


    }

    public void setCurrentParser(AbstractValueParser parser) {

    }
}

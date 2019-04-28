package calculator;

import calculator.console.Program;

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
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
        JButton go = new JButton("RESULT");
        JTextField result = new JTextField(10);

        String[] operations = new String[]{"+", "-", "*", "/"};
        JComboBox comboOps = new JComboBox(operations);

        String[] types = new String[]{"Integer", "Real", "Complex"};
        JComboBox comboTypes = new JComboBox(types);

        windowContent.add(label0);  windowContent.add(comboTypes);
        windowContent.add(label1);  windowContent.add(field1);
        windowContent.add(label3);  windowContent.add(comboOps);
        windowContent.add(label2);  windowContent.add(field2);
        windowContent.add(go);      windowContent.add(result);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem createNew =  new JMenuItem("Do new calculation");
        JMenuItem save = new JMenuItem("Save");
        menu.add(createNew); menu.add(save);
        menuBar.add(menu);



        JFrame frame = new JFrame("My Calculator");
        frame.setContentPane(windowContent);

        JFrame.setDefaultLookAndFeelDecorated(true);

        frame.setSize(400, 300);
        frame.setVisible(true);

        frame.setJMenuBar(menuBar);
        menuBar.setSize(400, 200);
        menuBar.setVisible(true);


    }
}

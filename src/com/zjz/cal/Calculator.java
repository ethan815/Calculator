package com.zjz.cal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Calculator extends JFrame {
    
    public static void main(String[] args) {
        // Create application frame.
        Calculator frame = new Calculator();
        
        frame.setTitle("Calculator");
        frame.setSize(340, 420);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frame.init();
        
        // Show frame
        frame.setVisible(true);
    }
    
    private void init() 
    {
        textField = new JTextField();   
        textField.setEditable(false);
        textField.setHorizontalAlignment (JTextField.RIGHT);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));
        
        Container container = getContentPane();
        container.add(textField, BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
        panel.add(useButton('C'));
        panel.add(useButton('%'));
        panel.add(useButton('('));
        panel.add(useButton(')'));
        panel.add(useButton('7'));
        panel.add(useButton('8'));
        panel.add(useButton('9'));
        panel.add(useButton('+'));
        panel.add(useButton('4'));
        panel.add(useButton('5'));
        panel.add(useButton('6'));
        panel.add(useButton('-'));
        panel.add(useButton('1'));
        panel.add(useButton('2'));
        panel.add(useButton('3'));
        panel.add(useButton('*'));
        panel.add(useButton('.'));
        panel.add(useButton('0'));
        panel.add(useButton('/'));
        panel.add(useButton('='));
    }
    
    public JButton useButton (final char key) 
    {
        JButton button = new JButton(String.valueOf(key));
        
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                JButton btn = (JButton) event.getSource();
                char key2 = btn.getText().charAt(0);
                
                action(key2);
            }
        });
        button.addKeyListener(new KeyAdapter()
        {
            public void keyReleased(KeyEvent event)
            {
                char key2 = event.getKeyChar ();
                
                //if(key2 != key)
                  //  return;
                
                action(key2);
            }
        });
        
        return button;
    }
    
    private void action(char key2)
    {
        if(reop)
        {
            textField.setText("");
            reop = false;
        }
        
        switch(key2)
        {
            case '+':
                v1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '+';
                break;
            case '-':
                v1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '-';
                break;
            case '*':
                v1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '*';
                break;
            case '/':
                v1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '/';
                break;
            case '%':
                v1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '%';
                break;
            case '=':
                reop = true;
                v2 = Double.parseDouble(textField.getText());
                switch(operator)
                {
                    case '+':
                        value = v1 + v2;
                        break;
                    case '-':
                        value = v1 - v2;
                        break;
                    case '*':
                        value = v1 * v2;
                        break;
                    case '/':
                        value = v1 / v2;
                        break;
                    case '%':
                        value = v1 % v2;
                        break;
                    default: ;
                }
                textField.setText(String.valueOf(value));
                break;
            case 'C':
                textField.setText("");
                break;
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '0':
            case '.':
                String text = textField.getText() + key2;
                textField.setText(text);
                break;
            default: ;
        }
    }
    private JTextField textField;
    private double v1, v2, value;
    private char operator;
    private boolean reop = false;
}

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Kalkulator extends JFrame implements ActionListener {
    private JButton a1Button;
    private JButton a8Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a4Button;
    private JButton a3Button;
    private JButton a9Button;
    private JButton a0Button;
    private JPanel digitsJPanel;
    private JButton addButton;
    private JButton subtractJButton;
    private JButton multiplyJButton;
    private JButton sharingJButton;
    private JPanel operationJPanel;
    private JTextField mainTextField;
    private JPanel viewJPanel;
    private JButton reaultJButton;
    private JLabel actionJLabel;
    private JButton aDot;
    private javax.swing.JLabel informationJLabel;
    private JButton clearJButton;
    private JButton piJButton;
    private JButton deleteLastDigitJbutton;
    private JPanel mainPanel;
    private JButton eJButton;
    private JButton sinJButton;
    private JButton cosJButton;
    private JButton tgJButton;
    private JButton ctgJButton;
    private JButton x2JButton;
    private JButton sqrtJButton;
    private JButton charMinusJButton;
    private JButton xPowYJButton;

    private final String[] viewJTextFiled = {""};
    private String viewJTextFiledTemp = "";
    private List<String> tempInformation = new ArrayList<>();
    private double temp;
    private int operationOption;

    private double result;
    private int counter;

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public Kalkulator() {
        add(mainPanel);
        setTitle("Kalkulator LAB5 Tomasz Wodzinski");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        addButtonsFunction();
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                operationOption = 1;
                operation();
            }
        });
        subtractJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                operationOption = 2;
                operation();
            }
        });
        multiplyJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                operationOption = 3;
                operation();
            }
        });
        sharingJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                operationOption = 4;
                operation();
            }
        });
        sinJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++counter;
                operationOption = 5;
                operation();
            }
        });
        cosJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++counter;
                operationOption = 6;
                operation();
            }
        });
        tgJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++counter;
                operationOption = 7;
                operation();
            }
        });
        ctgJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++counter;
                operationOption = 8;
                operation();
            }
        });
        x2JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++counter;
                operationOption = 9;
                operation();
            }
        });
        sqrtJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++counter;
                operationOption = 10;
                operation();
            }
        });
        reaultJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                operation();
            }
        });
        clearJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clearC();
            }
        });
        piJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainTextField.setText(String.valueOf(Math.PI));
            }
        });
        eJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainTextField.setText(String.valueOf(Math.E));
            }
        });
        deleteLastDigitJbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clearOneChar();
            }
        });

    }

    private void addButtonsFunction() {
        addMouseListenerForButtonsDigits(a0Button, "0");
        addMouseListenerForButtonsDigits(a1Button, "1");
        addMouseListenerForButtonsDigits(a2Button, "2");
        addMouseListenerForButtonsDigits(a3Button, "3");
        addMouseListenerForButtonsDigits(a4Button, "4");
        addMouseListenerForButtonsDigits(a5Button, "5");
        addMouseListenerForButtonsDigits(a6Button, "6");
        addMouseListenerForButtonsDigits(a7Button, "7");
        addMouseListenerForButtonsDigits(a8Button, "8");
        addMouseListenerForButtonsDigits(a9Button, "9");
        addMouseListenerForButtonsDigits(aDot, ".");
        addMouseListenerForButtonsDigits(charMinusJButton, "-");
    }

    private void addMouseListenerForButtonsDigits(JButton button, String digit) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setNextDigit(digit);
            }
        });
    }

    private void setNextDigit(String digit) {
        if(mainTextField.getText().contains(".")){
            informationJLabel.setText("Nieprawidłowe dane wejściowe. Powyżej 1 znaku \".\"");
        }
        viewJTextFiled[0] = mainTextField.getText();
        viewJTextFiled[0] += digit;
        mainTextField.setText(viewJTextFiled[0]);
    }

    private void operation() {
        if (verification()) {
            ;
            informationJLabel.setText("");

            viewJTextFiledTemp = "";
            if (counter == 0) {
                viewJTextFiledTemp = temp + operationSymbolToString();
                result = temp;
            } else if (counter > 0) {
                if (operationOption >= 5 && operationOption <= 10) {
                    tempInformation.add(String.valueOf(operationSymbolToString() + "(" + temp + ")"));
                } else {
                    tempInformation.add(String.valueOf(result + operationSymbolToString() + temp));
                }

                switch (operationOption) {
                    case 1:
                        add();
                        break;
                    case 2:
                        subtract();
                        break;
                    case 3:
                        multiply();
                        break;
                    case 4:
                        sharing();
                        break;
                    case 5:
                        sin();
                        break;
                    case 6:
                        cos();
                        break;
                    case 7:
                        tg();
                        break;
                    case 8:
                        ctg();
                        break;
                    case 9:
                        xPow2();
                        break;
                    case 10:
                        xSqrt();
                        break;
                    default:
                        break;

                }
                tempInformation.add(" = ");
                for (int i = 0; i < tempInformation.size(); i++) {
                    viewJTextFiledTemp += tempInformation.get(i);
                }
                tempInformation.clear();
                temp = 0;
            }
            mainTextField.setText(String.valueOf(result));
            actionJLabel.setText(viewJTextFiledTemp);
            ++counter;
        }
    }

    private boolean verification() {

        try {
            temp = Double.parseDouble(mainTextField.getText());
            return true;
        } catch (NumberFormatException exception) {
            informationJLabel.setText("Nieprawidłowe dane wejściowe.");
        }
        return false;
    }

    private String operationSymbolToString() {
        return switch (operationOption) {
            case 1 -> " + ";
            case 2 -> " - ";
            case 3 -> " * ";
            case 4 -> " / ";
            case 5 -> " sin ";
            case 6 -> " cos ";
            case 7 -> " tg ";
            case 8 -> " ctg ";
            case 9 -> " x^2, gdzie x wynosi ";
            case 10 -> "  √ ";
            default -> " ? ";
        };
    }

    private void add() {
        result += temp;
    }

    private void subtract() {
        result -= temp;
    }

    private void multiply() {
        result *= temp;
    }

    private void sharing() {
        if (temp != 0) {
            result /= temp;
        } else {
            informationJLabel.setText("Nie dziel przez 0.");
        }
    }

    private void sin() {
        result = Math.sin(temp);
    }

    private void cos() {
        result = Math.cos(temp);
    }

    private void tg() {
        result = Math.tan(temp);
    }

    private void ctg() {
        result = 1.0 / Math.tan(temp);
    }

    private void xPow2() {
        result = Math.pow(temp, 2);
    }

    private void xSqrt() {
        if (temp >= 0) {
            result = Math.sqrt(temp);
        } else {
            informationJLabel.setText("Nie może być liczba ujemna.");
        }
    }

    private void clearC() {
        counter = 0;
        result = 0;
        temp = 0;
        mainTextField.setText("");
        actionJLabel.setText("");
        informationJLabel.setText("");
    }

    private void clearOneChar() {
        viewJTextFiled[0] = mainTextField.getText();
        if (viewJTextFiled[0].length() > 0) {
            viewJTextFiled[0] = viewJTextFiled[0].substring(0, viewJTextFiled[0].length() - 1);
            mainTextField.setText(viewJTextFiled[0]);
        }
    }

}




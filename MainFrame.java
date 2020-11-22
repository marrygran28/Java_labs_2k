package bsu.rfe.java.group7.lab2.marrygran.var4;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

        //размеры окна
        private static final int WIDTH = 400;
        private static final int HEIGHT = 400;
        //текстовые поля для считывания значений переменных
        private JTextField textFieldX;
        private JTextField textFieldY;
        private JTextField textFieldZ;
        private JTextField textFieldResult;

        private Double sum;
        private JButton MC = new JButton("MC");
        private JButton MPlus = new JButton("M+");
        private ButtonGroup myButtons = new ButtonGroup();  //группа кнопок
        private Box boxFormulaType = Box.createHorizontalBox(); //контейнер для кнопок
        private int formulaId = 1;

        //формулы
        public Double calculateFormula1(Double x, Double y, Double z){
            return Math.sqrt(Math.pow(Math.sin(y) + Math.pow(y,2)+Math.exp(Math.cos(y)) , 2)
                    + Math.pow(Math.log(Math.pow(z,2)) + Math.sin(Math.PI*Math.pow(x,2)) , 3));
        }
        public Double calculateFormula2(Double x, Double y, Double z){
            return Math.sqrt(y) * 3*Math.pow(z,x) / Math.sqrt(1+Math.pow(y,3));
        }

        private void addRadioButton(String buttonName, final int formulaId) {
            JRadioButton button = new JRadioButton(buttonName);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    MainFrame.this.formulaId = formulaId;
                    //imagePane.updateUI();
                }
            });
            myButtons.add(button);
            boxFormulaType.add(button);
        }

        public MainFrame(){
            super("Вычислитель");
            setSize(WIDTH, HEIGHT);
            Toolkit kit = Toolkit.getDefaultToolkit();
            setLocation((kit.getScreenSize().width - WIDTH),
                    (kit.getScreenSize().height - HEIGHT));

            boxFormulaType.add(Box.createHorizontalGlue());
            addRadioButton("Формула 1", 1);
            addRadioButton("Формула 2", 2);
            myButtons.setSelected(myButtons.getElements().nextElement().getModel(), true);
            boxFormulaType.add(Box.createHorizontalGlue());
            boxFormulaType.setBorder(BorderFactory.createLineBorder(Color.RED));

            // Создать область с полями ввода для X, Y, Z
            JLabel labelForX = new JLabel("X:");
            textFieldX = new JTextField("0", 10);
            textFieldX.setMaximumSize(textFieldX.getPreferredSize());
            JLabel labelForY = new JLabel("Y:");
            textFieldY = new JTextField("0", 10);
            textFieldY.setMaximumSize(textFieldY.getPreferredSize());
            JLabel labelForZ = new JLabel("Z:");
            textFieldZ = new JTextField("0", 10);
            textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
            Box hboxVariables = Box.createHorizontalBox();
            hboxVariables.setBorder(
                    BorderFactory.createLineBorder(Color.RED));
            hboxVariables.add(labelForX);
            hboxVariables.add(Box.createHorizontalStrut(10));
            hboxVariables.add(textFieldX);
            hboxVariables.add(Box.createHorizontalGlue());
            hboxVariables.add(Box.createHorizontalStrut(100));
            hboxVariables.add(Box.createHorizontalGlue());
            hboxVariables.add(labelForY);
            hboxVariables.add(Box.createHorizontalStrut(10));
            hboxVariables.add(textFieldY);
            hboxVariables.add(Box.createHorizontalGlue());
            hboxVariables.add(Box.createHorizontalStrut(100));
            hboxVariables.add(Box.createHorizontalGlue());
            hboxVariables.add(labelForZ);
            hboxVariables.add(Box.createHorizontalStrut(10));
            hboxVariables.add(textFieldZ);
            // Создать область для вывода результата
            JLabel labelForResult = new JLabel("Результат:");

            //labelResult = new JLabel("0");
            textFieldResult = new JTextField("0", 13);
            textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
            Box hboxResult = Box.createHorizontalBox();
            hboxResult.add(Box.createHorizontalGlue());
            hboxResult.add(labelForResult);
            hboxResult.add(Box.createHorizontalStrut(10));
            hboxResult.add(textFieldResult);
            hboxResult.add(Box.createHorizontalGlue());
            hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            // Создать область для кнопок
            JButton buttonCalc = new JButton("Вычислить");
            //Добавление события нажатия кнопки buttonCalc
            buttonCalc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    try {
                        Double x = Double.parseDouble(textFieldX.getText());
                        Double y = Double.parseDouble(textFieldY.getText());
                        Double z = Double.parseDouble(textFieldZ.getText());
                        Double result;
                        if (formulaId==1)
                            result = f.calculate1(x, y, z);
                        else
                            result = f.calculate2(x, y, z);
                        temp = result;
                        textFieldResult.setText(result.toString());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            JButton buttonReset = new JButton("Очистить поля");
            buttonReset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    textFieldX.setText("0");
                    textFieldY.setText("0");
                    textFieldZ.setText("0");
                    textFieldResult.setText("0");
                }
            });

            //Обработчик событий нажатия на кнопку
            MC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setSum(0.0);
                }
            });
            MPlus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.plusSum(temp);
                    textFieldResult.setText(Double.toString(f.getSum()));
                }
            });
            //Вывод кнопок на экран
            Box hboxButtons = Box.createHorizontalBox();
            hboxButtons.add(Box.createHorizontalGlue());
            hboxButtons.add(buttonCalc);
            hboxButtons.add(Box.createHorizontalStrut(30));
            hboxButtons.add(buttonReset);
            hboxButtons.add(Box.createHorizontalStrut(30));
            hboxButtons.add(MC);
            hboxButtons.add(Box.createHorizontalStrut(30));
            hboxButtons.add(MPlus);
            hboxButtons.add(Box.createHorizontalGlue());
            hboxButtons.setBorder(
                    BorderFactory.createLineBorder(Color.GREEN));
            // Связать области воедино в компоновке BoxLayout
            Box contentBox = Box.createVerticalBox();
            contentBox.add(Box.createVerticalGlue());
            contentBox.add(boxFormulaType);
            contentBox.add(hboxVariables);
            contentBox.add(hboxResult);
            contentBox.add(hboxButtons);
            contentBox.add(Box.createVerticalGlue());
            getContentPane().add(contentBox, BorderLayout.CENTER);
        }

        public static void main(String[] args){
            MainFrame frame = new MainFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
}


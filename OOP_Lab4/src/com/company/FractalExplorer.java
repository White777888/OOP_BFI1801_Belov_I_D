package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class FractalExplorer {
    //Ширина и высота
    private int size;

    //Ссылка на изображение
    private JImageDisplay image;


    //Ссылка на объект фрактала
    private FractalGenerator fractal;

    //Диапазон комплексной области
    private Rectangle2D.Double range;

    public void drawFractal(){

        double xCoord, yCoord;
        int numIters;

        for(int x = 0; x < image.getWidth(); x++){
            for(int y = 0; y < image.getHeight(); y++){


                //Перевод координат изображения в координаты фрактала
                xCoord = FractalGenerator.getCoord(range.x, range.x + range.width,
                        size, x);
                yCoord = FractalGenerator.getCoord(range.y, range.y + range.height,
                        size, y);

                //Кол-во итераций для точки
                numIters = fractal.numIterations(xCoord, yCoord);

                //Установка пикселя
                if(numIters == -1){
                    image.drawPixel(x, y, 0);
                }
                else{
                    image.drawPixel(x, y, Color.HSBtoRGB(0.7f + (float) numIters / 200f, 1f, 1f));
                }
            }
        }

        //Перерисовка
        image.repaint();

    }

    //Конструктор
    public FractalExplorer(int size){
        this.size = size;

        range = new Rectangle2D.Double(0, 0, 0, 0);

        fractal = new Mandelbrot();

        fractal.getInitialRange(range);

    }

    public void createAndShowGUI(){
        JFrame frame = new JFrame("Fractal explorer");

        JButton resetButton = new JButton("Reset Display");
        resetButton.setName("resetButton");

        image = new JImageDisplay(size, size);

        //Установили слой
        frame.setLayout(new BorderLayout());
        //Добавили компонент JImageDisplay в центр
        frame.add(image, BorderLayout.CENTER);
        //Добавили кнопку вниз
        /*frame.add(resetButton, BorderLayout.SOUTH);*/


        //Установка способа выхода из приложения
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Добавляем для изображения прослушиватель для мышки
        image.addMouseListener(new MouseHand());


        //Добавляем для кнопки прослушиватель на ее события
        MyListener commonListener = new MyListener();

        resetButton.addActionListener(commonListener);


        //5 работа
        //Добавление combobox

        JComboBox<FractalGenerator> cb = new JComboBox<>();
        cb.setName("cbFractList");

        //Добавление объектов
        cb.addItem(new Mandelbrot());
        cb.addItem(new Tricorn());
        cb.addItem(new BurningShip());

        //Добавим комбобоксу слушателя ()
        cb.addActionListener(commonListener);

        //Поясняющая надпись
        JLabel fractList = new JLabel();
        fractList.setText("Fractal: ");

        //Панелька
        JPanel NorthPanel = new JPanel();
        NorthPanel.add(fractList);
        NorthPanel.add(cb);
        //Помещаем панель в северной части окна
        frame.add(NorthPanel, BorderLayout.NORTH);

        //Кнопка для сохранения
        JButton saveButton = new JButton("Save Image");
        saveButton.setName("saveButton");

        saveButton.addActionListener(commonListener);

        //Южная панель для кнопок
        JPanel SouthPanel = new JPanel();
        SouthPanel.add(saveButton);
        SouthPanel.add(resetButton);
        //Добавили панель вниз
        frame.add(SouthPanel, BorderLayout.SOUTH);

        //Ставим имена событиям на кнопках
        resetButton.setActionCommand("reset");
        saveButton.setActionCommand("save");


        //Метод для сборки окна
        frame.pack();
        //Метод вывода окна
        frame.setVisible(true);
        //Метод установки свойства изменения размера (запрещено)
        frame.setResizable(false);


    }

    //Реализуем интерефейс для обработки событий (в данном случае нажатия на кнопки)
    private class MyListener implements ActionListener {

        //Реализация метода обработки
        public void actionPerformed(ActionEvent e){

            //Провека, на кого ссылается e.getSource()
            if(e.getSource() instanceof JComboBox){
                fractal = (FractalGenerator) ((JComboBox)e.getSource()).getSelectedItem();

                fractal.getInitialRange(range);

                drawFractal();
            }
            else if(e.getSource() instanceof JButton){

                //Если событие вызвала кнопка сброса
                if(((JButton)e.getSource()).getActionCommand().equals("reset")){
                    fractal.getInitialRange(range);
                    drawFractal();
                }
                //Если событие вызвала кнопка сохранения
                else if(((JButton)e.getSource()).getActionCommand().equals("save")){

                    JFileChooser chooser = new JFileChooser();
                    //Создаем фильтр
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                    chooser.setFileFilter(filter);
                    chooser.setAcceptAllFileFilterUsed(false);

                    //Ставим файл по умолчанию
                    chooser.setSelectedFile(new File("myfile.png"));

                    //Вывод окна
                    if(chooser.showSaveDialog(image) == JFileChooser.APPROVE_OPTION){

                        File selectedFile = chooser.getSelectedFile();

                        //Записываем файл
                        try {
                            ImageIO.write(image.image, "png", selectedFile);
                        }catch(IOException ex){
                            JOptionPane.showMessageDialog(image, ex.getMessage(), "Save error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

        }

    }

    //Наследование класса MouseAdapter для отслеживания нажатий мышки
    private class MouseHand extends MouseAdapter {

        //Реализуем метод нажатия на мышь
        public void mouseClicked(MouseEvent e) {
            //Получаем координаты фрактала по координатам нажатия
            double xCoord = FractalGenerator.getCoord(range.x,
                    range.x + range.width, size, e.getX());
            double yCoord = FractalGenerator.getCoord(range.y,
                    range.y + range.width, size, e.getY());

            //Увеличиваем область
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            //Перерисовываем
            drawFractal();
        }

    }

}

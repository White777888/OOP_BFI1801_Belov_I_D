package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class JImageDisplay extends javax.swing.JComponent {
    //Объект изображения
    public java.awt.image.BufferedImage image;

    //Конструктор
    public JImageDisplay(int w, int h){
        //Инициализация изображения
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        //Указание предпочтиельного размера компонента
        setPreferredSize(new Dimension(w, h));
    }

    //Переопределение метода отрисовки
    @Override
    protected void paintComponent(Graphics g) {

        //Вызов родительской версии метода
        super.paintComponent(g);

        //Рисование изображения
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    public void clearImage(){
        //Проход всех пикселей
        for(int x = 0; x < image.getWidth(); x++){
            for(int y = 0; y < image.getHeight(); y++){
                //Установка черного цвета
                image.setRGB(x, y, 0);
            }
        }
    }

    public void drawPixel(int x, int y, int rgbColor){
        image.setRGB(x, y, rgbColor);
    }
}

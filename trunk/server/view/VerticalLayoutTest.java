package view;

import javax.swing.*;

public class VerticalLayoutTest {
    public static void main(String[] args)
    {
        // Создаем окно
        JFrame frame = new JFrame("VerticalLayoutTest");
        // Определяем размеры
        frame.setSize(260, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Создаем панель с менеджером вертикального расположения компонентов
        JPanel contents = new JPanel(new VerticalLayout());
        // Добавим кнопки и текстовое поле в панель
        contents.add(new JButton("Продукты"  ));
        contents.add(new JButton("Галантерея"));
        contents.add(new JTextField(20));
        // Размещаем панель в контейнере
        frame.setContentPane(contents);
        // Открываем окно
        frame.setVisible(true);
    }
}

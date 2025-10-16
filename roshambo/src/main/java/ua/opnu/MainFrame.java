package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");

        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");

        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);
    }

    private GameShape generateShape() {
        // Метод повертає об'єкт ігрової фігури (камінь, ножиці чи папір) випадковим чином
        int random = new Random().nextInt(3);

        switch (random) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            default:
                return new Scissors();
        }
    }

    private int checkWinner(GameShape player, GameShape computer) {
        // Нічия
        if (player.getClass() == computer.getClass()) {
            return 0;
        }

        // Перемога гравця
        if ((player instanceof Rock && computer instanceof Scissors) ||
                (player instanceof Scissors && computer instanceof Paper) ||
                (player instanceof Paper && computer instanceof Rock)) {
            return 1;
        }

        // Інакше — перемога комп’ютера
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Генерується хід комп’ютера
        GameShape computerShape = generateShape();

        GameShape playerShape = null;

        // Визначаємо, яку кнопку натиснув гравець
        switch (e.getActionCommand()) {
            case "rock":
                playerShape = new Rock();
                break;
            case "paper":
                playerShape = new Paper();
                break;
            case "scissors":
                playerShape = new Scissors();
                break;
        }

        // Визначити результат гри
        int gameResult = checkWinner(playerShape, computerShape);

        // Сформувати повідомлення
        String message = "Гравець: " + playerShape +
                "\nКомп’ютер: " + computerShape + "\n";

        switch (gameResult) {
            case -1:
                message += "Переміг комп’ютер!";
                break;
            case 0:
                message += "Нічия!";
                break;
            case 1:
                message += "Ви перемогли!";
                break;
        }

        // Вивести діалогове вікно з повідомленням
        JOptionPane.showMessageDialog(null, message);
    }
}
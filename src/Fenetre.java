import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame implements Observateur {
    private final JLabel label = new JLabel("----", SwingConstants.CENTER);
    private final Horloge horloge = new Horloge();

    public Fenetre() {
        setTitle("Horloge");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 80);
        setLocationRelativeTo(null);
        setResizable(false);

        label.setFont(new Font("Arial", Font.PLAIN, 30));
        add(label);

        horloge.addObservateur(this);
        startHorloge();
    }

    @Override
    public void update(String hour) {
        label.setText(hour);
    }

    private void startHorloge() {
        new Thread(horloge::start).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Fenetre fen = new Fenetre();
            fen.setVisible(true);
        });
    }
}

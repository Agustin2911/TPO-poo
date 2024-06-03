import javax.swing.*;
import java.awt.event.*;

public class MiVentana extends JFrame {
    public MiVentana() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Desactiva el cierre predeterminado

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Cierra la ventana
                dispose();
                // Imprime "Hola" en la consola
                System.out.println("Hola");
            }
        });

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiVentana();
    }
}

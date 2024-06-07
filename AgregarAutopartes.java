import javax.swing.*;
import java.awt.*;

public class AgregarAutopartes extends JFrame {
    
    public AgregarAutopartes() {
        // Configuración de la ventana principal
        setTitle("Agregar Autopartes");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        // Creación de los componentes
        String[] opciones = {"Placeholder", "Option 1", "Option 2"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setPreferredSize(new Dimension(150, 30));

        JTextField cantidad = new JTextField("Cantidad");
        cantidad.setPreferredSize(new Dimension(80, 30));
        
        JButton agregarButton = new JButton("Agregar");
        agregarButton.setPreferredSize(new Dimension(100, 30));

        // Añadir componentes al panel principal
        add(comboBox);
        add(cantidad);
        add(agregarButton);

        // Mostrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación en el hilo de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AgregarAutopartes();
            }
        });
    }
}
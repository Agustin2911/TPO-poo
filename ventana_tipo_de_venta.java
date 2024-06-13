import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ventana_tipo_de_venta extends JFrame {
    public sistemaAutoparte interfaz;
    public ventana_ventas ventana_padre;
    public ventana_tipo_de_venta(ventana_ventas ventana,sistemaAutoparte x) {
        interfaz = x;
        ventana_padre=ventana;
        setSize(600, 600);
        setLayout(new GridLayout(5, 3, 10, 10)); // Adjust grid layout and gaps

        JButton venta_directa = new JButton("Agregar Venta Directa");
        JButton venta_pedido = new JButton("Agregar Venta Pedido");

        // Set button properties
        Dimension buttonSize = new Dimension(250, 50);
        venta_directa.setPreferredSize(buttonSize);
        venta_pedido.setPreferredSize(buttonSize);
        venta_directa.setBackground(new Color(65, 105, 225)); // Azul Francia (Royal Blue)
        venta_pedido.setBackground(new Color(65, 105, 225)); // Azul Francia (Royal Blue)
        venta_directa.setForeground(Color.WHITE);
        venta_pedido.setForeground(Color.WHITE);

        // Add ActionListeners
        venta_directa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_agregar_ventas_d ventana = new ventana_agregar_ventas_d(ventana_padre, x);
            }
        });

        venta_pedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle venta pedido action
            }
        });

        // Add placeholders to center the buttons
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(venta_directa);
        add(new JPanel()); // Second row
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(venta_pedido);
        add(new JPanel());
        

        
        setVisible(true);
    }
}

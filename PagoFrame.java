import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagoFrame extends JFrame {
    private JComboBox<String> metodoPagoComboBox;
    private JComboBox<Integer> cuotasComboBox;
    
    public PagoFrame() {
        // Configuración básica del JFrame
        setTitle("Método de Pago");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        // Inicialización del JComboBox para métodos de pago
        metodoPagoComboBox = new JComboBox<>(new String[]{"Efectivo", "Tarjeta de Crédito", "Débito"});
        metodoPagoComboBox.setBounds(50, 30, 200, 25);
        add(metodoPagoComboBox);
        
        // Inicialización del JComboBox para las cuotas
        cuotasComboBox = new JComboBox<>(new Integer[]{1, 3, 6, 12});
        cuotasComboBox.setBounds(50, 70, 200, 25);
        cuotasComboBox.setEnabled(false); // Deshabilitado por defecto
        add(cuotasComboBox);
        
        // Agregar ActionListener al JComboBox del método de pago
        metodoPagoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el método de pago seleccionado
                String metodoPagoSeleccionado = (String) metodoPagoComboBox.getSelectedItem();
                
                // Habilitar o deshabilitar el JComboBox de cuotas según el método de pago seleccionado
                if ("Tarjeta de Crédito".equals(metodoPagoSeleccionado)) {
                    cuotasComboBox.setEnabled(true);
                } else {
                    cuotasComboBox.setEnabled(false);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        // Crear y mostrar la interfaz
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PagoFrame().setVisible(true);
            }
        });
    }
}

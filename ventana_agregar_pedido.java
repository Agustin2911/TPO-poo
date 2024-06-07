import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.time.LocalDate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ventana_agregar_pedido extends JFrame {
    public JPanel panel;
    private JPanel botones;
    private ScrollPane barra;
    ventana_agregar_pedido(sistemaAutoparte x){
        sistemaAutoparte interfaz=x;
        setSize(800,600);
        setLayout(new GridLayout(6,1,10,10));
        LocalDate dia= LocalDate.now();
        JLabel fecha= new JLabel("fecha: ");
        fecha.setPreferredSize(new Dimension(400,100));
        JTextField entrada_fecha=new JTextField(String.valueOf(dia));
        entrada_fecha.setPreferredSize(new Dimension(400,100));
        add(fecha);
        add(entrada_fecha);
        JLabel etiqueta_agregar=new JLabel("agregar autopartes al pedido: ");
        add(etiqueta_agregar);
        barra=new ScrollPane();
        add(barra);
        barra.setSize(400, 200);
        botones = new JPanel();
        botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
        barra.add(botones);
        panel=new JPanel();
        add(panel);
        JButton agregar_cliente=new JButton("agregar cliente");
        agregar_cliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventana_agregar_cliente ventana = new ventana_agregar_cliente(ventana_agregar_pedido.this,interfaz);
            }
        });
        agregar_cliente.setPreferredSize(new Dimension(400,100));
        add(agregar_cliente);
        setVisible(true);
    }

    public void agregar_cliente(JTextField x){
        panel.add(x);
        panel.revalidate();
        panel.repaint();
    }
}

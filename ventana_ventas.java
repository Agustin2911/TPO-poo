import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;


public class ventana_ventas extends JFrame {
    public sistemaAutoparte interfaz;
    private JPanel botones;
    private ScrollPane barra;
    private ArrayList<JButton> lista_botones;
    public  venta_mostrar boton_seleccionado;
    public sistemaAutoparte sistema;
    public ventana_ventas(sistemaAutoparte x){
        interfaz=x;
        lista_botones=new ArrayList<>();
        JFrame ventana_hija= new JFrame();
        ventana_hija.setLayout(new BorderLayout());
        ventana_hija.setSize(1200,600);
        JPanel contenedor_derecho=new JPanel();
        contenedor_derecho.setSize(400,600);
        contenedor_derecho.setLayout(new GridLayout(4,1,10,10));
        ventana_hija.add(contenedor_derecho,BorderLayout.EAST);
        JButton boton_agregar_autoparte= new JButton("agregar venta");
        boton_agregar_autoparte.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_agregar_autoparte.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        contenedor_derecho.add(boton_agregar_autoparte);
        boton_agregar_autoparte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventana_tipo_de_venta ventana= new ventana_tipo_de_venta(ventana_ventas.this,interfaz);
            }
        });
        JButton boton_eliminar_autoparte= new JButton("eliminar venta");
        boton_eliminar_autoparte.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_eliminar_autoparte.setForeground(Color.WHITE);
        boton_eliminar_autoparte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                eliminar();
            }
        });
        contenedor_derecho.add(boton_eliminar_autoparte);
        ventana_hija.setVisible(true);
        JPanel contenedor_izquierdo=new JPanel();
        contenedor_izquierdo.setSize(800,600);
        ventana_hija.add(contenedor_izquierdo,BorderLayout.CENTER);
        contenedor_izquierdo.setLayout(new FlowLayout());
        barra=new ScrollPane();
        contenedor_izquierdo.add(barra);
        barra.setSize(800, 500);
        botones = new JPanel();
        botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
        barra.add(botones);
        cargar_elementos();
    }
    private void eliminar() {
        if (boton_seleccionado != null) {
            Integer id=boton_seleccionado.id_elemento();
            interfaz.eliminarVenta(id);
            lista_botones.remove(boton_seleccionado.boton_final);
            botones.remove(boton_seleccionado.boton_final);
            botones.revalidate();
            botones.repaint();
            boton_seleccionado = null; 
        }
    }

    public void cargar_elementos(){
        lista_botones=new ArrayList<>();
        botones.removeAll();
        barra.add(botones);
        for(venta i:interfaz.ventas.ventas){
            venta_mostrar elemento=new venta_mostrar(i);
            JButton boton=elemento.boton();
            boton.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    boton_seleccionado=elemento;
                }
            }
            );
            lista_botones.add(boton);
            botones.add(boton);
        }            
            barra.revalidate();
            barra.repaint();
    }
}

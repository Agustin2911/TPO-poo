import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class ventana_pedidos extends JFrame{
    private JPanel botones;
    private ScrollPane barra;
    private ArrayList<JButton> lista_botones;
    public JButton boton_seleccionado;
    ventana_pedidos (){
        JFrame ventana_hija= new JFrame();
        ventana_hija.setLayout(new BorderLayout());
        ventana_hija.setSize(1200,600);
        lista_botones=new ArrayList<>();
        JPanel contenedor_derecho=new JPanel();
        contenedor_derecho.setSize(400,600);
        contenedor_derecho.setLayout(new GridLayout(3,1,10,10));
        ventana_hija.add(contenedor_derecho,BorderLayout.EAST);
        JButton boton_agregar_pedido= new JButton("agregar pedido");
        boton_agregar_pedido.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_agregar_pedido.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        contenedor_derecho.add(boton_agregar_pedido);
        boton_agregar_pedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });
        JButton boton_eliminar_autoparte= new JButton("eliminar pedido");
        boton_eliminar_autoparte.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_eliminar_autoparte.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        boton_eliminar_autoparte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                eliminar();
            }
        });
        contenedor_derecho.add(boton_eliminar_autoparte);
        JButton boton_modificar_pedido= new JButton("modificar pedido");
        boton_modificar_pedido.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_modificar_pedido.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        contenedor_derecho.add(boton_modificar_pedido);
        ventana_hija.setVisible(true);
        JPanel contenedor_izquierdo=new JPanel();
        contenedor_izquierdo.setSize(800,600);
        ventana_hija.add(contenedor_izquierdo,BorderLayout.CENTER);
        contenedor_izquierdo.setLayout(new FlowLayout());
        barra=new ScrollPane();
        contenedor_izquierdo.add(barra);
        barra.setSize(800, 500);
        botones=new JPanel();
        botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
        barra.add(botones);

    }
    private void eliminar() {
        if (boton_seleccionado != null) {
            lista_botones.remove(boton_seleccionado);
            botones.remove(boton_seleccionado);
            botones.revalidate();
            botones.repaint();
            boton_seleccionado = null; // Resetear el botón seleccionado
        }
    }
    public void agregar(String [] e){
        JButton boton =new JButton(String.format("%s %s %s %s %s %s %s %s  ",e[0], e[1],e[2],e[4],e[5],e[6],e[7],e[8]));
        boton.setPreferredSize(new Dimension(800, 100));
        boton.setMinimumSize(new Dimension(800, 100));
        boton.setMaximumSize(new Dimension(800, 100));
        
        boton.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton.setForeground(Color.WHITE);
        boton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                boton_seleccionado=boton;
        }
        });
        lista_botones.add(boton);
        botones.add(boton);            
        barra.revalidate();
        barra.repaint();
}
}
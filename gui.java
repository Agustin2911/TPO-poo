import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class gui extends JFrame {

    public gui(sistemaAutoparte x) {
        sistemaAutoparte interfaz=x;
        setTitle("Multiple Div Example with JPanel");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Desactiva el cierre predeterminado

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                interfaz.guardar_datos(new registros(interfaz.catalogo.autopartes,interfaz.pedidos.listaPedidos,interfaz.ventas.ventas,interfaz.clientes.clientes,interfaz.catalogo.getid(),interfaz.pedidos.getid(),interfaz.ventas.getid(),interfaz.clientes.getid()));
            }
        });
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        // Crear el primer JPanel (similar a un "div")
        JPanel container1 = new JPanel();
        container1.setLayout(new BorderLayout()); // Diseño de flujo
        container1.setPreferredSize(new Dimension(300, 600)); // Ancho preferido

        JPanel container2 = new JPanel();
        container2.setLayout(new BorderLayout());
        container2.setPreferredSize(new Dimension(300, 600)); // Ancho preferido

        // Crear el segundo JPanel (similar a otro "div")
        JPanel container3 = new JPanel();
        container3.setLayout(new GridLayout(3, 1)); // Diseño de cuadrícula
        container3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding


        // Configurar espaciado horizontal y vertical entre los componentes en GridLayout
        ((GridLayout) container3.getLayout()).setHgap(10); // Espacio horizontal de 10 píxeles
        ((GridLayout) container3.getLayout()).setVgap(10); // Espacio vertical de 10 píxeles

        JButton boton_gestionar_autopartes = new JButton("Gestionar autopartes");
        boton_gestionar_autopartes.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_gestionar_autopartes.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        boton_gestionar_autopartes.setPreferredSize(new Dimension(300, 100));
        boton_gestionar_autopartes.setMinimumSize(new Dimension(300, 100));
        boton_gestionar_autopartes.setMaximumSize(new Dimension(300, 100));
        boton_gestionar_autopartes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_autopartes ventana_autopartes = new ventana_autopartes(interfaz);
            
            }
        });

        JButton boton_registrar_ventas = new JButton("Registrar ventas");
        boton_registrar_ventas.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_registrar_ventas.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        boton_registrar_ventas.setPreferredSize(new Dimension(300, 100));
        boton_registrar_ventas.setMinimumSize(new Dimension(300, 100));
        boton_registrar_ventas.setMaximumSize(new Dimension(300, 100));
        boton_registrar_ventas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al método especificado cuando se presione el botón
                System.out.println(getName());
            }
        });

        JButton boton_gestionar_pedido = new JButton("Gestionar pedidos");
        boton_gestionar_pedido.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_gestionar_pedido.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        boton_gestionar_pedido.setPreferredSize(new Dimension(300, 100));
        boton_gestionar_pedido.setMinimumSize(new Dimension(300, 100));
        boton_gestionar_pedido.setMaximumSize(new Dimension(300, 100));
        boton_gestionar_pedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventana_pedidos pedidos=new ventana_pedidos(interfaz);
            }
        });

        container3.add(boton_gestionar_autopartes);
        container3.add(boton_registrar_ventas);
        container3.add(boton_gestionar_pedido);

        // Añadir los JPanels al JFrame con BorderLayout
        add(container1, BorderLayout.WEST);
        add(container2, BorderLayout.EAST);
        add(container3, BorderLayout.CENTER);
    }
}


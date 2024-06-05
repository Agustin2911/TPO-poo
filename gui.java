import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
class gui extends JFrame {

    public gui(sistemaAutoparte x) {
        sistemaAutoparte interfaz=x;
        setTitle("Multiple Div Example with JPanel");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Desactiva el cierre predeterminado

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                interfaz.guardar_datos(new registros(interfaz.catalogo.autopartes,interfaz.pedidos.listaPedidos,interfaz.ventas.ventas,interfaz.getId_autopartes()));
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
                ventana_pedidos pedidos=new ventana_pedidos();
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







/*class ventana_modificar_autopartes extends JFrame{
        ventana_autopartes ventana_padre;
        ventana_modificar_autopartes(ventana_autopartes x,sistemaAutoparte y){
            ventana_padre=x;
            sistemaAutoparte interfaz=y;
            JFrame ventana=new JFrame();
            ventana.setSize(new Dimension(800,600));
            ventana.setLayout(new GridLayout(10,2,20,20));
            JLabel titulo_denominacion=new JLabel("modificar la denominacion del autoparte: ");
            titulo_denominacion.setPreferredSize(new Dimension(400,100));
            JTextField denominacion= new JTextField();
            denominacion.setPreferredSize(new Dimension(400,100));
            JLabel titulo_descripcion = new JLabel("modificar la descripción del autoparte: ");
            JTextArea descripcion = new JTextArea();
            JScrollPane scrollDescripcion = new JScrollPane(descripcion);
            JLabel titulo_categoria=new JLabel("modificar la categoria del auto: ");
            titulo_categoria.setPreferredSize(new Dimension(400,100));
            JTextField categoria= new JTextField();
            categoria.setPreferredSize(new Dimension(400,100));
            JLabel titulo_marca = new JLabel("modificar la marca del autoparte: ");
            titulo_marca.setPreferredSize(new Dimension(400,100));
            JTextField marca=new JTextField();
            marca.setPreferredSize(new Dimension(400,100));
            JLabel titulo_auto= new JLabel("modificar de que auto es el autoparte: ");
            titulo_auto.setPreferredSize(new Dimension(400,100));
            JTextField auto = new JTextField();
            auto.setPreferredSize(new Dimension(400,100));
            JLabel titulo_precio= new JLabel("modificar el precio del  autoparte: ");
            titulo_precio.setPreferredSize(new Dimension(400,100));
            JTextField precio = new JTextField();
            precio.setPreferredSize(new Dimension(400,100));
            JLabel titulo_stock= new JLabel("modificar el stock del autoparte: ");
            titulo_stock.setPreferredSize(new Dimension(400,100));
            JTextField stock = new JTextField();
            stock.setPreferredSize(new Dimension(400,100));
            JLabel titulo_stock_minimo= new JLabel("modificar el stock minimo de esta autoparte: ");
            titulo_stock_minimo.setPreferredSize(new Dimension(400,100));
            JTextField stock_minimo = new JTextField();
            stock_minimo.setPreferredSize(new Dimension(400,100));
            JLabel titulo_enlace= new JLabel("modificar el enlace a la web del autoparte: ");
            titulo_enlace.setPreferredSize(new Dimension(400,100));
            JTextField enlace = new JTextField();
            enlace.setPreferredSize(new Dimension(400,100));
            JButton modificar= new JButton("modificar autoparte");
            modificar.setPreferredSize(new Dimension(400,100));
            modificar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){ 
                    String[] datos={denominacion.getText(),descripcion.getText(),categoria.getText(),marca.getText(),auto.getText(),precio.getText(),stock.getText(),stock_minimo.getText(),enlace.getText()};
                    interfaz.modificarAutoparte(id,datos[0], datos[1], datos[2],datos[3],datos[4],datos[5], new Integer(datos[6]),new Integer(datos[7]) , datos[8]);
                    ventana_padre.cargar_elementos();
                }
            });
            ventana.add(titulo_denominacion);
            ventana.add(denominacion);
            ventana.add(titulo_descripcion);
            ventana.add(scrollDescripcion);
            ventana.add(titulo_categoria);
            ventana.add(categoria);
            ventana.add(titulo_marca);
            ventana.add(marca);
            ventana.add(titulo_auto);
            ventana.add(auto);
            ventana.add(titulo_precio);
            ventana.add(precio);
            ventana.add(titulo_stock);
            ventana.add(stock);
            ventana.add(titulo_stock_minimo);
            ventana.add(stock_minimo);
            ventana.add(titulo_enlace);
            ventana.add(enlace);
            ventana.add(modificar);       
            ventana.setVisible(true);
        }
}

*/
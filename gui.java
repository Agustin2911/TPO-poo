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
                interfaz.mostrarAutopartes();
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
class ventana_autopartes extends JFrame{
    private JPanel botones;
    private ScrollPane barra;
    private ArrayList<JButton> lista_botones;
    public  JButton boton_seleccionado;
    public sistemaAutoparte sistema;
    public sistemaAutoparte interfaz;
    
    ventana_autopartes (sistemaAutoparte x){
        interfaz=x;
        lista_botones=new ArrayList<>();
        JFrame ventana_hija= new JFrame();
        ventana_hija.setLayout(new BorderLayout());
        ventana_hija.setSize(1200,600);
        JPanel contenedor_derecho=new JPanel();
        contenedor_derecho.setSize(400,600);
        contenedor_derecho.setLayout(new GridLayout(4,1,10,10));
        ventana_hija.add(contenedor_derecho,BorderLayout.EAST);
        JButton boton_agregar_autoparte= new JButton("agregar autoparte");
        boton_agregar_autoparte.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_agregar_autoparte.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        contenedor_derecho.add(boton_agregar_autoparte);
        boton_agregar_autoparte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventana_agregar_autopartes ventana_agregar= new ventana_agregar_autopartes(ventana_autopartes.this,interfaz);
            }
        });
        JButton boton_eliminar_autoparte= new JButton("eliminar autoparte");
        boton_eliminar_autoparte.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_eliminar_autoparte.setForeground(Color.WHITE);
        boton_eliminar_autoparte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                eliminar();
            }
        });
        contenedor_derecho.add(boton_eliminar_autoparte);
        JButton boton_modificar_autoparte= new JButton("modificar autoparte");
        boton_modificar_autoparte.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_modificar_autoparte.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        contenedor_derecho.add(boton_modificar_autoparte);
        JButton boton_modificar_stock= new JButton("modificar stock");
        boton_modificar_stock.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton_modificar_stock.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        contenedor_derecho.add(boton_modificar_stock);
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
            String id=((boton_seleccionado.getText()).split(" "))[0];
            Integer id_s=Integer.parseInt(id);
            interfaz.eliminarAutoparte(id_s);
            lista_botones.remove(boton_seleccionado);
            botones.remove(boton_seleccionado);
            botones.revalidate();
            botones.repaint();
            boton_seleccionado = null; // Resetear el botón seleccionado
        }
    }

    public void cargar_elementos(){
        for(autoparte i:interfaz.catalogo.autopartes){
            JButton boton =new JButton(String.format("%s %s %s %s %s %s %s %s %s %s",i.getid(),i.denominacion, i.descripcion,i.categoria,i.marca,i.vehiculo,i.getprecio(),i.getstock(),i.getstock_minimo(),i.enlace));
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
        }            
            barra.revalidate();
            barra.repaint();
    }
    
}


class ventana_pedidos extends JFrame{
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


class ventana_agregar_autopartes extends JFrame{
    ventana_autopartes ventana_padre;
    ventana_agregar_autopartes(ventana_autopartes x,sistemaAutoparte y){
        ventana_padre=x;
        sistemaAutoparte interfaz=y;
        JFrame ventana=new JFrame();
        ventana.setSize(new Dimension(800,600));
        ventana.setLayout(new GridLayout(10,2,20,20));
        JLabel titulo_denominacion=new JLabel("ingrese la denominacion del auto: ");
        titulo_denominacion.setPreferredSize(new Dimension(400,100));
        JTextField denominacion= new JTextField();
        denominacion.setPreferredSize(new Dimension(400,100));
        JLabel titulo_descripcion = new JLabel("Ingrese la descripción del autoparte: ");
        JTextArea descripcion = new JTextArea();
        JScrollPane scrollDescripcion = new JScrollPane(descripcion);
        JLabel titulo_categoria=new JLabel("ingrese la categoria del auto: ");
        titulo_categoria.setPreferredSize(new Dimension(400,100));
        JTextField categoria= new JTextField();
        categoria.setPreferredSize(new Dimension(400,100));
        JLabel titulo_marca = new JLabel("ingrese la marca del autoparte: ");
        titulo_marca.setPreferredSize(new Dimension(400,100));
        JTextField marca=new JTextField();
        marca.setPreferredSize(new Dimension(400,100));
        JLabel titulo_auto= new JLabel("ingrese de que auto es el autoparte: ");
        titulo_auto.setPreferredSize(new Dimension(400,100));
        JTextField auto = new JTextField();
        auto.setPreferredSize(new Dimension(400,100));
        JLabel titulo_precio= new JLabel("ingrese el precio del  autoparte: ");
        titulo_precio.setPreferredSize(new Dimension(400,100));
        JTextField precio = new JTextField();
        precio.setPreferredSize(new Dimension(400,100));
        JLabel titulo_stock= new JLabel("ingrese el stock del autoparte: ");
        titulo_stock.setPreferredSize(new Dimension(400,100));
        JTextField stock = new JTextField();
        stock.setPreferredSize(new Dimension(400,100));
        JLabel titulo_stock_minimo= new JLabel("ingrese el stock minimo de esta autoparte: ");
        titulo_stock_minimo.setPreferredSize(new Dimension(400,100));
        JTextField stock_minimo = new JTextField();
        stock_minimo.setPreferredSize(new Dimension(400,100));
        JLabel titulo_enlace= new JLabel("ingrese el enlace a la web del autoparte: ");
        titulo_enlace.setPreferredSize(new Dimension(400,100));
        JTextField enlace = new JTextField();
        enlace.setPreferredSize(new Dimension(400,100));
        JButton agregar= new JButton("agregar autoparte");
        agregar.setPreferredSize(new Dimension(400,100));
        agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Integer id=interfaz.getId_autopartes()+1; 
                String[] datos={denominacion.getText(),descripcion.getText(),categoria.getText(),marca.getText(),auto.getText(),precio.getText(),stock.getText(),stock_minimo.getText(),enlace.getText()};
                interfaz.cargarAutoparte(id,datos[0], datos[1], datos[2],datos[3],datos[4],datos[5], new Integer(datos[6]),new Integer(datos[7]) , datos[8]);
                ventana_padre.cargar_elementos();
                interfaz.setId_autopartes(id);
            }
        });
        JButton limpiar= new JButton("limpiar");
        limpiar.setSize(new Dimension(400,100));
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
        ventana.add(agregar);
        ventana.add(limpiar);        
        ventana.setVisible(true);
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
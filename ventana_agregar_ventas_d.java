import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
public class ventana_agregar_ventas_d extends JFrame {
    private JPanel panel; // Panel para mostrar componentes añadidos dinámicamente
    private JPanel botones; // Panel para contener botones
    private ScrollPane barra; // ScrollPane para hacer los botones desplazables
    private sistemaAutoparte interfaz; // Interfaz al sistema (se asume que está definido en otra parte)
    public cliente_mostrar cliente;
    public ventana_ventas ventana_padre;
    public Integer total_c;
    public JTextField total_entrada;
    public JComboBox<cliente> clientes;
    public JButton seleccionar_cliente;
    public JButton agregar_cliente;
    public JPanel centro;
    public GridBagConstraints gbc;
    public pedidoEnProceso pedido_en_proceso;
    public boolean dataSaved;
    public ventana_agregar_ventas_d(ventana_ventas y,sistemaAutoparte x) {
        interfaz = x;
        ventana_padre=y;
        total_c=0;
        pedido_en_proceso=new pedidoEnProceso();
        dataSaved=false;
        // Configuración de la ventana
        setSize(800, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!dataSaved) {
                    interfaz.devolver_stock(pedido_en_proceso.devolver_productos(),pedido_en_proceso.devolver_cantidades());
                }
                dispose();
            }
        });

        // Configuración del panel central
        centro = new JPanel();
        centro.setPreferredSize(new Dimension(600, 400));
        centro.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes de fecha
        LocalDate dia = LocalDate.now();
        JLabel fecha = new JLabel("Fecha: ");
        fecha.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        centro.add(fecha, gbc);

        JTextField entrada_fecha = new JTextField(String.valueOf(dia));
        entrada_fecha.setEnabled(false);
        entrada_fecha.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        centro.add(entrada_fecha, gbc);


        JComboBox<String> metodoPagoComboBox = new JComboBox<>(new String[]{"Efectivo", "Tarjeta de Crédito", "Débito"});
        metodoPagoComboBox.setBounds(50, 30, 200, 25);
        metodoPagoComboBox.setBackground(Color.WHITE);
        gbc.gridx = 2;
        gbc.gridy = 0;
        centro.add(metodoPagoComboBox,gbc);
        
        // Inicialización del JComboBox para las cuotas
        JComboBox<Integer>cuotasComboBox = new JComboBox<>(new Integer[]{2, 3,6});
        cuotasComboBox.setBounds(50, 70, 200, 25);
        cuotasComboBox.setEnabled(false);
        cuotasComboBox.setBackground(Color.WHITE);
        gbc.gridx = 3;
        gbc.gridy = 0;
        centro.add(cuotasComboBox,gbc);
        
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

        // Etiqueta para agregar partes
        JLabel etiqueta_agregar = new JLabel("Agregar autopartes a la venta: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        centro.add(etiqueta_agregar, gbc);
        
        String[] opciones=agregar_autopartes();
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setPreferredSize(new Dimension(150, 30));
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        centro.add(comboBox,gbc);

        JTextField cantidad = new JTextField("Cantidad");
        cantidad.setPreferredSize(new Dimension(80, 30));
        gbc.gridx=2;
        gbc.gridy=1;
        gbc.gridwidth=1;
        centro.add(cantidad,gbc);      
        JButton agregarButton = new JButton("Agregar");
        agregarButton.setPreferredSize(new Dimension(100, 30));
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                autoparte ap =interfaz.buscAutoparte((String)comboBox.getSelectedItem());
                Integer cant=Integer.valueOf(cantidad.getText());
                boolean x=agregar_boton(ap,cant);
                if(x){
                    pedido_en_proceso.agregar_autopartes(ap,cant);
                    interfaz.eliminar_stock(ap, cant);
                }
            }
        });
        agregarButton.setBackground(new Color(0, 102, 204));
        agregarButton.setForeground(Color.WHITE);
        gbc.gridx=3;
        gbc.gridy=1;
        gbc.gridwidth=1;
        centro.add(agregarButton,gbc);
        // Añadir componentes al panel principal
 
        // ScrollPane para botones
        barra = new ScrollPane();
        barra.setPreferredSize(new Dimension(400, 200));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        centro.add(barra, gbc);

        botones = new JPanel();
        botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
        barra.add(botones);


        JLabel total= new JLabel("Total$: ");
        total.setPreferredSize(new Dimension(80, 30));
        gbc.gridx=2;
        gbc.gridy=2;
        gbc.gridwidth=1;
        centro.add(total,gbc);      
        
        total_entrada= new JTextField("0");
        total_entrada.setPreferredSize(new Dimension(80, 30));
        gbc.gridx=3;
        gbc.gridy=2;
        gbc.gridwidth=1;
        centro.add(total_entrada,gbc);      

        // Panel para componentes dinámicos
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 100));
        

        clientes=new JComboBox<>();
        cargar_combobox();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        centro.add(clientes, gbc);

        seleccionar_cliente= new JButton("seleccionar cliente");
        seleccionar_cliente.setForeground(Color.WHITE);
        seleccionar_cliente.setBackground(new Color(0, 102, 204));
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        seleccionar_cliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cliente x=(cliente)clientes.getSelectedItem();
                cliente= new cliente_mostrar(x);
                agregar_cliente(cliente.texto_mostrar);
            }
        });
        centro.add(seleccionar_cliente, gbc);



        agregar_cliente = new JButton("Agregar cliente");
        agregar_cliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana_agregar_cliente ventana = new ventana_agregar_cliente(ventana_agregar_ventas_d.this, interfaz);
                ventana.setVisible(true);
            }
        });
        agregar_cliente.setPreferredSize(new Dimension(200, 100));
        agregar_cliente.setBackground(new Color(0, 102, 204));
        agregar_cliente.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        centro.add(agregar_cliente, gbc);

        JButton boton_agregar= new JButton("agregar venta");
        boton_agregar.setPreferredSize(new Dimension(200, 100));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        boton_agregar.setBackground(new Color(0, 102, 204));
        boton_agregar.setForeground(Color.WHITE);
        boton_agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(cliente!=null){
                metodoDePago forma_de_pago;
                    switch ((String)metodoPagoComboBox.getSelectedItem()) {
                        case "Efectivo":
                            forma_de_pago=new efectivo(Float.valueOf(total_c));
                            break;
                        case "Tarjeta de Crédito":
                            forma_de_pago=new TarjetaDeCredito(Float.valueOf(total_c),(Integer)cuotasComboBox.getSelectedItem());
                            break;
                        case "Débito":
                            forma_de_pago= new debito(total_c);
                            break;
                    
                        default:
                            forma_de_pago=null;
                            break;
                    }
                interfaz.iniciarVentaDirecta(interfaz.ventas.getid(),cliente.cliente.getnombre(), pedido_en_proceso.devolver_productos(), pedido_en_proceso.devolver_cantidades(),forma_de_pago);
                interfaz.ventas.setid(interfaz.ventas.getid()+1);
                ventana_padre.cargar_elementos();
                dataSaved=true;
                
                JOptionPane.showMessageDialog(null, 
                            "la venta se ha concretado correctamente", 
                      "venta ok", 
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, 
                            "seleccione un cliente para realizar la venta", 
                      "seleccionar cliente", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        centro.add(boton_agregar,gbc);
        add(centro, BorderLayout.CENTER);
        setVisible(true);
    }

    // Método para agregar un nuevo cliente al panel
    public void agregar_cliente(JTextField x) {
        centro.remove(clientes);
        centro.remove(seleccionar_cliente);
        centro.remove(agregar_cliente);
        panel.add(x);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        centro.add(panel, gbc);
        centro.revalidate();
        centro.repaint();
    }

    public String[] agregar_autopartes(){
       Integer largo= interfaz.catalogo.autopartes.size();
       String [] opciones= new String[largo];
       Integer cant=0;
       for (autoparte i : interfaz.catalogo.autopartes){
            opciones[cant]=i.denominacion;
            cant++;
       }
       return opciones;
       
    }


    public autoparte buscarAutoparte(String nombre){
        return interfaz.buscAutoparte(nombre);
    }

    public boolean agregar_boton(autoparte ap,Integer num){
        boolean stocK_ok=interfaz.hay_stock(ap,Integer.valueOf(num));
        if(!stocK_ok){
                JOptionPane.showMessageDialog(null, 
                "no hay suficiente stock de la autoparte: "+ap.denominacion+" el stock actual es de: "+String.valueOf(ap.getstock()), 
          "Error no hay suficiente stock", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            String a=ap.denominacion+" "+num;
            JButton boton =new JButton(a);
            total_c+=Integer.valueOf(ap.getprecio())*num;
            boton.setPreferredSize(new Dimension(415, 50));
            boton.setMaximumSize(new Dimension(415, 50));
            boton.setMinimumSize(new Dimension(415, 50));
            boton.setBackground(new Color(0, 102, 204));
            boton.setForeground(Color.WHITE);
            botones.add(boton);
            total_entrada.setText(String.valueOf(total_c));
            total_entrada.revalidate();
            total_entrada.repaint();
            botones.revalidate();
            botones.repaint();
            return true;
    }

    }

    public void cargar_combobox(){
        for (cliente i :interfaz.clientes.clientes){
            clientes.addItem(i);
        }
    }
}
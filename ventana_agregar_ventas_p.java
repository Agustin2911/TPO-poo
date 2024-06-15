import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana_agregar_ventas_p extends JFrame {
    public JPanel entrada_cliente;
    public JPanel botones;
    public ScrollPane barra;
    public sistemaAutoparte interfaz; 
    public cliente_mostrar cliente;
    public ventana_ventas ventana_padre;
    public Integer total_c;
    public JTextField total_entrada;
    public pedidos_mostrar boton_Seleccionado;
    public ArrayList<JButton> lista_botones;
    public pedido pedido_final;
    public ventana_agregar_ventas_p(ventana_ventas y,sistemaAutoparte x) {
        interfaz = x;
        ventana_padre=y;
        total_c=0;
        setSize(1000, 600);
        setLayout(new BorderLayout());
       

        // Configuración del panel central
        JPanel centro = new JPanel();
        centro.setPreferredSize(new Dimension(1000, 1000));
        centro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
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
        entrada_fecha.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 0;
        gbc.gridy = 1;
        centro.add(entrada_fecha, gbc);

        JLabel titulo_pago=new JLabel("metodo de pago: ");
        titulo_pago.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        centro.add(titulo_pago, gbc);
       
        JComboBox<String> metodoPagoComboBox = new JComboBox<>(new String[]{"Efectivo", "Tarjeta de Crédito", "Débito"});
        metodoPagoComboBox.setBounds(50, 30, 50, 25);
        gbc.gridx = 1;
        gbc.gridy = 1;
        centro.add(metodoPagoComboBox,gbc);
        
        // Inicialización del JComboBox para las cuotas
        JComboBox<Integer>cuotasComboBox = new JComboBox<>(new Integer[]{2, 3,6});
        cuotasComboBox.setBounds(50, 70, 50, 25);
        cuotasComboBox.setEnabled(false);
        gbc.gridx = 2;
        gbc.gridy = 1;
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

        
        barra = new ScrollPane();
        barra.setPreferredSize(new Dimension(415, 200));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        centro.add(barra, gbc);

        botones = new JPanel();
        botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
        barra.add(botones);


        JLabel total= new JLabel("Total: ");
        total.setPreferredSize(new Dimension(50, 30));
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

        JButton boton_seleccionar=new JButton("seleccionar pedido");
        boton_seleccionar.setBackground(new Color(0, 102, 204));
        boton_seleccionar.setForeground(Color.WHITE);
        boton_seleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            if(boton_Seleccionado!=null){    
                pedido pedido = boton_Seleccionado.pedido;
                boolean estado_pedido=true;
                Integer cont=0;
                for (Integer i=0 ; pedido.productos.size()!=i;i++){
                    autoparte ap=pedido.productos.get(i);
                    Integer cant=pedido.cantidades.get(i);
                    cont+=Integer.valueOf(ap.getprecio())*cant;
                    if((ap.getstock())<cant){
                        JOptionPane.showMessageDialog(null, 
                            "la venta no se ha podido concretar porque la autoparte "+ap.denominacion+" tiene una stock de "+ap.getstock()+" el pedido requiere "+cant, 
                            "venta ok", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(estado_pedido){
                    pedido_final=pedido;
                    total_entrada.setText(String.valueOf(cont));
                    cliente cliente= pedido_final.getcliente();
                    cliente_mostrar mostrar=new cliente_mostrar(cliente);
                    entrada_cliente.add(mostrar.texto_mostrar);
                    entrada_cliente.revalidate();
                    entrada_cliente.repaint();
                }
            }
        }});
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        centro.add(boton_seleccionar,gbc);     

        JLabel titulo_cliente=new JLabel("cliente: ");
        titulo_cliente.setPreferredSize(new Dimension(250,100));
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=1;
        centro.add(titulo_cliente,gbc);

        entrada_cliente = new JPanel();
        entrada_cliente.setPreferredSize(new Dimension(400,100));
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.gridwidth=1;
        centro.add(entrada_cliente,gbc);

        JButton boton_agregar= new JButton("agregar venta");
        boton_agregar.setPreferredSize(new Dimension(100, 50));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        boton_agregar.setBackground(new Color(0, 102, 204));
        boton_seleccionar.setForeground(Color.WHITE);
        boton_agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(pedido_final!=null){
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
                interfaz.ventaXPedido(interfaz.ventas.getid(), pedido_final.getcliente().getnombre(), forma_de_pago, pedido_final);
                interfaz.ventas.setid(interfaz.ventas.getid()+1);
                interfaz.cancelarPedido(pedido_final.getidPedido());
                ventana_padre.cargar_elementos();
                cargar_elementos();
                
                JOptionPane.showMessageDialog(null, 
                            "la venta se ha concretado correctamente", 
                      "venta ok", 
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        cargar_elementos();
        centro.add(boton_agregar,gbc);
        add(centro, BorderLayout.CENTER);
        setVisible(true);
    }




    public autoparte buscarAutoparte(String nombre){
        return interfaz.buscAutoparte(nombre);
    }

    

    public void cargar_elementos(){
            lista_botones=new ArrayList<>();
            botones.removeAll();
            barra.add(botones);
            for(pedido i:interfaz.pedidos.listaPedidos){
                pedidos_mostrar elemento=new pedidos_mostrar(i);
                JButton boton=elemento.boton();
                boton.setPreferredSize(new Dimension(680, 100));
                boton.setMinimumSize(new Dimension(680, 100));
                boton.setMaximumSize(new Dimension(680, 100));
                boton.addActionListener(new ActionListener() {
                    @Override 
                    public void actionPerformed(ActionEvent e){
                        boton_Seleccionado=elemento;
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
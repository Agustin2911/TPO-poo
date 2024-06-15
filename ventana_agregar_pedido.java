import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana_agregar_pedido extends JFrame {
    private JPanel panel; // Panel para mostrar componentes añadidos dinámicamente
    private JPanel botones; // Panel para contener botones
    private ScrollPane barra; // ScrollPane para hacer los botones desplazables
    private sistemaAutoparte interfaz; // Interfaz al sistema (se asume que está definido en otra parte)
    public cliente_mostrar cliente;
    public ArrayList<autoparte> repuestos;
    public ArrayList<Integer> cantidad_r;
    public ventana_pedidos ventana_padre;
    public JComboBox<cliente> clientes;
    public JButton seleccionar_cliente;
    public JButton agregar_cliente;
    public JPanel centro;
    public GridBagConstraints gbc;
    public ventana_agregar_pedido(ventana_pedidos y,sistemaAutoparte x) {
        interfaz = x;
        ventana_padre=y;
        repuestos=new ArrayList<>();
        cantidad_r=new ArrayList<>();
        
        // Configuración de la ventana
        setSize(800, 600);
        setLayout(new BorderLayout());
       

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

        // Etiqueta para agregar partes
        JLabel etiqueta_agregar = new JLabel("Agregar autopartes al pedido: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        centro.add(etiqueta_agregar, gbc);
        
        String[] opciones=agregar_autopartes();
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setPreferredSize(new Dimension(150, 30));
        comboBox.setBackground(Color.WHITE);
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
        agregarButton.setBackground(new Color(0, 102, 204));
        agregarButton.setForeground(Color.WHITE);
        agregarButton.setPreferredSize(new Dimension(100, 30));
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                agregar_boton((String)comboBox.getSelectedItem(),cantidad.getText());
            }
        });
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

        // Panel de clientes
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


        JLabel titulo_cliente=new JLabel("cliente: ");
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        centro.add(titulo_cliente,gbc);

        agregar_cliente = new JButton("Agregar cliente");
        agregar_cliente.setBackground(new Color(0, 102, 204));
        agregar_cliente.setForeground(Color.WHITE);
        agregar_cliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana_agregar_cliente ventana = new ventana_agregar_cliente(ventana_agregar_pedido.this, interfaz);
                ventana.setVisible(true);
            }
        });
        agregar_cliente.setPreferredSize(new Dimension(200, 100));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        centro.add(agregar_cliente, gbc);

        JButton boton_agregar= new JButton("agregar pedido");
        boton_agregar.setPreferredSize(new Dimension(200, 100));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        boton_agregar.setBackground(new Color(0, 102, 204));
        boton_agregar.setForeground(Color.WHITE);
        boton_agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                if(cliente!=null && botones.getComponentCount() != 0) {
                    for (Component comp : botones.getComponents()) {
                        JButton btn = (JButton) comp;
                        String[] text=(btn.getText()).split(" ");
                        autoparte ap=interfaz.buscAutoparte(text[0]);
                        agregar(ap,Integer.valueOf(text[1]));
                        interfaz.eliminar_stock(ap,Integer.valueOf(text[1]));
                }
                interfaz.registrarPedido(interfaz.pedidos.getid(),repuestos,cantidad_r, entrada_fecha.getText(),cliente.cliente);
                interfaz.pedidos.setid(interfaz.pedidos.getid()+1);
                ventana_padre.cargar_elementos();
                }
                else{
                    if(cliente==null){
                        JOptionPane.showMessageDialog(null, 
                            "el pedido no se puede realizar porque no hay cliente", 
                      "no hay cliente", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                    else if(botones.getComponentCount() == 0){
                        JOptionPane.showMessageDialog(null, 
                            "el pedido no tiene autorepuestos, porfavor ingresar autopartes", 
                      "no hay autorepuestos", 
                            JOptionPane.ERROR_MESSAGE);
                    }
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

    public void elementos(){

    }
    public void agregar(autoparte autoparte,Integer cant){
        repuestos.add(autoparte);
        cantidad_r.add(cant);
    }
    public autoparte buscarAutoparte(String nombre){
        return interfaz.buscAutoparte(nombre);
    }

    public void agregar_boton(String autoparte,String num){
        autoparte ap=interfaz.buscAutoparte(autoparte);
        boolean stocK_ok=interfaz.hay_stock(ap,Integer.valueOf(num));
        if(!stocK_ok){
                JOptionPane.showMessageDialog(null, 
                "no hay suficiente stock de la autoparte: "+ap.denominacion+" el stock actual es de: "+String.valueOf(ap.getstock()), 
          "Error no hay suficiente stock", 
                JOptionPane.ERROR_MESSAGE);
        }
        else{
            String a=autoparte+" "+num;
            JButton boton =new JButton(a);
            agregar(ap,Integer.valueOf(num));
            boton.setPreferredSize(new Dimension(415, 50));
            boton.setMaximumSize(new Dimension(415, 50));
            boton.setMinimumSize(new Dimension(415, 50));
            boton.setBackground(new Color(0, 102, 204));
            boton.setForeground(Color.WHITE);
            botones.add(boton);
            botones.revalidate();
            botones.repaint();

    }
    }
    
    public void cargar_combobox(){
        for (cliente i :interfaz.clientes.clientes){
            clientes.addItem(i);
        }
    }
}

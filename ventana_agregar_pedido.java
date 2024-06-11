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
    public ventana_agregar_pedido(ventana_pedidos y,sistemaAutoparte x) {
        interfaz = x;
        ventana_padre=y;
        repuestos=new ArrayList<>();
        cantidad_r=new ArrayList<>();
        
        // Configuración de la ventana
        setSize(800, 600);
        setLayout(new BorderLayout());
       

        // Configuración del panel central
        JPanel centro = new JPanel();
        centro.setPreferredSize(new Dimension(600, 400));
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

        // Panel para componentes dinámicos
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 100));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        centro.add(panel, gbc);

        JLabel titulo_cliente=new JLabel("cliente: ");
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        centro.add(titulo_cliente,gbc);

        JButton agregar_cliente = new JButton("Agregar cliente");
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
        boton_agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                for (Component comp : botones.getComponents()) {
                        JButton btn = (JButton) comp;
                        String[] text=(btn.getText()).split(" ");
                        agregar(text[0],new Integer(text[1]));
                        interfaz.eliminar_stock(text[0],new Integer(text[1]));
                }
                interfaz.registrarPedido(interfaz.pedidos.getid(),repuestos,cantidad_r, entrada_fecha.getText(),cliente.cliente);
                interfaz.pedidos.setid(interfaz.pedidos.getid()+1);
                ventana_padre.cargar_elementos();
                
            }
        });
        centro.add(boton_agregar,gbc);
        add(centro, BorderLayout.CENTER);
        setVisible(true);
    }

    // Método para agregar un nuevo cliente al panel
    public void agregar_cliente(JTextField x) {
        panel.add(x);
        panel.revalidate();
        panel.repaint();
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
    public void agregar(String nombre,Integer cant){
        repuestos.add(buscarAutoparte(nombre));
        cantidad_r.add(cant);
    }
    public autoparte buscarAutoparte(String nombre){
        return interfaz.buscAutoparte(nombre);
    }

    public void agregar_boton(String autoparte,String num){
        String a=autoparte+" "+num;
        JButton boton =new JButton(a);
        boton.setPreferredSize(new Dimension(400,50));
        botones.add(boton);
        barra.revalidate();
        barra.repaint();
    }
    
}

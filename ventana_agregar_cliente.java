import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ventana_agregar_cliente extends JFrame{
    public JTextField entrada_nombre;
    public JTextField entrada_direccion;
    public JTextField entrada_telefono;
    public JTextField entrada_localidad;
    public JTextField entrada_provincia;
    public JTextField entrada_email;
    public sistemaAutoparte interfaz;
    public  ventana_agregar_cliente(ventana_agregar_pedido ventana,sistemaAutoparte x){
        interfaz=x; 
        ventana_agregar_pedido ventana_padre=ventana;
        setSize(800,600);
        setLayout(new GridLayout(7,2,10,10));
        JLabel etiqueta_nombre= new JLabel("nombre del cliente(nombre y apellido): ");
        entrada_nombre = new JTextField();
        JLabel etiqueta_direccion= new JLabel("direccion del cliente(calle + numero de domicilio + codigo postal): ");
        entrada_direccion = new JTextField();
        JLabel etiqueta_telefono= new JLabel("telefono del cliente:");
        entrada_telefono = new JTextField();
        JLabel etiqueta_localidad= new JLabel("localidad del cliente:");
        entrada_localidad = new JTextField();
        JLabel etiqueta_provincia= new JLabel("provincia del cliente:");
        entrada_provincia = new JTextField();
        JLabel etiqueta_email= new JLabel("email del cliente:");
        entrada_email = new JTextField();
        JButton boton_agregar=new JButton("agregar cliente");
        boton_agregar.setForeground(Color.WHITE);
        boton_agregar.setBackground(new Color(0, 102, 204));
        boton_agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(esta_ok()){
                cliente cliente =new cliente(interfaz.clientes.getid(),entrada_nombre.getText(),entrada_direccion.getText(),entrada_telefono.getText(),entrada_localidad.getText(),entrada_provincia.getText(),entrada_email.getText());
                cliente_mostrar mostrar=new cliente_mostrar(cliente);
                interfaz.clientes.setid((interfaz.clientes.getid())+1);
                ventana_padre.agregar_cliente(mostrar.texto());
                ventana_padre.cliente=mostrar;
                interfaz.agregar_clientes(cliente);
            }
            else{
                JOptionPane.showMessageDialog(null, 
            "hay campos sin completar", 
      "campos sin completar", 
            JOptionPane.ERROR_MESSAGE);
            }
            }
        });
        JButton boton_limpiar=new JButton("limpiar");
        boton_limpiar.setForeground(Color.WHITE);
        boton_limpiar.setBackground(new Color(0, 102, 204));
        boton_limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                entrada_nombre.setText("");
                entrada_direccion.setText("");
                entrada_telefono.setText("");
                entrada_localidad.setText("");
                entrada_provincia.setText("");
                entrada_email.setText("");
            }
        });
        add(etiqueta_nombre);
        add(entrada_nombre);
        add(etiqueta_direccion);
        add(entrada_direccion);
        add(etiqueta_telefono);
        add(entrada_telefono);
        add(etiqueta_localidad);
        add(entrada_localidad);
        add(etiqueta_provincia);
        add(entrada_provincia);
        add(etiqueta_email);
        add(entrada_email);
        add(boton_agregar);
        add(boton_limpiar);
        setVisible(true);
    }

    public  ventana_agregar_cliente(ventana_agregar_ventas_d ventana,sistemaAutoparte x){
        interfaz=x; 
        ventana_agregar_ventas_d ventana_padre=ventana;
        setSize(800,600);
        setLayout(new GridLayout(7,2,10,10));
        JLabel etiqueta_nombre= new JLabel("nombre del cliente(nombre y apellido): ");
        entrada_nombre = new JTextField();
        JLabel etiqueta_direccion= new JLabel("direccion del cliente(calle + numero de domicilio + codigo postal): ");
        entrada_direccion = new JTextField();
        JLabel etiqueta_telefono= new JLabel("telefono del cliente:");
        entrada_telefono = new JTextField();
        JLabel etiqueta_localidad= new JLabel("localidad del cliente:");
        entrada_localidad = new JTextField();
        JLabel etiqueta_provincia= new JLabel("provincia del cliente:");
        entrada_provincia = new JTextField();
        JLabel etiqueta_email= new JLabel("email del cliente:");
        entrada_email = new JTextField();
        JButton boton_agregar=new JButton("agregar cliente");
        boton_agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(esta_ok()){
                cliente cliente =new cliente(interfaz.clientes.getid(),entrada_nombre.getText(),entrada_direccion.getText(),entrada_telefono.getText(),entrada_localidad.getText(),entrada_provincia.getText(),entrada_email.getText());
                cliente_mostrar mostrar=new cliente_mostrar(cliente);
                interfaz.clientes.setid((interfaz.clientes.getid())+1);
                ventana_padre.agregar_cliente(mostrar.texto());
                ventana_padre.cliente=mostrar;
            }
            else{
                    JOptionPane.showMessageDialog(null, 
                "hay campos sin completar", 
          "campos sin completar", 
                JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton boton_limpiar=new JButton("limpiar");
        boton_limpiar.setForeground(Color.WHITE);
        boton_limpiar.setBackground(new Color(0, 102, 204));
        boton_limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                entrada_nombre.setText("");
                entrada_direccion.setText("");
                entrada_telefono.setText("");
                entrada_localidad.setText("");
                entrada_provincia.setText("");
                entrada_email.setText("");
            }
        });
        add(etiqueta_nombre);
        add(entrada_nombre);
        add(etiqueta_direccion);
        add(entrada_direccion);
        add(etiqueta_telefono);
        add(entrada_telefono);
        add(etiqueta_localidad);
        add(entrada_localidad);
        add(etiqueta_provincia);
        add(entrada_provincia);
        add(etiqueta_email);
        add(entrada_email);
        add(boton_agregar);
        add(boton_limpiar);
        setVisible(true);
    }
    public boolean esta_ok(){
        Boolean rf=true;
        if (entrada_nombre.getText().equals("")){
            rf=false;
        }
        if(entrada_telefono.getText().equals("")){
            rf=false;
        }
        if(entrada_direccion.getText().equals("")){
            rf=false;
        }
        if(entrada_localidad.getText().equals("")){
            rf=false;
        }
        if(entrada_provincia.getText().equals("")){
            rf=false;
        }
        if(entrada_email.getText().equals("")){
            rf=false;
        }
        return rf;
      }
}
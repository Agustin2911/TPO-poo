import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ventana_modificar_autopartes {
    ventana_autopartes ventana_padre;
    public ventana_modificar_autopartes(ventana_autopartes x,sistemaAutoparte y){
        ventana_padre=x;
        sistemaAutoparte interfaz=y;
        JFrame ventana=new JFrame();
        ventana.setSize(new Dimension(800,600));
        ventana.setLayout(new GridLayout(10,2,20,20));
        JLabel titulo_denominacion=new JLabel("modificar la denominacion del auto: ");
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
                Integer id=interfaz.getId_autopartes()+1; 
                interfaz.modificarAutoparte(id,denominacion.getText(),descripcion.getText(),categoria.getText(),marca.getText(),auto.getText(),precio.getText(),new Integer (stock.getText()),new Integer(stock_minimo.getText()),enlace.getText());
                ventana_padre.modificar_elemento();
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


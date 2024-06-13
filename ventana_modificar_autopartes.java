import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ventana_modificar_autopartes {
    ventana_autopartes ventana_padre;
    stock_mostrar elemento;
    public ventana_modificar_autopartes(ventana_autopartes x,sistemaAutoparte y,stock_mostrar elemento_m){
        ventana_padre=x;
        elemento=elemento_m;
        sistemaAutoparte interfaz=y;
        JFrame ventana=new JFrame();
        ventana.setSize(new Dimension(800,600));
        ventana.setLayout(new GridLayout(10,2,20,20));
        JLabel titulo_denominacion=new JLabel("modificar la denominación: ");
        titulo_denominacion.setPreferredSize(new Dimension(400,100));
        JTextField denominacion= new JTextField(elemento.autoparte.denominacion);
        denominacion.setPreferredSize(new Dimension(400,100));
        JLabel titulo_descripcion = new JLabel("modificar la descripcion: ");
        JTextArea descripcion = new JTextArea(elemento.autoparte.descripcion);
        JScrollPane scrollDescripcion = new JScrollPane(descripcion);
        JLabel titulo_categoria=new JLabel("modificar la categoria: ");
        titulo_categoria.setPreferredSize(new Dimension(400,100));
        JTextField categoria= new JTextField(elemento.autoparte.categoria);
        categoria.setPreferredSize(new Dimension(400,100));
        JLabel titulo_marca = new JLabel("modificar la marca del autoparte: ");
        titulo_marca.setPreferredSize(new Dimension(400,100));
        JTextField marca=new JTextField(elemento.autoparte.marca);
        marca.setPreferredSize(new Dimension(400,100));
        JLabel titulo_auto= new JLabel("modificar de que auto es el autoparte: ");
        titulo_auto.setPreferredSize(new Dimension(400,100));
        JTextField auto = new JTextField(elemento.autoparte.vehiculo);
        auto.setPreferredSize(new Dimension(400,100));
        JLabel titulo_precio= new JLabel("modificar el precio del producto: ");
        titulo_precio.setPreferredSize(new Dimension(400,100));
        JTextField precio = new JTextField(elemento.autoparte.getprecio());
        precio.setPreferredSize(new Dimension(400,100));
        JLabel titulo_stock= new JLabel("modificar el stock: ");
        titulo_stock.setPreferredSize(new Dimension(400,100));
        JTextField stock = new JTextField(String.valueOf(elemento.autoparte.getstock()));
        stock.setPreferredSize(new Dimension(400,100));
        JLabel titulo_stock_minimo= new JLabel("modificar el stock minimo: ");
        titulo_stock_minimo.setPreferredSize(new Dimension(400,100));
        JTextField stock_minimo = new JTextField(String.valueOf(elemento.autoparte.getstock_minimo()));
        stock_minimo.setPreferredSize(new Dimension(400,100));
        JLabel titulo_enlace= new JLabel("modificar el enlace a la web del autoparte: ");
        titulo_enlace.setPreferredSize(new Dimension(400,100));
        JTextField enlace = new JTextField(elemento.autoparte.enlace);
        enlace.setPreferredSize(new Dimension(400,100));
        JButton modificar= new JButton("modificar autoparte");
        modificar.setPreferredSize(new Dimension(400,100));
        modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ 
                interfaz.modificarAutoparte(elemento.autoparte,denominacion.getText(),descripcion.getText(),categoria.getText(),marca.getText(),auto.getText(),precio.getText(),Integer.valueOf(stock.getText()),Integer.valueOf(stock_minimo.getText()),enlace.getText());
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


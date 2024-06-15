import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


class ventana_agregar_autopartes extends JFrame{
    public ventana_autopartes ventana_padre;
    public JTextField denominacion;
    public JTextArea descripcion;
    public JTextField categoria;
    public JTextField marca;
    public JTextField auto ;
    public JTextField precio;
    public JTextField stock;
    public JTextField stock_minimo;
    public JTextField enlace;
    ventana_agregar_autopartes(ventana_autopartes x,sistemaAutoparte y){
        ventana_padre=x;
        sistemaAutoparte interfaz=y;
        JFrame ventana=new JFrame();
        ventana.setSize(new Dimension(800,600));
        ventana.setLayout(new GridLayout(10,2,20,20));
        JLabel titulo_denominacion=new JLabel("ingrese la denominacion del auto: ");
        titulo_denominacion.setPreferredSize(new Dimension(400,100));
        denominacion= new JTextField();
        denominacion.setPreferredSize(new Dimension(400,100));
        JLabel titulo_descripcion = new JLabel("Ingrese la descripción del autoparte: ");
        descripcion = new JTextArea();
        JScrollPane scrollDescripcion = new JScrollPane(descripcion);
        JLabel titulo_categoria=new JLabel("ingrese la categoria del auto: ");
        titulo_categoria.setPreferredSize(new Dimension(400,100));
        categoria= new JTextField();
        categoria.setPreferredSize(new Dimension(400,100));
        JLabel titulo_marca = new JLabel("ingrese la marca del autoparte: ");
        titulo_marca.setPreferredSize(new Dimension(400,100));
        marca=new JTextField();
        marca.setPreferredSize(new Dimension(400,100));
        JLabel titulo_auto= new JLabel("ingrese de que auto es el autoparte: ");
        titulo_auto.setPreferredSize(new Dimension(400,100));
        auto = new JTextField();
        auto.setPreferredSize(new Dimension(400,100));
        JLabel titulo_precio= new JLabel("ingrese el precio del  autoparte: ");
        titulo_precio.setPreferredSize(new Dimension(400,100));
        precio = new JTextField();
        precio.setPreferredSize(new Dimension(400,100));
        JLabel titulo_stock= new JLabel("ingrese el stock del autoparte: ");
        titulo_stock.setPreferredSize(new Dimension(400,100));
        stock = new JTextField();
        stock.setPreferredSize(new Dimension(400,100));
        JLabel titulo_stock_minimo= new JLabel("ingrese el stock minimo de esta autoparte: ");
        titulo_stock_minimo.setPreferredSize(new Dimension(400,100));
        stock_minimo = new JTextField();
        stock_minimo.setPreferredSize(new Dimension(400,100));
        JLabel titulo_enlace= new JLabel("ingrese el enlace a la web del autoparte: ");
        titulo_enlace.setPreferredSize(new Dimension(400,100));
        enlace = new JTextField();
        enlace.setPreferredSize(new Dimension(400,100));
        JButton agregar= new JButton("agregar autoparte");
        agregar.setPreferredSize(new Dimension(400,100));
        agregar.setBackground(new Color(0, 102, 204));
        agregar.setForeground(Color.WHITE);
        agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(esta_ok()){
                Integer id=interfaz.catalogo.getid()+1; 
                interfaz.cargarAutoparte(id,denominacion.getText(),descripcion.getText(),categoria.getText(),marca.getText(),auto.getText(),precio.getText(),Integer.valueOf(stock.getText()),Integer.valueOf(stock_minimo.getText()),enlace.getText());
                ventana_padre.cargar_elementos();
                interfaz.catalogo.setid(id);
                }
                else{
                    JOptionPane.showMessageDialog(null, 
                "hay campos sin completar", 
          "campos sin completar", 
                JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton limpiar= new JButton("limpiar");
        limpiar.setForeground(Color.WHITE);
        limpiar.setBackground(new Color(0, 102, 204));
        limpiar.setSize(new Dimension(400,100));
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                denominacion.setText("");
                descripcion.setText("");
                scrollDescripcion.revalidate();
                scrollDescripcion.repaint();
                categoria.setText("");
                marca.setText("");
                auto.setText("");
                precio.setText("");
                stock.setText("");
                stock_minimo.setText("");
                enlace.setText("");
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
        ventana.add(agregar);
        ventana.add(limpiar);        
        ventana.setVisible(true);
    }

  public boolean esta_ok(){
    Boolean rf=true;
    if (denominacion.getText().equals("")){
        rf=false;
    }
    if(descripcion.getText().equals("")){
        rf=false;
    }
    if(categoria.getText().equals("")){
        rf=false;
    }
    if(marca.getText().equals("")){
        rf=false;
    }
    if(auto.getText().equals("")){
        rf=false;
    }
    if(precio.getText().equals("")){
        rf=false;
    }
    if(stock.getText().equals("")){
        rf=false;
    }
    if(stock_minimo.getText().equals("")){
        rf=false;
    }
    if(enlace.getText().equals("")){
        rf=false;
    }
    return rf;
  }

}
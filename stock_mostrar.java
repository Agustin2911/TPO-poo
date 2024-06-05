import javax.swing.*;
import java.awt.*;


public class stock_mostrar extends JFrame {
    public autoparte autoparte;
    public JButton boton_final;
    public stock_mostrar(autoparte x){
        this.autoparte=x;
    }

    public JButton boton(){
        JButton boton =new JButton(String.format("%s %s %s %s %s %s %s %s %s %s",autoparte.getid(),autoparte.denominacion, autoparte.descripcion,autoparte.categoria,autoparte.marca,autoparte.vehiculo,autoparte.getprecio(),autoparte.getstock(),autoparte.getstock_minimo(),autoparte.enlace));
        boton.setPreferredSize(new Dimension(800, 100));
        boton.setMinimumSize(new Dimension(800, 100));
        boton.setMaximumSize(new Dimension(800, 100));
        boton.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton.setForeground(Color.WHITE);
        boton_final=boton;
        return boton;
    }
    
    public Integer id_elemento(){
        return autoparte.getid();
    } 
}

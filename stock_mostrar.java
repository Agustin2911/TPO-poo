import javax.swing.*;
import java.awt.*;


public class stock_mostrar extends JFrame {
    public autoparte autoparte;
    public JButton boton_final;
    public String nombre;
    public stock_mostrar(autoparte x){
        this.autoparte=x;
    }

    public JButton boton(){
        JButton boton =new JButton(String.format("%s %s %s %s %s %s %s %s %s %s",autoparte.getid(),autoparte.denominacion, autoparte.descripcion,autoparte.categoria,autoparte.marca,autoparte.vehiculo,autoparte.getprecio(),String.valueOf(autoparte.getstock()),String.valueOf(autoparte.getstock_minimo()),autoparte.enlace));
        boton.setPreferredSize(new Dimension(800, 100));
        boton.setMinimumSize(new Dimension(800, 100));
        boton.setMaximumSize(new Dimension(800, 100));
        if(autoparte.getstock()<=autoparte.getstock_minimo()){
            boton.setBackground(new Color(255, 0,0));// Cambiar el color de fondo del botón
            } 
        else{
            boton.setBackground(new Color(0, 102, 204));
        }
        boton.setForeground(Color.WHITE);
        boton_final=boton;
        return boton;
    }
    
    public Integer id_elemento(){
        return autoparte.getid();
    } 
    
}

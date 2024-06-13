import javax.swing.JButton;
import java.awt.*;
public class venta_mostrar {
    public venta venta;
    public JButton boton_final;
    
    public venta_mostrar(venta x){
        this.venta=x;
    }

    public JButton boton(){
        JButton boton =new JButton(String.format("%s %s %s ",venta.getid(),venta.getNombre(),venta.gettotal()));
        boton.setPreferredSize(new Dimension(800, 100));
        boton.setMinimumSize(new Dimension(800, 100));
        boton.setMaximumSize(new Dimension(800, 100));
        boton.setBackground(new Color(0, 102, 204)); 
        boton.setForeground(Color.WHITE);
        boton_final=boton;
        return boton;
    }
    
    public Integer id_elemento(){
        return venta.getid();
    } 
    
}
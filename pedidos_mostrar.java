import javax.swing.JButton;
import java.awt.*;
public class pedidos_mostrar {
    public pedido pedido;
    public JButton boton_final;
    
    public pedidos_mostrar(pedido x){
        this.pedido=x;
    }

    public JButton boton(){
        JButton boton =new JButton(String.format("%s %s %s ",pedido.getidPedido(),pedido.getfecha(),pedido.getcliente().getnombre()));
        boton.setPreferredSize(new Dimension(800, 100));
        boton.setMinimumSize(new Dimension(800, 100));
        boton.setMaximumSize(new Dimension(800, 100));
        boton.setBackground(new Color(0, 102, 204)); // Cambiar el color de fondo del botón
        boton.setForeground(Color.WHITE);
        boton_final=boton;
        return boton;
    }
    
    public Integer id_elemento(){
        return pedido.getidPedido();
    } 
    
}

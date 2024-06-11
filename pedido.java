import java.util.ArrayList;
import java.io.Serializable;


public class pedido implements Serializable{
    private Integer idPedido;
    public ArrayList<autoparte>productos;
    public ArrayList<Integer>cantidades;
    private String fecha;
    private cliente cliente;

    public pedido(Integer id,ArrayList<autoparte> autopartes,ArrayList<Integer> cant,String f,cliente cliente_pedido){
        setidPedido(id);
        productos=autopartes;
        cantidades=cant;
        setfecha(f);
        setcliente(cliente_pedido);
        
    }
    public void eliminarProducto(autoparte autoparte){
        productos.remove(autoparte);
    }
    public void setidPedido(Integer id){
        this.idPedido=id;
    }

    public Integer getidPedido(){
        return this.idPedido;
    }


    public void setcliente(cliente cliente_p){
        this.cliente=cliente_p;
    }

    public cliente getcliente(){
        return this.cliente;
    }

    public void setfecha(String f){
        this.fecha=f;
    }
    public String getfecha(){
        return fecha;
    }
}

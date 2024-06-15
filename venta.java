import java.util.ArrayList;
import java.io.Serializable;

public class venta implements Serializable{
    private Integer id;
    private String nombre;
    public ArrayList<detalleVenta> lista_detalles;
    private  metodoDePago metodoDePago; 
    private Float total;

    public venta(Integer id_v,String nombre_v,ArrayList<autoparte>autopartes,ArrayList<Integer>cantidades,metodoDePago formaPago){
        lista_detalles=new ArrayList<>();
        setid(id_v);
        setNombre(nombre_v);
        ventaSinPedido(autopartes, cantidades);
        setmetodoDePago(formaPago);
        settotal(metodoDePago.gettotal());
        
    }

    public venta(Integer id_v,String nombre_v,metodoDePago formaPago,pedido pedido){
        lista_detalles=new ArrayList<>();
        setid(id_v);
        setNombre(nombre_v);
        ventaXPedido(pedido);
        setmetodoDePago(formaPago);
        settotal(metodoDePago.gettotal());
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setid(Integer id) {
        this.id = id;
    }
    public Integer getid() {
        return id;
    }

    public void ventaXPedido(pedido pedido){
        for (autoparte i :pedido.productos){
            Integer index=pedido.productos.indexOf(i);
            lista_detalles.add(new detalleVenta(i.getid(),pedido.cantidades.get(index),Float.parseFloat( i.getprecio())));
        }
    }

    public void ventaSinPedido(ArrayList<autoparte>autopartes,ArrayList<Integer>cantidades){
        for (autoparte i :autopartes){
            Integer index=autopartes.indexOf(i);
            lista_detalles.add(new detalleVenta(i.getid(),cantidades.get(index),Float.parseFloat(i.getprecio())));
        }
    }


    public void setmetodoDePago(metodoDePago x){
        this.metodoDePago=x;
    }
    public metodoDePago getmetodoDePago(){
        return this.metodoDePago;
    }

    public void settotal(Float x){
        this.total=x;
    }

    public Float gettotal(){
        return total;
    }



}
import java.util.ArrayList;
import java.io.Serializable;

public class venta implements Serializable{
    public Integer id;
    public ArrayList<detalleVenta> lista_detalles;
    private Float subTotal=0f;
    private  metodoDePago metodoDePago; 
    private Float total;

    public venta(Integer id_v,ArrayList<autoparte>autopartes,ArrayList<Integer>cantidades,String formaPago){
        id=id_v;
        ventaSinPedido(autopartes, cantidades);
        tipoDePago(formaPago);
    }

    public venta(String formaPago,pedido pedido){
            ventaXPedido(pedido);
            tipoDePago(formaPago);
    }

    public void ventaXPedido(pedido pedido){
        for (autoparte i :pedido.productos){
            Integer index=pedido.productos.indexOf(i);
            lista_detalles.add(new detalleVenta(i.getid(),pedido.cantidades.get(index),Float.parseFloat( i.getprecio())));
        }
        generarSubTotal();
    }

    public void ventaSinPedido(ArrayList<autoparte>autopartes,ArrayList<Integer>cantidades){
        for (autoparte i :autopartes){
            Integer index=autopartes.indexOf(i);
            lista_detalles.add(new detalleVenta(i.getid(),cantidades.get(index),Float.parseFloat(i.getprecio())));
        }
        generarSubTotal();
    }
    public void setsubTotal(float i){
        this.subTotal+=i;
    }
    public float getsubTotal(){
        return this.subTotal;
    }

    public void generarSubTotal(){
        for (detalleVenta i : lista_detalles){
            setsubTotal(i.precioUnitario);
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
    public void tipoDePago (String formaPago){
        setmetodoDePago(new metodoDePago(formaPago,getsubTotal()));
        settotal(getmetodoDePago().gettotal());
    }


}
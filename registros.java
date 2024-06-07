
import java.util.ArrayList;

import java.io.Serializable;

class registros implements Serializable{
    public ArrayList<autoparte> registro1;
    public ArrayList<pedido> registro2;
    public ArrayList<venta> registro3;
    public ArrayList<cliente> registro4;
    private Integer id_autopartes;
    private Integer id_pedidos;
    private Integer id_ventas;
    private Integer id_clientes;
    public registros(ArrayList<autoparte>x , ArrayList<pedido> y ,ArrayList<venta> v,ArrayList<cliente> c,Integer id_a,Integer id_p,Integer id_v,Integer id_c){
        this.registro1=x;
        this.registro2=y;
        this.registro3=v;
        this.registro4=c;
        setid_autopartes(id_a);
        setid_pedidos(id_p);
        setid_ventas(id_v);
        setid_clientes(id_c);
    }
    public void setid_autopartes(Integer id_autopartes) {
        this.id_autopartes = id_autopartes;
    }
    public Integer getid_autopartes() {
        return id_autopartes;
    }

    public void setid_pedidos(Integer id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    public Integer getid_pedidos() {
        return id_pedidos;
    }
    public void setid_ventas(Integer id_ventas) {
        this.id_ventas = id_ventas;
    }

    public Integer getid_ventas() {
        return id_ventas;
    }

    public void setid_clientes(Integer id_clientes) {
        this.id_clientes = id_clientes;
    }

    public Integer getid_clientes() {
        return id_clientes;
    }

}


import java.util.ArrayList;

import java.io.Serializable;

class registros implements Serializable{
    ArrayList<autoparte> registro1;
    ArrayList<pedido> registro2;
    ArrayList<venta> registro3;
    private Integer id_autopartes;
    public registros(ArrayList<autoparte>x , ArrayList<pedido> y ,ArrayList<venta> v,Integer id){
        this.registro1=x;
        this.registro2=y;
        this.registro3=v;
        setId_autopartes(id);
    }
    public void setId_autopartes(Integer id_autopartes) {
        this.id_autopartes = id_autopartes;
    }
    public Integer getId_autopartes() {
        return id_autopartes;
    }
}

import java.util.ArrayList;


public class listaVentas{
    
    public ArrayList<venta>ventas;
    private Integer id;
    public listaVentas(){
        ventas=new ArrayList<>();
        setid(0);

    }

    public listaVentas(ArrayList<venta> x,Integer id_v){
        ventas=x;
        setid(id_v);
    }
    public void agregarventa (venta x){
        ventas.add(x);
    }

    public Integer buscarVenta(Integer id){   
        for(venta i :ventas){
            if(i.id==id){
                return ventas.indexOf(i);
            }       
        }
        return -1;
    }
    public void eliminarVenta(Integer id){
        Integer index=buscarVenta(id);
        if(index!=-1){
            ventas.remove(ventas.get(index));
        }
    }
    
    public void setid(Integer id) {
        this.id = id;
    }

    public Integer getid() {
        return id;
    }
}
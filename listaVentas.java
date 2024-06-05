import java.util.ArrayList;


public class listaVentas{
    
    public ArrayList<venta>ventas;
    
    public listaVentas(){
        ventas=new ArrayList<>();
    }

    public listaVentas(ArrayList<venta> x){
        ventas=x;
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
}
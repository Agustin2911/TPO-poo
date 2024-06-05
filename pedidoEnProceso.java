import java.util.ArrayList;

public class pedidoEnProceso{
    
    public ArrayList<autoparte>productos;
    public ArrayList<Integer>cantidades;

    public pedidoEnProceso (){
        productos=new ArrayList<>();
        cantidades=new ArrayList<>();
    }

    public void agregarProductos(autoparte producto,Integer cantidad){
        Integer index=buscarAutoparte(producto.getid());
        if(index==-1){
            productos.add(producto);
            cantidades.add(cantidad);
        }
        else if(index!=-1){
            cantidades.set(index,(cantidades.get(index)+cantidad));
        }
    }
    public Integer buscarAutoparte(Integer id){   
        for(autoparte i :productos){
            if(i.getid()==id){
                return productos.indexOf(i);
            }       
        }
        return -1;
    }
    public void eliminarAutoparte(Integer id){
        Integer index=buscarAutoparte(id);
        if(index!=-1){
            productos.remove(productos.get(index));
        }
    } 
}
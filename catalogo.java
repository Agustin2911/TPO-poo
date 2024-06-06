import java.util.ArrayList;




public class catalogo{
    ArrayList<autoparte>autopartes;
    public catalogo(){
        autopartes=new ArrayList<>();
    }


    public catalogo(ArrayList<autoparte> x){
        autopartes=x;
    }
    public void agregarAutoparte(Integer  id, String denominacion, String descripcion, String categoria, String marca, String vehiculo,
    String precio, Integer stock, Integer stockMinimo, String enlace){
        autoparte nueva_autoparte=new autoparte(id, denominacion, descripcion, categoria,marca, vehiculo,precio,stock, stockMinimo, enlace);
        autopartes.add(nueva_autoparte);
    }
    public void eliminarAutoparte(Integer autoparteId){
        for (autoparte i:autopartes){
            
            if (i.getid().equals(autoparteId)){
                autopartes.remove(i);
                break;
            }
        }
    } 

    public void actualizarAutoparte(autoparte x,String denominacion_m, String descripcion_m, String categoria_m, String marca_m, String vehiculo_m,
    String precio_m, Integer stock_m, Integer stockMinimo_m, String enlace_m){
        Integer  idx=autopartes.indexOf(x);
        autoparte ap=autopartes.get(idx);
        ap.denominacion=denominacion_m;
        ap.descripcion=descripcion_m;
        ap.categoria=categoria_m;
        ap.marca=marca_m;
        ap.vehiculo=vehiculo_m;
        ap.setprecio(precio_m);
        ap.setstock(stock_m);
        ap.setstock(stockMinimo_m);                
        ap.enlace=enlace_m;
    }
    
    public void modificarStock(Integer id,Integer cant_stock){
        Integer x=buscarAutoparte(id);
        if(x !=-1){
            autoparte ap=autopartes.get(x);               
            ap.setstock(cant_stock);
        }
        else if (x==-1) {
                System.out.println("no existe la autoparte");
        }
    }
    public void  listaAutopartes(){
        for (autoparte i:autopartes){
            System.out.println(i.denominacion);
        }
    }    
    /*public void verificarStock(pedido) : boolean hay que ve para que sirve*/
    public void actualizarStock(Integer id, Integer cantidadNueva){
        Integer index=buscarAutoparte(id);
        autoparte ap=autopartes.get(index);
        ap.setstock(cantidadNueva);
    } 
    public Integer buscarAutoparte(Integer id){   
            for(autoparte i :autopartes){
                if(i.getid()==id){
                    return autopartes.indexOf(i);
                }       
            }
            return -1;
    } 

    public void stockMinimo(){
        for (autoparte i: autopartes){
            if(i.getstock()<=i.getstock_minimo()){
                System.out.println("la autoparte"+i.getid()+"tiene stock bajo");
            }
        }
    }
}
import java.util.ArrayList;

public class lista_pedidos{
    public ArrayList<pedido>listaPedidos;
    private Integer id;

    public lista_pedidos(){
        listaPedidos=new ArrayList<>();
        setid(0);
    }

    public lista_pedidos(ArrayList<pedido> x,Integer id_p){
            listaPedidos=x;
            setid(id_p);
    }

    public void agregarPedido(pedido x){
        listaPedidos.add(x);
    }
    public void eliminarPedido(Integer  id){
        Integer index=buscarPedidos(id);
        listaPedidos.remove(listaPedidos.get(index));
    }

    public Integer buscarPedidos(Integer id ){
        for (pedido i : listaPedidos){
            if(i.getidPedido()==id){
                return listaPedidos.indexOf(i);
            }
        }
        return -1;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public Integer getid() {
        return id;
    }

    public void devolver_stock(Integer id){
        Integer id_p=buscarPedidos(id);
        pedido pedido= listaPedidos.get(id_p);
        for (Integer i=0;i!=pedido.productos.size();i++){
            autoparte parte=pedido.productos.get(i);
            parte.setstock((parte.getstock())+pedido.cantidades.get(i));
        }   
    }
    public void devolver_stock(ArrayList<autoparte>x,ArrayList<Integer> y){
        for (Integer i=0;i!=x.size();i++){
            autoparte parte=x.get(i);
            parte.setstock((parte.getstock())+y.get(i));
        }   
    }
}
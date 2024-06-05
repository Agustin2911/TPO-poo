import java.util.ArrayList;

public class lista_pedidos{
    public ArrayList<pedido>listaPedidos;

    public lista_pedidos(){
        listaPedidos=new ArrayList<>();
    }

    public lista_pedidos(ArrayList<pedido> x){
            listaPedidos=x;
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

}
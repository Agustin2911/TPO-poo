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
}
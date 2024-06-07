import java.util.ArrayList;

public class lista_clientes {
    public ArrayList<cliente> clientes;
    private Integer id ;

    public lista_clientes(){
        clientes=new ArrayList<>();
        setid(0);
    }

    public lista_clientes(ArrayList<cliente> x,Integer id_c){
        clientes=x;
        setid(id_c);
    }

    public void agregar_cliente(cliente x){
        clientes.add(x);
    }

    public void eliminar_cliente(Integer id){
        for (cliente i: clientes){
            if(i.getid()==id){
                clientes.remove(i);
                break;
            }
        }
    }
    public void setid(Integer id) {
        this.id = id;
    }

    public Integer getid() {
        return id;
    }

}

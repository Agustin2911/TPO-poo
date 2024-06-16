import java.util.ArrayList;

public class pedidoEnProceso  {
    public ArrayList<autoparte>productos;
    public ArrayList<Integer>cantidades;

    pedidoEnProceso(){
        productos=new ArrayList<>();
        cantidades=new ArrayList<>();
    }

    public void agregar_autopartes(autoparte autoparte,Integer cant){
        productos.add(autoparte);
        cantidades.add(cant);
    }

    public ArrayList<autoparte> devolver_productos(){
        return productos;
    }

    public ArrayList<Integer> devolver_cantidades(){
        return cantidades;
    }
}


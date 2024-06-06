import java.util.ArrayList;
import java.io.*;
public class sistemaAutoparte {
    
    public catalogo catalogo;
    public lista_pedidos pedidos;
    public listaVentas ventas;
    private Integer id_autopartes;
    public  sistemaAutoparte(ArrayList<autoparte> x,ArrayList<pedido> y,ArrayList<venta> v,Integer id){
        this.catalogo=new catalogo(x);
        this.pedidos=new lista_pedidos(y);
        this.ventas=new listaVentas(v);
        setId_autopartes(id);
    }

    public void setId_autopartes(Integer id_autopartes) {
        this.id_autopartes = id_autopartes;
    }
    public Integer getId_autopartes() {
        return id_autopartes;
    }

    public void mostrarAutopartes() {
       catalogo.listaAutopartes();
    }

    public void modificarAutoparte(autoparte x, String denominacion, String descripcion, String categoria, String marca, String vehiculo,
    String precio, Integer stock, Integer stockMinimo, String enlace) {
       catalogo.actualizarAutoparte(x, denominacion,  descripcion, categoria,  marca,  vehiculo,precio, stock, stockMinimo, enlace);
    } 

    public void modificarStock( Integer id, Integer cantNueva) {
        catalogo.modificarStock(id,cantNueva);
    }

    public void eliminarAutoparte( Integer id) {
        catalogo.eliminarAutoparte(id);
    }

    public void cargarAutoparte(Integer  id, String denominacion, String descripcion, String categoria, String marca, String vehiculo,
    String precio, Integer stock, Integer stockMinimo, String enlace) {
        catalogo.agregarAutoparte(id,denominacion, descripcion,  categoria, marca, vehiculo, precio, stock, stockMinimo,  enlace);
    }

    public void agregarStock(Integer id, Integer cantNueva) {
        catalogo.modificarStock(id,cantNueva);
    }

    public void registrarPedido(Integer id,ArrayList<autoparte> productos,ArrayList<Integer>cant,cliente cliente_pedido) {
        pedidos.agregarPedido(new pedido(id,productos,cant,cliente_pedido));
    }

    public void cancelarPedido(Integer idPedido) {
        pedidos.eliminarPedido(idPedido);
    }

    public void iniciarVentaDirecta(Integer id_v,ArrayList<autoparte>autopartes,ArrayList<Integer>cantidades,String formaPago) {
        ventas.agregarventa(new venta( id_v,autopartes,cantidades,formaPago));
    }

    public void monitorearStockMinimo() {
        catalogo.stockMinimo();
    }
    public boolean guardar_datos(Object obj){
		try{
			FileOutputStream fout = new FileOutputStream("datos.bin");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			//Serialization:
			out.writeObject(obj);    
			out.close();
			return true;
		}
		catch(Exception ex){
            System.out.print("ttttt");
            return false;
            
            
		}
	}
}
import java.util.ArrayList;
import java.io.*;
public class sistemaAutoparte {
    
    public catalogo catalogo;
    public lista_pedidos pedidos;
    public listaVentas ventas;
    public lista_clientes clientes;
    public  sistemaAutoparte(ArrayList<autoparte> ca,ArrayList<pedido> p,ArrayList<venta> v,ArrayList<cliente> cli,Integer id_ca,Integer id_p, Integer id_v,Integer id_cli){
        this.catalogo=new catalogo(ca,id_ca);
        this.pedidos=new lista_pedidos(p,id_p);
        this.ventas=new listaVentas(v,id_v);
        this.clientes=new lista_clientes(cli,id_cli);
    }



    public void mostrarAutopartes() {
       catalogo.listaAutopartes();
    }

    public void modificarAutoparte(autoparte x, String denominacion, String descripcion, String categoria, String marca, String vehiculo,
    String precio, Integer stock, Integer stockMinimo, String enlace) {
       catalogo.actualizarAutoparte(x, denominacion,  descripcion, categoria,  marca,  vehiculo,precio, stock, stockMinimo, enlace);
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

    public void registrarPedido(Integer id,ArrayList<autoparte> productos,ArrayList<Integer>cant,String fecha,cliente cliente_pedido) {
        pedidos.agregarPedido(new pedido(id,productos,cant,fecha,cliente_pedido));
    }

    public void cancelarPedido(Integer idPedido) {
        pedidos.eliminarPedido(idPedido);
    }

    public void iniciarVentaDirecta(Integer id_v,String nombre,ArrayList<autoparte>autopartes,ArrayList<Integer>cantidades,metodoDePago formaPago) {
        ventas.agregarventa(new venta(id_v,nombre,autopartes,cantidades,formaPago));
    }

    public void ventaXPedido(Integer id_v,String nombre_v,metodoDePago formaPago,pedido pedido){
        ventas.agregarventa(new venta(id_v,nombre_v,formaPago,pedido));
    }
    public void eliminarVenta(Integer id){
        ventas.eliminarVenta(id);
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
            return false;
            
            
		}
	}
    public autoparte buscAutoparte(String denominacion){
        return catalogo.buscarAutoparte(denominacion);

    } 

    public void eliminarpedido(Integer id ){
        pedidos.eliminarPedido(id);
    }
    public void eliminar_stock(autoparte parte, Integer cant){
        catalogo.restar_stock(parte, cant);
    }

    public void devolver_stock(Integer id){
        pedidos.devolver_stock(id);
    }

    public Integer calcular_subtotales(autoparte ap,Integer cant){
        return Integer.valueOf(ap.getprecio())*cant;
    }


    public boolean hay_stock(autoparte autoparte,Integer cant){
        return autoparte.getstock()>=cant;
    }
}
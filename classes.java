import java.util.ArrayList;
import java.util.*;
import java.io.Serializable;
class pedido implements Serializable{
    private Integer idPedido;
    public ArrayList<autoparte>productos;
    public ArrayList<Integer>cantidades;
    private cliente cliente;

    public pedido(Integer id,ArrayList<autoparte> autopartes,ArrayList<Integer> cant,cliente cliente_pedido){
        setidPedido(id);
        productos=autopartes;
        cantidades=cant;
        setcliente(cliente_pedido);
    }
    public void agregarProductos(autoparte prodcuto,Integer cantidad){

    }
    public void eliminarProducto(autoparte autoparte){
        productos.remove(autoparte);
    }
    public void setidPedido(Integer id){
        this.idPedido=id;
    }

    public Integer getidPedido(){
        return this.idPedido;
    }


    public void setcliente(cliente cliente_p){
        this.cliente=cliente_p;
    }

    public cliente getcliente(){
        return this.cliente;
    }


}

class autoparte implements Serializable{
    private Integer id;
    public String denominacion;
    public String descripcion;
    public String categoria;
    public String marca;
    public String vehiculo;
    private String precio;
    private Integer stock;
    private Integer stock_minimo;
    public String enlace;

    public autoparte(Integer id_a,String denominacion_a,String descripcion_a,String categoria_a,
    String marca_a,String vehiculo_a,String precio_a,Integer stock_a,Integer stock_minimo_a,String enlace_a){
        setid(id_a);
        denominacion=denominacion_a;
        descripcion=descripcion_a;
        categoria=categoria_a;
        marca=marca_a;
        vehiculo=vehiculo_a;
        setprecio(precio_a);
        setstock(stock_a);
        setstock_minimo(stock_minimo_a);
        enlace=enlace_a;
    }

    public void setid(Integer id_a){
        this.id=id_a;
    }
    public Integer getid(){
        return this.id;
    }

    public void setprecio(String precio_a){
        this.precio=precio_a;
    } 
    public String getprecio(){
        return this.precio;
    }

    public void setstock(Integer stock_a){
        this.stock=stock_a;
    }

    public Integer getstock(){
        return this.stock;
    }

    public void setstock_minimo(Integer stock_minimo_a){
        this.stock_minimo=stock_minimo_a;
    }

    public Integer getstock_minimo(){
        return this.stock_minimo;
    }

}
class cliente implements Serializable{
    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String localidad;
    private String provincia;
    private String email;
    
    public cliente(Integer id_c, String nombre_c, String direccion_c, String telefono_c, String localidad_c, String provincia_c, String email_c) {
        setid(id);
        setnombre(nombre_c);
        setdireccion(direccion_c);
        settelefono(telefono_c);
        setlocalidad(localidad_c);
        setprovincia(provincia_c);
        setemail(email_c);
    }

    public void setid(Integer id_c){
        this.id=id_c;
    }
    public Integer getid(){
        return this.id;
    }
    public void setnombre(String nombre_c){
        this.nombre=nombre_c;
    }
    public String getnombre(){
        return this.nombre;
    }
    public void setdireccion(String direccion_c){
        this.direccion=direccion_c;
    }
    public String getdireccion(){
        return this.direccion;
    }
    public void settelefono(String telefono_c){
        this.telefono=telefono_c;
    }
    public String gettelefono(){
        return this.telefono;
    }
    public void setlocalidad(String localidad_c){
        this.localidad=localidad_c;
    }
    public String getlocalidad(){
        return this.localidad;
    }
    public void  setprovincia(String provincia_c){
        this.provincia=provincia_c;
    }
    public String getprovincia(){
        return this.provincia;
    }
    public void setemail(String email_c){
        this.email=email_c;
    }
    public String getemail(){
        return this.email;
    }
}

public class classes {
    private Integer id;
    private String nombreUsuario;
    private String contraseña;
    private String email;
    private String perfil;

    public classes(Integer id_u, String nombreUsuario_u, String contraseña_u, String email_u, String perfil_u) {
        this.id = id_u;
        this.nombreUsuario = nombreUsuario_u;
        this.contraseña = contraseña_u;
        this.email = email_u;
        this.perfil = perfil_u;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id_u) {
        this.id = id_u;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario_u) {
        this.nombreUsuario = nombreUsuario_u;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña_u) {
        this.contraseña = contraseña_u;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email_u) {
        this.email = email_u;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil_u) {
        this.perfil = perfil_u;
    }
}
class detalleVenta implements Serializable{
    public Integer productoId;
    public Integer cantidad;
    public float precioUnitario;

    public detalleVenta(Integer productoId_d,Integer cantidad_d,Float precioUnitario_d){
        this.productoId=productoId_d;
        this.cantidad=cantidad_d;
        this.precioUnitario=precioUnitario_d;
        this.precioUnitario=(float)cantidad*precioUnitario;
    }
}   
class metodoDePago implements Serializable{
    /*faltan cosas */
    private String formaDePago;
    private Integer cantCuotas;
    private Float subTotal;
    private Float total;

    public metodoDePago(String x,float y){
        setformaDePago(x);
        setsubTotal(y);
        forma_de_pago(getformaDePago());
    }
    public void setformaDePago(String x){
        this.formaDePago=x;
    }
    public String getformaDePago(){
        return this.formaDePago;
    }
    public void setcantCuotas(Integer y){
        this.cantCuotas=y;
    }
    public Integer getcantCuotas(){
        return this.cantCuotas;
    }

    public void settotal(float x){
        this.total=x;
    }

    public Float gettotal(){
        return this.total;
    }

    public void setsubTotal(Float x){
        this.subTotal=x;
    }
    public Float getsubTotal(){
        return this.subTotal;
    }
    public void forma_de_pago(String x){
        switch (x) {
            case "efectivo":
                setcantCuotas(1);
                settotal(getsubTotal()-getsubTotal()*0.10f);
                break;
            case "transferencia":
                setcantCuotas(1);
                settotal(getsubTotal());
                break;
            case "tarjeta de credito":
                setcantCuotas(1);
                Scanner scanner = new Scanner(System.in);
                System.out.println("en cuantas cuotas se va a pagar ? opciones:(2,3,6)");
                Integer cuotas= scanner.nextInt();
                scanner.nextLine();
                switch (cuotas) {
                    case 2:
                    setcantCuotas(cuotas);
                    settotal(getsubTotal()+getsubTotal()*0.06f);
                        break;
                    case 3:
                    setcantCuotas(cuotas);
                    settotal(getsubTotal()+getsubTotal()*0.12f);    
                        break;
                    case 6:
                    setcantCuotas(cuotas);
                    settotal(getsubTotal()+getsubTotal()*0.20f);
                        break;
                }
                break;
            default:
                break;
        }
    }

}
class venta implements Serializable{
    public Integer id;
    public ArrayList<detalleVenta> lista_detalles;
    private Float subTotal=0f;
    private  metodoDePago metodoDePago; 
    private Float total;

    public venta(Integer id_v,ArrayList<autoparte>autopartes,ArrayList<Integer>cantidades,String formaPago){
        id=id_v;
        ventaSinPedido(autopartes, cantidades);
        tipoDePago(formaPago);
    }

    public venta(String formaPago,pedido pedido){
            ventaXPedido(pedido);
            tipoDePago(formaPago);
    }

    public void ventaXPedido(pedido pedido){
        for (autoparte i :pedido.productos){
            Integer index=pedido.productos.indexOf(i);
            lista_detalles.add(new detalleVenta(i.getid(),pedido.cantidades.get(index),Float.parseFloat( i.getprecio())));
        }
        generarSubTotal();
    }

    public void ventaSinPedido(ArrayList<autoparte>autopartes,ArrayList<Integer>cantidades){
        for (autoparte i :autopartes){
            Integer index=autopartes.indexOf(i);
            lista_detalles.add(new detalleVenta(i.getid(),cantidades.get(index),Float.parseFloat(i.getprecio())));
        }
        generarSubTotal();
    }
    public void setsubTotal(float i){
        this.subTotal+=i;
    }
    public float getsubTotal(){
        return this.subTotal;
    }

    public void generarSubTotal(){
        for (detalleVenta i : lista_detalles){
            setsubTotal(i.precioUnitario);
        }
    }

    public void setmetodoDePago(metodoDePago x){
        this.metodoDePago=x;
    }
    public metodoDePago getmetodoDePago(){
        return this.metodoDePago;
    }

    public void settotal(Float x){
        this.total=x;
    }

    public Float gettotal(){
        return total;
    }
    public void tipoDePago (String formaPago){
        setmetodoDePago(new metodoDePago(formaPago,getsubTotal()));
        settotal(getmetodoDePago().gettotal());
    }


}
class catalogo{
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

    public void actualizarAutoparte(Integer id,String denominacion_m, String descripcion_m, String categoria_m, String marca_m, String vehiculo_m,
    String precio_m, Integer stock_m, Integer stockMinimo_m, String enlace_m){
        Integer x=buscarAutoparte(id);
        if(x !=-1){
        autoparte ap=autopartes.get(x);
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

class lista_pedidos{
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

class pedidoEnProceso{
    
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
class listaVentas{
    
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
class registros implements Serializable{
    ArrayList<autoparte> registro1;
    ArrayList<pedido> registro2;
    ArrayList<venta> registro3;
    private Integer id_autopartes;
    public registros(ArrayList<autoparte>x , ArrayList<pedido> y ,ArrayList<venta> v,Integer id){
        this.registro1=x;
        this.registro2=y;
        this.registro3=v;
        setId_autopartes(id);
    }
    public void setId_autopartes(Integer id_autopartes) {
        this.id_autopartes = id_autopartes;
    }
    public Integer getId_autopartes() {
        return id_autopartes;
    }
}


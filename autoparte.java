import java.io.Serializable;

public class autoparte implements Serializable {
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


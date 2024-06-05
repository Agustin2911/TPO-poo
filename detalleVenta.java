
import java.io.Serializable;


public class detalleVenta implements Serializable{
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
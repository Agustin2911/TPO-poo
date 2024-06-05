
import java.util.*;
import java.io.Serializable;


public class metodoDePago implements Serializable{
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
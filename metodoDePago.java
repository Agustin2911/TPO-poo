import java.io.Serializable;


public class metodoDePago implements Serializable{
    private Float subTotal;
    private Float total;

    public metodoDePago(float y){
        setsubTotal(y);
    }

    public float calculartotal(){
        return 0f;
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
    
}
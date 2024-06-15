
import java.io.Serializable;



public class cliente implements Serializable{
    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String localidad;
    private String provincia;
    private String email;
    
    public cliente(Integer id_c, String nombre_c, String direccion_c, String telefono_c, String localidad_c, String provincia_c, String email_c) {
        setid(id_c);
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

    @Override
    public String toString(){
        return getid()+" "+getnombre()+" "+getdireccion();
    }
}
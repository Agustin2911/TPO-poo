import java.util.ArrayList;

import java.io.Serializable;

public class usuario{
    private Integer id;
    private String nombreUsuario;
    private String contraseña;
    private String email;
    private String perfil;

    public usuario(Integer id_u, String nombreUsuario_u, String contraseña_u, String email_u, String perfil_u) {
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


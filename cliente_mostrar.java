
import javax.swing.JTextField;

public class cliente_mostrar {
    public cliente cliente;
    public JTextField texto_mostrar;
    cliente_mostrar(cliente c){
        cliente=c;
        hacer_texto();
    }

    public void hacer_texto(){
        String texto=cliente.getid()+" "+cliente.getnombre()+" "+cliente.getdireccion()+" "+cliente.gettelefono()+" "+cliente.getlocalidad()+" "+cliente.getprovincia()+" "+cliente.getemail();
        texto_mostrar= new JTextField(texto);
    }

    public JTextField texto(){
        return texto_mostrar;
    }
}

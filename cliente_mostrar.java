import java.awt.Dimension;
import javax.swing.JTextField;

public class cliente_mostrar {
    public cliente cliente;
    public JTextField texto_mostrar;
    cliente_mostrar(cliente c){
        cliente=c;
        hacer_texto();
    }

    public void hacer_texto(){
        String texto=cliente.getid()+" "+cliente.getnombre()+" "+cliente.gettelefono()+" "+cliente.getemail();
        texto_mostrar= new JTextField(texto);
        texto_mostrar.setPreferredSize(new Dimension(400,100));
    }

    public JTextField texto(){
        return texto_mostrar;
    }
}

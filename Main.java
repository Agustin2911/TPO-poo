import javax.swing.SwingUtilities;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        registros registro=(registros)cargar_datos();
        //sistemaAutoparte interfaz= new sistemaAutoparte(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),0,0,0,0);
		sistemaAutoparte interfaz= new sistemaAutoparte(registro.registro1,registro.registro2,registro.registro3,registro.registro4,registro.getid_autopartes(),registro.getid_pedidos(),registro.getid_ventas(),registro.getid_clientes());
        SwingUtilities.invokeLater(() -> {
            gui ex = new gui(interfaz);
            ex.setVisible(true);
        });

    }
    static public Object cargar_datos(){
		Object registro;
		try{
			FileInputStream fi = new FileInputStream("datos.bin");
			ObjectInputStream fs = new ObjectInputStream(fi);
            
			// Deserialazation:
			registro = fs.readObject();
			fs.close();
		}
		catch(Exception ex){
			registro=null;
            System.out.println("aaaa");
		}
		return registro;
	}
}




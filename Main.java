import javax.swing.SwingUtilities;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        registros registro=(registros)cargar_datos();
        sistemaAutoparte interfaz= new sistemaAutoparte(registro.registro1,registro.registro2,registro.registro3,registro.getId_autopartes());
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




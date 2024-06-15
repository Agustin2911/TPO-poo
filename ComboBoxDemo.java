import javax.swing.*;

public class ComboBoxDemo {
    public static void main(String[] args) {
        // Crear un JFrame para mostrar el JComboBox
        JFrame frame = new JFrame("JComboBox Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Crear un JComboBox y agregar objetos Persona
        JComboBox<Persona> comboBox = new JComboBox<>();
        comboBox.addItem(new Persona("Juan", 25));
        comboBox.addItem(new Persona("María", 30));
        comboBox.addItem(new Persona("Pedro", 40));

        // Agregar el JComboBox al JFrame
        frame.add(comboBox);

        // Mostrar el JFrame
        frame.setVisible(true);

        // Obtener el objeto seleccionado
        comboBox.addActionListener(e -> {
            Persona selectedPersona = (Persona) comboBox.getSelectedItem();
            if (selectedPersona != null) {
                System.out.println("Seleccionado: " + selectedPersona.getNombre() + ", Edad: " + selectedPersona.getEdad());
            }
        });
    }
}
class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return nombre + " (Edad: " + edad + ")";
    }
}



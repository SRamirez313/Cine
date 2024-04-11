
package cine;

import javax.swing.JOptionPane;

public class Cine {

    private static String[][] asientos = new String[5][6]; 
    private static String nombrePelicula = " Scarface"; 

    public static void main(String[] args) {
        while (true) {
            String[] opciones = {"Mostrar asientos", "Modificar nombre de la película", "Asignar asiento", "Salir"};
            int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Cine App", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            switch (opcionSeleccionada) {
                case 0: 
                    mostrarAsientos();
                    break;
                case 1: 
                    modificarNombrePelicula();
                    break;
                case 2: 
                    asignarAsiento();
                    break;
                case 3: 
                    System.exit(0);
            }
        }
    }

    private static void mostrarAsientos() {
        String mensaje = "Nombre de la película: " + nombrePelicula + "\n\n";
        mensaje += "   A    B    C    D    E\n";
        for (int i = 0; i < asientos.length; i++) {
            mensaje += (i + 1) + " ";
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] == null) {
                    mensaje += "L";
                } else {
                    mensaje += "O";
                }
                mensaje += "   ";
            }
            mensaje += "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje, "Asientos del cine", JOptionPane.PLAIN_MESSAGE);
    }

    private static void modificarNombrePelicula() {
        String nuevapelicula = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre de la película:", "Modificar nombre de la película", JOptionPane.PLAIN_MESSAGE);
        if (nuevapelicula != null) {
            nombrePelicula = nuevapelicula;
        }
    }

    private static void asignarAsiento() {
        String fila = JOptionPane.showInputDialog(null, "Ingrese la fila del asiento (1-5):", "Asignar asiento", JOptionPane.PLAIN_MESSAGE);
        String columna = JOptionPane.showInputDialog(null, "Ingrese la columna del asiento (A-E):", "Asignar asiento", JOptionPane.PLAIN_MESSAGE);

        try {
            int filanumero = Integer.parseInt(fila) - 1;
            int columnanumero = columna.toUpperCase().charAt(0) - 'A';
            if (filanumero >= 0 && filanumero < asientos.length && columnanumero >= 0 && columnanumero < asientos[filanumero].length) {
                if (asientos[filanumero][columnanumero] == null) {
                    asientos[filanumero][columnanumero] = "X";
                    JOptionPane.showMessageDialog(null, "Asiento asignado correctamente.", "Asignar asiento", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El asiento ya está ocupado.", "Asignar asiento", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Asiento fuera de rango.", "Asignar asiento", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.", "Asignar asiento", JOptionPane.ERROR_MESSAGE);
        }
    }
}


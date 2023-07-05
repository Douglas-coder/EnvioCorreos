import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserProcessor {

    // Método para obtener el nombre y la fecha de nacimiento
    public void processUser(List<User> name, List<User> dobString) {
        // Validar el formato de la fecha de nacimiento
        if (isValidDateFormat(dobString.toString())) {
            // Convertir la fecha de nacimiento a un objeto de tipo Date
            Date dob = parseDate(dobString.toString());

            // Realizar las operaciones necesarias con el nombre y la fecha de nacimiento
            // ...

            // Ejemplo: Imprimir el nombre y la fecha de nacimiento
            System.out.println("Nombre: " + name);
            System.out.println("Fecha de Nacimiento: " + dobString);
        } else {
            System.out.println("El formato de la fecha de nacimiento no es válido");
        }
    }

    // Método para validar el formato de la fecha
    private boolean isValidDateFormat(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // No permitir fechas inválidas (ejemplo: 30/02/2022)

        try {
            dateFormat.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // Método para convertir una cadena de fecha en un objeto Date
    private Date parseDate(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}

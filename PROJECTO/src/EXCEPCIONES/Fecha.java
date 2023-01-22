package EXCEPCIONES;

public class Fecha {
    public Fecha(String fecha_string) throws FechaException {
        try {
            String[] parts = fecha_string.split("/");
            if(parts.length != 3) {
                throw new FechaException("La fecha debe estar en el formato año/mes/dia.");
            }
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new FechaException("La fecha debe estar en el formato año/mes/dia.");
        }
    }
}
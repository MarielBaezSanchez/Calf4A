package Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class filess {

    private static final String RUTA = "C:\\archivoss\\";

    // Funciones de archivo
    public double[] fileToDoubleArray(int parcialNumber) throws Exception {
        String fileName = RUTA + "parcial" + parcialNumber + ".txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return bufferedReader.lines()
                    .mapToDouble(Double::parseDouble)
                    .toArray();
        } catch (Exception e) {
            throw new Exception("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void writeArrayToFile(int parcialNumber, double[] grades) throws Exception {
        String fileName = RUTA + "promedio" + parcialNumber + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (double grade : grades) {
                writer.println(grade);
            }
        } catch (Exception e) {
            throw new Exception("Error al escribir el archivo: " + e.getMessage());
        }
    }

    // Funciones de calificación
    public double[] calcuInd(double[] grades1, double[] grades2, double[] grades3, double[] grades4) {
        int gradeCount = grades1.length;
        double[] individualAverages = new double[gradeCount];

        for (int i = 0; i < gradeCount; i++) {
            individualAverages[i] = (grades1[i] + grades2[i] + grades3[i] + grades4[i]) / 4;
        }

        return individualAverages;
    }

    public double[] calcuParcial(double[] grades1, double[] grades2, double[] grades3, double[] grades4) {
        return new double[]{
                calcuGrup(grades1),
                calcuGrup(grades2),
                calcuGrup(grades3),
                calcuGrup(grades4)
        };
    }

    public double calcuGrup(double[] grades) {
        double sum = 0;

        for (double grade : grades) {
            sum += grade;
        }

        return sum / grades.length;
    }
}
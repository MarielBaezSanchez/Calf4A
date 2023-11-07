package calf4a;

import Files.filess;

public class Calf4A {

    private static filess opera = new filess();

    public static void main(String[] args) {
        try {
            double[] cali1 = opera.fileToDoubleArray(1);
            double[] cali2 = opera.fileToDoubleArray(2);
            double[] cali3 = opera.fileToDoubleArray(3);
            double[] cali4 = opera.fileToDoubleArray(4);

            double[] promediosIndividuales = opera.calcuInd(cali1, cali2, cali3, cali4);
            double[] promediosParciales = opera.calcuParcial(cali1, cali2, cali3, cali4);
            double promedioGrupal = opera.calcuGrup(promediosParciales);

            opera.writeArrayToFile(1, promediosIndividuales);
            opera.writeArrayToFile(2, promediosParciales);

            System.out.println("El promedio general es: " + promedioGrupal);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
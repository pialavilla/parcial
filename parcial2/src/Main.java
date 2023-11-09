import java.util.Scanner;

public class Main {
    public static boolean isValidDNA(String seq) {
        String validCharacters = "ACGT";
        // Verifica si la secuencia es válida si tiene exactamente 6 caracteres y todos los caracteres son A, C, G o T.
        //convierte la secuencia a mayusculas
        seq=seq.toUpperCase();
        return seq.length() == 6 && seq.chars().allMatch(ch -> validCharacters.indexOf(ch) != -1);
    }

    public static boolean isMutant(String[] dna) {
        int count = 0;
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length(); j++) {
                // Verifica patrones mutantes en las secuencias de ADN.
                if (j + 3 < dna[i].length() && dna[i].substring(j, j + 4).chars().distinct().count() == 1) {
                    count++;
                }
                if (i + 3 < dna.length && dna[i].charAt(j) == dna[i + 1].charAt(j) &&
                        dna[i].charAt(j) == dna[i + 2].charAt(j) && dna[i].charAt(j) == dna[i + 3].charAt(j)) {
                    count++;
                }
                if (i + 3 < dna.length && j + 3 < dna[i].length() &&
                        dna[i].charAt(j) == dna[i + 1].charAt(j + 1) && dna[i].charAt(j) == dna[i + 2].charAt(j + 2) &&
                        dna[i].charAt(j) == dna[i + 3].charAt(j + 3)) {
                    count++;
                }
                if (i - 3 >= 0 && j + 3 < dna[i].length() &&
                        dna[i].charAt(j) == dna[i - 1].charAt(j + 1) && dna[i].charAt(j) == dna[i - 2].charAt(j + 2) &&
                        dna[i].charAt(j) == dna[i - 3].charAt(j + 3)) {
                    count++;
                }
            }
        }
        // Devuelve true si se encuentra más de un patrón mutante en las secuencias de ADN.
        return count > 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] dna = new String[6];
            for (int i = 0; i < 6; i++) {
                while (true) {
                    System.out.print("Ingrese la fila " + (i + 1) + ": ");
                    String seq = scanner.nextLine().toUpperCase();
                    if (isValidDNA(seq)) {
                        dna[i] = seq;
                        break;
                    } else {
                        System.out.println("Secuencia de ADN no válida. Debe tener exactamente 6 caracteres válidos (A, C, G, T).");
                    }
                }
            }

            boolean isHumanMutant = isMutant(dna);

            if (isHumanMutant) {
                System.out.println("El humano es mutante.");
            } else {
                System.out.println("El humano no es mutante.");
            }

            System.out.print("¿Desea ingresar otra secuencia? (Presione cualquier letra para continuar o 'X' para salir): ");
            String another = scanner.nextLine();
            if (another.equalsIgnoreCase("X")) {
                break;
            }
        }

        scanner.close();
    }
}
//pruebas---

        //NO ES MUTANTE
        // Ingrese la fila 1: ATGCAT
        // Ingrese la fila 2: CAGTAC
        // Ingrese la fila 3: TAGCTA
        // Ingrese la fila 4: CATGCA
        // Ingrese la fila 5: AGTACG
        // Ingrese la fila 6: GCTAGT

        // SI ES MUTANTE
        // Ingrese la fila 1: AAAAAAA
        // Ingrese la fila 2: TTTTTTT
        // Ingrese la fila 3: CGCGCG
        // Ingrese la fila 4: GCGCGC
        // Ingrese la fila 5: CGCGCG
        // Ingrese la fila 6: GCGCGC

        //SI ES MUTANTE EJ 2 /FILAS DIAGONALES SECUNDARIAS
        // Ingrese la fila 1: CGATTG
        // Ingrese la fila 2: GTTACG
        // Ingrese la fila 3: ACCGAC
        // Ingrese la fila 4: TAGATA
        // Ingrese la fila 5: TTTTAC
        // Ingrese la fila 6: CGATGC

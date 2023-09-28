/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcial;
import java.util.Scanner;
public class Parcial {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {

            System.out.println("ingrese el primer numero: "); //pedir primer numero al usuario
            int numerouno = leer.nextInt();

            System.out.println("ingrese el segundo numero: ");//pedir segundo numero al usuario
            int numerodos = leer.nextInt();

            System.out.println("que desea realizar? ");
            System.out.println("para suma: 1, resta:2, multiplicacion:3, division:4, si desea salir ingrese: 5");
            int calculo = leer.nextInt();

            switch(calculo){
                case 1:
                    System.out.println("la suma de los numeros es: "+ (numerouno+numerodos)); //suma de los numeros
                    break;
                case 2:
                    System.out.println("la resta de los numeros es: "+ (numerouno-numerodos)); //resta de los numeros
                    break;
                case 3:
                    System.out.println("la multiplicacion de los numeros es: "+ (numerouno*numerodos));//multiplicacion de los numeros
                    break;
                case 4:
                    if (numerodos!=0){
                        System.out.println("la division de los numeros es: "+ (numerouno/numerodos));//division de los numeros
                        break;
                    } else {
                        System.out.println("No se puede dividir por cero."); // no se puede dividir por 0
                        break;
                    }
                case 5:
                    System.out.println("Gracias por hacer tus calculos aqui!!"); //salida
                    salir=true;
                default:
                    System.out.println("Opción no válida."); //no elije ninguna de las opc dadas
                    break;
            }
        }
    }
}

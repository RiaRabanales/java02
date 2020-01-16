/* Maria Rabanales González
 */
package practica02;

import java.util.Arrays;
import java.util.Scanner;

public class Practica02 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int userOption = 9;
        while (userOption != 0) {
            System.out.println(" ");
            System.out.println("Elige qué quieres hacer:");
            System.out.println(" ");
            System.out.println("  1- crear matriz con valor de cada celda como suma de su posición fila-columna");
            System.out.println("  2- comprobar si una matriz 4x4 es simétrica");
            System.out.println("  3- sumar dos matrices 3x3");
            System.out.println("  4- crear matriz 7x7 con 1 en diagonal");
            System.out.println("  5- crear matriz 8x6 con 1 en bordes");
            System.out.println("  6- crear matriz con tamaño según usuario y 1 en bordes");
            System.out.println(" ");
            System.out.println("  0- salir");
            userOption = lector.nextInt();

            //planteo el switch
            switch (userOption) {
                case 1: addTablePositions();
                break;
                case 2: checkTableSymmetry();
                break;
                case 3: addTwoTables();
                break;
                case 4: createDiagonalTable();
                break;
                case 5: createBasicTable();
                break;
                case 6: createBasicUserTable(lector);
                break;
                case 0: System.out.println("¡Adiós!");
                break;
                default: System.out.println("Opción imposible.");
            }
        }
    }
    
    //crear matriz con valor de cada celda como suma de su posición fila-columna
    public static void addTablePositions() {
        //start 19:25
        //lógica: creo la matriz y la relleno con el agregado de sus posiciones
        int[][] myAddedTable = new int[5][5];
        for (int i = 0; i < myAddedTable.length; i++) {
            for (int j = 0; j< myAddedTable.length; j++) {
                myAddedTable[i][j] = i + j;
            }
        }
        //lamo a método externo para imprimir la matriz
        printTable(myAddedTable);
        //end 19:33
    }
    
    //comprobar si una matriz 4x4 es simétrica
    public static void checkTableSymmetry() {
        //start 19:22
        //genero numeros aleatorios para rellenar la tabla, entre el 0 y el 9 (por simplicidad)
        int[][] mySymmetricTable = new int[4][4];
        for (int i = 0; i < mySymmetricTable.length; i++) {
            for (int j = 0; j< mySymmetricTable.length; j++) {
                mySymmetricTable[i][j] = (int)(Math.random() * ((9 - 0) + 1));
            }
        }
        printTable(mySymmetricTable);
        System.out.println("¿Es simétrica?");
        boolean isSymmetric = true;
        int iCheck = 0;
        int jCheck = 0;
        while (isSymmetric == true && iCheck < mySymmetricTable.length && jCheck < mySymmetricTable[0].length) {
            if (mySymmetricTable[iCheck][jCheck] != mySymmetricTable[jCheck][iCheck]) {
                isSymmetric = false;
            } else {
                jCheck += 1;
                if (jCheck == mySymmetricTable[0].length -1 && iCheck != mySymmetricTable.length -1) {
                    jCheck = 0;
                    iCheck += 1;
                }
            }
        }
        
        /*alternativa: uso interesante del break a través de etiqueta/label, para salir del loop exterior
        * lo comento porque es un for y no un while, pero es limpio y quiero conservar la idea
        label1:
        for (int i = 0; i < mySymmetricTable.length; i++) {
            for (int j = 0; j< mySymmetricTable.length; j++) {
                if (mySymmetricTable[i][j] != mySymmetricTable[j][i]) {
                    isSymmetric = false;
                    //este break es forzado; TODO: mejorar esta parte del código
                    break label1;
                }
            }
        }*/
        
        if (isSymmetric == true) {
            System.out.println("Sí.");
        } else {
            System.out.println("No.");
        }
        //end 19:38
    }
            
    //sumar dos matrices 3x3
    public static void addTwoTables() {
        //start 19:39
        int[][] myBaseTableA = new int[3][3];
        int[][] myBaseTableB = new int[3][3];
        
        //genero los valores sólo entre 0 y 9, por simplicidad
        for (int i = 0; i < myBaseTableA.length; i++) {
            for (int j = 0; j < myBaseTableA[i].length; j++) {
                myBaseTableA[i][j] = (int)(Math.random() * ((9 - 0) + 1));
            }
        }
        printTable(myBaseTableA);
        
        for (int i = 0; i < myBaseTableB.length; i++) {
            for (int j = 0; j < myBaseTableB[i].length; j++) {
                myBaseTableB[i][j] = (int)(Math.random() * ((9 - 0) + 1));
            }
        }
        printTable(myBaseTableB);
        
        System.out.println("Suma de ambas matrices:");
        int[][] myBaseTableC = new int[3][3];
        for (int i = 0; i < myBaseTableC.length; i++) {
            for (int j = 0; j < myBaseTableC[i].length; j++) {
                myBaseTableC[i][j] = myBaseTableA[i][j] + myBaseTableB[i][j];
            }
        }
        //impresión de la tabla final:
        printTable(myBaseTableC);
    }
    
    //crear matriz 7x7 con 1 en diagonal y 0 en el resto
    public static void createDiagonalTable() {
        //start 19:18
        int[][] myDiagonalTable = new int[7][7];
        for (int i = 0; i < myDiagonalTable.length; i++) {
            for (int j = 0; j< myDiagonalTable.length; j++) {
                if (i == j) {
                    myDiagonalTable[i][j] = 1;
                } else {
                    myDiagonalTable[i][j] = 0;
                }
            }
        }
        printTable(myDiagonalTable);
        //end: 19:25
    }
    
    //crear matriz 8x6 con 1 en bordes y 0 en resto
    public static void createBasicTable() {
        //start 19:33
        int[][] myBasicTable = new int[8][6];
        for (int i = 0; i < myBasicTable.length; i++) {
            for (int j = 0; j< myBasicTable[i].length; j++) {
                if (i != 0 && j != 0 && i != myBasicTable.length - 1 && j != myBasicTable[i].length - 1) {
                    myBasicTable[i][j] = 0;
                } else {
                    myBasicTable[i][j] = 1;
                }
            }
        }
        printTable(myBasicTable);
        //end: 19:38
    }
    
    //crear matriz con tamaño según usuario y 1 en bordes y 0 en resto
    public static void createBasicUserTable(Scanner lector) {
        //start 19:38
        System.out.println("Introduce el número de filas:");
        int userRows = lector.nextInt();
        System.out.println("Introduce el número de columnas:");
        int userColumns = lector.nextInt();
        int[][] myBasicUserTable = new int[userRows][userColumns];
        for (int i = 0; i < userRows; i++) {
            for (int j = 0; j< userColumns; j++) {
                if (i != 0 && j != 0 && i != userRows - 1 && j != userColumns - 1) {
                    myBasicUserTable[i][j] = 0;
                } else {
                    myBasicUserTable[i][j] = 1;
                }
            }
        }
        printTable(myBasicUserTable);
        //end 19:42
    }
    
    public static void printTable(int[][] myTable) {
	System.out.println("Impresión de la matriz " + myTable.length + "x" + myTable[0].length + ": ");
        for (int i = 0; i < myTable.length; i++) {
            System.out.println(Arrays.toString(myTable[i]));
            //la imprimo así y no con un for que recorra cada elemento interno porque así adopta aspecto de matriz
        }
    }
}

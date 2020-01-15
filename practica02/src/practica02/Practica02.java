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
            System.out.println("  6- crear matriz con tamaño según usuario y 0 en bordes");
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
    
    public static void addTablePositions() {
        //start 19:25
        //genero numeros aleatorios para rellenar la tabla, entre el 0 y el 10
        int[][] myAddedTable = new int[5][5];
        for (int i = 0; i < myAddedTable.length; i++) {
            for (int j = 0; j< myAddedTable.length; j++) {
                myAddedTable[i][j] = i + j;
            }
        }
        System.out.println("Impresión de la tabla " + myAddedTable.length + "x" + myAddedTable.length + ": ");
        for (int i = 0; i < myAddedTable.length; i++) {
            System.out.println(Arrays.toString(myAddedTable[i]));
        }
        //end 19:33
    }
    
    public static void checkTableSymmetry() {
        //start 19:22
        int[][] mySymmetricTable = new int[4][4];
        for (int i = 0; i < mySymmetricTable.length; i++) {
            for (int j = 0; j< mySymmetricTable.length; j++) {
                mySymmetricTable[i][j] = (int)(Math.random() * ((9 - 0) + 1));
            }
        }
        System.out.println("Impresión de la tabla " + mySymmetricTable.length + "x" + mySymmetricTable.length + ": ");
        for (int i = 0; i < mySymmetricTable.length; i++) {
            System.out.println(Arrays.toString(mySymmetricTable[i]));
        }
        System.out.println("¿Es simétrica?");
        boolean isSymmetric = true;
        for (int i = 0; i < mySymmetricTable.length; i++) {
            for (int j = 0; j< mySymmetricTable.length; j++) {
                if (mySymmetricTable[i][j] != mySymmetricTable[j][i]) {
                    isSymmetric = false;
                    //este break es forzado; TODO: mejorar esta parte del código
                    break;
                }
            }
        }
        if (isSymmetric == true) {
            System.out.println("Sí.");
        } else {
            System.out.println("No.");
        }
        //end 19:38
    }
    
    public static void addTwoTables() {
        //start 19:39
        int[][] myBaseTableA = new int[3][3];
        int[][] myBaseTableB = new int[3][3];
        
        for (int i = 0; i < myBaseTableA.length; i++) {
            for (int j = 0; j < myBaseTableA[i].length; j++) {
                myBaseTableA[i][j] = (int)(Math.random() * ((9 - 0) + 1));
            }
        }
        System.out.println("Impresión de la primera matriz:");
        for (int i = 0; i < myBaseTableA.length; i++) {
            System.out.println(Arrays.toString(myBaseTableA[i]));
        }
        
        for (int i = 0; i < myBaseTableB.length; i++) {
            for (int j = 0; j < myBaseTableB[i].length; j++) {
                myBaseTableB[i][j] = (int)(Math.random() * ((9 - 0) + 1));
            }
        }
        System.out.println("Impresión de la segunda matriz:");
        for (int i = 0; i < myBaseTableB.length; i++) {
            System.out.println(Arrays.toString(myBaseTableB[i]));
        }
        
        System.out.println("Suma de ambas matrices:");
        int[][] myBaseTableC = new int[3][3];
        for (int i = 0; i < myBaseTableC.length; i++) {
            for (int j = 0; j < myBaseTableC[i].length; j++) {
                myBaseTableC[i][j] = myBaseTableA[i][j] + myBaseTableB[i][j];
            }
        }
        //impresión de la tabla final:
        for (int i = 0; i < myBaseTableC.length; i++) {
            System.out.println(Arrays.toString(myBaseTableC[i]));
        }
    }
    
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
        System.out.println("Impresión de la tabla " + myDiagonalTable.length + "x" + myDiagonalTable.length + ": ");
        for (int i = 0; i < myDiagonalTable.length; i++) {
            System.out.println(Arrays.toString(myDiagonalTable[i]));
        }
        //end: 19:25
    }
    
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
        System.out.println("Impresión de la tabla " + myBasicTable.length + "x" + myBasicTable[0].length + ": ");
        for (int i = 0; i < myBasicTable.length; i++) {
            System.out.println(Arrays.toString(myBasicTable[i]));
        }
        //end: 19:38
    }
    
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
        System.out.println("Impresión de la tabla " + userRows + "x" + userColumns + ": ");
        for (int i = 0; i < userRows; i++) {
            System.out.println(Arrays.toString(myBasicUserTable[i]));
        }
        //end 19:42
    }
}

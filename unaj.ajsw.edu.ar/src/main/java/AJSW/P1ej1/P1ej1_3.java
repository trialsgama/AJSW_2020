import java.math.*;
import java.util.Scanner;

public class P1ej1_3 {

    public static void main(String []args){
        AskForData();
    }

    public static void AskForData(){
         int rangoFilaA=0,rangoColumnaA=0,rangoFilaB=0,rangoColumnaB=0,opcion=0,traza=0,det=0;
         int[][] MatrizA,MatrizB,MatrizC;
         boolean flag=false;
         while (flag==false) {
             Scanner scan = new Scanner(System.in);
             System.out.println("Bienvenido a la calculadora de matrices\nElija la cantidad de filas de la primer matriz:\n");
             rangoFilaA = scan.nextInt();
             System.out.println("\nPor favor, indique numero de columnas de Matriz A:\n");
             rangoColumnaA = scan.nextInt();
             System.out.println("\nPor favor, indique numero de filas de Matriz B:\n");
             rangoFilaB = scan.nextInt();
             System.out.println("\nPor favor, indique numero de columnas de Matriz b:\n");
             rangoColumnaB = scan.nextInt();
             if(rangoFilaA!=rangoFilaB || rangoColumnaA!=rangoColumnaB){
                 System.out.println("Error,las matrices deben ser cuadradas.Reingrese:\n");
             } else {
                 flag=true;
             }
         }
         System.out.println("[+]Creando matrices...");
         MatrizA=CreateAndFillMatrix(rangoFilaA,rangoColumnaA);
         MatrizB=CreateAndFillMatrix(rangoFilaB,rangoColumnaB);
         System.out.println("Calculadora\nElija opcion:\n1-Sumar\n2-Restar\n3-Traza\n4-Determinante");
         Scanner scan=new Scanner(System.in);
         opcion=scan.nextInt();
         switch (opcion){
             case 1:
                    MatrizC=Add(MatrizA,MatrizB);
                    ShowMatrix(MatrizC);
                    break;
             case 2:
                    MatrizC=Minus(MatrizA,MatrizB);
                    ShowMatrix(MatrizC);
                    break;
             case 3:
                    traza=Traza(MatrizA);
                    System.out.println(traza);
                    break;
             case 4:
                    det=determinanteMatriz(MatrizA, MatrizA.length);
                    System.out.println(det);
                    break;
             default:
                 break;
         }
         
    }

    public static int[][] CreateAndFillMatrix(int x,int y){
        int[][] Matrix=new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                Matrix[i][j]=(int)(Math.random()*100);
            }
        }
        return Matrix;
    }

    public static int[][] Add(int[][] MatrixA,int[][] MatrixB){
        int[][] MatrixC = new int[MatrixA.length][MatrixA[0].length];
        for(int x=0;x<MatrixA.length;x++){
            for(int y=0;y<MatrixA[x].length;y++){
                MatrixC[x][y]=MatrixA[x][y]+MatrixB[x][y];
            }
        }
        return MatrixC;
    }

    public static int[][] Minus(int[][] MatrixA,int[][] MatrixB){
        int[][] MatrixC = new int[MatrixA.length][MatrixA[0].length];
        for(int x=0;x<MatrixA.length;x++){
            for(int y=0;y<MatrixA[x].length;y++){
                MatrixC[x][y]=MatrixA[x][y]-MatrixB[x][y];
            }
        }
        return MatrixC;
    }

    public static int Traza(int[][] Matrix){
        int traza = 0;
        for(int x=0;x<Matrix.length;x++){
                traza+=Matrix[x][x];
        }
        return traza;
    }

    public static int determinanteMatriz(int x[][], int N){
        int det=0;
        switch(N){
            case 2:
                det=((x[0][0]*x[1][1])-(x[1][0]*x[0][1]));
                break;
            case 3:	//Método de Gauss
                det=((x[0][0])*(x[1][1])*(x[2][2])+(x[1][0])*(x[2][1])*(x[0][2])+(x[2][0])*(x[0][1])*(x[1][2]))-((x[2][0])*(x[1][1])*(x[0][2])+(x[1][0])*(x[0][1])*(x[2][2])+(x[0][0])*(x[2][1])*(x[1][2]));
                break;
            default:	//Desarrollo a partir de los elementos de una fila/columna
                for(int z=0;z<x.length;z++){
                    det+=(x[z][0]*adj(x,z,0));
                }
        }
        return det;
    }
    public static int adj(int x[][], int i, int j){
        int adjunto;
        int y[][]=new int[x.length-1][x.length-1];
        int m,n;
        for(int k=0;k<y.length;k++){
            if(k<i){
                m=k;
            }
            else{
                m=k+1;
            }
            for(int l=0;l<y.length;l++){
                if(l<j){
                    n=l;
                }
                else{
                    n=l+1;
                }
                y[k][l]=x[m][n];
            }
        }
        adjunto=(int)Math.pow(-1,i+j)*determinanteMatriz(y, y.length);
        return adjunto;
    }

    public static void ShowMatrix(int[][] Matrix){
        for(int i=0;i<Matrix.length;i++){
            for(int j=0;j<Matrix[i].length;j++){
                System.out.println(Matrix[i][j]);
            }
        }
    }

}

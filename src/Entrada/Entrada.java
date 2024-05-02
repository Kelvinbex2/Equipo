package Entrada;


import java.util.Scanner;

public class Entrada {

    static Scanner sc = new Scanner(System.in);
    
    public static int leerEntero(){
        int num=0;

        try {
            num=sc.nextInt();
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }finally{
            sc.nextLine();
        }
        return num;
    }

    public static String leerString(){
        String texto ="";
        try {
            texto=sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return texto;
    }
}

package Leonteq;

import java.util.Scanner;

public class Que2_MarbleBox {

    public static void main(String args[]) throws Exception
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int previousValue=0;
        int[] marbleBoxes = new int[N];
        for(int i=0; i<N; i++){
            int element = s.nextInt();
            marbleBoxes[i] = previousValue + element;
            previousValue = element;
        }

        int Q = s.nextInt();

        for(int i=0; i<Q; i++){
            int searchElement = s.nextInt();

            for(int j=0; j<N; j++){
                if(marbleBoxes[j]>=searchElement){
                    System.out.println(j+1);
                }
            }
        }
    }
}



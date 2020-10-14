
import java.math.BigInteger;
import java.util.*;

class TestClass {
		// sum of array after performing K times operations on it (divide and multiply by 2)
    static class Pair {
        BigInteger min;
        BigInteger max;
    }

    static Pair getMinMax(BigInteger arr[], int n) {
        Pair minmax = new  Pair();
        int i;

        if (n == 1) {
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }

        if (arr[0].compareTo(arr[1])==1) {
            minmax.max = arr[0];
            minmax.min = arr[1];
        } else {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }

        for (i = 2; i < n; i++) {
            if (arr[i].compareTo(minmax.max)==1) {
                minmax.max = arr[i];
            } else if (arr[i].compareTo(minmax.min)==-1) {
                minmax.min = arr[i];
            }
        }
        return minmax;
    }

    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int K = s.nextInt();

        BigInteger[] A = new BigInteger[n];

        for (int i = 0; i < A.length; i++) {
            A[i] = s.nextBigInteger();
        }

        for(int j=0; j<K; j++){
            Pair minmax = getMinMax(A, n);
            int minFlag=0;
            int maxFlag=0;
            for (int i = 0; i < A.length; i++) {
                if(A[i]==minmax.min && minFlag==0){
                    A[i] = minmax.min.multiply(BigInteger.valueOf(2));
                    minFlag++;
                }
                if(A[i]==minmax.max && maxFlag==0){
                    if(!minmax.max.mod(BigInteger.valueOf(2)).equals(0)){
                        minmax.max = minmax.max.add(BigInteger.valueOf(1));
                    }
                    A[i] = minmax.max.divide(BigInteger.valueOf(2));
                    maxFlag++;
                }
            }
        }

        BigInteger sum = null;
        for (int i = 0; i < A.length; i++) {
            if(sum==null){
                sum = A[i];
            }
            else{
                sum = sum.add(A[i]);
            }
        }
        System.out.println(sum);

    }
}



import java.lang.Math;

public class HelloWorld{
    
    public static String solution(String x) {
        int result;
        char mirrorCharacter ;
        String finalResult = "";
        for(int i=0; i<x.length(); i++){
            int ascii = x.charAt(i);
            if(97<=ascii && ascii<=122){
            result = 122 - Math.abs(97 - ascii);
            mirrorCharacter = (char)result;  
            finalResult += mirrorCharacter;
            }
            else{
            finalResult += (char) ascii;
            }
        }
        return finalResult;
         
    }
    
    
    public static void main(String []args){
        System.out.println(solution("aBhHgm+"));
    }
}



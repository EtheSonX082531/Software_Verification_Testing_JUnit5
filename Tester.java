public class Tester {
    public int add(int a,int b){
        return a+b;
    }

    public boolean checkPositive(int n){
        if(n<0){
            return false;
        }
        else{
            return true;
        }
    }

    public String getNull(){
        return null;
    }

    public String getName(){
        return "Anik Roy";
    }

    public int divide(int a,int b){
        if(b==0){
            throw new ArithmeticException("Division by Zero!");
        }
        else{
            return a/b;
        }
    }

    public boolean checkEven(int n){
        if(n%2==0){
            return true;
        }
        else{
            return false;
        }
    }

    public static void printAlphabet(){
        for(int i=0;i<26;i++){
            System.out.println((char)(65+i));
        }
    }
}

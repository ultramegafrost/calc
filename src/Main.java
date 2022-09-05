import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int num1 = 0;
    static int num2 = 0;
    static char operation = ' ';
    static boolean romN = false;

    public static void main(String[] args) throws Exception{
        String str = getString();
        String[] strings;

        if (str.contains("+") || str.contains("-") || str.contains("*") || str.contains("/")){
            strings = str.split(" ");
            operation=strings[1].charAt(0);
            if (strings.length > 3) throw new Exception();
        }else throw new Exception();

        if ((strings[0].contains("I") || strings[0].contains("V") || strings[0].contains("X")) && (strings[2].contains("I") || strings[2].contains("V") || strings[2].contains("X"))){
            num1 = RomanNum.toInt(strings[0]);
            num2 = RomanNum.toInt(strings[2]);
            romN = true;
        }else{
            num1 = Integer.parseInt(strings[0]);
            num2 = Integer.parseInt(strings[2]);
        }
        if (num1 > 10 || num2 > 10) throw new Exception();
        int result = calc(num1,num2,operation);
        if (romN) System.out.println(RomanNum.intToRoman(result));
        else System.out.println(result);
    }
    public static String getString(){
        System.out.println("Input ur string");
        String str = scanner.nextLine();
        return str;
    }

    public static int calc(int num1, int num2, char operation){
        int result=0;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
        }
        return result;
    }
}
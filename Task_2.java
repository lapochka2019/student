import java.util.Arrays;

public class Task_2 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(Ex1("ABCD", 2));
        System.out.println("Задание 2:");
        System.out.println(Ex2(new int[]{6, 2, 1, 0, 9, 0, 55, -10}));
        System.out.println("Задание 3:");
        Ex3(new int[]{2, 2, 1});
        System.out.println(Ex3(new int[]{1, 2, 1}));
        System.out.println("Задание 4:");
        int [] g={3,2,8};
        System.out.println(Arrays.toString(Ex4(g)));
        System.out.println("Задание 5:");
        System.out.println(Ex5(2.10));
        System.out.println("Задание 6:");
        System.out.println(Ex6(7));
        System.out.println("Задание 7:");
        System.out.println(Ex7("10256"));
        System.out.println("Задание 8:");
        System.out.println(Ex8("cola","abba"));
        System.out.println("Задание 9:");
        System.out.println(Ex9("automation", "auto-"));
        System.out.println("Задание 10:");
        System.out.println(Ex10(3));

    }

    public static String Ex1(String a, int b) {//повторить символ строки
        String c = "";
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b; j++) {
                c = c + a.charAt(i);

            }
        }
        return c;
    }
    public static int Ex2(int a[]) {//разниа между макс и мин
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max - min;
    }
    public static boolean Ex3(int a[]) {//среднее число массива
        int b=0;
        for (int i=0;i<a.length;i++){
         b+=a[i];
        }return b%a.length==0;
    }
    public static int [] Ex4(int a[]){//массив сумм
        int [] b = new int [a.length];
        int c=0;
        for (int i=0;i<a.length;i++){
            b[i]=a[i]+c;
            c=c+a[i];
        }return b;
    }
    public static int Ex5 (double a){//число десятичных знаков
        String b = String.valueOf(a);
        int count =0;
        for (int i=0;i<b.length();i++) {
        if (b.charAt(i)=='.'){
            count = b.length()-i;
        }
        }return count;
    }
    public static int Ex6 (int a){//фибоначчи
        int b=0;
        int [] c = new int [a];
        c[0]=1;
        c[1]=2;
        for (int i=2;i<a;i++){
            c[i] = c[i - 1] + c[i - 2];//формула
            b=c[i];
        }return b;
    }
    public static boolean Ex7 (String a){//почтовый индекс
        int b=0;
        if(a.length()>5){
            return false;
        }else{
            for (int i=0;i<a.length();i++){
                if (a.charAt(i)>='0'&& a.charAt(i)<='9'){
                    b=1;
                }else b=-1;
            }
            if (b>0){return true;}
            else return false;
        }
    }
    public static boolean Ex8 (String a, String b){//странная пара
        return  ((a.charAt((a.length()-1))==b.charAt(0))||(a.charAt((0))==b.charAt(b.length()-1)));
    }
    public static boolean Ex9 (String a, String b){//префикс суффикс
       if (b.charAt(b.length()-1)=='-'){//prefix
           if (a.indexOf(b.substring(b.length()))==0){
               return true;
           }return false;
       }else if (b.charAt(0)=='-'){//suffix
           if (a.indexOf(b.substring(0))==(a.length()-b.length())){
               return true;
           }return false;
       }else return false;

    }public static int Ex10 (int a){//шаги
        if(a%2==0){
            return a;
        }else return a+2;
    }
}
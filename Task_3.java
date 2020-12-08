import java.util.Arrays;

public class Task_3 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(Ex1(1,0,-1));
        System.out.println("Задание 2:");
        System.out.println(Ex2("all zip files are zipped"));
        System.out.println("Задание 3:");
        System.out.println(Ex3(6));
        System.out.println("Задание 4:");
        System.out.println(Ex4("Aga"));
        System.out.println("Задание 5:");
        System.out.println(Ex5("#eaecee"));
        System.out.println("Задание 6:");
        System.out.println(Ex6(new int[] {1, 3, 4, 4, 4}, new int [] {2, 5, 7}));
        System.out.println("Задание 7:");
        System.out.println(Ex7(297));
        System.out.println("Задание 8:");
        System.out.println(Ex8("11000100100001"));
        System.out.println("Задание 9:");
        System.out.println(Ex9(12));
        System.out.println("Задание 10:");
        System.out.println(Ex10(3,4,5));

    }
    public static String Ex1 (int a, int b, int c){//квадратное уравнение
        double D = b*b-4*a*c;
        //D=Math.sqrt(D);
        if (D == 0) {
            return "Уравнение имеет один корень: "+ (b*(-1))/(2*a);
        }else if (D>0){
            return "Уравнение имеет два корня: х1= " + (b*(-1)+Math.sqrt(D))/(2*a) + " x2= " + (b*(-1)-Math.sqrt(D))/(2*a);
        }else return "Уравнение не имеет действительных корней";
    }
    public static int Ex2 (String a){//второе вхождение зипа
        String b = "zip";
        int c=a.indexOf(b);
        if (c>0){
           return a.indexOf(b,(c+b.length()));
        }else return -1;
    }
    public static boolean Ex3 (int a){//совершенное число
        int b=0;
        for (int i=1;i<a;i++){
            if (a%i==0) b+=i;
        }if (b==a){return true;}
        else return false;
    }
    public static String Ex4 (String a){//строки
        if (a.length()>1){
            if (a.charAt(0)==a.charAt(a.length()-1)){
                 return "Two's a pair.";
            }
            if (a.charAt(0)!=a.charAt(a.length()-1)){
                 char b = a.charAt(0);
                 char c = a.charAt((a.length()-1));
                 char[] str = a.toCharArray();
                 str[0]=c;
                 str [a.length()-1]=b;
                 return new String (str);
            }
        }else return "Incompatible.";
        return "";
    }
    public static boolean Ex5 (String a){//шестнадцетиричный код
        if (a.length()!=7){
            return false;
        }else{
            if (a.charAt(0)!='#'){
                return false;
            }else {
                int count=1;
                for (int i=1;i<a.length();i++){
                    if ((a.charAt(i)>=0 && a.charAt(i)<=9)||(a.charAt(i)>='A' && a.charAt(i)<='F'))
                       count++;
                }
                if (count==a.length()){
                    return true;
                }else return false;
            }
        }
    }
    public static boolean Ex6(int[] a, int [] b){//уникальные символы
        int c1=0; int c2=0;
        int temp=0;
        for (int i=0;i<a.length-1;i++){
            for (int j=0;j<a.length-1;j++){
                if ((a[i]==a[j])&&(i!=j))
                    temp++;
            }
            if (temp==0) c1++;
            temp=0;
        }
        for (int i=0;i<b.length-1;i++){
            for (int j=0;j<b.length-1;j++){
                if (b[i]==b[j]&&i!=j) temp++;
            }
            if (temp==0) c2++;
            temp=0;
        }
        if (c1==c2) {return true;}
        else return false;
    }
    public static boolean Ex7 (int Krap){//число капрекара
        int Krap2 = Krap * Krap;
        int b=1;
        int KrapA;
        int KrapB;
        String a = Integer.toString(Krap2);
        if (a.length() %2 == 0) {
            for (int i=0;i<a.length()/2;i++){
                b*=10;
            }
            KrapA=Krap2%b;
            KrapB=Krap2/b;
            return  KrapA+KrapB==Krap;
        }else
            for (int i=0;i<(a.length()/2+1);i++){
                b*=10;
            }
            KrapA=Krap2%b;
            KrapB=Krap2/b;
            return  KrapA+KrapB==Krap;
    }
    public static String Ex8 (String a){//длинное количество нуей
        String b="";
        int len=0;
        int max=0;
        for (int i=0;i<a.length();i++){
            if (a.charAt(i)=='0'){
                //b=b+a.charAt(i);
                len++;
            }else {
                if (max<len){
                    max=len;
                }
                len=0;
            }

        }
        for (int i=0;i<max;i++){
            b=b+'0';
        }return b;
    }
    public static int Ex9 (int a){//простое число
        int b=0;
       if (isPrime(a)==true){
           return a;
       }else {

           for (int i=a;i<a+100;i++){
               if (isPrime(i)==true){
                   b=i;
                   break;
               }
           }
       }
       return b;
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean Ex10 (int a, int b, int c){
    return (a*a+b*b==c*c||a*a+c*c==b*b||b*b+c*c==a*a);
    }//прямоугольный треугольник
}

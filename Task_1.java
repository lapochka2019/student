public class Task_1 {
    public static void main (String[] args){
        System.out.println("Задание 1:");
        System.out.println(Ex1(5,2));
        System.out.println("Задание 2:");
        System.out.println(Ex2(6,2));
        System.out.println("Задание 3:");
        System.out.println(Ex3(2,2,1));
        System.out.println("Задание 4:");
        System.out.println(Ex4(3,2,8));
        System.out.println("Задание 5:");
        System.out.println(Ex5(5,2,10));
        System.out.println("Задание 6:");
        System.out.println(Ex6('A'));
        System.out.println("Задание 7:");
        System.out.println(Ex7(10));
        System.out.println("Задание 8:");
        System.out.println(Ex8(5,7));
        System.out.println("Задание 9:");
        System.out.println(Ex9(new int[]{5, 7, 3, 5, 7, 6, 0}));
        System.out.println("Задание 10:");
        System.out.println(Ex10(3,5,9));

    }
    public static int Ex1 (int a, int b){//остаток от деление
        return a%b;
    }//остаток от деления
    public static int Ex2 (int a, int b){//площать прямоугольного треугольника
        return a*b/2;
    }//площаль треугольника
    public static int Ex3 (int a, int b, int c){//количество ног животных
        return a*2+b*4+c*4;
    }//посчитать количесто ног
    public static boolean Ex4 (int a, int b, int c){//является лли правдной, что а*в больше с
        return a*b>c;
    }// prob * prize > pay
    public static String Ex5 (int a, int b, int c){//определетить выполненную операцию
        if (a*b==c){return "умножение";}
        else if (a/b==c){return "деление";}
        else if (a-b==c){return "вычитание";}
        else if (a+b==c){return "сложение";}
        else {return "ничего";}
    }
    public static int Ex6 (char a){//номер буквы в аски коде
       int b=a;
        return b;
    }
    public static int Ex7 (int a){//сумма чисел до числа
        int b=1;
        for(int i=2;i<=a;i++){
            b=b+i;
        }
        return b;
    }
    public static int Ex8 (int a, int b){//длина третьего ребра треугольника
        return a+b-1;
    }//максимальное значение третьего ребра (сумаа двух больше третьей)
    public static int Ex9 (int a[]){//сумма кубов массивов
        int b=a.length;
        int c=0;
        for (int i=0;i<b;i++){
            c=c+a[i]*a[i]*a[i];
        }
        return c;
    }public static boolean Ex10 (int a, int b, int c){//а*b/с
    return a*b%c==0;
    }
}

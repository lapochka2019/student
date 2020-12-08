import java.util.Arrays;
import java.util.SplittableRandom;

public class Task_6 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(Ex1(3));
        System.out.println("Задание 2:");
        System.out.println(Ex2("flag"));
        System.out.println(Ex2("Apple"));
        System.out.println("Задание 3:");
        System.out.println(Ex3("rgb(0,0,0)"));
        System.out.println("Задание 4:");
        System.out.println(Ex4("https://edabit.com?a=1&b=2&a=2"));
        System.out.println("Задание 5:");
        System.out.println(Arrays.toString(Ex5("How the Avocado Became the Fruit of the Global Trade")));
        System.out.println("Задание 6:");
        System.out.println(Ex6(4));
        System.out.println("Задание 7:");
        System.out.println(Ex7("abcabcbb"));
        System.out.println("Задание 8:");
        System.out.println(Ex8(16));
        System.out.println("Задание 9:");
        System.out.println(Ex9("6 * 9 = 60"));
        System.out.println("Задание 10:");
        System.out.println(Ex10(11211230));
    }

    public static int[] Vect(int[] v, int n) {//вектор паскаля
        int i, j;
        int[] nv = new int[n + 1];
        nv[0] = 1;
        nv[n] = 1;
        j = 1;
        for (i = 0; i < n - 1; i++)
            nv[j++] = v[i] + v[i + 1];
        return nv;
    }

    public static int Ex1(int n) {
        int[] curr;
        int[] prev;
        int i, j, k, s;
        int[] Bi = new int[n + 1];
        Bi[0] = Bi[1] = 1;
        prev = new int[2];
        prev[0] = prev[1] = 1;
        curr = prev;
        for (i = 2; i < n + 1; i++) {
            s = 0;
            for (j = 0; j < i; j++)
                s += Bi[j] * curr[j];
            Bi[i] = s;
            curr = Vect(prev, i);
            //delete [] prev;
            prev = curr;
        }
        return Bi[n];
    }

    public static String Ex2(String a) {
        if (a.toLowerCase().charAt(0) == 'a' || a.toLowerCase().charAt(0) == 'e' || a.toLowerCase().charAt(0) == 'i' || a.toLowerCase().charAt(0) == 'o' || a.toLowerCase().charAt(0) == 'u' || a.toLowerCase().charAt(0) == 'y') {
            a += "yay";
            return a;
        } else {
            String b = "";
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != 'a' && a.charAt(i) != 'e' && a.charAt(i) != 'i' && a.charAt(i) != 'o' && a.charAt(i) != 'u' && a.charAt(i) != 'y') {
                    b += a.charAt(i);
                    a = a.substring(1);
                    i--;
                } else {
                    i = a.length() - 1;
                }
            }
            a = a + b + "ay";
        }
        return a;
    }

     public static boolean Ex3 (String str){
         String temp = "";
         int i = 0;
         for (; i < 4; i++) {
             temp+=str.charAt(i);
         }
         if (temp.equals("rgb(")||temp.equals("RGB("))
         {
             temp="";
             while (str.charAt(i)!=')')
             {
                 temp+=str.charAt(i);
                 i++;
             }
             if (i!=str.length()-1) return false;
             temp = str.substring(4,str.length()-1);
             String[] temparr = temp.split(",");
             for (int j = 0; j < temparr.length; j++) {
                 double val = Double.parseDouble(String.valueOf(temparr[j]));
                 if (val<0||val>255)
                     return false;
             }
             return true;
         }
         temp+=str.charAt(i);
         i++;
         if (temp.equals("rgba(")||temp.equals("RGBA("))
         {
             temp="";
             while (str.charAt(i)!=')')
             {
                 temp+=str.charAt(i);
                 i++;
             }
             if (i!=str.length()-1) return false;
             i=0;
             for (int j = 0; j < 3; j++) {
                 String temp_val ="";
                 while (temp.charAt(i)!=',')
                 {
                     temp_val+=temp.charAt(i);
                     i++;
                 }
                 i++;
                 double val = Double.parseDouble(temp_val);
                 if (val<0||val>255)
                     return false;
             }
             return true;
         }
         else
         {
             return false;
         }
     }
    public static String Ex4 (String str, String[] ... params)
        {
            String temp ="", res="";
            int i = 0;
            for (; i < 8; i++) {
                temp+=str.charAt(i);
                res+=str.charAt(i);
            }
            if (!temp.equals("https://"))
            {
                return "не является URL";
            }
            else
            {
                while (str.charAt(i)!='.')
                {
                    res+=str.charAt(i);
                    i++;
                }
                temp ="";
                res+=str.charAt(i);
                i++;
                for (int j = 0; j < 3; j++, i++) {
                    temp+=str.charAt(i);
                    res+=str.charAt(i);
                }
                if (temp.equals("com")&&i==str.length())//если параметров нет
                {
                    return res;
                }
                temp+=str.charAt(i);
                res+=str.charAt(i);
                ++i;
                if (temp.equals("com?")&&i!=str.length()-1)//если должны быть параметры и они есть
                {
                    int ques =0, equs=0;
                    for (int j=i; j < str.length(); j++) {
                        //if (Character.isAlphabetic(str.charAt(j))) chars++;
                        if (str.charAt(j)=='='&&Character.isDigit(str.charAt(j+1))) equs++;
                        if (str.charAt(j)=='&') ques++;
                    }
                    if (ques+1==equs)//если введено корректно
                    {
                        String part = str.substring(i);
                        String[] words = part.split("&");//массив переменных со значениями
                        String[] names = new String[words.length];//массив имён переменных
                        String[] vals_str = new String[words.length];//массив значений переменных
                        for (int j = 0, k=0; j < words.length; j++) {
                            names[j]="";
                            vals_str[j]="";
                            while (words[j].charAt(k)!='=')//запись названий переменных
                            {
                                names[j]+=words[j].charAt(k);
                                k++;
                            }
                            k++;
                            while (k!=words[j].length())//запись значений переменных
                            {
                                vals_str[j]+=words[j].charAt(k);
                                k++;
                            }
                            k=0;
                        }////////////нужно определить, какие переменные повторяются и оставить только плсденее повторение если оно есть
                        boolean[] repeat = new boolean[words.length];
                        for (int word1 = words.length-1; word1 > 0; word1--) {//сравнение всех переменных по имени
                            for (int word2 = word1-1; word2 >= 0; word2--) {
                                if (names[word1].equals(names[word2]))
                                {
                                    repeat[word2]= true;
                                }
                            }
                        }
                        for (int j = 0; j < words.length; j++) {
                            if (repeat[j]==false){
                                res+=words[j]+ "&";
                            }
                        }
                        res+="\b";
                    }
                }
                else//если должны быть параметры и их нет
                {
                    return "не является URL";
                }
            }
            return res;
    }
    public static String[] Ex5 (String a) {
        String[] b = a.split(" ");
        if (b.length < 3) {
            return b;
        } else {
            int max = 0;
            int k = 0;
            int[] m = new int[2];
            String[] c = new String[3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (b[j].length() > max) {
                        max = b[j].length();
                        k = j;
                    }
                }
                max = 0;
                c[i] = "#" + b[k].toLowerCase();
                b[k] = "";
            }
            return c;
        }
    }

    public static int Ex6(int a) {
        int[] n = new int[a];
        n[0] = 1;
        n[1] = 2;
        int b = 2;
        int S = 0;
        for (int q = 2; q < a; q++) {
            for (int i = q + 1; i < 1000; i++) {
                int c = 0;
                for (int j = 0; j < b - 1; j++) {
                    for (int k = j + 1; k < b; k++) {
                        if (n[j] + n[k] == i) {
                            c++;
                            S = i;
                        }
                    }
                }
                if (c == 1) {
                    n[q] = S;
                    b++;
                    c = 0;
                    i = 999;
                }
            }
        }
        return n[a - 1];
    }

    public static String Ex7 (String str) {
        int mas[][] = new int[str.length() + 1][str.length() + 1];
        String res = "";
        int res_length = 0;
        int i, index = 0;
        for (i = 1; i <= str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1)&& mas[i - 1][j - 1] < (j - i)) {
                    mas[i][j] = mas[i - 1][j - 1] + 1;
                    if (mas[i][j] > res_length) {
                        res_length = mas[i][j];
                        index = Math.max(i, index);
                    }
                } else {
                    mas[i][j] = 0;
                }
            }
        }
        if (res_length > 0) {
            for (i = index - res_length + 1; i <= index; i++) {
                res += str.charAt(i - 1);
            }
        }
        return res;
    }
    public static String Ex8(int a) {
        int[] mas1 = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] mas2 = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        String s = "";
        while (a > 0)              //крутим цикл пока n>0
        {
            if (mas1[i] <= a) {      // i - элемент массива арабских цифр меньше либо равен числу n то
                a = a - mas1[i];   // от числа вычитаем его эквивалент в массиве арабском
                s = s + mas2[i];
            }else {i++;
            }
        }return s;
    }
    public static boolean Ex9 (String str){
        String temp = str.replace(" ", "");
        for (int i = 0; i < temp.length(); i++) {
            if (!Character.isDigit(temp.charAt(i))&&temp.charAt(i)!='+'&&temp.charAt(i)!='-'&&temp.charAt(i)!='*'&&temp.charAt(i)!='/'&&temp.charAt(i)!='>'&&temp.charAt(i)!='<'&&temp.charAt(i)!='='&&temp.charAt(i)!='%')
            {
                return false;
            }
        }
        String first = "", second = "", res = "", operand1 = "", operand2 = "";
        double first_val = 0, second_val = 0, res_val = 0;
        char operand1_char, operand2_char,operand12_char=0, operand22_char = 0;
        int i = 0;
        while (str.charAt(i) != '+' && str.charAt(i) != '-' && str.charAt(i) != '*' && str.charAt(i) != '/' && str.charAt(i) != '%') {
            first += str.charAt(i);
            i++;
        }
        operand1 += str.charAt(i);
        i++;
        while (str.charAt(i) != '=') {
            second += str.charAt(i);
            i++;
        }
        operand2 += str.charAt(i);
        i++;
        while (i != str.length()) {
            res += str.charAt(i);
            i++;
        }
        first_val = Double.parseDouble(first);
        second_val = Double.parseDouble(second);
        res_val = Double.parseDouble(res);
        operand1_char=operand1.charAt(0);
        if (operand1.length()>1)
        {
            operand12_char=operand1.charAt(1);
        }
        operand2_char=operand2.charAt(0);
        if (operand2.length()>1)
        {
            operand22_char=operand2.charAt(1);
        }
        if (operand1_char == '+') {
            if (operand2_char == '=') {
                if (first_val + second_val == res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '>'&& operand22_char == '=') {
                if (first_val + second_val >= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<'&& operand22_char == '=') {
                if (first_val + second_val <= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<') {
                if (first_val + second_val < res_val) {
                    return true;
                } else return false;
            }
        }
        if (operand1_char == '-') {
            if (operand2_char == '=') {
                if (first_val - second_val == res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '>'&& operand22_char == '=') {
                if (first_val - second_val >= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<'&& operand22_char == '=') {
                if (first_val - second_val <= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<') {
                if (first_val - second_val < res_val) {
                    return true;
                } else return false;
            }
        }
        if (operand2_char == '*') {
            if (operand2_char == '=') {
                if (first_val * second_val == res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '>'&& operand22_char == '=') {
                if (first_val * second_val >= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<'&& operand22_char == '=') {
                if (first_val * second_val <= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<') {
                if (first_val * second_val < res_val) {
                    return true;
                } else return false;
            }
        }
        if (operand1_char == '/') {
            if (operand2_char == '=') {
                if (first_val / second_val == res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '>'&& operand22_char == '=') {
                if (first_val / second_val >= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<'&& operand22_char == '=') {
                if (first_val / second_val <= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<') {
                if (first_val / second_val < res_val) {
                    return true;
                } else return false;
            }
        }
        if (operand1_char == '%') {
            if (operand2_char == '=') {
                if (first_val % second_val == res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '>'&& operand22_char == '=') {
                if (first_val % second_val >= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<'&& operand22_char == '=') {
                if (first_val % second_val <= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<') {
                if (first_val % second_val < res_val) {
                    return true;
                } else return false;
            }
        }
        return false;
    }
    public  static boolean Ex10 (int val){
        int counter =0, temp=val;
        while (temp!=0){
            temp/=10;
            counter++;
        }
        if (counter%2 ==1){
            return false;
        }
        String str = Integer.toString(val);
        while (str.length()!=2||(Integer.parseInt(String.valueOf(str.charAt(0)))+Integer.parseInt(String.valueOf(str.charAt(1))))>9){
            String str2 = "";
            for ( int i = 1, j=str.length();i <= j/2; i++,j--) {
                if (str.charAt(i-1)!=str.charAt(j-1)){//если исходное значение не палиндром
                    for (int k = 0; k < str.length()-1; k+=2) {
                        str2+=Integer.toString(Integer.parseInt(String.valueOf(str.charAt(k)))+Integer.parseInt(String.valueOf(str.charAt(k+1))));
                    }
                    str = str2;
                    break;
                }
            }
        }
        if(str.charAt(0)==str.charAt(1))return true;
        else return false;
    }
}

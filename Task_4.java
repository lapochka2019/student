public class Task_4 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(Ex1(10,7 ,"hello my name is Bessie and this is my essay"));
        System.out.println("Задание 2:");
        System.out.println(Ex2("()()()"));
        System.out.println("Задание 3:");
        System.out.println(Ex3("foo_bar"));
        System.out.println(Ex3("fooBar"));
        System.out.println("Задание 4:");
        System.out.println(Ex4(9, 17, 30, 1.5));
        System.out.println("Задание 5:");
        System.out.println(Ex5("55 kilos", "1.65 meters"));
        System.out.println("Задание 6:");
        System.out.println(Ex6(999));
        System.out.println("Задание 7:");
        System.out.println(Ex7("abbccc"));
        System.out.println("Задание 8:");
        System.out.println(Ex8("Sam I am!", "Green eggs and ham."));
        System.out.println("Задание 9:");
        System.out.println(Ex9(1222345, 12345));
        System.out.println("Задание 10:");
        System.out.println(Ex10("AZYWABBCATTTA", 'A'));
    }
    public static String Ex1 (int a, int b, String c){//ессе
     String[] words = c.split(" ");
     String neW="";//zapis' stroki
     int split= 0;
     String d="";//vivod
     for (int i=0;i < a;i++){
            if ((b-(neW.length()-split))>=(words[i].length())){
                neW=neW + words[i]+" ";
                split++;
            }else {
                d = d + neW+"\n";
                neW="";
                neW = words[i]+" ";
                split=1;
            }
        }d = d+words[a-1];
     return d;
     }
     public static String Ex2 (String a){//скобки
        String b = "\"";
        int left=0, right = 0;
        for (int i=0;i<a.length();i++){

            if (a.charAt(i)=='('){
                right++;
                b+=a.charAt(i);
            }if (a.charAt(i)==')'){
                left++;
                b+=a.charAt(i);
                if (right==left)
                    b+="\" \"";
            }

        } b=b.substring(0, b.length() - 1);
         b=b.substring(0, b.length() - 1);
         return b;
     }
     public static String Ex3 (String a){//
         String b = "";
        for(int i = 0;i<a.length();i++){

            if (a.charAt(i)=='_'){
                i++;
                b+=Character.toUpperCase(a.charAt(i));

            }else if (a.charAt(i)>='A'&&a.charAt(i)<='Z'){
                b= b + "_"+Character.toLowerCase(a.charAt(i));
            }else b+=a.charAt(i);
        }return b;
     }private static String Ex4 (int t1,int t2,int M,double x){//работа
        int countX=0;
        double Sum=0;
        if (t1<9){
            countX+=(9-t1);
            t1=t1-(9-t1);
        }
        if (t2>17){
            countX+=(t2-17);
            t2=t2-(t2-17);
        }
        Sum=(t2-t1)*M+countX*x*M;
        return ("$"+Sum+"0");

    }public static String Ex5 (String a, String b){//масса тела
        String[] a1 = a.split(" ");
        String[] b1 = b.split(" ");
        double w=Double.parseDouble(a1[0]);
        double h=Double.parseDouble(b1[0]);
        a = a1[1];
        b=b1[1];
        if (a.charAt(0)=='p'){
            w = w*0.45;
        }
        if (b.charAt(0)=='i'){
            h=h*2.54;
        }
        double c = ((double)((int)(w/(h*h)*100))/100);
        if(c<18.5){
            return c + " Overweight";
        }else if (c>=18.5 && c<=24.9){
            return c + " Normal weight";
        }else return c + " Underweight";
    }
    public static int Ex6 (int a){//мультипликативное постоянство
        if (a<10){
            return 0;
        }
        int b=0;
        int sum=1;
        while (a>9){
            while (a>0){
                sum*=a%10;
                a=a/10;
            }
            a=sum;
            b++;
        }return b;
    }
    public static String Ex7 (String a){//звездная пентограмма
        a+=" ";
        String b="";
        int c=1;
        for (int i=0;i<a.length()-1;i++){
            for (int j=i+1;j<a.length();j++){
                if (a.charAt(i)==a.charAt(j)){
                    c++;
                }else if (c>1){
                    b=b+a.charAt(i)+"*"+c;
                    i+=c;
                    c=1;
                }else {
                    b=b+a.charAt(i);
                    j=a.length()-1;
                }
            }
        }

        return b;
    }public static boolean Ex8 (String a, String b){//рифма
        //'a','e','i','o','u' 'y'
        String[] a1 = a.split(" ");
        String[] b1 = b.split(" ");
        a= a1[a1.length-1];
        b= b1[b1.length-1];
        String a2="";
        String b2="";
        int c=0;
        for (int i=0;i<a.length();i++){
            if (a.charAt(i)=='a'||a.charAt(i)=='e'||a.charAt(i)=='i'||a.charAt(i)=='o'||a.charAt(i)=='u'||a.charAt(i)== 'y')
                a2+=a.charAt(i);
        }
        for (int i=0;i<b.length();i++){
            if (b.charAt(i)=='a'||b.charAt(i)=='e'||b.charAt(i)=='i'||b.charAt(i)=='o'||b.charAt(i)=='u'||b.charAt(i)== 'y')
                b2+=b.charAt(i);
        }

            for (int i=0; i< a2.length(); i++){
                for (int j=0; j< b2.length(); j++){
                    if (a2.charAt(i)==b2.charAt(j)) c++;
                }
            }
        return c==a2.length();
    }
    public static boolean Ex9 (long a, long b){//три и два
        long a1=1;
        long a2=1;
        long b1=1;
        long b2=1;
        int c1=1;
        int c2=1;
        while (a>0){
            if (a%10==a/10%10){
                c1++;
                a1=a%10;
                a/=10;
            }else {
                if(c1==3){
                    c1=1;
                    a2=a1;
                }else {
                    c1=1;

                }
                a/=10;
            }
        }
        while (b>0){
            if (b%10==b/10%10){
                c2++;
                b1=b%10;
                b/=10;
            }else{
                if(c2==2){
                    c2=1;
                    b2=b1;
                }else {
                    c2=1;

                }
                b/=10;
            }
        }
        return (c2==2&&c1==3&& b2==a2);
    }
    public static int Ex10 (String a, char b){//книги
        String c = String.valueOf(b);
        String[] a1 = a.split(c);
        return a1.length;
    }



}

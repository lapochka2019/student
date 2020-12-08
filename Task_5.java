import java.security.MessageDigest;
import java.util.Arrays;

public class Task_5 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(Ex1_1(new int[]{72, 29, 7, 0, 3}));
        System.out.println(Arrays.toString(Ex1_2("Hello")));
        System.out.println("Задание 2:");
        System.out.println(Ex2("Rook", "A8", "H8"));
        System.out.println("Задание 3:");
        System.out.println(Ex3("butl", "beautiful"));
        System.out.println("Задание 4:");
        System.out.println(Ex4(new int []{16, 28}));
        System.out.println("Задание 5:");
        System.out.println(Arrays.toString(Ex5(new String[]{"toe", "ocelot", "maniac"})));
        System.out.println("Задание 6:");
        System.out.println(Ex6( 1234567890123456l));
        System.out.println("Задание 7:");
        System.out.println(Ex7(108));
        System.out.println("Задание 8:");
        System.out.println(Ex8("password123"));
        System.out.println("Задание 9:");
        System.out.println(Ex9("jOn SnoW, kINg IN thE noRth."));
        System.out.println("Задание 10:");
        System.out.println(Ex10(19));
    }
    public static char [] Ex1_1 (int [] a){
        char [] b = new char[a.length];
        b[0]=(char)a[0];
        for (int i=1;i<a.length;i++){
            b[i]=(char) (a[i-1]+a[i]);
            a[i]=a[i-1]+a[i];
        }return b;
    }
    public static int [] Ex1_2 (String a){
        int [] c = new int  [a.length()];
        c[0]=(int) a.charAt(0);
        for (int i =1;i< a.length();i++){
            c[i]=(int)a.charAt(i)-(int)a.charAt(i-1);
        }return c;
    }
    public static boolean Ex2 (String a, String b, String c){
        //"пешка", "конь", "слон", "Ладья", "Ферзь"и " король"
        //"Pawn", "Knight", "Bishop", "Rook", "Queen" and "King"
        char b1 = b.charAt(0);
        int b2 = Integer.parseInt(String.valueOf(b.charAt(1)));
        char c1 = c.charAt(0);
        int c2 = Integer.parseInt(String.valueOf(c.charAt(1)));
        if (a=="Pawn"){
            if (b1==c1){
                return Math.abs(b2-c2)==1;
            }else return false;
        }
        if (a=="Knight"){
            if (Math.abs(b1-c1)==1||Math.abs(b1-c1)==2){
                return Math.abs(b2-c2)==2;
            }
            else return false;
        }
        if (a=="Bishop"){
            return Math.abs(b2-c2)==Math.abs(b1-c1);
        }
        if (a == "Rook"){
            return (b1==c1||b2==c2);
        }
        if (a=="Queen"){
            return  (Math.abs(b2-c2)==Math.abs(b1-c1)||b1==c1);
        }else return (Math.abs(b2-c2)==1&&Math.abs(b1-c1)==1);
    }
    public static boolean Ex3 (String a, String b){
        String c="";
        for (int i=0;i<a.length();i++){
            for (int j=i;j<b.length();j++){
                if (b.charAt(j)==a.charAt(i)){
                    c+=b.charAt(j);
                    j=b.length()-1;
                }
            }
        }
            int count=0;
            for (int i=0;i<a.length();i++){
                if (c.charAt(i)==a.charAt(i)) count++;
            }return count==a.length();
        }
        public static int Ex4 (int [] a){
        int b=0;
        for (int i=0;i<a.length;i++){
            b+=a[i];
        }
            int c=1;
        while (b>9){
             c=1;
            while (b>0){
                c*=b%10;
                b=b/10;
            }b=c;
        }return c;
        }
        public static String[] Ex5 (String[] a){
        String b=a[0];

        int c;
        String d1="";
        String d2="";
            for (int i=0;i<a[0].length();i++){
                if (a[0].charAt(i)=='a'||a[0].charAt(i)=='e'||a[0].charAt(i)=='i'||a[0].charAt(i)=='o'||a[0].charAt(i)=='u'||a[0].charAt(i)== 'y')
                    d1+=a[0].charAt(i);
            }
            for (int i=1;i<a.length-1;i++){
                for (int j=0;j<a[i].length();j++){
                    if (a[i].charAt(j)=='a'||a[i].charAt(j)=='e'||a[i].charAt(j)=='i'||a[i].charAt(j)=='o'||a[i].charAt(j)=='u'||a[i].charAt(j)== 'y')
                        d2+=a[i].charAt(j);
                }
                int count=0;
                for (int k1=0;k1<d1.length();k1++){
                    for (int k2=k1;k2<d2.length();k2++){
                        if (d2.charAt(k2)==d1.charAt(k1))
                            count++;
                    }
                }
                if (count==d2.length()) {b=b+ " "+a[i];}
                d2="";
            }
            String [] b1=b.split(" ");
        return b1;
        }
        public static boolean Ex6 (long a){
        String t = String.valueOf(a);
        if (t.length()>=14&&t.length()<=19){
            int b =(int) a%10;
            int [] c  = new int [t.length()-1];
            a=a/10;
                for (int i=0; i< t.length()-1;i++){
                    c[i]=(int) a%10;
                    a=a/10;
                }
                for (int i=0;i< c.length;i++){
                    if (i%2!=0){
                        c[i]=c[i]*2;
                        if (c[i]>9){
                            c[i]=c[i]/10+c[i]%10;
                        }
                    }
                }
                int sum=0;
            for (int i=0;i< c.length;i++){
                sum+=c[i];
            }sum=10-sum%10;
            return sum==b;
        }
        else{
            return false;
        }
    }
       public static String Ex7 (int a){
        String [] b1 = {" ","one", "two", "three", "four", "five", "six", "seven", "eight","nine", "ten", "eleven", "twelve", "thirteen", "fourteen","fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
       String [] b2  = {" "," ","twenty", "thirty", "forty", "fifty", "sixty", "seventy",
               "eighty", "ninety"};
       String c="";
       if (a==0){
           return "zero";
       }
       if (a<100){
           if (a<20){
               return b1[a];
           }if (a>20){
               c=c+b2[a/10]+" "+b1[a%10];
               return c;
           }
       }if (a>=100){
           c=c+b1[a/100]+" hundred "+b2[a%100/10]+" "+b1[a%10];
           return c;
       }
       return "";
    }
    public static String Ex8 (String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static String Ex9 (String a){
        //and, the, of, in.
        String [] b = a.split(" ");
        String c="";
        for (int i=0;i<b.length;i++){
            b[i] = b[i].toLowerCase();
            if (b[i].equals("and")==true||b[i].equals("the")==true||b[i].equals("of")==true||b[i].equals("in")==true){
                c= c + " " + b[i].toLowerCase();
            }else {
                b[i] = b[i].substring(0, 1).toUpperCase() + b[i].substring(1).toLowerCase();
                c= c + " " + b[i];
            }
        }return c;
    }
    public static String Ex10 (int a){
        int c=0;
        String b="Invalid";
        for (int i=1;i<50;i++){
            int n = i*3*(i-1)+1;
            if (a==n){
                c=i;
                i=49;
            }
        }
        if (c!=0){
           b="";
            int temp=0;
            for (int i=0;i<c*2-1;i++){
                if (i<c){
                    for (int j=0;j<c+i;j++){
                        b+="○";
                        temp=c+i-1;
                    }
                }
                if (i>=c){
                   for (int j=0;j<temp;j++){
                        b+="○";

                    }temp--;

                }
                b+="\n";
            }

        } return b;
    }


    }

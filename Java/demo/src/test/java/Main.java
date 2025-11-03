import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<Character> list = new ArrayList<>();
        Character c =null;
        Boolean flag = false;
        for (int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            if (Character.isDigit( c)){
                list.add(c);
                if (i == str.length()-1){
                    if((d=='.'||d=='/')&&d!=null){
                        while (!list.isEmpty() && list.get(0) == '0') {
                            list.remove(0);
                        }
                    }
                    Collections.reverse(list);
                    while (!list.isEmpty() && list.get(0) == '0') {
                        list.remove(0);
                    }
                    list.stream().forEach(System.out::print);
                }
            }
            else {
                if ( flag)
                Collections.reverse(list);
                while (!list.isEmpty() && list.get(0) == '0') {
                    list.remove(0);
                }
                list.stream().forEach(System.out::print);
                list.clear();
                System.out.print(c);
            }

        }

    }
}
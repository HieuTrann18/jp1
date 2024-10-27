import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        numbers.add(123);
        numbers.add(124);
        numbers.add(125);
        numbers.add(126);
        HashSet<Integer> divisibleBy3 = new HashSet<Integer>();
        for(Integer n : numbers){
            if(check(n)){
                divisibleBy3.add(n);
            }
        }
        System.out.println("Cac so chia het cho 3 la: " + divisibleBy3);
    }

    public static boolean check(int x){
        return x % 3 == 0;
    }
}
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(123);
        numbers.add(456);
        numbers.add(789);
        numbers.add(12312386);

        HashSet<Integer> numbers2 = new HashSet<>();
        for(Integer i : numbers){
            if(divisibleBy3(i)){
                numbers2.add(i);
            }
        }
        System.out.println("The numbers divisible by 3 are: " + numbers2);

    }

    public static boolean divisibleBy3(int x){
        if(x < 0){
            x = -x;
        }
        while(x > 0){
            x -= 3;
        }
        return x == 0;
    }
}
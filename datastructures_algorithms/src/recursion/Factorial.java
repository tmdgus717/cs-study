package recursion;

public class Factorial {

    public int factorialSum(int num) {
        int total;
        if (num == 1) return 1;
        else
            total = num * factorialSum(num-1);
        return total;
    }

    public int factorialIter(int num) {
        int total = 1;
        for (int i = 1; i <= num; i++) {
            total *= i;
        }
        return total;
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int sum = factorial.factorialSum(10);
        System.out.println(sum);

        //iter version
        int sum2 = factorial.factorialIter(10);
        System.out.println(sum2);
    }

}

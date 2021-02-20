public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int temp_sum = 0;
        while (x < 10) {
            System.out.print(temp_sum + " ");
            x = x + 1;
            temp_sum = temp_sum + x;
        }
        System.out.print('\n');
    }
}
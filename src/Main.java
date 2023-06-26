import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // int number = (int) (Math.random() * 100); 1'nci yöntem!

        Random random = new Random();
        int number = random.nextInt(100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int guess;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrongInput = false;
        while (right < 5) {
            System.out.print("Tahmininizi giriniz : ");
            guess = input.nextInt();

            if (guess < 0 || guess > 99) {
                System.out.println("Lütfen 0-100 arasında bir değer giriniz. ");
                if (!isWrongInput) {
                    isWrongInput = true;
                    System.out.println("Bir sonraki hatalı girişinizde hakkınızdan düşülecektir.");
                } else {
                    wrong[right] = guess;
                    right++;
                    System.out.println("Çok fazla hatalı giriş yapınız. Kalan hakkınız : " + (5 - right));

                }
                continue;
            }

            if (guess == number) {
                System.out.println("Tebrikler doğru tahmin ettiniz. Tamin ettiğiniz sayı : " + number);
                isWin = true;
                break;
            } else {
                System.out.println("Yanlış tahmin ettiniz.");
                if (guess > number) {
                    System.out.println(guess + " sayısı, gizli sayıdan büyüktür.");
                } else {
                    System.out.println(guess + " sayısı, gizli sayıdan küçüktür.");
                }
            }
            wrong[right] = guess;
            right++;
            System.out.println("Kalan hakkınız : " + (5 - right));
        }
        if (!isWin) {
            System.out.println("Kaybettiniz.");
            System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
        }

    }
}
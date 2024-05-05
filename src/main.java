import java.util.Scanner;

public class Main {
    private static Harf[] harf = new Harf[10];
    private static int tahminHakki = 6;
    public static void main(String[] args) {
        harf[0] = new Harf("B");
        harf[1] = new Harf("İ");
        harf[2] = new Harf("L");
        harf[3] = new Harf("G");
        harf[4] = new Harf("İ");
        harf[5] = new Harf("S");
        harf[6] = new Harf("A");
        harf[7] = new Harf("Y");
        harf[8] = new Harf("A");
        harf[9] = new Harf("R");

        while (!bittMi()) {
            oyun();
            tahminEt();
        }
        if (tahminHakki != 0) {
            oyun();
            System.out.println("Oyunu başarıyla bitirdiniz tebrikler!");
        }

    }
    public static void tahminEt() {
        Scanner input = new Scanner(System.in);
        System.out.print("Harf girin: ");
        String deger = input.nextLine();
        for (Harf value : harf) {
            if (deger.equalsIgnoreCase(value.getDeger())) {
                value.setTahmin(true);
                tahminHakki++;
            }
        }
        tahminHakki--;
        System.out.println("Tahmin hakkı:" + tahminHakki);

    }
    public static void oyun() {
        for (Harf value : harf) {
            if (value.isTahmin()) {
                System.out.print(value.getDeger());
            } else {
                System.out.print("_");
            }
        }
        System.out.println("");
    }
    public static boolean bittMi() {
        if (tahminHakki == 0) {
            System.out.println("Tahmin hakkınız bitti!");
            return true;
        }
        for (Harf value : harf) {
            if (!value.isTahmin()) {
                return false;
            }

        }
        return true;
    }

}

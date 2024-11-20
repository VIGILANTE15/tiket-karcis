public class Main {
    public static void main(String[] args) {

        Kendaraan kendaraan1 = new Kendaraan(1,2361,7, "Mobil", 5000, 30);
        double biaya = kendaraan1.total(5000, 30);
        System.out.println("-".repeat(20));
        kendaraan1.tampilkanInfo();
        System.out.println("Total biaya : " + biaya/10);

        Kendaraan kendaraan2 = new Kendaraan(2,9382,8, "Motor", 2000, 20);
        double biaya2 = kendaraan2.total(2000, 20);
        System.out.println("-".repeat(20));
        kendaraan2.tampilkanInfo();
        System.out.println("Total biaya2 : " + biaya2/10);
    }
}
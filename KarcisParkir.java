import java.util.Scanner;

class KarcisParkir {
    private static final int MOBIL_PERTAMA = 5000;
    private static final int MOTOR_PERTAMA = 2000;
    private static final int MOBIL_TAMBAHAN = 3000;
    private static final int MOTOR_TAMBAHAN = 1000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Sistem Karcis Parkir ===");
        System.out.println("Pilih jenis kendaraan:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.print("Masukkan pilihan (1 atau 2): ");
        int jenisKendaraan = input.nextInt();

        System.out.print("Masukkan durasi parkir dalam jam: ");
        int durasiJam = input.nextInt();

        int biaya = hitungBiayaParkir(jenisKendaraan, durasiJam);

        System.out.println("\n--- Karcis Parkir ---");
        if (jenisKendaraan == 1) {
            System.out.println("Jenis Kendaraan: Mobil");
        } else if (jenisKendaraan == 2) {
            System.out.println("Jenis Kendaraan: Motor");
        } else {
            System.out.println("Jenis Kendaraan: Tidak dikenal");
        }
        System.out.println("Durasi Parkir: " + durasiJam + " jam");
        System.out.println("Biaya Parkir: Rp " + biaya);
    }

    private static int hitungBiayaParkir(int jenisKendaraan, int durasiJam) {
        int biaya = 0;
        if (jenisKendaraan == 1) {
            biaya = MOBIL_PERTAMA + (durasiJam - 1) * MOBIL_TAMBAHAN;
        } else if (jenisKendaraan == 2) {
            biaya = MOTOR_PERTAMA + (durasiJam - 1) * MOTOR_TAMBAHAN;
        } else {
            System.out.println("Jenis kendaraan tidak valid.");
        }
        return biaya > 0 ? biaya : 0;
    }
}

public class Karcis {
    int no;
    int nopol;
    int awalmasuk;
    String jeniskendaraan;

    public Karcis(int no,int nopol, int awalmasuk, String jeniskendaraan) {
        this.no = no;
        this.nopol = nopol;
        this.awalmasuk = awalmasuk;
        this.jeniskendaraan = jeniskendaraan;
    }

    public void tampilkanInfo() {
        System.out.println("No. Karcis: " + no);
        System.out.println("Nopol : " + nopol);
        System.out.println("Awal masuk : jam " + awalmasuk);
        System.out.println("Jenis kendaraan : " + jeniskendaraan);
    }
}

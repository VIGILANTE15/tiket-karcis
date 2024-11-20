public class Kendaraan extends Karcis{
    int hargaawal;
    int durasi;

    public Kendaraan(int no, int nopol, int awalmasuk, String jeniskendaraan, int hargaawal, int durasi) {
        super(no, nopol, awalmasuk, jeniskendaraan);
        this.hargaawal = hargaawal;
        this.durasi = durasi;
    }

    @Override
    public void tampilkanInfo(){
        super.tampilkanInfo();
        System.out.println("Harga awal : " + hargaawal);
        System.out.println("Durasi : " + durasi + " Menit");
    }

    public double total (int hargaawal, int durasi){
    return hargaawal * durasi;
    }
}

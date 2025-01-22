package models;

public class Mobil extends Transportasi {
    public Mobil(String nomorKendaraan) {
        super(nomorKendaraan);
    }

    @Override
    public String getJenisTransportasi() {
        return "Mobil";
    }
}

package models;

public class Motor extends Transportasi {
    public Motor(String nomorKendaraan) {
        super(nomorKendaraan);
    }

    @Override
    public String getJenisTransportasi() {
        return "Motor";
    }
}


package models;

public abstract class Transportasi {
    private String nomorKendaraan;

    public Transportasi(String nomorKendaraan) {
        this.nomorKendaraan = nomorKendaraan;
    }

    public String getNomorKendaraan() {
        return nomorKendaraan;
    }

    public abstract String getJenisTransportasi();
}


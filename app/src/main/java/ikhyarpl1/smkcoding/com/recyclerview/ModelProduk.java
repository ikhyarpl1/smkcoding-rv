package ikhyarpl1.smkcoding.com.recyclerview;

/**
 * Created by Mesto on 30/08/2018.
 */

public class ModelProduk {

    private String nama;
    private String deskripsi;
    private int foto;

    public ModelProduk(String nama, String deskripsi, int foto) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

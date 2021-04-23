package com.tr.newsappcent;

public class favClass {


    String resim;
    String baslik;
    String icerik;
    String yazar;
    String tarih;
    String link;

    public favClass() {
    }

    public favClass(String resim, String baslik, String icerik, String yazar, String tarih,String link) {
        this.resim = resim;
        this.baslik = baslik;
        this.icerik = icerik;
        this.yazar = yazar;
        this.tarih = tarih;
        this.link = link;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

import java.util.ArrayList;


//Menambahkan kelas Karakter yang nantinya akan menjadi superClass dr player dan Zombie

public class Karakter {
    private Ruangan ruanganAktif;  //ruangan tempat player saat ini berada
    public int kesehatan;
    public String nama;
    private int damage;
    public GameInfo objGameInfo;
    public ArrayList<Item> arrItem;

    public boolean cariItem(String namaItem) {
        for (Item objItem:arrItem) {
            if (namaItem.equals(objItem.getNama())) {
                return (true);
            }
        }
        return(false); //tidak ketemu
    }

    public void identitas() {
        System.out.println("Nama :"+nama);
        System.out.println("Kesehatan :"+kesehatan);
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public GameInfo getObjGameInfo() {
        return objGameInfo;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public Ruangan getRuanganAktif() {
        return ruanganAktif;
    }

    public void setRuanganAktif(Ruangan ruanganAktif) {
        this.ruanganAktif = ruanganAktif;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

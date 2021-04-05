import java.util.ArrayList;
//belum menggunakan inheritance, idealnya turunan dari Item
//setelah menggunakan inheritance, class pintu menjadi turunan dari class item
//sehingga pada pintu sendiri memiliki atribut yang sama dengan

public class Pintu extends Item{


    //constrcutor
    public Pintu() {
        super("Pintu");
        //init pilihan
        arrAksi.add("Deskripsikan pintu");
        arrAksi.add("Coba buka pintu");
    }

    @Override
    public void prosesAksi(int subPil) {
        //1: deskripsikan
        //2: buka pintu
        if (subPil==1) {
            System.out.println("Pintu berwarna merah dengan tulisan 'EXIT' di atas ");
        } else if (subPil==2) {
            //cek apakah mempunyai kunci
            if (objGameInfo.getObjPlayer().cariItem("Kunci")) {
                //kunci ada, pintu terbuka
                System.out.println("Player menggunakan kunci untuk membuka pintu dan pintu terbuka!");
                objGameInfo.setGameOver(true); //game over
            } else {
                //kunci tidak ada
                System.out.println("Player mencboa membuka pintu. TERKUNCI!");
            }
        }
    }

    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

    @Override
    public ArrayList<String> getAksi() {
        return arrAksi;
    }

}

import java.util.ArrayList;
import java.util.Scanner;
//NPC merupakan turunan atau sub class dari item, mengapa?
//karena ada beberapa atribut dan method yang sama
public class NPC extends Item{
    //kunci dipindahkan dari ruangan
    private boolean isKenal = false;
    private Scanner sc = new Scanner(System.in);

    public NPC() {
        //kunci diturunkan pada npc, karena class npc sendiri merupakan
        // turunan dari class item yang tadinya item tersebut ada di pintu
        super("Kunci");
        objKunci = new Item("Kunci");
        objKunci.setDeskripsi("Sebuah kunci kecil yang sudah agak berkarat");

        //aksi npc
        arrAksi.add("Perkenalan dgn NPC");
        arrAksi.add("Minta kunci");

    }

    @Override
    public void prosesAksi(int subPil) {
        //1: perkenalan dengan npc
        //2: buka pintu

        if (subPil == 1) {
            System.out.println("Halo saya penjaga pintu ini");
            isKenal = true;
        } else if (subPil == 2) {
            int pilih;
            if (isKenal) {
                //berikan kunci pada player
                if (objKunci==null) {
                    System.out.println("Masa lupa, kunci kan sudah saya berikan!");
                } else
                {

                    System.out.println("Kunci diberikan pada player");
                    objGameInfo.getObjPlayer().addItem(objKunci);     //tambahkan  objek ini pada player
                    objKunci = null;

                }

            } else {
                System.out.println("Siapa anda? kenalan dulu dong");
            }
        }
    }

    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objKunci.setObjGameInfo(objGameInfo);
    }

    @Override
    public ArrayList<String> getAksi() {
        return arrAksi;
    }
}

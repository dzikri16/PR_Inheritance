import java.util.ArrayList;

//merupakan turunan atau subclass dari class Karakter
//kenapa? karena ada beberapa atribut dan method yang sama dengan class Player
public class Zombie extends Karakter{
    //item default yang dimiliki Zombie
    private Item objBlati = new Item("Pisau Belati");


    @Override
    public void setObjGameInfo(GameInfo objGameInfo){
        this.objGameInfo = objGameInfo;
        objBlati.setObjGameInfo(objGameInfo);
    }

    public Zombie(){
        arrItem = new ArrayList<>();
        objBlati.setDeskripsi("Pisau Belati Berkarat");
        setDamage(12);
        arrItem.add(objBlati);
        setNama("Agus");
        setKesehatan(100);
    }

    @Override
    public void identitas(){
        System.out.println("Nama : "+nama);
        System.out.println("Nyawa : "+kesehatan);
        System.out.println("Membawa "+objBlati.getDeskripsi());
    }
}

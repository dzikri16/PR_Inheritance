import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.format;

//merupakan turunan atau subclass dari class Karakter
//kenapa? karena ada beberapa atribut dan method yang sama dengan Class Zombie

public class Player extends Karakter{
    //item defulat yang dimiliki player
    private Item objCincin = new Item("Cincin Emas");
    private Item objPedang = new Item("Pedang");
    private Scanner sc = new Scanner(System.in);
    public Zombie objZombie = new Zombie();
    public int damageBaru;

    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objCincin.setObjGameInfo(objGameInfo);
        objPedang.setObjGameInfo(objGameInfo);
    }

    public Player() {
        arrItem = new ArrayList<>();
        objCincin.setDeskripsi("Cincin emas bertuliskan suatu kalimat..");
        arrItem.add(objCincin);
        arrItem.add(objPedang);
        objPedang.setDeskripsi("Pedang Suci");
        setNama("Budiwati");
        setKesehatan(100);
    }



    @Override
    public void identitas() {
        System.out.println("Nama Player: "+nama);
        System.out.println("Kesehatan Player: "+kesehatan);
    }

//    public void printItem() {
//        System.out.println("Item milik player");
//        int cc = 0;
//        for (Item objItem:arrItem) {
//            cc++;
//            System.out.printf("%d. %s%n",cc,objItem.getNama());
//            System.out.println(objItem.getDeskripsi());
//        }
//    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {
        if(!objItem.getNama().equals("Pedang")){
            System.out.println("Item dibuang player ke ruangan"); //saya pindahkan dr class Item ke sini
            arrItem.remove(objItem);  //buang item
        }
    }


    public void pilihanAksi() {
        damageBaru = 30;
        setDamage(damageBaru);
        System.out.println("**** Pilihan Aksi pada Player *** ");
        //disamakan dengan  ruangan
        //bisa direfactoring nanti supaya tdk duplikasi

        //aksi2 item yang dimiliki player
        int urutPil = 0;  //item
        int subPil;   //aksinya
        System.out.println("Item yang dimiliki player");
        for (Item objItem:arrItem) {
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());
            //ambil pilihannya
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        //info seputar player
        urutPil++;
        subPil = 0;
        int pilInfoPlayer  = urutPil; //catat untuk pintu
        System.out.println("Info Player");
        //hanya satu
        subPil++;
        System.out.printf("%d%d. info player%n", urutPil, subPil);

        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        if (pil == pilInfoPlayer) {
            identitas();
        } else {
            Item objItemPilih = arrItem.get(pil-1);
            objItemPilih.prosesAksi(subPil); //aksi item
        }

//        System.out.println("2. Item milik player");
//        System.out.print("Pilihan anda?");
//        int pilih = sc.nextInt();
//        System.out.println("--");
//        if (pilih==1) {
//            identitas();
//        } else if (pilih==2) {
//            printItem();
//        }
    }

    public void tempur(){ //menambahkan method tempur untuk melawan zombie
        int pilih;
        System.out.println("TIDAK!!!! \nADA ZOMBIEE!!");
        objZombie.identitas();
        while(kesehatan >= 1 && objZombie.kesehatan > 1){
            System.out.println("[1] Serang!");
            System.out.println("[2] Kabur");
            System.out.print("??");
            pilih = sc.nextInt();
            if(pilih == 1){
                if(kesehatan == 1){
                    System.out.println("Tidak Bisa Melawan Zombie!");
                    System.out.println("Kesehatan Kamu sudah sekarat");
                }else{
                        objZombie.kesehatan -= getDamage();
                        objZombie.setKesehatan(objZombie.kesehatan);
                        kesehatan -= objZombie.getDamage();
                        setKesehatan(kesehatan);
                        if(objZombie.kesehatan > 1) {
                            System.out.println("Nyawa Kamu " + kesehatan);
                            System.out.println("Nyawa Zombie " + objZombie.kesehatan);
                        }else {
                            System.out.println("Kamu menang!!");
                            setKesehatan(100);
                        }
                }
            }else if(pilih == 2){
                break;
            }
        }
    }
}

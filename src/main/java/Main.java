import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    static int qtyOfJigs = 100;

    public static void main(String[] args) {
//        Jig jig1 = new Jig("N3434");
//        Jig jig2 = new Jig("T2520");
//        Jig jig3 = new Jig("R2810");
//        Jig jig4 = new Jig("RRR10");
//
//        HashMap<Jig, Integer> jigForStorage = new HashMap<Jig, Integer>();
//        jigForStorage.put(jig1, 5);
//        jigForStorage.put(jig2, 3);
//        jigForStorage.put(jig3, 2);
//        jigForStorage.put(jig4, 1);
//
//        HashMap<Jig, Integer> jigNeededForHarn = new HashMap<Jig, Integer>();
//        jigNeededForHarn.put(jig1, 5);
//        jigNeededForHarn.put(jig2, 3);
//        jigNeededForHarn.put(jig3, 2);
//
//        HashMap<Jig, Integer> jigInstall = new HashMap<Jig, Integer>();
//        jigInstall.put(jig1, 1);
//        jigInstall.put(jig2, 2);
//        jigInstall.put(jig3, 3);
//
//
//        AssemblyBoard board = new AssemblyBoard("Bord1");
//        board.addNeededJigs(jigNeededForHarn);
//
////        board.installJigs(jigInstall);
//
//        Storage storage = new Storage("JigStorage", 5, 4);
//        storage.addJigs(jig1);
//        storage.addJigs(jig1);
//        storage.addJigs(jig1);
//        storage.addJigs(jig1);
//
//        storage.addJigs(jig2);
//        storage.addJigs(jig2);
//        storage.addJigs(jig2);
//        storage.addJigs(jig2);
//        storage.addJigs(jig2);
//
//        storage.addJigs(jig3);
//        storage.addJigs(jig3);
//        storage.addJigs(jig3);
//
//        System.out.println("before transfer:");
//        storage.showStorage();
//
//        storage.transferJigs(board);
//
//        System.out.println("After transfer:");
//        storage.showStorage();
//
//        HashMap<Jig, Integer> listOfNeededJigs = board.getNeededJigs();
//        HashMap<Jig, Integer> listOfInstalledJigs = board.getInstalledJigs();
//
//        System.out.println("Needed jigs:");
//        listOfInstalledJigs.keySet().forEach(System.out::println);
//
//        System.out.println("Installed jigs:");
//        listOfNeededJigs.keySet().forEach(System.out::println);
        for (int i = 56; i > 0; i = i + 10) {
            System.out.println("ye");
            if (i < 60) {
                break;
            }
        }
    }

    private static void autoFillingStorageWithJigs(Storage storage) {
        int counter = 0;
        for (int i = 0; i < qtyOfJigs; i++) {
            counter++;
            Jig jig = new Jig("Jig_" + counter);
            storage.addJigs(jig);
            if (counter == 21) {
                counter = 0;
            }
        }
    }

}

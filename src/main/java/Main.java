import java.util.HashMap;

public class Main {

    static int qtyOfJigs = 100;

    public static void main(String[] args) {
        Jig n3434 = new Jig("N3434");
        Jig t2520 = new Jig("T2520");
        Jig r2810 = new Jig("R2810");
        Jig rrr10 = new Jig("RRR10");

        HashMap<Jig, Integer> jigForStorage = new HashMap<Jig, Integer>();
        jigForStorage.put(n3434, 5);
        jigForStorage.put(t2520, 3);
        jigForStorage.put(r2810, 2);
        jigForStorage.put(rrr10, 1);

        HashMap<Jig, Integer> jigNeededForHarn = new HashMap<Jig, Integer>();
        jigNeededForHarn.put(n3434, 5);
        jigNeededForHarn.put(t2520, 3);
        jigNeededForHarn.put(r2810, 2);

        HashMap<Jig, Integer> jigInstall = new HashMap<Jig, Integer>();
        jigInstall.put(n3434, 1);
        jigInstall.put(t2520, 2);
        jigInstall.put(r2810, 3);


        AssemblyBoard board = new AssemblyBoard("Bord1", jigNeededForHarn);
        System.out.println("Board before:");
        board.showInstalledJigs();


        board.installJigs(jigInstall);
        board.installJigs(jigInstall);
        board.installJigs(jigInstall);
        board.installJigs(jigInstall);
        board.installJigs(jigInstall);
        board.installJigs(jigInstall);
        System.out.println("Board after:");
        board.showInstalledJigs();

//        board.installJigs(jigInstall);

        JigStorage storage = new JigStorage("JigStorage", 5, 4);
        storage.installJigs(jigForStorage);

        System.out.println("Storage before transfer:");
        storage.showInstalledJigs();

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

    }

//    private static void autoFillingStorageWithJigs(JigStorage storage) {
//        int counter = 0;
//        for (int i = 0; i < qtyOfJigs; i++) {
//            counter++;
//            Jig jig = new Jig("Jig_" + counter);
//            storage.addOneJig(jig);
//            if (counter == 21) {
//                counter = 0;
//            }
//        }
//    }

}

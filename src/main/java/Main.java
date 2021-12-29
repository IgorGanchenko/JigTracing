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

        HashMap<Jig, Integer> jigInstallHarness = new HashMap<Jig, Integer>();
        jigInstallHarness.put(n3434, 1);
        jigInstallHarness.put(t2520, 2);
        jigInstallHarness.put(r2810, 3);

        HashMap<Jig, Integer> jigsTrancfer = new HashMap<Jig, Integer>();
        jigsTrancfer.put(n3434, 1);
        jigsTrancfer.put(t2520, 1);
        jigsTrancfer.put(r2810, 1);

        AssemblyBoard board = new AssemblyBoard("Bord1", jigNeededForHarn);
        board.showInstalledJigs();
        board.installJigs(jigInstallHarness);
        System.out.println("Board after:");
        board.showInstalledJigs();

        JigStorage storage = new JigStorage("JigStorage", 5, 4);
        storage.installJigs(jigForStorage);

        System.out.println("Storage after adding:");
        storage.showStorage();

        storage.transferJigs(board, jigsTrancfer);
        storage.transferJigs(board, jigsTrancfer);

        System.out.println("Storage after transfer:");
        storage.showStorage();

        System.out.println("Harness after transfer:");
        board.showInstalledJigs();

        System.out.println("Transfer back");
        board.transferJigs(storage, jigsTrancfer);
        board.transferJigs(storage, jigsTrancfer);
        storage.showStorage();
        board.showInstalledJigs();

    }
}

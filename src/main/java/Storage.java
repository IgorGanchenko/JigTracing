import java.util.HashMap;

public class Storage {
    private int id;
    private int height;
    private int wight;
    private String storageName;
    private HashMap<Location, Jig> locations;
    private HashMap<Jig, Integer> qty = new HashMap<Jig, Integer>();

    private Jig[][] storagePlaces;

    public Storage(String storageName, int height, int wight) {
        this.height = height;
        this.wight = wight;
        this.storageName = storageName;
        storagePlaces = new Jig[height][wight];
    }

    public Jig[][] getStoragePlaces() {
        return storagePlaces;
    }

    public boolean addJigs(Jig jig) {
        if (qty.containsKey(jig)) {
            putJigToStoragePlace(jig);
        } else if (!checkIfStorageFull()) {
            putJigToEmptySpace(jig);
        }
        return false;
    }

    private boolean checkIfStorageFull() {
        for (Jig[] storagePlace : storagePlaces) {
            for (Jig jig : storagePlace) {
                if (jig == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean putJigToStoragePlace(Jig jig) {
        for (Jig[] storagePlace : storagePlaces) {
            for (Jig value : storagePlace) {
                if (value.equals(jig)) {
                    int jigQty = qty.get(jig);
                    qty.replace(jig, ++jigQty);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean putJigToEmptySpace(Jig jig) {
        for (int i = 0; i < storagePlaces.length; i++) {
            for (int j = 0; j < storagePlaces[i].length; j++) {
                if (storagePlaces[i][j] == null) {
                    storagePlaces[i][j] = jig;
                    qty.put(jig, 1);
                    System.out.printf("Jig %s has been added to storage %s\n", jig.getPkcCode(), storageName);
                    return true;
                }
            }
        }
        return false;
    }

    public void showStorage() {
        for (Jig[] storagePlace : storagePlaces) {
            for (Jig value : storagePlace) {
                if (value != null) {
                    System.out.println(value.getPkcCode() + " - " + qty.get(value));
                }
            }
        }
    }

    public void transferJigs(AssemblyBoard board){
        board.installJigs(qty);
    }

}

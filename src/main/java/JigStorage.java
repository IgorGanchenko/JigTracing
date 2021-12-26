import java.util.HashMap;
import java.util.Map;

public class JigStorage extends Storage {

    private int height;
    private int wight;
    private HashMap<Jig, Integer> existedJigs = new HashMap<Jig, Integer>();

    private Jig[][] storagePlaces;

    public JigStorage(String name, int height, int wight) {
        super(name);
        this.height = height;
        this.wight = wight;
        this.name = name;
        storagePlaces = new Jig[height][wight];
    }

    public Jig[][] getStoragePlaces() {
        return storagePlaces;
    }


    @Override
    protected boolean addOneJig(Jig jig, int qty) {
        if (existedJigs.containsKey(jig)) {
            int oldQty = existedJigs.get(jig);
            existedJigs.replace(jig, oldQty + qty);
            return true;
        } else if (!checkIfStorageFull()) {
            putJigToEmptySpace(jig);
            existedJigs.put(jig, qty);
            return true;
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


    private boolean putJigToEmptySpace(Jig jig) {
        for (int i = 0; i < storagePlaces.length; i++) {
            for (int j = 0; j < storagePlaces[i].length; j++) {
                if (storagePlaces[i][j] == null) {
                    storagePlaces[i][j] = jig;
                    System.out.printf("Jig %s has been added to storage %s\n", jig.getPkcCode(), name);
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
                    System.out.println(value.getPkcCode() + " - " + existedJigs.get(value));
                }
            }
        }
    }

    @Override
    public void installJigs(HashMap<Jig, Integer> transferredJigs) {
        for (Map.Entry<Jig, Integer> entry : transferredJigs.entrySet()) {
            Jig jig = entry.getKey();
            int qty = entry.getValue();
            addOneJig(jig, qty);
        }
    }

}

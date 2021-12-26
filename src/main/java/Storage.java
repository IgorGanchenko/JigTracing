import java.util.HashMap;
import java.util.Map;

public abstract class Storage {
    protected int id;
    protected String name;
    protected HashMap<Jig, Integer> existedJigs = new HashMap<Jig, Integer>();

    public Storage(String name) {
        this.name = name;
    }


    public HashMap<Jig, Integer> getExistedJigs() {
        return existedJigs;
    }


    public abstract void installJigs(HashMap<Jig, Integer> transferredJigs);


    protected abstract boolean addOneJig(Jig jig, int qty);

    public void transferJigs(Storage distStorage, HashMap<Jig, Integer> transferredJigs) {
        for (Map.Entry<Jig, Integer> entry : transferredJigs.entrySet()) {
            Jig jig = entry.getKey();
            int qty = entry.getValue();
            if (existedJigs.containsKey(jig) && (qty < existedJigs.get(jig))) {
                existedJigs.replace(jig, qty);
                distStorage.addOneJig(jig, qty);
            }
        }
    }

    protected void showInstalledJigs() {
        for (Map.Entry<Jig, Integer> entry : existedJigs.entrySet()) {
            Jig jig = entry.getKey();
            if (jig != null) {
                int qty = entry.getValue();
                System.out.println(jig.getPkcCode() + " - " + qty);
            }

        }
    }
}

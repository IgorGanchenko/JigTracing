import java.util.HashMap;
import java.util.Map;

public class AssemblyBoard extends Storage {
    private HashMap<Jig, Integer> neededJigs = new HashMap<Jig, Integer>();

    boolean isActive;

    public AssemblyBoard(String name, HashMap<Jig, Integer> neededJigs) {
        super(name);
        this.neededJigs = neededJigs;
    }

    public HashMap<Jig, Integer> getNeededJigs() {
        HashMap<Jig, Integer> jigs = new HashMap<Jig, Integer>();
        jigs.putAll(neededJigs);
        return jigs;
    }

    public void setNeededJigs(HashMap<Jig, Integer> neededJigs) {
        this.neededJigs = neededJigs;
    }

    @Override
    public void installJigs(HashMap<Jig, Integer> transferredJigs) {
        for (Map.Entry<Jig, Integer> entry : transferredJigs.entrySet()) {
            Jig jig = entry.getKey();
            int qty = entry.getValue();
            addOneJig(jig, qty);
        }
    }


    @Override
    protected boolean addOneJig(Jig jig, int qty) {
        if (neededJigs.containsKey(jig)) {
            if (existedJigs.containsKey(jig)) {
                if (existedJigs.get(jig) == neededJigs.get(jig)) {
                    return false;
                } else {
                    int necessaryQty = neededJigs.get(jig) - existedJigs.get(jig);
                    int qtyForInstall = Math.min(qty, necessaryQty);
                    existedJigs.replace(jig, existedJigs.get(jig) + qtyForInstall);
                    return true;
                }
            } else {
                int necessaryQty = Math.min(neededJigs.get(jig), qty);
                existedJigs.put(jig, necessaryQty);
                return true;
            }
        } else {
            System.out.printf("Harness %s not contains %s jig\n", name, jig);
            return false;
        }
    }


}

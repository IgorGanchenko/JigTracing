import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssemblyBoard {

    private int id;
    private String harnessName;
    private HashMap<Jig, Integer> installedJigs = new HashMap<Jig, Integer>();
    private HashMap<Jig, Integer> neededJigs = new HashMap<Jig, Integer>();
    boolean isActive;

    public AssemblyBoard(String harnessName) {
        this.harnessName = harnessName;
    }

    public HashMap<Jig, Integer> getInstalledJigs() {
        return installedJigs;
    }

    public HashMap<Jig, Integer> getNeededJigs() {
        return neededJigs;
    }

    public void addNeededJigs(HashMap<Jig, Integer> jigs) {
           neededJigs.putAll(jigs);
    }

    public void installJigs(HashMap<Jig, Integer> jigs){
        jigs.keySet().forEach(jig -> {
            if (neededJigs.containsKey(jig)){
                int qty = jigs.get(jig);
                int needQty = neededJigs.get(jig);
                installedJigs.put(jig, needQty);
                jigs.replace(jig, qty - needQty);
            }
        });
    }


    private void addOneJig(Jig jig, int qty) {
        if (neededJigs.containsKey(jig)){
            installedJigs.put(jig, qty);
        } else {
            System.out.printf("Harness %s not contains %s jig\n", harnessName, jig);
        }
    }



}

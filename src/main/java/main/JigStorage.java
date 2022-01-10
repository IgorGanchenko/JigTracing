package main;

import main.response.Jig;
import main.response.Storage;

import java.util.HashMap;
import java.util.Map;

public class JigStorage extends Storage {

    private int height;
    private int wight;

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

    @Override
    protected boolean removeOneJig(Jig jig, int qty) {
        if (existedJigs.containsKey(jig)) {
            int oldQty = existedJigs.get(jig);
            if (oldQty >= qty) {
                existedJigs.replace(jig, oldQty - qty);
                cleanStoragePlaceIfEmpty(jig);
            } else {
                existedJigs.replace(jig, qty - oldQty);
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean cleanStoragePlaceIfEmpty(Jig jig) {
        if (existedJigs.get(jig) == 0) {
            existedJigs.remove(jig);
            return cleanStoragePlace(jig);
        }
        return false;
    }

    private boolean cleanStoragePlace(Jig seekingJig) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wight; j++) {
                Jig jig = storagePlaces[i][j];
                if (jig != null && jig.equals(seekingJig)) {
                    storagePlaces[i][j] = null;
                    System.out.printf("main.response.Jig %s in place %s - %s in storage %s nas been removed.\n", jig, i, j, name);
                    return true;
                }
            }
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
                    System.out.printf("main.response.Jig %s has been added to storage %s\n", jig.getPkcCode(), name);
                    return true;
                }
            }
        }
        return false;
    }

    public void showStorage() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wight; j++) {
                Jig jig = storagePlaces[i][j];
                if (jig != null) {
                    System.out.println("Place " + i + "-" + j + " " + jig.getPkcCode() + " - " + existedJigs.get(jig));
                } else {
                    System.out.println("Place " + i + "-" + j + " " + "empty");
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

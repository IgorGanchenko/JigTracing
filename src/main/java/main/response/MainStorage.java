package main.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainStorage extends Storage {

    private int id;

    //private List<Jig> jigs;

    public MainStorage (){
        super("MainStorage");
    }

    @Override
    public void installJigs(HashMap<Jig, Integer> transferredJigs) {

    }

    @Override
    public boolean addOneJig(Jig jig, int qty) {
        return false;
    }

    @Override
    protected boolean removeOneJig(Jig jig, int qty) {
        return false;
    }
}

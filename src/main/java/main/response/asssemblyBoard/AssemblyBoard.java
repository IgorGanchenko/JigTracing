package main.response.asssemblyBoard;


import main.response.Jig;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Assembly_board")
public class AssemblyBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "assemblyBoards")
    private Set<Jig> jigsInBoard;

    public AssemblyBoard() {
        this.id = 0;
        this.name = "";
        this.jigsInBoard = new HashSet<>();
    }

    public AssemblyBoard(String name) {
        this.name = name;
        this.jigsInBoard = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Jig> getJigsInBoard() {
        return jigsInBoard;
    }

    public void setJigsInBoard(Set<Jig> jigsInBoard) {
        this.jigsInBoard = jigsInBoard;
    }
//    private HashMap<Jig, Integer> neededJigs = new HashMap<Jig, Integer>();
//
//    boolean isActive;
//
//    public main.response.asssemblyBoard.AssemblyBoard(String name, HashMap<Jig, Integer> neededJigs) {
//        super(name);
//        this.neededJigs = neededJigs;
//    }
//
//    public HashMap<Jig, Integer> getNeededJigs() {
//        HashMap<Jig, Integer> jigs = new HashMap<Jig, Integer>();
//        jigs.putAll(neededJigs);
//        return jigs;
//    }
//
//    public void setNeededJigs(HashMap<Jig, Integer> neededJigs) {
//        this.neededJigs = neededJigs;
//    }
//
//    @Override
//    public void installJigs(HashMap<Jig, Integer> transferredJigs) {
//        for (Map.Entry<Jig, Integer> entry : transferredJigs.entrySet()) {
//            Jig jig = entry.getKey();
//            int qty = entry.getValue();
//            addOneJig(jig, qty);
//        }
//    }
//
//

    public boolean addOneJig(Jig jig) {
        jigsInBoard.add(jig);
        return true;
//        if (neededJigs.containsKey(jig)) {
//            if (existedJigs.containsKey(jig)) {
//                if (existedJigs.get(jig).equals(neededJigs.get(jig))) {
//                    return false;
//                } else {
//                    int necessaryQty = neededJigs.get(jig) - existedJigs.get(jig);
//                    int qtyForInstall = Math.min(qty, necessaryQty);
//                    existedJigs.replace(jig, existedJigs.get(jig) + qtyForInstall);
//                    return true;
//                }
//            } else {
//                int necessaryQty = Math.min(neededJigs.get(jig), qty);
//                existedJigs.put(jig, necessaryQty);
//                return true;
//            }
//        } else {
//            System.out.printf("Harness %s not contains %s jig\n", name, jig);
//            return false;
//        }
    }
//
//    @Override
//    protected boolean removeOneJig(Jig jig, int qty) {
//        if (existedJigs.containsKey(jig)) {
//            int currentQty = existedJigs.get(jig);
//            int necessaryQty = Math.min(currentQty, qty);
//            existedJigs.replace(jig, currentQty - necessaryQty);
//            if (existedJigs.get(jig) == 0) {
//                existedJigs.remove(jig);
//            }
//            return true;
//        }
//        return false;
//    }


}

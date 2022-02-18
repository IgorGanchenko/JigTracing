package main.response;

import main.response.asssemblyBoard.AssemblyBoard;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "jig")
public class Jig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "pkc_code")
    private String pkcCode;

    private int qty;

    @ManyToMany
    @JoinTable(
            name = "jigs_in_storage",
            joinColumns = @JoinColumn(name = "jig_id"),
            inverseJoinColumns = @JoinColumn(name = "storage_id"))
    private Set<AssemblyBoard> assemblyBoards;

    public Jig() {
        this.id = 0;
        this.pkcCode = "";
        this.qty = 0;
        this.assemblyBoards = new HashSet<>();
    }

    public Jig(String pkcCode, int qty) {
        this.pkcCode = pkcCode;
        this.qty = qty;
        this.assemblyBoards = new HashSet<>();
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPkcCode() {
        return pkcCode;
    }

    public void setPkcCode(String pkcCode) {
        this.pkcCode = pkcCode;
    }

    public Set<AssemblyBoard> getAssemblyBoards() {
        return assemblyBoards;
    }

    public void setAssemblyBoards(Set<AssemblyBoard> assemblyBoards) {
        this.assemblyBoards = assemblyBoards;
    }

//public Jig(String pkcCode) {
//        this.pkcCode = pkcCode;
//    }

//    public String getPkcCode() {
//        return pkcCode;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jig)) return false;
        Jig jig = (Jig) o;
        return getPkcCode().equals(jig.getPkcCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkcCode());
    }

    @Override
    public String toString() {
        return "main.response.Jig{" +
                "pkcCode='" + pkcCode + '\'' +
                '}';
    }
}

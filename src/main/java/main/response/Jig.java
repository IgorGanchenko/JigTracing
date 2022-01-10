package main.response;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jig")
public class Jig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "pkc_code")
    private String pkcCode;

    @Column(name = "storage_id")
    private int storageId;

    public Jig(String pkcCode){
        this.pkcCode = pkcCode;
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

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
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
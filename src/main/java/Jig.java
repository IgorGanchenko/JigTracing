import java.util.Objects;

public class Jig {
    private String pkcCode;
    private int id;
    private boolean isHasLeg;
    private JigStorage storage;
    private int totalQty;

    public Jig(String pkcCode) {
        this.pkcCode = pkcCode;
    }

    public String getPkcCode() {
        return pkcCode;
    }

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
        return "Jig{" +
                "pkcCode='" + pkcCode + '\'' +
                '}';
    }
}

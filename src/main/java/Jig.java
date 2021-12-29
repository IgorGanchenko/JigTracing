import java.util.Objects;

public class Jig {
    private static int totalQty = 0;
    private String pkcCode;
    private int id;
    private boolean isHasLeg;
    private JigStorage storage;


    public Jig(String pkcCode) {
        this.pkcCode = pkcCode;
        totalQty++;
    }

    public static int getTotalQty() {
        int qty = totalQty;
        return qty;
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

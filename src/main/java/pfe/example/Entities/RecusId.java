/* package pfe.example.Entities;

import java.io.Serializable;
import java.util.Objects;


public class RecusId implements Serializable{
    private Long courrierRecus;
    private String agenceRecus;

    public RecusId() {}

    public RecusId(Long courrierRecus, String agenceRecus) {
        this.courrierRecus = courrierRecus;
        this.agenceRecus = agenceRecus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecusId)) return false;
        RecusId that = (RecusId) o;
        return Objects.equals(courrierRecus, that.courrierRecus) && Objects.equals(agenceRecus, that.agenceRecus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courrierRecus, agenceRecus);
    }

}
 */
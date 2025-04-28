package pfe.example.Entities;

import java.io.Serializable;
import java.util.Objects;

public class RecusId implements Serializable{
    private Long courrier;
    private Long agence;

    public RecusId() {}

    public RecusId(Long courrier, Long agence) {
        this.courrier = courrier;
        this.agence = agence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecusId)) return false;
        RecusId that = (RecusId) o;
        return Objects.equals(courrier, that.courrier) && Objects.equals(agence, that.agence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courrier, agence);
    }

}

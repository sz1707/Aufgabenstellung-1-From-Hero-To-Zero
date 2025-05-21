package paket1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "emissionswerte")
public class Emissionsdaten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Land", nullable = false)
    private String land;

    @Column(name = "CO2Emissionen")
    private Double co2Emissionen;

    // Getter und Setter

    public Long getId() {
        return id;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Double getCo2Emissionen() {
        return co2Emissionen;
    }

    public void setCo2Emissionen(Double co2Emissionen) {
        this.co2Emissionen = co2Emissionen;
    }
}




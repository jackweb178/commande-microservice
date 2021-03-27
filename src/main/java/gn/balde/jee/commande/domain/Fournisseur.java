package gn.balde.jee.commande.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Fournisseur.
 */
@Entity
@Table(name = "fournisseur")
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "entreprisename", nullable = false)
    private String entreprisename;

    
    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "date", nullable = false)
    private Instant date;

    @ManyToMany(mappedBy = "fournisseurs")
    @JsonIgnore
    private Set<Commande> commandes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntreprisename() {
        return entreprisename;
    }

    public Fournisseur entreprisename(String entreprisename) {
        this.entreprisename = entreprisename;
        return this;
    }

    public void setEntreprisename(String entreprisename) {
        this.entreprisename = entreprisename;
    }

    public String getDescription() {
        return description;
    }

    public Fournisseur description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getDate() {
        return date;
    }

    public Fournisseur date(Instant date) {
        this.date = date;
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public Fournisseur commandes(Set<Commande> commandes) {
        this.commandes = commandes;
        return this;
    }

    public Fournisseur addCommande(Commande commande) {
        this.commandes.add(commande);
        commande.getFournisseurs().add(this);
        return this;
    }

    public Fournisseur removeCommande(Commande commande) {
        this.commandes.remove(commande);
        commande.getFournisseurs().remove(this);
        return this;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fournisseur)) {
            return false;
        }
        return id != null && id.equals(((Fournisseur) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Fournisseur{" +
            "id=" + getId() +
            ", entreprisename='" + getEntreprisename() + "'" +
            ", description='" + getDescription() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }
}

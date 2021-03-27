package gn.balde.jee.commande.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Commande.
 */
@Entity
@Table(name = "commande")
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    
    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @NotNull
    @Column(name = "date", nullable = false)
    private Instant date;

    @NotNull
    @Column(name = "date_delivry", nullable = false)
    private Instant dateDelivry;

    @ManyToMany
    @JoinTable(name = "commande_fournisseur",
               joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "fournisseur_id", referencedColumnName = "id"))
    private Set<Fournisseur> fournisseurs = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "commande_product",
               joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> products = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Commande title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public Commande content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getDate() {
        return date;
    }

    public Commande date(Instant date) {
        this.date = date;
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Instant getDateDelivry() {
        return dateDelivry;
    }

    public Commande dateDelivry(Instant dateDelivry) {
        this.dateDelivry = dateDelivry;
        return this;
    }

    public void setDateDelivry(Instant dateDelivry) {
        this.dateDelivry = dateDelivry;
    }

    public Set<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public Commande fournisseurs(Set<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
        return this;
    }

    public Commande addFournisseur(Fournisseur fournisseur) {
        this.fournisseurs.add(fournisseur);
        fournisseur.getCommandes().add(this);
        return this;
    }

    public Commande removeFournisseur(Fournisseur fournisseur) {
        this.fournisseurs.remove(fournisseur);
        fournisseur.getCommandes().remove(this);
        return this;
    }

    public void setFournisseurs(Set<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Commande products(Set<Product> products) {
        this.products = products;
        return this;
    }

    public Commande addProduct(Product product) {
        this.products.add(product);
        product.getCommandes().add(this);
        return this;
    }

    public Commande removeProduct(Product product) {
        this.products.remove(product);
        product.getCommandes().remove(this);
        return this;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Commande)) {
            return false;
        }
        return id != null && id.equals(((Commande) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Commande{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", content='" + getContent() + "'" +
            ", date='" + getDate() + "'" +
            ", dateDelivry='" + getDateDelivry() + "'" +
            "}";
    }
}

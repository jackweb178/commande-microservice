package gn.balde.jee.commande.repository;

import gn.balde.jee.commande.domain.Commande;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Commande entity.
 */
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

    @Query(value = "select distinct commande from Commande commande left join fetch commande.fournisseurs left join fetch commande.products",
        countQuery = "select count(distinct commande) from Commande commande")
    Page<Commande> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct commande from Commande commande left join fetch commande.fournisseurs left join fetch commande.products")
    List<Commande> findAllWithEagerRelationships();

    @Query("select commande from Commande commande left join fetch commande.fournisseurs left join fetch commande.products where commande.id =:id")
    Optional<Commande> findOneWithEagerRelationships(@Param("id") Long id);
}

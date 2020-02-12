package com.gomax.repositories;

        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import com.gomax.entities.Tarif;

@Repository
public interface TarifRepository extends CrudRepository<Tarif, Long>{

}

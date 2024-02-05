package ubb.demo.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ubb.demo.common.PersistenceAdapter;

import java.util.Collection;

@Repository
@PersistenceAdapter
public interface SpringDataGuitarRepository extends JpaRepository<GuitarJpaEntity, Long> {
    @Query("SELECT g FROM GuitarJpaEntity g WHERE g.stock > 0")
    Collection<GuitarJpaEntity> getAllAvailableGuitars();

    @Transactional
    @Modifying
    @Query("UPDATE GuitarJpaEntity g SET g.stock = g.stock - 1 WHERE g.id = :guitarId")
    GuitarJpaEntity sellGuitarById(@Param("guitarId") Long guitarId);

    @Transactional
    @Modifying
    @Query("UPDATE GuitarJpaEntity g SET g.stock = g.stock + 1 WHERE g.id = :guitarId")
    GuitarJpaEntity restockGuitarById(@Param("guitarId") Long guitarId);
}

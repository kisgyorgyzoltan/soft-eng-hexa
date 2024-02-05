package ubb.demo.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GuitarRepository extends JpaRepository<GuitarJpaEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE GuitarJpaEntity g SET g.stock = g.stock - 1 WHERE g.id = :guitarId")
    int sellGuitarById(@Param("guitarId") Long guitarId);

    @Transactional
    @Modifying
    @Query("UPDATE GuitarJpaEntity g SET g.stock = g.stock + 1 WHERE g.id = :guitarId")
    int restockGuitarById(@Param("guitarId") Long guitarId);
}

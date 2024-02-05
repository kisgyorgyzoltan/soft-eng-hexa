package ubb.demo.adapter.out.persistence;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import ubb.demo.application.domain.model.Guitar;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface PersistenceGuitarMapper {
    GuitarJpaEntity mapToJpaEntity(Guitar guitar);

    Guitar toDomain(GuitarJpaEntity guitarJpaEntity);

    @IterableMapping(elementTargetType = Guitar.class)
    Collection<Guitar> toDomainList(Collection<GuitarJpaEntity> guitarJpaEntities);
}

package ubb.demo.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ubb.demo.application.domain.model.Guitar;
import ubb.demo.application.port.out.PersistencePort;
import ubb.demo.common.PersistenceAdapter;

import java.util.Collection;

@RequiredArgsConstructor
@PersistenceAdapter
public class GuitarPersistenceAdapter implements PersistencePort {
    @Autowired
    private SpringDataGuitarRepository guitarRepository;

    @Autowired
    private PersistenceGuitarMapper persistenceGuitarMapper;

    @Override
    public Guitar findById(Long guitarId) {
        GuitarJpaEntity guitarJpaEntity = guitarRepository.findById(guitarId).orElseThrow();
        return persistenceGuitarMapper.toDomain(guitarJpaEntity);
    }

    @Override
    public Collection<Guitar> findAll() {
        Collection<GuitarJpaEntity> guitarJpaEntities = guitarRepository.findAll();
        return persistenceGuitarMapper.toDomainList(guitarJpaEntities);
    }

    @Override
    public Guitar create(Guitar guitar) {
        GuitarJpaEntity guitarJpaEntity = persistenceGuitarMapper.mapToJpaEntity(guitar);
        GuitarJpaEntity savedGuitarJpaEntity = guitarRepository.save(guitarJpaEntity);
        return persistenceGuitarMapper.toDomain(savedGuitarJpaEntity);
    }

    @Override
    public Guitar update(Guitar guitar) {
        GuitarJpaEntity guitarJpaEntity = persistenceGuitarMapper.mapToJpaEntity(guitar);
        GuitarJpaEntity savedGuitarJpaEntity = guitarRepository.save(guitarJpaEntity);
        return persistenceGuitarMapper.toDomain(savedGuitarJpaEntity);
    }

    @Override
    public void delete(Long guitarId) {
        guitarRepository.deleteById(guitarId);
    }

    @Override
    public Collection<Guitar> loadAvailableGuitars() {
        Collection<GuitarJpaEntity> guitarJpaEntities = guitarRepository.getAllAvailableGuitars();
        return persistenceGuitarMapper.toDomainList(guitarJpaEntities);
    }

    @Override
    public Guitar restockGuitar(Long guitarId) {
        GuitarJpaEntity restockedGuitar = guitarRepository.restockGuitarById(guitarId);
        return persistenceGuitarMapper.toDomain(restockedGuitar);
    }

    @Override
    public Guitar sellGuitar(Long guitarId) {
        GuitarJpaEntity soldGuitar = guitarRepository.sellGuitarById(guitarId);
        return persistenceGuitarMapper.toDomain(soldGuitar);
    }
}
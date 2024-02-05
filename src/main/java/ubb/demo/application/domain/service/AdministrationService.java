package ubb.demo.application.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubb.demo.application.domain.model.Guitar;
import ubb.demo.application.port.in.AdministrationUseCase;
import ubb.demo.application.port.out.PersistencePort;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class AdministrationService implements AdministrationUseCase {
    @Autowired
    private PersistencePort persistencePort;
    @Override
    public Collection<Guitar> getAvailableGuitars() {
        return persistencePort.loadAvailableGuitars();
    }

    @Override
    public Guitar getGuitarById(Long guitarId) {
        return persistencePort.findById(guitarId);
    }

    @Override
    public Collection<Guitar> getAllGuitars() {
        return persistencePort.findAll();
    }

    @Override
    public Guitar addGuitar(Guitar guitar) {
        return persistencePort.create(guitar);
    }

    @Override
    public Guitar updateGuitar(Long guitarId, Guitar guitar) {
        return persistencePort.update(guitar);
    }

    @Override
    public void deleteGuitar(Long guitarId) {
        persistencePort.delete(guitarId);
    }

}

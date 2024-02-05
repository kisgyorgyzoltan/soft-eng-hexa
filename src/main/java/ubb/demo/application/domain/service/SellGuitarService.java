package ubb.demo.application.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubb.demo.application.domain.model.Guitar;
import ubb.demo.application.port.in.SellGuitarUseCase;
import ubb.demo.application.port.out.PersistencePort;

@RequiredArgsConstructor
@Service
public class SellGuitarService implements SellGuitarUseCase {
    @Autowired
    private PersistencePort persistencePort;
    @Override
    public Guitar sellGuitar(Long guitarId) {
        return persistencePort.sellGuitar(guitarId);
    }
}

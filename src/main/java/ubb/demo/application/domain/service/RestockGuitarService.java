package ubb.demo.application.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubb.demo.application.domain.model.Guitar;
import ubb.demo.application.port.in.RestockGuitarUseCase;
import ubb.demo.application.port.out.PersistencePort;

@RequiredArgsConstructor
@Service
public class RestockGuitarService implements RestockGuitarUseCase {
    @Autowired
    private PersistencePort persistencePort;
    @Override
    public Guitar restockGuitar(Long guitarId) {
        return persistencePort.restockGuitar(guitarId);
    }

}

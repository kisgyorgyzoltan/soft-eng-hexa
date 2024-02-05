package ubb.demo.application.port.in;

import ubb.demo.application.domain.model.Guitar;
import ubb.demo.common.UseCase;

@UseCase
public interface RestockGuitarUseCase {
    Guitar restockGuitar(Long guitarId);
}

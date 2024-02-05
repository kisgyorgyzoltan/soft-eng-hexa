package ubb.demo.application.port.in;

import ubb.demo.application.domain.model.Guitar;
import ubb.demo.common.UseCase;

import java.util.Collection;

@UseCase
public interface SellGuitarUseCase {
    Guitar sellGuitar(Long guitarId);
}

package ubb.demo.application.port.in;

import ubb.demo.application.domain.model.Guitar;
import ubb.demo.common.UseCase;

import java.util.Collection;

@UseCase
public interface AdministrationUseCase {
    Guitar getGuitarById(Long guitarId);
    Collection<Guitar> getAllGuitars();
    Guitar addGuitar(Guitar guitar);
    Guitar updateGuitar(Long guitarId, Guitar guitar);
    void deleteGuitar(Long guitarId);
    Collection<Guitar> getAvailableGuitars();

}

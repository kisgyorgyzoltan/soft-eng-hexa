package ubb.demo.application.port.out;

import ubb.demo.application.domain.model.Guitar;

import java.util.Collection;

public interface PersistencePort {
    Guitar findById(Long guitarId);
    Collection<Guitar> findAll();
    Guitar create(Guitar guitar);
    Guitar update(Guitar guitar);
    void delete(Long guitarId);
    Collection<Guitar> loadAvailableGuitars();
    Guitar restockGuitar(Long guitarId);
    Guitar sellGuitar(Long guitarId);
}

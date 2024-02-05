package ubb.demo.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubb.demo.adapter.in.web.dto.CreateGuitarDTO;
import ubb.demo.application.domain.model.Guitar;
import ubb.demo.application.port.in.AdministrationUseCase;
import ubb.demo.common.WebAdapter;

import java.util.Collection;

@WebAdapter
@RestController
@RequestMapping("/guitars")
@RequiredArgsConstructor
public class GuitarAdministrationController {
    @Autowired
    private WebGuitarMapper guitarMapper;

    @Autowired
    private AdministrationUseCase administrationUseCase;

    @GetMapping(value = "/{guitarId}")
    public ResponseEntity<?> getGuitarById(@PathVariable Long guitarId) {
        Guitar guitar = administrationUseCase.getGuitarById(guitarId);
        return ResponseEntity.ok(guitarMapper.toGetDetailedDTO(guitar));
    }

    @GetMapping
    public ResponseEntity<?> getAllGuitars() {
        Collection<Guitar> guitars = administrationUseCase.getAllGuitars();
        return ResponseEntity.ok(guitarMapper.toGetDetailedDTOList(guitars));
    }

    @GetMapping(value = "/available")
    public ResponseEntity<?> getAvailableGuitars() {
        Collection<Guitar> guitars = administrationUseCase.getAvailableGuitars();
        return ResponseEntity.ok(guitarMapper.toGetSimpleDTOList(guitars));
    }

    @PostMapping
    public ResponseEntity<?> addGuitar(@RequestBody CreateGuitarDTO guitarDTO) {
        Guitar guitar = guitarMapper.toDomain(guitarDTO);
        Guitar addedGuitar = administrationUseCase.addGuitar(guitar);
        return ResponseEntity.ok(guitarMapper.toGetDetailedDTO(addedGuitar));
    }

    @PutMapping(value = "/{guitarId}")
    public ResponseEntity<?> updateGuitar(@PathVariable Long guitarId, @RequestBody CreateGuitarDTO guitarDTO) {
        Guitar guitar = guitarMapper.toDomain(guitarDTO);
        Guitar updatedGuitar = administrationUseCase.updateGuitar(guitarId, guitar);
        return ResponseEntity.ok(guitarMapper.toGetDetailedDTO(updatedGuitar));
    }

    @DeleteMapping(value = "/{guitarId}")
    public ResponseEntity<?> deleteGuitar(@PathVariable Long guitarId) {
        administrationUseCase.deleteGuitar(guitarId);
        return ResponseEntity.ok("Guitar deleted successfully");
    }
}

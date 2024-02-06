package ubb.demo.adapter.in.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ubb.demo.adapter.in.web.dto.CreateGuitarDTO;
import ubb.demo.adapter.in.web.dto.GetDetailedGuitarDTO;
import ubb.demo.adapter.in.web.dto.GetSimpleGuitarDTO;
import ubb.demo.adapter.in.web.mapper.WebGuitarMapper;
import ubb.demo.application.domain.model.Guitar;
import ubb.demo.application.port.in.AdministrationUseCase;
import ubb.demo.common.WebAdapter;

import java.util.Collection;


@WebAdapter
@RestController
@RequestMapping("/guitars")
public class GuitarAdministrationController {
    @Autowired
    private WebGuitarMapper guitarMapper;

    @Autowired
    private AdministrationUseCase administrationUseCase;

    @GetMapping(value = "/{guitarId}")
    public GetDetailedGuitarDTO getGuitarById(@PathVariable Long guitarId) {
        Guitar guitar = administrationUseCase.getGuitarById(guitarId);
        return guitarMapper.toGetDetailedDTO(guitar);
    }

    @GetMapping
    public Collection<GetDetailedGuitarDTO> getAllGuitars() {
        Collection<Guitar> guitars = administrationUseCase.getAllGuitars();
        return guitarMapper.toGetDetailedDTOList(guitars);
    }

    @GetMapping(value = "/available")
    public Collection<GetSimpleGuitarDTO> getAvailableGuitars() {
        Collection<Guitar> guitars = administrationUseCase.getAvailableGuitars();
        return guitarMapper.toGetSimpleDTOList(guitars);
    }

    @PostMapping
    public GetDetailedGuitarDTO addGuitar(@RequestBody CreateGuitarDTO guitarDTO) {
        Guitar guitar = guitarMapper.toDomain(guitarDTO);
        Guitar addedGuitar = administrationUseCase.addGuitar(guitar);
        return guitarMapper.toGetDetailedDTO(addedGuitar);
    }

    @PutMapping(value = "/{guitarId}")
    public GetDetailedGuitarDTO updateGuitar(@PathVariable Long guitarId, @RequestBody CreateGuitarDTO guitarDTO) {
        Guitar guitar = guitarMapper.toDomain(guitarDTO);
        Guitar updatedGuitar = administrationUseCase.updateGuitar(guitarId, guitar);
        return guitarMapper.toGetDetailedDTO(updatedGuitar);
    }

    @DeleteMapping(value = "/{guitarId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuitar(@PathVariable Long guitarId) {
        administrationUseCase.deleteGuitar(guitarId);
    }
}

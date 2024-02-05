package ubb.demo.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ubb.demo.application.domain.model.Guitar;
import ubb.demo.application.port.in.RestockGuitarUseCase;
import ubb.demo.common.WebAdapter;

@WebAdapter
@RestController
@RequestMapping("/restock")
@RequiredArgsConstructor
public class RestockGuitarController {
    @Autowired
    private WebGuitarMapper guitarMapper;
    @Autowired
    private RestockGuitarUseCase restockGuitarUseCase;

    @PutMapping("/{guitarId}")
    public ResponseEntity<?> restockGuitar(@PathVariable Long guitarId) {
        Guitar restockedGuitar = restockGuitarUseCase.restockGuitar(guitarId);
        return ResponseEntity.ok(guitarMapper.toGetDetailedDTO(restockedGuitar));
    }
}

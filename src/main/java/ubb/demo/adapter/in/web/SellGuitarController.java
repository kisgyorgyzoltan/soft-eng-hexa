package ubb.demo.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ubb.demo.application.domain.model.Guitar;
import ubb.demo.application.port.in.SellGuitarUseCase;
import ubb.demo.common.WebAdapter;

@WebAdapter
@RestController
@RequestMapping("/sell")
@RequiredArgsConstructor
public class SellGuitarController {

    @Autowired
    private SellGuitarUseCase sellGuitarUseCase;

    @Autowired
    private WebGuitarMapper guitarMapper;

    @PutMapping("/{guitarId}")
    ResponseEntity<?> sellGuitar(@PathVariable Long guitarId) {
        Guitar soldGuitar = sellGuitarUseCase.sellGuitar(guitarId);
        return ResponseEntity.ok(guitarMapper.toGetDetailedDTO(soldGuitar));
    }
}

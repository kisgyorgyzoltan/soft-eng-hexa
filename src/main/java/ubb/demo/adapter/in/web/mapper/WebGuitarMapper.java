package ubb.demo.adapter.in.web.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import ubb.demo.adapter.in.web.dto.CreateGuitarDTO;
import ubb.demo.adapter.in.web.dto.GetDetailedGuitarDTO;
import ubb.demo.adapter.in.web.dto.GetSimpleGuitarDTO;
import ubb.demo.application.domain.model.Guitar;

import java.util.Collection;


@Mapper(componentModel = "spring")
public interface WebGuitarMapper {
    GetDetailedGuitarDTO toGetDetailedDTO(Guitar guitar);

    GetSimpleGuitarDTO toGetSimpleDTO(Guitar guitar);

    Guitar toDomain(GetDetailedGuitarDTO getDetailedGuitarDTO);

    Guitar toDomain(GetSimpleGuitarDTO getSimpleGuitarDTO);

    Guitar toDomain(CreateGuitarDTO createGuitarDTO);

    @IterableMapping(elementTargetType = GetDetailedGuitarDTO.class)
    Collection<GetDetailedGuitarDTO> toGetDetailedDTOList(Collection<Guitar> guitars);

    @IterableMapping(elementTargetType = GetSimpleGuitarDTO.class)
    Collection<GetSimpleGuitarDTO> toGetSimpleDTOList(Collection<Guitar> guitars);
}

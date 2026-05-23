package com.morcineck.agendadortarefas.business.mapper;


import com.morcineck.agendadortarefas.business.dto.TarefasDTO;
import com.morcineck.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}

package com.morcineck.agendadortarefas.business;

import com.morcineck.agendadortarefas.business.dto.TarefasDTO;
import com.morcineck.agendadortarefas.business.mapper.TarefasConverter;
import com.morcineck.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.morcineck.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.morcineck.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.morcineck.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravaTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.pendente);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }

}

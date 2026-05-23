package com.morcineck.agendadortarefas.controller;

import com.morcineck.agendadortarefas.business.TarefasService;
import com.morcineck.agendadortarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestHeader("Authorization") String toke){
        return ResponseEntity.ok(tarefasService.gravaTarefa(toke, dto));
    }
}

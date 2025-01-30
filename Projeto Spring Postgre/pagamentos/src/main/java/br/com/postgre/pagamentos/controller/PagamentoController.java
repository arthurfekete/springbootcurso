package br.com.postgre.pagamentos.controller;

import br.com.postgre.pagamentos.dto.PagamentoDto;
import br.com.postgre.pagamentos.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor

public class PagamentoController {
    private final PagamentoService service;

    @GetMapping
    public List<PagamentoDto> listar(){
        return service.getAll();
    }
}

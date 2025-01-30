package br.com.postgre.pagamentos.controller;

import br.com.postgre.pagamentos.dto.PagamentoDto;
import br.com.postgre.pagamentos.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor

public class PagamentoController {
    private final PagamentoService service;

    @GetMapping // Listagem dos pagamentos
    public List<PagamentoDto> listar(){
        return service.getAll();
    }

    @GetMapping("/{id}") // Buscar por Id pelo @PathVariable
    public ResponseEntity<PagamentoDto> BuscarPorId(@PathVariable @NotNull Long id){
        PagamentoDto dto = service.getByID(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping // Cadastrar novos pagamentos
    public ResponseEntity<PagamentoDto> cadastrar (@RequestBody @Valid PagamentoDto dto, UriComponentsBuilder uriBuilder){
        PagamentoDto pagamento = service.createPayment(dto);
        var uri = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();

        return ResponseEntity.created(uri).body(pagamento);
    }

    @PostMapping // Atualizar o registro dos pagamentos
    public ResponseEntity<PagamentoDto> atualizarRegistro (@PathVariable @NotNull Long id, @RequestBody @Valid PagamentoDto dto){
        PagamentoDto pagamentoAtualizado = service.updatePayment(id, dto);
        return ResponseEntity.ok(pagamentoAtualizado);
    }

    @DeleteMapping("/{id}") // Deletar os pagamentos pelo id
    public ResponseEntity<PagamentoDto> deletarRegistro (@PathVariable @NotNull Long id){
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}

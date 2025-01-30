package br.com.postgre.pagamentos.service;

import br.com.postgre.pagamentos.dto.PagamentoDto;
import br.com.postgre.pagamentos.model.Pagamento;
import br.com.postgre.pagamentos.model.Status;
import br.com.postgre.pagamentos.repository.PagamentosRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentosRepository repository;

    private final ModelMapper modelMapper;

    public List<PagamentoDto> getAll() {
        return repository.findAll().stream().map(p -> modelMapper.map(p, PagamentoDto.class)).collect(Collectors.toList());
    }

    public PagamentoDto getByID(Long Id) {
        Optional<Pagamento> optionalPagamento = repository.findById(Id);
        Pagamento pagamento = optionalPagamento.orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto createPayment(PagamentoDto dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto updatePayment(Long id, PagamentoDto dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        pagamento = repository.save(pagamento);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public void deletePayment(Long id) {
        repository.deleteById(id);
    }
}

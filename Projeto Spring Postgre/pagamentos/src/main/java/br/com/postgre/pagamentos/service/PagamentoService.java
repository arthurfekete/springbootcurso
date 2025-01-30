package br.com.postgre.pagamentos.service;

import br.com.postgre.pagamentos.dto.PagamentoDto;
import br.com.postgre.pagamentos.repository.PagamentosRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentosRepository repository;

    private final ModelMapper modelMapper;

    public List<PagamentoDto> getAll() {

    }
}

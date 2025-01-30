package br.com.postgre.pagamentos.repository;

import br.com.postgre.pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.postgre.pagamentos.model.Pagamento;

public interface PagamentosRepository extends JpaRepository<Pagamento, Long> {
}

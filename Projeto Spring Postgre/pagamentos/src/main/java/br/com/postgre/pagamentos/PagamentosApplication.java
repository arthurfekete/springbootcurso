package br.com.postgre.pagamentos;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PagamentosApplication {

	public static void main(String[] args) {
		// Carregar variáveis do .env
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		// Iniciar a aplicação Spring Boot
		SpringApplication.run(PagamentosApplication.class, args);
	}
}

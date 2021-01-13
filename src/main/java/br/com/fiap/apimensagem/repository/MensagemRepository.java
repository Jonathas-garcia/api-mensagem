package br.com.fiap.apimensagem.repository;

import br.com.fiap.apimensagem.model.Mensagem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MensagemRepository extends MongoRepository<Mensagem, String> {
}

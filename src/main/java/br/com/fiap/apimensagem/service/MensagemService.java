package br.com.fiap.apimensagem.service;

import br.com.fiap.apimensagem.model.Mensagem;

import java.util.List;

public interface MensagemService {

    List<Mensagem> findAll();

    Mensagem findById(String id);

    Mensagem create(Mensagem despesa);

    Mensagem update(Mensagem despesa);

    void delete(Mensagem despesa);

}

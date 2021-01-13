package br.com.fiap.apimensagem.service;

import br.com.fiap.apimensagem.model.Mensagem;
import br.com.fiap.apimensagem.repository.MensagemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MensagemServiceImpl implements MensagemService {

    private final MensagemRepository repository;

    public MensagemServiceImpl(MensagemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Mensagem> findAll() {
        return repository.findAll();
    }

    @Override
    public Mensagem findById(String id) {
        return getMensagemById(id);
    }

    @Override
    public Mensagem create(Mensagem msg) {
        return repository.save(msg);
    }

    @Override
    public Mensagem update(Mensagem msg) {
        return repository.save(msg);
    }

    @Override
    public void delete(Mensagem msg) {
        repository.delete(msg);
    }


    private Mensagem getMensagemById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}

package br.com.fiap.apimensagem.controller;


import br.com.fiap.apimensagem.model.Mensagem;
import br.com.fiap.apimensagem.service.MensagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("mensagens")
public class MensagemController {

    private final MensagemService service;

    public MensagemController(MensagemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Mensagem>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Mensagem> getById(@PathVariable String id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mensagem create(@RequestBody Mensagem mensagem) {
        return service.create(mensagem);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        Mensagem msg = new Mensagem();
        msg.setId(id);

        service.delete(msg);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mensagem update(@RequestBody Mensagem despesa, @PathVariable String id) {
        Mensagem updateMensagem = service.findById(id);
        updateMensagem.setText(despesa.getText() != null ? despesa.getText() : updateMensagem.getText());

        return service.update(updateMensagem);
    }
}

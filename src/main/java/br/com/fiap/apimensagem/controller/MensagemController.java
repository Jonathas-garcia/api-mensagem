package br.com.fiap.apimensagem.controller;


import br.com.fiap.apimensagem.model.Mensagem;
import br.com.fiap.apimensagem.model.ResponseModel;
import br.com.fiap.apimensagem.service.MensagemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.net.UnknownHostException;
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
    public ResponseEntity<ResponseModel> findAll() throws JsonProcessingException, UnknownHostException {

        ResponseModel response = new ResponseModel();
        response.getResponse().put("messages", service.findAll());
        response.getResponse().put("ServerHostName", Inet4Address.getLocalHost().getHostName());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseModel> getById(@PathVariable String id) throws JsonProcessingException, UnknownHostException {

        ResponseModel response = new ResponseModel();
        response.getResponse().put("message", service.findById(id));
        response.getResponse().put("ServerHostName", Inet4Address.getLocalHost().getHostName());

        return new ResponseEntity<>(response, HttpStatus.OK);
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

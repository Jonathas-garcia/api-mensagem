package br.com.fiap.apimensagem.model;

import java.util.HashMap;
import java.util.Map;

public class ResponseModel {

    private Map<String, Object> response;

    public ResponseModel() {
        this.response = new HashMap<>();
    }

    public Map<String, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<String, Object> response) {
        this.response = response;
    }
}

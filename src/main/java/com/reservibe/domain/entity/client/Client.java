package com.reservibe.domain.entity.client;

import com.reservibe.infra.model.client.ClientModel;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

public class Client {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String cpf;

    public Client(UUID id, String name, @Email String email, String phone, @CPF String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
    }

    public Client(ClientModel clientModel) {
        this(clientModel.getId(), clientModel.getName(), clientModel.getEmail(), clientModel.getPhone(), clientModel.getCpf());
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCpf() {
        return cpf;
    }

    public UUID getId() {
        return id;
    }
}

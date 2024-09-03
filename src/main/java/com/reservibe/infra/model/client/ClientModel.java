package com.reservibe.infra.model.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Entity
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String cpf;

    public ClientModel(String name, @Email String email, String phone, @CPF String cpf) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
    }

    public ClientModel() {

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

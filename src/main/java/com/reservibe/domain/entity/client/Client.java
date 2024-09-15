package com.reservibe.domain.entity.client;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public class Client {


    private String name;
    private String email;
    private String phone;
    private String cpf;

    public Client(String name, @Email String email, String phone, @CPF String cpf) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
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

}

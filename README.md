
# Reservibe

**Documentação do Sistema de Reserva e Avaliação de Restaurantes**

Este projeto faz parte de um curso de pós-graduação e tem como objetivo fornecer um sistema eficiente para **reserva de mesas** e **avaliação de restaurantes**. Os restaurantes podem gerenciar suas reservas e os usuários podem compartilhar suas experiências através de avaliações.

## Links Importantes

- [Swagger API Documentation](https://reservibe.onrender.com/swagger-ui/index.html#/)
- [Repositório GitHub](https://github.com/4adjt-group10/reservibe)

## Objetivo

O objetivo deste sistema é permitir que usuários realizem reservas e avaliem restaurantes, enquanto os restaurantes podem gerenciar suas reservas de maneira eficiente. Foi projetado para ser escalável e fornecer uma experiência otimizada tanto para os usuários quanto para os estabelecimentos.

## Funcionalidades

1. **Cadastro de Restaurantes**
    - Nome, localização, tipo de cozinha e horários de funcionamento.

2. **Reserva de Mesas**
    - Os usuários podem reservar mesas para datas e horários específicos.

3. **Avaliações e Comentários**
    - Após a visita, os usuários podem avaliar e comentar sobre o restaurante.

4. **Busca de Restaurantes**
    - Busca por nome, localização ou tipo de cozinha.

5. **Gerenciamento de Reservas**
    - Os restaurantes podem visualizar e atualizar o status das mesas e reservas.

## Arquitetura do Sistema

O sistema foi desenvolvido utilizando **Clean Architecture**, garantindo um código modular, escalável e de fácil manutenção.

### Design da API

A API RESTful possui endpoints para operações como:
## Passo a Passo de Uso das Rotas

1. **Cadastro de Restaurante**
    - Endpoint: `POST /restaurant/register`
    - Descrição: Registra um novo restaurante no sistema.
   #####
2. **Criação de Reserva**
    - Endpoint: `POST /reservation/create`
    - Descrição: Cria uma nova reserva para um restaurante.
   #####
3. **Buscar o ID da Reserva com ID do restaurante**
   - Endpoint: `GET /reservation/search/{restaurantId}`
   - Descrição: Buscar a Reserva com ID do restaurante.
   #####
4. **Confirmação de Reserva**
    - Endpoint: `PUT /reservation/management`
    - Descrição: Atualiza o status da reserva para CONFIRMED junto com o ID da Reserva, obtido no passo 3.
   #####
5. **Cadastro de Avaliação**
    - Endpoint: `POST /review/create`
    - Descrição: Permite que o usuário faça uma avaliação do restaurante. A reserva precisa estar com status CONFIRMED.
   #####
6. **Finalização de Reserva**
    - Endpoint: `PUT /reservation/management`
    - Descrição: Atualiza o status da reserva para FINISH ou CACELLED, liberando a mesa junto com o ID da Reserva, obtido no passo 3.
   #####
7. **Busca de Restaurantes**
    - Endpoint: `GET /restaurant/search/name/{name}`
    - Descrição: Busca restaurante por nome.
   #####
    - Endpoint: `GET /restaurant/search/cuisine/{cuisine}`
    - Descrição: Busca restaurante por tipo de cozinha.
   #####
    - Endpoint: `GET /restaurant/search/city/{city}`
    - Descrição: Busca restaurante por cidade.

## Qualidade de Software

1. **Testes Unitários**: Implementados com **TDD** usando JUnit, focados nas regras de negócio.

2. **Testes de Integração**: Verificam a comunicação entre camadas como controllers, adapters e repositories utilizando o Cucumber e Rest Assured para BDD.

3. **Testes de Carga**: Realizados com **JMeter**, garantem que o sistema suporta até 1.000 usuários simultâneos.

4. **Cobertura de Código**: Medida com **JaCoCo**, com cobertura de **73%** nos testes unitários.

## Ferramentas Utilizadas

- **Java Spring Boot**: Framework backend.
- **Cucumber**: Testes BDD.
- **JUnit**: Testes unitários.
- **JaCoCo**: Cobertura de código.
- **Docker**: Containerização.
- **PostgreSQL**: Banco de dados.
- **Render**: Plataforma de deploy na nuvem.

## Implementação na Nuvem

A aplicação foi implementada na plataforma **Render**, utilizando Docker para facilitar a portabilidade e configuração.

## Resultados dos Testes

1. **Testes Unitários**: Cobertura de 73%.
2. **Testes de Integração**: Sucesso completo.
3. **Testes de Carga**: Sistema suporta até 1.000 usuários simultâneos.

---
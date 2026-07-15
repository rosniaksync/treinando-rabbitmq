# Meus Microsserviços

Repositório com microsserviços que se comunicam de forma assíncrona utilizando **RabbitMQ**.

## Sobre

Este projeto é organizado como um monorepo, reunindo diferentes microsserviços que trocam mensagens entre si através de filas no RabbitMQ, permitindo processamento desacoplado e assíncrono.

## Microsserviços

- `/processamento` — responsável por processar os pedidos recebidos via fila
- `/pedido` — responsável por criar e gerenciar os pedidos

## Tecnologias

- Java + Spring Boot
- Spring AMQP (RabbitMQ)
- Maven

## Como funciona

1. O serviço `pedido` publica uma mensagem em uma fila do RabbitMQ.
2. O serviço `processamento` consome essa mensagem e realiza o processamento.
3. A comunicação entre os serviços acontece de forma assíncrona, sem chamadas diretas entre eles.

## Como rodar

Cada microsserviço possui seu próprio `pom.xml` e pode ser executado individualmente. É necessário ter uma instância do RabbitMQ rodando localmente ou configurada via variáveis de ambiente.

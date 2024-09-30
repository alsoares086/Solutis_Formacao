# Trabalhando com mensagens na fila SQS :computer:

## Descrição
Nesse trabalho eu irei explorar o Amazon SQS utilizando serviços como o localstack e a framework Spring Boot através de envio e recebimento de mensagens.

## Antes de começar
Será fundamental instalar no computador as seguintes ferramentas:
- Docker
- Amazon CLI
- Java Development Kit (JDK)
   * OBS: De preferência do 17 em diante
     
## Instalando e Iniciando o LocalStack

### Instalação
Você pode instalar o LocalStack de duas formas:

1. Acessando o site oficial do LocalStack para instruções completas de instalação [aqui](https://docs.localstack.cloud/getting-started/installation/).
   
2. Instalando diretamente via **pip**:

   ```
   pip install localstack
   ```
### Iniciação
Eu iniciei o localStack pelo **docker** :whale2:
   ```
   docker run --rm -it -p 4566:4566 -p 4571:4571 localstack/localstack
   ```
## Fila 
1. Criei uma fila chamada FilaTeste para o envio e o recebimento das mensagens através desse comando:
    ```
    aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name FilaTeste
    ```
2. Listei as filas por desencargo de consciência
   ```
   aws --endpoint-url=http://localhost:4566 sqs list-queues
   ```
![Fila](https://github.com/alsoares086/Solutis_Formacao/blob/main/Sqs/assets/fila.png)
## Resultados
Conforme o esperado, o código resultou no envio e no recebimento da mensagem com sucesso. Consegui compreender a gestão de mensagens e como , em prática, o serviço da AWS funciona, mesmo eu utilizando o localStack e rodando tudo localmente.

![Mensage Enviada](https://github.com/alsoares086/Solutis_Formacao/blob/main/Sqs/assets/mensagem_enviada.png)
![Mensagem Recebida](https://github.com/alsoares086/Solutis_Formacao/blob/main/Sqs/assets/mensagem_recebida.png)

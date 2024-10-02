# Trabalhando com Spring-Security :computer:

## Descrição
Nesse trabalho eu irei explorar o funcionamento do Spring-Security utilizando maven

## Antes de começar
Será fundamental instalar no computador as seguintes ferramentas:
- JRE (Utilizei a versão 8)
- Java Development Kit (Eu utilizei a versão 17)

### Rodando o código
O código pode ser encontrado no [aqui](https://docs.spring.io/spring-security/reference/servlet/getting-started.html)

Eu baixei o código e rodei utilizando o Visual Studio Code, após a conexão com o localhost ser estabelecida, tentei fazer login.


![login](https://github.com/alsoares086/Solutis_Formacao/blob/main/Spring-security/assets/Screenshot%202024-10-01%20151040.png)
![login1](https://github.com/alsoares086/Solutis_Formacao/blob/main/Spring-security/assets/Screenshot%202024-10-01%20150717.png)

## Outros Comandos
Utilizando o pequeno tutorial providenciado no link da ![Spring-Security](https://docs.spring.io/spring-security/reference/servlet/getting-started.html), eu rodei os comandos no terminal e obtive os seguintes resultados:
```
curl -i http://localhost:8080/some/path
HTTP/1.1 401
```
![result1](https://github.com/alsoares086/Solutis_Formacao/blob/main/Spring-security/assets/Screenshot%202024-10-02%20053913.png)

```
curl -i -u user:8e557245-73e2-4286-969a-ff57fe326336 http://localhost:8080/some/path
HTTP/1.1 404
```
![result2](https://github.com/alsoares086/Solutis_Formacao/blob/main/Spring-security/assets/Screenshot%202024-10-02%20053913.png)

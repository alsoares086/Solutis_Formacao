package com.sqs.Sqs;

import java.net.URI;
import java.util.List;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

public class SqsConsumer {

    private static final String QUEUE_URL = "http://localhost:4566/000000000000/FilaTeste";

    public static void main(String[] args) {

        // Cria o cliente SQS
        SqsClient sqsClient = SqsClient.builder()
                .region(Region.SA_EAST_1)
                .endpointOverride(URI.create("http://localhost:4566"))
                .build();

        // Recebe e processa mensagens
        receiveMessages(sqsClient);

        // Fecha o cliente
        sqsClient.close();
    }

    public static void receiveMessages(SqsClient sqsClient) {
        ReceiveMessageRequest receiveRequest = ReceiveMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .maxNumberOfMessages(5)
                .waitTimeSeconds(10) // Long polling
                .build();

        List<Message> messages = sqsClient.receiveMessage(receiveRequest).messages();

        for (Message message : messages) {
            System.out.println("Mensagem recebida: " + message.body());

            // Exclui a mensagem da fila após o processamento
            DeleteMessageRequest deleteRequest = DeleteMessageRequest.builder()
                    .queueUrl(QUEUE_URL)
                    .receiptHandle(message.receiptHandle())
                    .build();
            sqsClient.deleteMessage(deleteRequest);
        }
    }
}

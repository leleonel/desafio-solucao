package com.example.desafioitau.subscribers;

import com.example.desafioitau.event.Data;
import com.example.desafioitau.event.BankBalanceUpdateReceived;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BankBalanceConsultSubscriber {

    public Data getBankBalanceConsult(BankBalanceUpdateReceived bankBalanceUpdateReceived){
        Long idConta = bankBalanceUpdateReceived.getIdConta();

        /*RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://api/contas/%s/saldos", idConta);
        ResponseEntity<Data> response = restTemplate.getForEntity(url, Data.class);*/



        //To manually simulate json received.
        String json = "{\"data\": { \"saldo\": -200 }}";

        JsonElement je = JsonParser.parseString(json);

        JsonElement content = je.getAsJsonObject().get("data");

        System.out.println( content );

        Gson gson = new Gson();

        Data data = gson.fromJson(content, Data.class);
        /*return response.getBody();*/

        return data;

    }
}

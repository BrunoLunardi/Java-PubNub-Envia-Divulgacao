package pub_sub;

import com.google.gson.JsonObject;
import com.pubnub.api.*;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.models.consumer.PNPublishResult;
import com.pubnub.api.models.consumer.PNStatus;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Publisher {
	
    final String PubKey = "pub-c-29ffe5d9-2643-4b78-8bb3-29d9b066c99b";
    final String SubKey = "sub-c-55c41470-ead1-11e9-bdee-36080f78eb20";	
    final String channelName = "divulgacao";
    PubNub pubnub;
    JsonObject position = new JsonObject();
    
    //configurações para pubnub
    public Publisher() {
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setPublishKey(PubKey);
        pnConfiguration.setSubscribeKey(SubKey);
        
        pubnub = new PubNub(pnConfiguration);    	
    }
    
    public void publishMessage(String tipo_residencia, String valor, String municipio, 
    		String uf, String mensagem) {
    	
    	//valores que serão filtrados
    	Map<String, Object> meta = new HashMap<>();
    	meta.put("valor_minimo", valor);
    	meta.put("tipo_residencia", tipo_residencia);
    	meta.put("municipio", municipio);
    	meta.put("uf", uf);
    	//falta cidade e estado	
    	
        try {
            pubnub.publish().channel(channelName).meta(meta).message(mensagem).async(new PNCallback<PNPublishResult>() {
                @Override
                public void onResponse(PNPublishResult result, PNStatus status) {
                    // handle publish response
                }
            });
            pubnub.subscribe()
                    .channels(Arrays.asList(channelName)) // subscribe to channels
                    .withPresence() // also subscribe to related presence information
                    .execute();
        } catch (Exception e) {
            System.out.println("Erro na Configuração");
            e.printStackTrace();
        }    	
    	
    }

}


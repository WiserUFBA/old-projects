package br.ufba.dcc.wiser.smartufba.tatu.app.mqttlogger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;

class Mqtt implements MqttCallback {

    /**
     *
     */
    public static MongoClient mongo;
    public static DB db;
    public static DBCollection col;
    public static MqttClient cliente;
    public static MqttConnectOptions conOptions;

    public Mqtt() {

    }

    public static void main(String[] args) throws java.lang.Exception {
        new Mqtt().mqtt();
    }

    public void mqtt() {
        String server = "tcp://wisergroup.tk:8080";
        Mqtt.conOptions = new MqttConnectOptions();
        String senha = "boteco@wiser";
        char[] pass = senha.toCharArray();
        Mqtt.conOptions.setUserName("device");
        Mqtt.conOptions.setPassword(pass);
        try {
            Mqtt.cliente = new MqttClient(server, "wiser");
            cliente.connect(Mqtt.conOptions);
            cliente.subscribe("#");
            cliente.setCallback(this);
            System.out.println("conectado");
        } catch (Exception e) {
            System.out.println("erro ao conectar");
        }
        
    }

    @Override
    public void connectionLost(Throwable cause) {
    // TODO Auto-generated method stub

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        String valor = message.toString();
        if (valor.charAt(0) == 'P') {
            Mqtt.mongo = new MongoClient();
            Mqtt.db = mongo.getDB("sensores");
            Mqtt.col = db.getCollection(topic);
            BasicDBObject obj = new BasicDBObject();
            DateFormat formato = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
            Date data = new Date();
            valor = valor.substring(valor.indexOf('{'));
            System.out.println(valor);
            valor = "{\"OBJ\":\"" + valor + "\", \"ID\":\"" + topic + "\", \"DATE\":\"" + formato.format(data) + "\"}";
            obj.put("valor", valor);
            try {
                Mqtt.col.insert(obj);
            } catch (Exception e) {
                cliente.close();
            }
            System.out.println("success");
            Mqtt.mongo.close();
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
    // TODO Auto-generated method stub

    }

}

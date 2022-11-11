import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.security.auth.KafkaPrincipal;
import java.util.Properties;
import java.util.Random;
public class Producer {
    public static void main(String[] args) {
        KafkaProducer Producer;
        String broker = "localhost:9092";
        String topic = "kafka";
        Properties prop = new Properties();
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,broker);
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        Producer = new KafkaProducer(prop);
        Random rand = new Random();
        while (true){
            try{

                int dataToSend = rand.nextInt(1,10);
                String val = String.format("{'userid':6,'unit':"+dataToSend+"}");
                //String val = String.valueOf(dataToSend);
                Producer.send(new ProducerRecord(topic,val));
                Thread.sleep(10000);
            }
            catch (Exception e){
                System.out.println(e);
            }

        }



    }
}

import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
object KafkaProd extends App{
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val producer = new KafkaProducer[Integer, String](props)
  for(cnt <- Range(0, 1000)) {
    producer.send(new ProducerRecord[Integer, String] ("kafka_test","Message: "+cnt))
  }
  producer.close()
}

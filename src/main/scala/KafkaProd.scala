import java.util.Properties
import scala.io.Source
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object KafkaProd extends App{
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val producer = new KafkaProducer[Integer, String](props)

  for (line <- Source.fromFile("TheTimeMachine.txt").getLines()) {
    producer.send(new ProducerRecord[Integer, String] ("test",line))
  }
  producer.send(new ProducerRecord[Integer, String] ("test","****Completed!****"))
  producer.close()
}

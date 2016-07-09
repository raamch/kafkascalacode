import java.util.Properties

import org.apache.kafka.clients.consumer.KafkaConsumer


object KafkaCons extends App{
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val consumer = new KafkaConsumer[](props)

}

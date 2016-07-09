import java.util
import java.util.Properties
import collection.JavaConverters._
import org.apache.kafka.clients.consumer.{ConsumerRecords, KafkaConsumer}


object KafkaCons extends App{
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("group.id", "test")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

  val consumer = new KafkaConsumer[String, String] (props)
  consumer.subscribe(util.Arrays.asList("test"))
  while(true) {
    val records: ConsumerRecords[String, String] = consumer.poll(100)
    records.asScala.foreach(record => {
      println( record.value() + ":" + record.offset())
    })
  }
}
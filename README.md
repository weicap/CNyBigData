# Trabajo_Final_CN

Integrantes Grupo 9:
- Christian Néstor Barriga Marcapura
- Weimar Ccapatina Huamani
- Abel Eberth Ojeda Mamani
- Roger Gutiérrez Espinoza

link video: https://drive.google.com/file/d/1urlkgQplRXUEL_2pAsArCE5bcrT92AzU/view?usp=sharing
#
Instalar y arrancar Kafka
Descargar y descomprimir Kafka de la URL https://kafka.apache.org/. Este es todo el proceso de instalación.

A partir de aquí hemos arrancado primero Zookeeper y después Kafka:

	<KAFKA_HOME>/bin/zookeeper-server-start.sh config/zookeeper.properties

	<KAFKA_HOME>/bin/kafka-server-start.sh config/server.properties

Creamos nuestros los topic:

	(Topic para mensajes manual 1)
	<KAFKA_HOME>/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test-stream-in
	(Topic para mensajes automàtico)
	<KAFKA_HOME>/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test-stream-out
	(Topic para mensajes manual 2)
	<KAFKA_HOME>/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test-stream-out2
	(Topic para mostrar longitud de cadena y cantidad de palabras por mensaje de todos los productores)
	<KAFKA_HOME>/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test-stream-out3
	(Topic para la salida de Wordcount)
	<KAFKA_HOME>/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test-stream

	
Después hemos comprobado que realmente ambos topics se han generado correctamente:

	<KAFKA_HOME>/bin/kafka-topics.sh --list --bootstrap-server localhost:9092
		test-stream
		test-stream-in
		test-stream-out
		test-stream-out2
		test-stream-out3

Nos conectamos al topic de entrada y nos suscribimos al de salida

	<KAFKA_HOME>/app1/index.js (Script para generar mensajes aleatorios)
	<KAFKA_HOME>/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test-stream-in
	<KAFKA_HOME>/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test-stream
	
	(Consumidor para los mensajes automaticos "index.js")
	<KAFKA_HOME>/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-stream-out --from-beginning
	<KAFKA_HOME>/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-stream-in --from-beginning
	<KAFKA_HOME>/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-stream-out2 --from-beginning
	<KAFKA_HOME>/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-stream-out3 --from-beginning \
	> --formatter kafka.tools.DefaultMessageFormatter \
	> --property print.key=true \
	> --property print.value=true \
	> --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer \
	> --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer


Arrancamos nuestro proyecto "index.js"
Arrancamos nuestro proyecto WCkafka1.java, kafka1.java


![Aquí la descripción de la imagen por si no carga](https://github.com/Christbm88/Trabajo_Final_CN/blob/main/img/Captura%20desde%202023-01-08%2013-51-08.png)

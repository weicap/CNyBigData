package mcc.kafkastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueStore;

public class kafka1 {

	public static void main(String[] args) {
	       Properties props = new Properties();
	        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "lostsys-kafka-sample");
	        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
	        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
	        
	        List<String> topics = Arrays.asList("test-stream-in", "test-stream","test-stream-out");
	        final StreamsBuilder builder = new StreamsBuilder();
	        final KStream<String, String> source = builder.stream(topics);
	        
	        source.flatMapValues(value -> {
	        	ArrayList<String> r=new ArrayList<String>();
	        			
	        	r.add("{ word: '"+value+"', length: "+value.length()+", words: "+value.split(" ").length+" }");
	        	return r;
	        	})
	                .to("test-stream-out4");

	        final KafkaStreams streams = new KafkaStreams(builder.build(), props);
	        streams.start();
		}	
	
	}
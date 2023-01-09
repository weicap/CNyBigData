const kafka = require('kafka-node');

const client = new kafka.KafkaClient({kafkaHost: '127.0.0.1:9092'});

/* Consumidor */
/*var consumer = new kafka.Consumer(client, [ { topic: 'test-stream-in' } ]);

consumer.on('message', function (message) {
    	console.log(message);
	});
*/
/* Productor */
var producer = new kafka.Producer(client);

producer.on('ready', function () {

	setInterval(function() {
  		producer.send( [ { topic: "test-stream-out", messages: "Mensaje automático cada 10 seg." } ], function (err,data) {} );
		}, 10000);


	});

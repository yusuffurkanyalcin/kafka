# How to run
- Clone this project to your local
- Go to the root path of this project --> /kafka
- Open docker desktop. Make sure that docker engine is running
- Make sure that all containers are running successfully
- Open terminal and run `docker-compose up -d`
- Open Postman or a similar tool
- Copy everything from `/kafka/resource/debezium_kafka_connect_config.json` file
- Send a POST request below URI with copied content above: </br>
  `http://localhost:8083/connectors/`
- Start kafka-producer, kafka-consumer and kafka-retry-service
- Go `http://localhost:9091/ui/clusters/local/brokers` via a browser
- Go `http://localhost:8001/?pgsql=db` --> password: example </br>
![image](https://github.com/user-attachments/assets/e04500a1-c3f9-4435-a66e-814ea0ee4a4e)


## References
- While developing this project, I took Furkan Sönmez's Kafka lesson as an example.
- Furkan's github: https://github.com/mrsonmez10
- Furkan's Kafka video: [https://www.youtube.com/watch?v=R4Qbngs_tKw](https://www.youtube.com/watch?v=R4Qbngs_tKw)

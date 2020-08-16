# spring-boot-rabbitMQ-demo

Run the Spring Boot Application
We send the message using the url - http://localhost:8080/javainuse-rabbitmq/direct/producer?exchangeName=direct-exchange&routingKey=admin&messageData=HelloWorldJavaInUse
we will be specifying the following
exchange name= "direct-exchange"
routing key ="admin"
message to sent to queue = "HelloWorldJavaInUse"

Run the Spring Boot Application
We send the message using the url - http://localhost:8080/javainuse-rabbitmq/fanout/producer?exchangeName=fanout-exchange&messageData=HelloWorldJavaInUse
exchange name= "fanout-exchange"
message to sent to queue = "HelloWorldJavaInUse"
We do not need to specify the routing key here as message is published to all the queues. The message is sent to the admin queue.We get the web

Run the Spring Boot Application
We send the message using the url - http://localhost:8080//javainuse-rabbitmq/topic/producer?exchangeName=topic-exchange&routingKey=queue.admin&messageData=HelloWorldJavaInUse
exchange name= "topic-exchange"
routing key ="queue.admin"
message to be sent to queue = "HelloWorldJavaInUse"


Run the Spring Boot Application
We send the message using the url - http://localhost:8080/javainuse-rabbitmq/header/producer?exchangeName=header-exchange&department=admin&messageData=HelloWorldJavaInUse
exchange name= "header-exchange"
header key ="admin"
message to be sent to queue = "HelloWorldJavaInUse"

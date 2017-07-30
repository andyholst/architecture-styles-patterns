# Monolithic Application

## Intent
Monolithic application describes a single-tiered software application in which the user interface and data access code 
are combined into a single program from a single platform. A monolithic application is self-contained, and independent 
from other computing applications. The design philosophy is that the application is responsible not just for a 
particular task, but can perform every step needed to complete a particular function.    

You are developing a server-side enterprise application. It must support a variety of different clients including 
desktop browsers, mobile browsers and native mobile applications. The application might also expose an API for 3rd 
parties to consume. It might also integrate with other applications via either web services or a message broker. 
The application handles requests (HTTP requests and messages) by executing business logic; accessing a database; 
exchanging messages with other systems; and returning a HTML/JSON/XML response. There are logical components 
corresponding to different functional areas of the application.     

## Applicability

* There is a team of developers working on the application
* New team members must quickly become productive
* The application must be easy to understand and modify
* You want to practice continuous deployment of the application
* You must run multiple copies of the application on multiple machines in order to satisfy scalability and 
availability requirements
* You want to take advantage of emerging technologies (frameworks, programming languages, etc)

## Reference
[Beginning Software Engineering](https://www.amazon.com/Beginning-Software-Engineering-Rod-Stephens/dp/1118969146/)

# JBoss Fuse POC For Bank Mega

## Demo AS400 (Version 1)

Demo Web Service to consume socket server using AS400 format.

### Installation

Install Packages
- camel-cxf-transport
- camel-cxf
- camel-servlet
- camel-jt400

Install bundle
```
mvn:com.bankmega.account/account-service/0.0.1
```

### Usage
SOAP WSDL: `http://localhost:9292/account?wsdl`

## Demo AS400 (Version 2)

Demo REST Service to consume socket server using AS400 format.

### Installation

Install Packages
- camel-netty4
- camel-restlet
- camel-jackson

Install bundle
```
mvn:com.bankmega/demo-as400/1.0.0
```

### Usage
REST Endpoint: `GET http://localhost:7890/inquiry`
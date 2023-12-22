## Building the docker compose image
```shell
chmod +x ./build.sh
./build.sh
```

### Sending  simple request to local producer
```
PUT http://localhost:9550/api/producer/simple
```

### Sending request reply to local producer
```
PUT http://localhost:9550/api/producer/simple/async
```

### Sending  simple request to docker producer
```
PUT http://localhost:19550/api/producer/simple
```

### Sending request reply to docker producer
```
PUT http://localhost:19550/api/producer/simple/async
```

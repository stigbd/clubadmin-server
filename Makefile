.PHONY: test
all: stop build run sleep test push

build:
	@echo "Building"
	mvn clean package

test:
	@echo "Testing"
	mvn verify

run:
	docker-compose --x-networking up -d

sleep:
	sleep 30

stop:
	docker-compose stop
	docker-compose rm -f

push:
	@echo "======= PUSHING CONTAINER ======\n"

clean:
	@echo "Cleaning"

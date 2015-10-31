.PHONY: test
all: stop build run test push

build:
	@echo "Building"
	mvn clean install

test:
	@echo "Testing"
	cd test && cucumber

run:
	docker-compose up -d
	sleep 30

stop:
	docker-compose stop
	docker-compose rm -f

push:
	@echo "======= PUSHING CONTAINER ======\n"

clean:
	@echo "Cleaning"

.PHONY: test
all: build test push

build:
	@echo "Building"
	mvn clean install

test:
	@echo "Testing"
	cd test && cucumber

run:
	docker-compose up -d

stop:
	docker-compose stop
	docker-compose rm -f

push:
	@echo "======= PUSHING CONTAINER ======\n"

clean:
	@echo "Cleaning"

.PHONY: test
all: build test push

build:
	@echo "Building"
	mvn clean install

test:
	@echo "Testing"
	cd test && cucumber

run-db:
	docker run -d -p 27017:27017 --name mongo mongo

run: run-db
	docker run  --name clubadmin-server --link mongo:mongo -v /home/sbd/src/stigbd/clubadmin-server/target:/target  -d -p 8080:8080 stigbd/clubadmin-server

stop-db:
	docker stop mongo
	docker rm mongo

stop: stop-db
	docker stop clubadmin-server
	docker rm clubadmin-server

push:
	@echo "======= PUSHING CONTAINER ======\n"

clean:
	@echo "Cleaning"

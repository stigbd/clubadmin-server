.PHONY: test
all: build test push

build:
	@echo "Building"
	mvn clean install

test:
	@echo "Testing"
	cd test && cucumber

run:
	docker run  --name clubadmin-server -v /home/sbd/src/stigbd/clubadmin-server/target:/target  -d -p 8080:8080 stigbd/clubadmin-server

stop:
	docker stop clubadmin-server
	docker rm clubadmin-server

push:
	@echo "======= PUSHING CONTAINER ======\n"

clean:
	@echo "Cleaning"

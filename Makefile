.PHONY: test
all: build test push

build:
	@echo "Building"

test:
	@echo "Testing"
	cd test && cucumber

push:
	@echo "======= PUSHING CONTAINER ======\n"

clean:
	@echo "Cleaning"

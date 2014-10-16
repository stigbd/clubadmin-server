.PHONY: test
all: build test push

build:
	@echo "Building"

test:
	@echo "Testing"

push:
	@echo "======= PUSHING CONTAINER ======\n"

clean:
	@echo "Cleaning"

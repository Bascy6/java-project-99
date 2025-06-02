build:
	gradle clean build

install:
	gradle installDist

test:
	gradle test

lint:
	gradle checkstyleMain

report:
	gradle jacocoTestReport

dev:
	gradle bootRun --args='--spring.profiles.active=dev'

prod:
	gradle bootRun --args='--spring.profiles.active=prod'

.PHONY: build

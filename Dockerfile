FROM alpine:latest

WORKDIR /usr/local/app

COPY ./target/iris-graal /usr/local/app

CMD ["./usr/local/app/iris-graal"]

## -*- docker-image-name: "clubadmin-server" -*-
# Clubadmin-server
#
# Version 1

FROM glassfish:latest

MAINTAINER Stig B. Dørmænen "stigbd@gmail.com"

COPY ./start.sh /

EXPOSE 8080

ENTRYPOINT ["/start.sh"]
FROM nginx:latest

# noop for legacy migration
RUN mkdir /app && \
    echo "#!/bin/bash" > /app/migrate.sh && \
    chmod +x /app/migrate.sh

COPY books-doker/ /usr/share/nginx/html
RUN ls /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf

VOLUME /usr/share/nginx/html
VOLUME /etc/nginx

EXPOSE 9080
CMD ["nginx", "-g", "daemon off;"]
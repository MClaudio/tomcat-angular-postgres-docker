FROM nginx:latest

# noop for legacy migration
RUN mkdir /app && \
    echo "#!/bin/bash" > /app/migrate.sh && \
    chmod +x /app/migrate.sh

COPY nginx.conf /etc/nginx/nginx.conf

VOLUME /usr/share/nginx/html
VOLUME /etc/nginx

EXPOSE 8000
CMD ["nginx", "-g", "daemon off;"]
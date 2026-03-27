# HTTPD Docker Task

## Problem Statement
Pull the Apache HTTP Server Docker image, run it in a container, modify the default web page from inside the container, verify the output on localhost, and then perform container cleanup.

## Step 1: Pull the HTTPD image

```bash
docker pull httpd
```

This command downloads the official Apache image from Docker Hub. If no tag is given, Docker uses the latest tag by default.

Observed result:
- Image pulled successfully: docker.io/library/httpd:latest
- Digest: sha256:331548c5249bdeced0f048bc2fb8c6b6427d2ec6508bed9c1fec6c57d0b27a60

## Step 2: Run container with port mapping

```bash
docker run -d --name my-apache -p 8080:80 httpd
```

This starts a container in detached mode.
- --name my-apache gives the container a readable name.
- -p 8080:80 maps host port 8080 to container port 80.

Observed result:
- Container started successfully and returned a container ID.

## Step 3: Update default Apache page

```bash
docker exec -it my-apache bash -c "echo '<h1>Hello from Docker Apache</h1>' > /usr/local/apache2/htdocs/index.html"
```

This runs a command inside the running container and replaces the default index.html with custom HTML content.

## Step 4: Verify webpage output

```bash
curl http://localhost:8080
```

This checks the running web server through host port 8080.

Observed output:

```html
<h1>Hello from Docker Apache</h1>
```

This confirms the containerized Apache server is working and serving the updated page.

## Step 5: Stop the container

```bash
docker stop my-apache
```

This gracefully stops the running container process.

Note:
- Your terminal showed docmy-apache, but standard output is typically my-apache.

## Step 6: Remove the container

```bash
docker rm my-apache
```

This removes the stopped container and frees local container resources.

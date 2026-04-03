## Basic commands used to create and manage Docker volumes
1. To create a Docker volume:
```bash
docker volume create <volume_name>
```
2. To list all Docker volumes:
```bash
docker volume ls
```
3. To inspect a Docker volume:
```bash
docker volume inspect <volume_name>
```
4. To run a container with a Docker volume:
```bash 
docker run -v <volume_name>:/path/in/container <image_name>
```
5. To run a container in detached mode with a Docker volume:
``` bash
docker run -dit --name <container_name> -v <volume_name>:/path/in/container <image_name>
```     
6. To access the container and list the contents of the mounted volume:
``` bash
docker exec -it <container_name> ls /app/data
```
7. To remove a Docker container forcefully:
```bash
docker container rm -f <container_name>
```
8. To remove a Docker volume:
```bash
docker volume rm <volume_name>
```
9. To remove all unused Docker volumes:
```bash
docker volume prune
```

## Docker command to remove the image forcefully
```bash
docker rmi -f <image_name>
```
This command forcefully removes the specified Docker image, even if it is being used by any containerars.

## Docker command to remove the container forcefully
```bash
docker rm -f <container_name>
```
This command forcefully removes the specified Docker container, even if it is currently running.
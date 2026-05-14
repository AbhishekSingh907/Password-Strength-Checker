# Command Task

## Problem Statement
How would you use the docker run command with -it, -e, -v, and --name to:

- Set an environment variable APP_ENV=prod
- Bind a local directory /app/data to /data inside the container
- Name the container my_app

## Command

```bash
docker run -it --name my_app -e APP_ENV=production -v /home/xyrix/Desktop/temp:/data ubuntu /bin/bash
```

## Basic Docker Commands

- `docker --version`: Checks the installed Docker version.
- `docker info`: Shows detailed Docker system information.
- `docker history nginx`: Displays the layer history of the `nginx` image.
- `docker images`: Lists all local Docker images with tags and sizes.

## Common `docker run` Options

- `-it`: Interactive mode (`-i` keeps STDIN open, `-t` allocates a TTY(Pseudo terminal)).
- `-d`: Detached mode (runs container in the background).
- `-p`: Port mapping (`host_port:container_port`).
- `--rm`: Automatically removes the container when it exits.
- `--name`: Assigns a custom container name.
- `-e`: Sets environment variables inside the container.
- `-v`: Mounts a volume for data persistence or sharing.

## Running a Simple Container

1. Run a basic command in a container:

	```bash
	docker run httpd echo "Hello, World"
	```

	This command runs the `httpd` image and executes `echo "Hello, World"`.

2. Run with a custom container name:

	```bash
	docker run --name my-container httpd echo "Hello, World!"
	```

	This command runs the `httpd` image, names the container `my-container`, and executes `echo "Hello, World!"`.



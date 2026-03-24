## What Are Environment Variables in Docker?
Environment variables are key-value pairs that can be passed to a container at runtime. They are used to:

- read configuration values,
- store secrets, and
- control application behavior.

Example:
```bash
docker run -e "ENV_VAR_NAME=value" nginx
```
This sets the environment variable `ENV_VAR_NAME` to `value` inside the container running the `nginx` image.

```bash
docker run -e APP_ENV=production -e APP_VERSION=1.0 nginx
```
This command sets two environment variables(example of multiple variables), `APP_ENV` and `APP_VERSION`, inside the container.

## Why Environment Variables Are Needed?

### Without `-e`
- Configuration must be hardcoded into the image, which makes it less flexible and reusable.
- You need to rebuild the image for every configuration change, which is time-consuming and inefficient.

### With `-e`
- The same image can behave differently based on environment variables, making it more flexible and reusable.
- Configuration becomes secure and flexible without rebuilding the image, saving time and resources.
- This approach is widely used in **microservices and cloud deployments** for dynamic configuration and secret management.

## Command for MySQL container
```bash
docker run -d -p 3306:3306 --name mysql-container -e MYSQL_ROOT_PASSWORD=my-secret-pw mysql:latest
```
This command runs a MySQL container in detached mode, maps port 3306, names the container `mysql-container`, and sets the root password to `my-secret-pw`.

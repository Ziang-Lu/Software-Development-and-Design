# Dev & Ops

## Docker

Check out the following to articles:

<https://zhuanlan.zhihu.com/p/23599229>

<https://zhuanlan.zhihu.com/p/47077536>

***

### About Docker volumes

**Problem**

During development, if we run the web application using Docker container by doing:

* Copy the application files to build an Docker image

  ```bash
  # Assumption: The current folder contains the Dockerfile to build the image.
  > docker build -t my-app-img .
  ```

* Instantiate the Docker image to create and run a Docker container

  ```bash
  > docker run -it -p 80:80 my-app-img
  ```

-> Then, <u>any subsequent changes we made to the application files won't reflect on the Docker container, which is inconvenient for development</u>.

**Solution: Docker volumes**

During development, we can <u>mount a directory on the host machine, to a directory in the Docker image file system</u>.

```bash
> docker run -p 80:80 -v /path/to/host/folder:path/to/image/folder my-app-img
```

*(This is like on the Docker image file system, the directory is just a <u>pointer</u> to a directory on the host machine.)*

-> So that <u>any changes we made to the application files will be reflected on the Docker container</u>, because the Docker container is actually seeing those application files on the host machine.

*Note: We just give the Docker container the ability to "see" a directory on the host machine, but the image itself is not changed. For deployment, we always need to rebuild the image with the updated application files.*

***


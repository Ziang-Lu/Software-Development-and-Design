# This is a sample Dockerfile to create an image of a Python Flask app.
# FROM <image>:<tag>
FROM python:2.7
LABEL maintainer="fake_email@gmail.com"
# COPY <src> <dest>
# Copy the current directory to "./app" directory in the container
COPY . /app
# Specify the working directory as "./app"
WORKDIR /app
# RUN adds one more layer to the original image.
# Install dependency packages
RUN pip install -r requirements.txt
# Expose port 5000
EXPOSE 5000
# When a container is run, start the app
ENTRYPOINT ["python"]
CMD ["app.py"]
# This is equivalent to "python app.py"

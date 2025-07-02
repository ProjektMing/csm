FROM ghcr.io/graalvm/graalvm-community:latest

# Set environment variables
ENV CATALINA_HOME /opt/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
ENV TOMCAT_VERSION=11

# Download and install Tomcat
RUN microdnf install -y tomcat

# Expose port
EXPOSE 8080

# Create volume for project mounting
VOLUME ["$CATALINA_HOME/webapps"]


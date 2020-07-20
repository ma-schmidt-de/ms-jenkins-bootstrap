# pull latest Jenkins docker image as base
FROM jenkins/jenkins:2.245-jdk11

# install docker in custom Jenkins docker
USER root
RUN curl -sSL https://get.docker.com/ | sh
RUN usermod -a -G docker jenkins
USER jenkins

# Install Node
RUN curl -sL https://deb.nodesource.com/setup_4.x | bash
RUN apt-get -y install nodejs
RUN node -v
RUN npm -v
RUN npm install -g newman

# install a set of Jenkins plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

# add seed job that genertates all other jobs / pipelines
COPY seedJob.xml /usr/share/jenkins/ref/jobs/seed-job/config.xml

# skip setup Jenkins wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
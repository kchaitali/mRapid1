FROM jenkins:1.609.1
MAINTAINER Chaitali Kanetkar

WORKDIR /mRapidMFToHadoop

# Copy the pom.xml into the container to install all dependencies
COPY pom.xml ./

# Copy the whole repository into the container
COPY . ./

#In the Dockerfile, add a local file using ADD
#ADD your-local.jar /some-container-location
ADD mRapidMFToHadoop/target/mRapidMFToHadoop-0.0.1-SNAPSHOT.jar D:\Jar

#You could use volumes to put a file in the container in runtime
VOLUME /mRapidMFToHadoop/myJar

EXPOSE 4567 
ENTRYPOINT ["java", "-jar", "target/mRapidMFToHadoop-0.0.1-SNAPSHOT.jar"]
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "target/mRapidMFToHadoop-0.0.1-SNAPSHOT.jar"]
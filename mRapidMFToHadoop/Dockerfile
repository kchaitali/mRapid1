FROM jenkins:1.609.1
MAINTAINER Chaitali Kanetkar

WORKDIR /mRapidMFToHadoop

# Copy the pom.xml into the container to install all dependencies
COPY pom.xml ./

# Copy the whole repository into the container
COPY . ./

#You could use volumes to put a file in the container in runtime
VOLUME /Jar

#In the Dockerfile, add a local file using ADD
ADD mRapidMFToHadoop-0.0.1-SNAPSHOT.jar mRapid.jar
#COPY mRapidMFToHadoop-0.0.1-SNAPSHOT.jar /

EXPOSE 4567 
#ENTRYPOINT ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "mRapidMFToHadoop-0.0.1-SNAPSHOT.jar"]
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "mRapid.jar"]
#CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "mRapidMFToHadoop-0.0.1-SNAPSHOT.jar"]
CMD ["D:\\Users\\ckanetka\\Desktop\\data\\cpybook_mf_ebcdic_data.txt","D:\\Users\\ckanetka\\Desktop\\data\\mf_ebcdic_data_file1.txt","D:\\Users\\ckanetka\\Desktop\\data\\mf.txt"]
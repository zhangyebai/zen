# springboot_jdk18 : centos latest with jdk1.8 for springboot project
FROM springboot_jdk18:V1.0
MAINTAINER zhangyebai
ADD zen.jar /opt/jar/
ENV JAVA_HOME /opt/jdk1.8.0_201
ENV PATH $JAVA_HOME/bin:$PATH
ENV CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
EXPOSE 8090
# CMD rm -f /opt/jar
CMD ["java", "-jar", "/opt/jar/zen.jar"]

FROM centos
#维护者
MAINTAINER kq
# 先 wget http://mirrors.163.com/.help/CentOS7-Base-163.repo
COPY CentOS7-Base-163.repo /etc/yum.repos.d

#构建
RUN mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.bak && yum install -y epel-release && yum makecache && mkdir /mytemp  \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

ADD jdk-8u144-linux-x64.tar.gz /usr/local
ADD apache-activemq-5.15.10-bin.tar.gz /usr/local

WORKDIR /usr/local

RUN mv jdk1.8.0_144 jdk8 && mv apache-activemq-5.15.10 activemq515

ENV JAVA_HOME /usr/local/jdk8
ENV ACTIVEMQ_HOME /usr/local/activemq515
ENV PATH $JAVA_HOME/bin:$PATH:$ACTIVEMQ_HOME/bin
ENV CLASSPATH .:$JAVA_HOME/lib

CMD sh activemq start && /bin/bash
EXPOSE 61616 8161

-------------------------------------------------------------------------------------------------
# 以下是缩减版

FROM centos
#维护者
MAINTAINER kq

ADD jdk-8u144-linux-x64.tar.gz /usr/local
ADD apache-activemq-5.15.10-bin.tar.gz /usr/local

WORKDIR /usr/local

ENV JAVA_HOME /usr/local/jdk1.8.0_144
ENV ACTIVEMQ_HOME /usr/local/apache-activemq-5.15.10
ENV PATH $JAVA_HOME/bin:$PATH:$ACTIVEMQ_HOME/bin
ENV CLASSPATH .:$JAVA_HOME/lib

CMD sh activemq start && /bin/bash
EXPOSE 61616 8161


------------------------------------------------------------------------------------------------------
FROM centos
#维护者
MAINTAINER kq

ADD jdk-8u144-linux-x64.tar.gz /usr/local
ADD apache-activemq-5.15.10-bin.tar.gz /usr/local
ADD start.sh /usr/local

WORKDIR /usr/local

ENV JAVA_HOME /usr/local/jdk1.8.0_144
ENV ACTIVEMQ_HOME /usr/local/apache-activemq-5.15.10
ENV PATH $JAVA_HOME/bin:$PATH:$ACTIVEMQ_HOME/bin
ENV CLASSPATH .:$JAVA_HOME/lib


EXPOSE 61616 8161

ENTRYPOINT ["sh","start.sh"]
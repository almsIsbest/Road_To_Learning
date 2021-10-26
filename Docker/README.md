# Docker



## 安装Docker

```shell
环境准备Ubuntu
```

```shell
环境查看
# 系统内核
root@alms-virtual-machine:/var/lib/docker# uname -r
5.11.0-38-generic
```

```shell
#系统版本
root@alms-virtual-machine:/var/lib/docker# cat /etc/os-release
NAME="Ubuntu"
VERSION="20.04.3 LTS (Focal Fossa)"
ID=ubuntu
ID_LIKE=debian
PRETTY_NAME="Ubuntu 20.04.3 LTS"
VERSION_ID="20.04"
HOME_URL="https://www.ubuntu.com/"
SUPPORT_URL="https://help.ubuntu.com/"
BUG_REPORT_URL="https://bugs.launchpad.net/ubuntu/"
PRIVACY_POLICY_URL="https://www.ubuntu.com/legal/terms-and-policies/privacy-policy"
VERSION_CODENAME=focal
UBUNTU_CODENAME=focal
```

> 安装

```shell
#帮助文档

#1.卸载旧的版本
sudo apt-get remove docker docker-engine docker.io containerd runc

#2.添加Docker官方的GPG密钥
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

#3 查看现在是否拥有了指纹
sudo apt-key fingerprint 0EBFCD88

#4 使用一下命令设置稳定存储库。
 echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
 
#5 安装Docker引擎
#5.1 更新源
sudo apt-get update
#5.2 安装引擎
sudo apt-get install docker-ce docker-ce-cli containerd.io

#6测试
 sudo docker run hello-world


```

## Docker相关命令

>命令

```shell
#查看docker中运行的所有容器
docker ps -a

#关闭容器
docker stop “容器号”


```



## 底层原理

### Docker是怎么工作的？

Docker是一个Client-Server结构的系统，Docker的守护进程运行在主机上。通过Socket从客户端访问！

DockerServer接收到Docker-Client的指令

![image-20211025113148003](C:\Users\Betta\AppData\Roaming\Typora\typora-user-images\image-20211025113148003.png)

### Docker为什么比VM快？

1、Docker有着比虚拟机更少的抽象层

2、Docker利用的是宿主机的内核，vm需要是Guest

![image-20211025113646994](C:\Users\Betta\AppData\Roaming\Typora\typora-user-images\image-20211025113646994.png)

# Docker的常用命令

## 帮助命令

```shell
docker version     	#显示docker的版本信息
docker info 		# 显示docker的系统信息
docker --help		#万能命令
```

## 镜像命令

```shell
docker images		#查看所有本地的主机上的镜像

alms@alms-virtual-machine:~$ docker images
REPOSITORY    TAG       IMAGE ID       CREATED       SIZE
hello-world   latest    feb5d9fea6a5   4 weeks ago   13.3kB

#解释
REPOSITORY  镜像的仓库
TAG			镜像的标签
IMAGE ID  	镜像的id
CREATED		镜像的创建时间
SIZE		镜像的大小
```

```shell
docker search  #搜索镜像

alms@alms-virtual-machine:~$ docker search mysql
NAME                              DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
mysql                             MySQL is a widely used, open-source relation…   11587     [OK]       
mariadb                           MariaDB Server is a high performing open sou…   4407      [OK]       
mysql/mysql-server                Optimized MySQL Server Docker images. Create…   856                  [OK]
centos/mysql-57-centos7           MySQL 5.7 SQL database server                   91                   
mysql/mysql-cluster               Experimental MySQL Cluster Docker images. Cr…   88                   
centurylink/mysql                 Image containing mysql. Optimized to be link…   59                   [OK]
databack/mysql-backup             Back up mysql databases to... anywhere!         51                   
prom/mysqld-exporter                                                              43                   [OK]
deitch/mysql-backup               REPLACED! Please use http://hub.docker.com/r…   41                   [OK]
tutum/mysql                       Base docker image to run a MySQL database se…   35                   
linuxserver/mysql                 A Mysql container, brought to you by LinuxSe…   33                   
schickling/mysql-backup-s3        Backup MySQL to S3 (supports periodic backup…   31                   [OK]
mysql/mysql-router                MySQL Router provides transparent routing be…   23                   

```


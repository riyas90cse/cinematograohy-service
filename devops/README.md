# Getting Started

### Run this one time setup
git clone https://github.com/riyas90cse/cinematography-service.git
cd devops
sudo chmod 755 docker_setup.sh

### Run this to build docker base image under (~/devops)
./docker_setup.sh

### Run this to up the services under (~/devops)
docker-compose build
docker-compose up -d

### Run this to stop the services under (~/devops)
docker-compose stop

### Run this to stop and remove the services under (~/devops)
docker-compose down -v

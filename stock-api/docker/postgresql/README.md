## run dockerfile
docker build -t postgresql .

## run container
docker run --rm -P --name postgresql postgresql

## connect to data base
psql -h 0.0.0.0 -p 32768 -d stock -U stock --password

docker run --rm -t -i --link postgresql:pg postgresql bash

- download openvpn

```
git clone https://github.com/kylemanna/docker-openvpn.git
```

- create a new docker image 

```
docker build -t myownvpn .
```

- create folder to store config file 

```
mkdir vpn-data && touch vpn-data/vars
```

- generate OpenVPN config file 
# CHANGE TO YOUR IP ADDRESS!!

```
docker run -v $PWD/vpn-data:/etc/openvpn --rm myownvpn ovpn_genconfig -u udp://IP_ADDRESS:3000
```

- init PKI and generate CA certificate

```
docker run -v $PWD/vpn-data:/etc/openvpn --rm -it myownvpn ovpn_initpki
```

- run the VPN 

```
docker run -v $PWD/vpn-data:/etc/openvpn -d -p 3000:1194/udp --cap-add=NET_ADMIN myownvpn
```

- create the VPN user

```
docker run -v $PWD/vpn-data:/etc/openvpn --rm -it myownvpn easyrsa build-client-full user1 nopass
```
- connect to vpn

```
sudo openvpn --config FILENAME
```
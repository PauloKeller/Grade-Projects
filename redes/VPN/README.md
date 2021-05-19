- install openvpn

```
sudo apt install openvpn curl
```

- download openvpn installer 

```
curl -O https://raw.githubusercontent.com/angristan/openvpn-install/master/openvpn-install.sh
chmod +x openvpn-install.sh
```

- install vpn server

```
sudo ./openvpn-install.sh
```

- for client 
```
sudo apt install openvpn networkmanager-openvpn-gnome
```

- send de vpn file from the server (.ovpn file)
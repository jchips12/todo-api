# Postgres SQL on WSL2

## Install
- `sudo apt update`
- `sudo apt install postgresql postgresql-contrib`
- `psql --version`

## Manage
- `sudo service postgresql status`
- `sudo service postgresql start`
- `sudo service postgresql stop`

## Get All Users
- `sudo -u postgres psql`
- `\du`
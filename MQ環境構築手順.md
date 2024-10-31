# MQ環境構築手順
#### イメージの取得
- GNU Makeのインストール
```
brew install make
```
- GitHubのClone
```
git clone https://github.com/ibm-messaging/mq-container.git
```
- Cloneしたフォルダに移動
```
cd mq-container
```
- イメージの取得
```
MQ_VERSION=9.4.0.0 make build-devserver
```
#### ボリュームの作成
```
podman volume create qm1data
```
#### コンテナの起動
```
podman run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --volume qm1data:/mnt/mqm --publish 1414:1414 --publish 9443:9443 --detach --env MQ_APP_USER=app --env MQ_APP_PASSWORD=passw0rd --env MQ_ADMIN_USER=admin --env MQ_ADMIN_PASSWORD=passw0rd --name QM1 localhost/ibm-mqadvanced-server-dev:9.4.0.0-arm64
```
#### （Option） コンソールへのアクセス
https://localhost:9443/ibmmq/console/
- ユーザー名：admin
- パスワード：passw0rd

### 参考資料
[Get an IBM MQ queue for development in a container](https://developer.ibm.com/tutorials/mq-connect-app-queue-manager-containers/)
# Db2環境構築手順
#### colimaの導入
- colimaとDockerのインストール
```
brew install colima docker
```
- colimaの起動
```
colima start --arch x86_64 --vm-type vz --vz-rosetta --mount-type virtiofs
```
- 起動確認
```
colima status
```
#### イメージを取得
```
docker pull icr.io/db2_community/db2
```
#### コンテナの作成
```
docker create --name db2test  \
--privileged=true -p 50000:50000 \
-e LICENSE=accept -e DB2INST1_PASSWORD=Passw0rd icr.io/db2_community/db2
```

### 参考資料
[M1 Mac上でcolimaを使ってDb2 Community Edition Docker イメージを動かす](https://qiita.com/nishikyon/items/553b5c4dff473d9b6322)
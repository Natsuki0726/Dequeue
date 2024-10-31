# MQとDb2を使用したアプリケーション
### コンテナ準備（初回のみ）
- [MQ環境構築手順](MQ環境構築手順.md)
- [Db2をDockerで動かす](Db2環境構築手順.md)

### データベースとテーブルの作成（初回のみ）
- [データベース・テーブル作成手順](データベース・テーブル作成手順.md)

### 実行手順
ディレクトリの移動
```
cd MQDb2Application
```
MQ・Db2コンテナの起動
```
./start.sh
```
ディレクトリの移動
```
cd Web1
```
アプリケーションの実行
- メッセージの格納
```
java -cp ./com.ibm.mq.allclient-9.3.0.0.jar:./javax.jms-api-2.0.1.jar:./json-20220320.jar:./db2jcc4.jar:. app
```
- メッセージの確認
```
java -cp ./com.ibm.mq.allclient-9.3.0.0.jar:./javax.jms-api-2.0.1.jar:./json-20220320.jar:./db2jcc4.jar:. check
```
コンテナの停止
```
cd ..
```
```
./stop.sh
```
### （Option）コンパイル
javaのコードを変更した場合は以下のコマンドでコンパイルしてください。
- app.java
```
javac -cp ./com.ibm.mq.allclient-9.3.0.0.jar:./javax.jms-api-2.0.1.jar:./json-20220320.jar:./db2jcc4.jar ./app.java
```
- check.java
```
javac -cp ./com.ibm.mq.allclient-9.3.0.0.jar:./javax.jms-api-2.0.1.jar:./json-20220320.jar:./db2jcc4.jar ./check.java
```
## 参考資料
- [IBM MQ Developer Essentials](https://developer.ibm.com/learningpaths/ibm-mq-badge/)
- [DB2に接続するサンプルプログラム](https://information-channel.officialblog.jp/archives/26619459.html)
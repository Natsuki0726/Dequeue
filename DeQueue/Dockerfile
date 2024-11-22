# ベースイメージを指定 (OpenJDK)
FROM openjdk:11-jre-slim

# 作業ディレクトリを設定
WORKDIR /app

# 必要なファイルをコピー
COPY app.class app.java com.ibm.mq.allclient-9.3.0.0.jar db2jcc4.jar javax.jms-api-2.0.1.jar json-20220320.jar ./

# 実行コマンドを指定
CMD ["java", "-cp", ".:com.ibm.mq.allclient-9.3.0.0.jar:db2jcc4.jar:javax.jms-api-2.0.1.jar:json-20220320.jar", "app"]
[![Deploy Status](https://github.com/kinoshita-daiki/my-portfolio-url-shortner-client/actions/workflows/deploy.yml/badge.svg)](https://github.com/kinoshita-daiki/my-portfolio-url-shortner-client/actions?query=workflow%3ADeploy)

[![CI Status](https://github.com/kinoshita-daiki/my-portfolio-url-shortner-client/actions/workflows/maven.yml/badge.svg)](https://github.com/kinoshita-daiki/my-portfolio-url-shortner-client/actions?query=workflow%3ACI)

[API Doc](https://kinoshita-daiki.github.io/my-portfolio-url-shortner-client/)

ポートフォリオとして作成した、URL短縮サイトのクライアントサーバ側のリポジトリです。<br>
バックエンドサーバ側は[こちらです](https://github.com/kinoshita-daiki/my-portfolio-url-shortner)

- [URL短縮サイト](#URL短縮サイト)
- [URL短縮の仕方](#URL短縮の仕方)
- [特徴](#特徴)
- [使用技術](#使用技術)

# URL短縮サイト
下記よりWebアプリをご利用ください。<br>
https://kinoshitadaiki.work/us/urlShortner

> [!NOTE]
> このWebアプリはポートフォリオとして作成されています。機能は簡素であることにご留意ください。

# URL短縮の仕方
1. 入力欄に短縮したいURLを入力します。
2. 変換ボタンを押下します。
3. 画面に短縮されたURLが表示されます。

# 特徴
REST APIを作成し、他アプリケーションからの呼び出しも可能にしています。<br>
プッシュされた場合、自動でコンパイル、テスト、テストレポートを出力するパイプラインを構築しています。<br>
また手動トリガーでパッケージの作成(RunnableJar)、サーバへの自動デプロイが可能です。

# 使用技術
- Java(17)
- Quarkus
	- JSON-P/JSON-B
	- JAX-RS
	- Qute
- Docker
- Maven
- lombok

その他については[pom.xml](https://github.com/kinoshita-daiki/my-portfolio-url-shortner/blob/main/pom.xml)を参照してください。

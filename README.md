Leap Motionを使って
指先の位置を描画したりしてみる。

Mac上で、ScalaとProcessingを利用。
Leap MotionのライブラリはMavenにないので、
SBTで自動解決はできないらしい。
SDKは、V2 Desktopというものを手動でダウンロードして、
libフォルダに配置すれば動いた。

Leap Motion公式からJava向けチュートリアルが出ている。
Leap Motionは「手の動きを取る」ことにフォーカスした
ガジェットなので、SDKはあまり複雑ではない。
英語だか、比較的簡単に読み解けるはず。

## 1 指先を検出して描画
このまま実行すると、指先だけ描画される。

## 2 カメラの画像を描画
実はLeap Motionのカメラ機能にもアクセスできる
（すごく歪んでいるが）。  
Main.scalaでCameraAppのコメントアウトを外せば
カメラも試せる。
負荷が高そうなので、フレームレートは毎秒1回に落とした。

## 実装時の注意
Listenerは、クラスのフィールドに持たせないとダメらしい。
ガベージコレクタに回収されるらしく、
実行時Javaが早々にクラッシュをする。  
当初、これにハマった。

## Reference
- [Hello World](https://developer.leapmotion.com/documentation/java/devguide/Sample_Tutorial.html)
- [SDKのダウンロード](https://developer-archive.leapmotion.com/v2)
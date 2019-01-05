Leap Motionで指先の位置を検出して描画。

Mac上で、ScalaとProcessingを利用。
Leap MotionのライブラリはMavenにないので、
SBTで自動解決はできないらしい。
SDKは、V2 Desktopというものを手動でダウンロードして、
libフォルダに配置すれば動いた。

Leap Motion公式からJava向けチュートリアルが出ている。
Leap Motionは「手の動きを取る」ことにフォーカスした
ガジェットなので、SDKはあまり複雑ではない。
英語だか、比較的簡単に読み解ける。
（なお、実はLeap Motionのカメラ機能にもアクセスできる）

なお、Listenerは、クラスのフィールドに持たせないとダメらしい。
ガベージコレクタにやられるらしく、
Javaが不可解なクラッシュをする。  
当初、これにハマった。

## Reference
- [Hello World](https://developer.leapmotion.com/documentation/java/devguide/Sample_Tutorial.html)
- [SDKのダウンロード](https://developer-archive.leapmotion.com/v2)
# RestTemplateTest
* RestTemplateで自作Factoryを使うテストプロジェクト  
  
springのデフォルトでは、javaが標準で持つURLConnectionを使用してコネクションを作成するが、  
URLConnectionでは、GETメソッドの場合に、ボディを設定しようとするとPOSTメソッドに変換して通信を行う。  
そのため、別のコネクションを作成するライブラリを使用する必要があり、Apache Http Clientを使用することで、実現可能。

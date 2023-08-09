## 爬虫
* **如何解决爬虫403问题？（经验题）**
爬虫403的异常通常为"java.io.IOException:Server returned HTTP response code: 403 for URL"。通常情况下这种问题分为以下两种：  
如果是服务端需要访问权限，那么需要提供授权信息。例如在URL中添加用户名或密码，或者使用OAuth2等认证方式。  
如果是服务端禁止抓去，因为有些网站会根据请求的User-Agent头部判断请求是否来自合法浏览器，那么可以通过设置User-Agent。  
* **如何最快速地从HTTP-URL中获取输入流并能够解析HTML源码？（代码题）**
new BufferReader(new InputStreamReader(new URL(String urlPath).openConnection().getInputStream())).readLine()
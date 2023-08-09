## 爬虫
* **如何最快速地从HTTP-URL中获取输入流并能够解析HTML源码？（代码题）**  
从输入流中逐行读取`new BufferReader(new InpuptStreamReader(new URL(new String(urlPath)).openConnection().getInputStream())).readLine()`。
* **如何解决爬虫403问题？（经验题）**  
爬虫403的异常通常为"java.io.IOException:Server returned HTTP response code: 403 for URL"。通常情况下这种问题分为以下两种：  
如果是服务端需要访问权限，那么需要提供授权信息。例如在URL中添加用户名或密码，或者使用OAuth2等认证方式。  
如果是服务端禁止抓去，因为有些网站会根据请求的User-Agent头部判断请求是否来自合法浏览器，那么可以通过设置User-Agent。  
* **java.net.URLConnection和java.net.HttpURLConnection有什么异同（）？**  
从继承关系上来说：  
`URLConnection`是一个抽象类，它是所有URL连接类型的基类，用于处理各种类型的URL连接而不局限于HTTP。  
`HttpURLConnection`是`URLConnection`的子类，它专门用于处理HTTP协议的URL，提供与HTTP协议相关的特定方法和功能。  
从使用范围上来说：  
`URLConnection`可以用于多种协议的连接，例如HTTP, FTP, FILE。  
`HTTPURLConnection`只能用于HTTP协议等连接，提供了更多欲HTTP相关的方法和属性。  
从功能特性上来说：  
`URLConnection`提供了基本的连接功能，可以获取输入流、输出流及一些基本的头信息。  
`HTTPURLConnection`在`URLConnection`的基础功能上还提供了更多的HTTP相关功能，例如设置请求方法、处理响应状态码、设置请求头、设置连接超时等。  
从默认行为上来说：  
`URLConnection`默认的连接实现是根据URL协议的不同而调用不同的子类。  
`HTTPURLConnection`默认情况下会自动执行**HTTP重定向**。  
总体来说，如果单独处理HTTP连接，或者执行HTTP连接的相关操作，如设置请求头、处理响应状态等，使用`HTTPURLConnection`更合适，如果需要处理多种协议等连接，或者更加通用的连接操作，最好使用`URLConnection`。  
* **什么是HTTP重定向？如何在爬虫中取消重定向？**  
HTTP Redirect（HTTP重定向）是一种在客户端发起请求时，服务器返回特定响应状态码和新的URL，用于将客户端Redirect到另一个URL的机制。通常用于网站的流量转发、访问控制、错误处理以及网站内容的移动。  
HTTP重定向可以用于多种情况，例如：  
1. 当网站更改了页面的URL结构时，旧的URL可能会重定向到新的URL，以确保用户可以找到所需的内容；  
2. 当某个资源被删除或被移动到其他位置时，可以通过重定向告知客户端新的位置；  
3. 当需要对用户进行身份验证或权限检查时，可以将用户重定向到登录页面。  
当客户端发起HTTP请求时，服务器可能会返回以下一些常见的HTTP重定向状态码：  
**301 (Moved Permanently)**: 表示所请求资源已永久移动至新的URL。客户端应当更新其链接并将所有未来请求发送到新的URL。  
**302 (Found)/303(See Other)**: 表示所请求的资源临时移动到新的URL，而303则是一种更严格的重定向方式，要求客户端使用GET请求新的URL。这两种状态码通常用于临时重定向。  
**307 (Temporary Redirect)**: 表示所请求的资源临时移动到新的URL，但是客户端应该保持原始请求的HTTP方法，即如果是POST请求，仍然要用POST请求新的URL。此状态码类似于302。  
**308 (Permanent Redirect)**: 表示所请求资源永久移动到新的URL，但是客户端应该抱池原始请求的HTTP方法。  
如果你需要关闭重定向，可以通过setInstanceFollowRedirects(false)
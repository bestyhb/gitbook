
> 在GitBook项目根目录下创建或编辑book.json。

### Plugin (插件)
``` JSON
"plugins": [
    "hide-element",
    "include-codeblock",
    "copy-code-button",
    "anchor-navigation-ex",
    "advanced-emoji",
    "emphasize"
]
```

### Configuration (插件配置)
* SUMMARY添加分级编号  
``` JSON
"pluginsConfig":{
    "theme-default":{
        "showLevel": true
    }
}
```
* SUMMARY隐藏Gitbook LOGO
``` JSON
"pluginsConfig":{
    "hide-element":{
        "elements":[".gitbook-link"]
    }
}
```
* Article代码块复制
``` JSON
"pluginsConfig":{
    "include-codeblock": {
        "template": "ace",
        "theme": "monokai"
    }
}
```


# mvn lifecycle
|   生命周期  | attention  |fafd|
|-------------------------|-----------------|----|
|   clean    | | 用于清理项目    |
|            |  pre-clean  |清理前|
|            |  clean      |清理|
|            |  post-clean |清理后|
|   default  | | 用于构建项目    |
|            |  validate   | 验证项目是否正确以及所有必要信息是否可用 |
|            |  initialize | 初始化构建状态 |
|            |  generate-sources | 生成编译阶段需要的所有源码文件 |
|            |  process-sources  | 生成项目打包阶段需要的资源文件 |


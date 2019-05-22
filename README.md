# modularization
组件化、Arouter

1、统一配置依赖 config.gradle ，并在根项目的build.gradle里面应用改配置
  apply from:'config.gradle'
在config中统一配置版本号，并且配置isModule变量的boolean值
根据配置的isModule的boolean值来判断是组件化集成，还是独立运行，true 是以组件化的形式集成 ，false代表独立运行

2、新建主工程module，app
新建基础类库library， commonlib
新建不同的业务模块module，如home，mine（而不是建库）

3、所有业务模块module依赖基类库
主工程app依赖所有的业务模块module

4、业务module配置独立运行的代码路径

5、业务module的build.gradle中需要配置的信息（红色部分）
if (isModule) {
    apply plugin: 'com.android.library'
} else {
    apply plugin: 'com.android.application'
}
android {
  
    compileSdkVersion rootProject.ext.android.compileSdkVersion
    defaultConfig {
        minSdkVersion rootProject.ext.android.minSdkVersion
        targetSdkVersion rootProject.ext.android.targetSdkVersion
        versionCode rootProject.ext.android.versionCode
        versionName rootProject.ext.android.versionName
  //配置资源命名前缀
        resourcePrefix "home_"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
        //独立运行时，需要定包名
        if(!isModule){
            applicationId rootProject.ext.appId["home"]
        }
 //arouter的配置项
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [AROUTER_MODULE_NAME: project.getName()]
            }
        }
    }

    //支持业务模块独立运行的资源配置
    sourceSets {
        main {
            //在组件模式下 使用不同的manifest文件
            if (isModule) {
                manifest.srcFile 'src/main/AndroidManifest.xml'
            } else {
                manifest.srcFile 'src/main/debug/AndroidManifest.xml'
                java.srcDirs 'src/main/debug/java', 'src/main/java'
                res.srcDirs 'src/main/debug/res', 'src/main/res'
            }
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])

    implementation rootProject.ext.dependencies.appcompatv7
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    //依赖基础库
    implementation project(':commonlib')
//必须在每一个业务模块中都依赖这个注解处理器，不然没办法解析aouter注解
    annotationProcessor rootProject.ext.dependencies["arouterProcessor"]

}

6、通过Arouter进行组件间通信
https://github.com/alibaba/ARouter

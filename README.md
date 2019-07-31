# KotlinMvp

## MVP+dagger2.android+LiveData

## 网络请求：RxJava2+Retrofit2+OkHttp

## 权限管理：RxPermission2

## ARouter框架模块间的路由，通信，解耦

生命周期相关：

1. 整个框架用Lifecycle管理生命周期，Activity与P层生命周期都是用Lifecycle自动管理，这样两者生命周期就同步了

2. 网络请求和RxJava操作的生命周期是用AutoDispose管理

3. dagger2生成的变量的生命周期，与整个APP生命周期同步即放在AppComponent中，与Activity生命周期同步即放在ActComponent中，
与Fragment生命周期同步即放在FragComponent中。比方说HttpReal(网络请求相关)，SpReal(sp操作相关),RouterReal(路由相关)等整
个APP都要用到，就放在AppComponent中获取


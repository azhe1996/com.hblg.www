# Game的实现

[TOC]

## 需求的分析/设计:

​	项目名:	 com.hblg.game

 1. 分析游戏需要的类及所在的包

    a) 游戏的窗体 		   GameFrame

    ​	游戏和画板			GamePanel 

    ​	自己的飞机			Flight

    ​	自己飞机的子弹	Bullet

    ​	敌机					   EnemyFlight

    ​	敌机的子弹		   EnemyBullet

    b)分包: 

    ​	实体类包.	com.hblg.entity

    ​	游戏包.		com.hglg.game

    ​	------------------------------------------

    ​	bean

    ​	service

    ​	serviceImpl

    ​	main(控制层)



## 代码的实现/测试:

1. 创建一个Gradle项目(项目中可以直接使用resources资源路径)
2. 从之前项目拷备窗体及画板的实现
3. 完成背景图的设置
   1. 可以使用满天星
      1. 创建出星星的类.
   2. 可以通过画图,让图形下落实现背景移动
4. 

## 项目的完成及总结:


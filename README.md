# Mayigushi-ResCleaner

## 优秀程序员的素质

- 懒
- 没耐心
- 骄傲

__不要和我比懒，我懒得和你比，└(^o^)┘__

## 概要

在android项目开发中，随着版本不断迭代，项目里难免会产生一些无用资源，如drawable-x/x.png、layout/x.xml等，无用的东东就应该清理掉，不需要理由。天性骄傲，一个个清没耐心，也懒得那么干，于是写了这个脚本。

## 设计目标

- 坚决干掉一切没用的资源
- 坚决不干掉一切我不想干掉无关有用无用的资源（设置白名单，因为项目有些资源文件并不是通过R引用的）

## 如何使用

1. 右键project－>Analyze->Run Inspection by Name->输入“Unuesed resources”->enter->export to xml
2. 替换AndroidLintUnusedResources.xml
3. run一把Cleaner
4. 赶紧休息

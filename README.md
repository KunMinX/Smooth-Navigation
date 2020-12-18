
# Smooth-Navigation

## 中文说明

提供安全可靠的 Navigation 操作，解决 GitHub 上开源的 "Navigation Add Hide 修改版" 普遍存在的 "popUpToInclusive 导致 Fragment 不符预期地加载" 等问题。

**使用方式：** 在 gradle 中添加 `com.kunminx.archi:smooth-navigation` 依赖，并将原有的 `androidx.navigation:navigation-fragment` 或修改版依赖 移除（否则在编译过程中会遭到原有依赖的覆盖）。

```groovy
implementation 'com.kunminx.archi:smooth-navigation:3.3.2-beta5'
```

如果使用 kotlin 拓展，那么在上述的基础上，添加如下依赖即可：

```groovy
implementation('androidx.navigation:navigation-fragment-ktx:2.3.2') {
    exclude group: 'androidx.navigation', module: "navigation-fragment"
}
```

## English Guide

Provides safe and reliable Navigation operations, and solves the common problem of "popUpToInclusive causing Fragment to load unexpectedly" in the open source "Navigation Add Hide modified version" on GitHub.

**How to use:** Add `com.kunminx.archi:smooth-navigation` dependency in gradle, and remove the original `androidx.navigation:navigation-fragment` or modified version dependency (otherwise the original Dependent coverage).

```groovy
implementation 'com.kunminx.archi:smooth-navigation:3.3.2-beta5'
```

If you use kotlin extension, then on the basis of the above, add the following dependencies:

```groovy
implementation('androidx.navigation:navigation-fragment-ktx:2.3.1') {
    exclude group: 'androidx.navigation', module: "navigation-fragment"
}
```

## License

```
Copyright 2019-present KunMinX

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
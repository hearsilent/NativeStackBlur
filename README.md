# NativeStackBlur
Android StackBlur with gradle support (only for the native method) https://github.com/kikoso/android-stackblur

As you may see, kikoso has not yet provided a way to add StackBlur as a gradle dependency easily. This library is an attempt to make the NativeBlurProcess availible through gradle without the need to import any modules or do any other configuration.

[![](https://jitpack.io/v/HearSilent/NativeStackBlur.svg)](https://jitpack.io/#HearSilent/NativeStackBlur)

# Gradle Dependency

Add this in your root `settings.gradle` file:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

Then, add the library to your project `build.gradle`
```gradle
dependencies {
    implementation 'com.github.HearSilent:NativeStackBlur:1.0.6'
}
```

This library is provided as a "fat" aar with native binaries for all available architectures. To
reduce your APK size, use the ABI filtering/splitting techniques in the Android plugin:
http://tools.android.com/tech-docs/new-build-system/user-guide/apk-splits

# Usage
Usage is similar to StackBlur, but also more streamlined:

```java
Bitmap bm = NativeStackBlur.process(source, blurRadius);
```

# Compiling
If you want to compile the original StackBlur lib for various reasons, such as adding more architecture support, simply pull down the original StackBlur repo, navigate to the StackBlur project folder (with the res and src folders). Delete the `x86` and other folders containing `.so` files. Also, remove the `<uses-sdk` block from the manifest. You will probably also get errors relating to LOCAL_SRC_FILES pointing to a missing file. Since we do not support Renderscript, just open up the `Android.mk` file and remove the `ifneq` block. Now, run `ndk-build`. This should output all the .so files you need within the /libs folder (ignoring the renderscript-v8.jar). This process works with commit cf19121553f50f346c48eabc7ebf04d27b074f17 of [android-stackblur](https://github.com/kikoso/android-stackblur)

License
--------

    MIT License

    Copyright (c) 2022 HearSilent

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.

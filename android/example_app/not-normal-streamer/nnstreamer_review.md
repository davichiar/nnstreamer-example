# NNStreamer Tutorial Review

## 2020.09.21.월 - 2020.09.27.일
```sh
nnstreamer setting
- https://github.com/nnstreamer/nnstreamer/blob/master/api/android/README.md
- https://github.com/nnstreamer/nnstreamer-example/blob/master/android/example_app/capi-sample/README.md

HOST PC
OS: Ubuntu 16.04 / 18.04 x86_64 LTS
Android Studio: Ubuntu version
Android SDK: Min version 24 (Nougat)
Android NDK: Use default ndk-bundle in Android Studio
GStreamer: gstreamer-1.0-android-universal-1.16.2
```

```sh
export JAVA_HOME=/opt/android-studio/jre            # JRE path in Android Studio
export ANDROID_DEV_ROOT=$HOME/android               # Set your own path (default location: "$HOME/Android".)

# $ANDROID_DEV_ROOT/tools/sdk/: Android SDK root directory (default location: $HOME/Android/Sdk)
# $ANDROID_DEV_ROOT/tools/ndk/: Android NDK root directory (default location: $HOME/Android/Sdk/ndk/<ndk-version>)
# $ANDROID_DEV_ROOT/gstreamer-1.0/: GStreamer binaries
# $ANDROID_DEV_ROOT/workspace/nnstreamer/: The git repository of NNStreamer

export ANDROID_SDK=$ANDROID_DEV_ROOT/tools/sdk
export ANDROID_NDK=$ANDROID_DEV_ROOT/tools/ndk
export ANDROID_SDK_ROOT=$ANDROID_SDK
export ANDROID_NDK_ROOT=$ANDROID_NDK
export GSTREAMER_ROOT_ANDROID=$ANDROID_DEV_ROOT/gstreamer-1.0
export NNSTREAMER_ROOT=$ANDROID_DEV_ROOT/workspace/nnstreamer
```

```sh
sudo apt install subversion curl pkg-config

https://developer.android.com/studio/install - android SDK install

cd $ANDROID_DEV_ROOT/workspace
git clone https://github.com/nnstreamer/nnstreamer-example.git

cd $ANDROID_DEV_ROOT/workspace/nnstreamer-example/android/example_app/common/jni
tar xJf ./extfiles.tar.xz
curl -O https://raw.githubusercontent.com/nnstreamer/nnstreamer-android-resource/master/external/tensorflow-lite-1.13.1.tar.xz
tar xJf ./tensorflow-lite-1.13.1.tar.xz # Check tensorflow-lite version and extract prebuilt library
ls ahc tensorflow-lite

cd $NNSTREAMER_ROOT/android_lib
cp nnstreamer-[DATE].aar $ANDROID_DEV_ROOT/workspace/nnstreamer-example/android/example_app/api-sample/libs

cd $NNSTREAMER_ROOT
bash ./api/android/build-android-lib.sh --enable_nnfw=yes --enable_snpe=yes

cd $NNSTREAMER_ROOT/android_lib
cp nnstreamer-native-[DATE].zip $ANDROID_DEV_ROOT/workspace/nnstreamer-example/android/example_app/capi-sample/src
cd $ANDROID_DEV_ROOT/workspace/nnstreamer-example/android/example_app/capi-sample/src
unzip nnstreamer-native-[DATE].zip
```

```sh
build script 수정

buildscript {
    repositories {
        jcenter() // or mavenCentral()
        mavenCentral()
        maven{url "https://maven.google.com"}
        google()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.5.1'
    }
}

- https://github.com/davichiar/nnstreamer-example/blob/master/android/example_app/not-normal-streamer/tutorial_review.md
implementation 추가
implementation 'org.nnsuite:nnstreamer:0.0.3'
```


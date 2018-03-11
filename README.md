### Example implementation of the NyTimes API, POC project

The main components used are:

- Kotlin
- Support libraries
- Databinding
- Architecture components
- Dagger
- Okio/OkHttp/Retrofit/Moshi
- PaperDb
- RxAndroid/RxJava
- Glide
- JUnit
- Robolectric

### Building

The project is using only standard android tools, nothing fancy. It can be opened and built with Android Studio 3.0.1 or later. Alternatively, the project can be built in terminal or command line as well.

To verify that everything builds and tests correctly, run the following:

```
./gradlew clean build
```

To run the tests separately:

```
./gradlew testDebug
```

To run the build of a debug version separately:

```
./gradlew assembleDebug
```

To install immediately after build:

```
./gradlew installDebug
```
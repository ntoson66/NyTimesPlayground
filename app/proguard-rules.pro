# Core
-keep class com.hdeva.nytimes.net.dto.** { *; }
-keep class com.hdeva.nytimes.net.converter.** { *; }
-keep class com.hdeva.nytimes.model.** { *; }

# Support library
-dontwarn android.support.**

# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# Miscellaneous
-dontwarn sun.misc.Unsafe
-dontwarn com.google.errorprone.**
-dontwarn java.lang.invoke.**
-dontwarn org.codehaus.mojo.**
-dontwarn java.nio.**
-dontwarn okio.**

plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.jetbrains.kotlin.android)
  `maven-publish`
}

android {
  namespace = "dev.mango.labs.logger"
  compileSdk = 36

  defaultConfig {
    minSdk = 23
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlin {
    compilerOptions {
      jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
  }
  publishing {
    singleVariant("release") {
      withSourcesJar()
    }
  }
}

dependencies {
  api(libs.androidx.annotation)
}

publishing {
  publications {
    register<MavenPublication>("release") {
      groupId = "dev.mango.labs"
      artifactId = "logger"
      version = providers.gradleProperty("LIB_VERSION").get()

      afterEvaluate {
        from(components["release"])
      }
    }
  }
  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/mango-labs-dev/logger-android")
      credentials {
        username = providers.gradleProperty("gpr.user").orElse(providers.environmentVariable("GITHUB_ACTOR")).getOrElse("")
        password = providers.gradleProperty("gpr.token").orElse(providers.environmentVariable("GITHUB_TOKEN")).getOrElse("")
      }
    }
  }
}

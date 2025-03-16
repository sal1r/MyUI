import org.gradle.api.JavaVersion

object Config {
    private val version = Version(0, 0, 1)
    val versionCode = version.major * 1_000_000 + version.minor * 1_000 + version.patch
    val versionName = "${version.major}.${version.minor}.${version.patch}"

    val compileSdk = 35

    val minSdk = 26
    val targetSdk = 35

    val sourceCompatibility = JavaVersion.VERSION_11
    val targetCompatibility = JavaVersion.VERSION_11

    val jvmTarget = "11"
}
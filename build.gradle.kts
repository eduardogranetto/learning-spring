import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "com.learning"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}


val junitJupiterVersion = "5.4.2"
val testContainerVersion = "1.14.3"
val restAssuredVersion = "4.3.0"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	
	testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
	testImplementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
	testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
	testImplementation("org.testcontainers:testcontainers:$testContainerVersion")
	testImplementation("org.testcontainers:junit-jupiter:$testContainerVersion")
	
	testImplementation("io.rest-assured:rest-assured-all:$restAssuredVersion")
	testImplementation("io.rest-assured:kotlin-extensions:$restAssuredVersion")
	testImplementation("io.rest-assured:json-schema-validator:$restAssuredVersion")
	testImplementation("io.rest-assured:spring-mock-mvc:$restAssuredVersion")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

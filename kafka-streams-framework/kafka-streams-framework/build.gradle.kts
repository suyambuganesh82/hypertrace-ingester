plugins {
    `java-library`
    jacoco
    id("org.hypertrace.publish-plugin")
    id("org.hypertrace.jacoco-report-plugin")
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    api(project(":kafka-streams-framework:kafka-streams-serdes"))
    api("org.apache.kafka:kafka-streams:5.5.1-ccs")
    api("com.typesafe:config:1.4.0")
    api("io.confluent:kafka-streams-avro-serde:5.5.0")
    implementation("org.hypertrace.core.serviceframework:platform-metrics:0.1.14")
    implementation("org.hypertrace.core.serviceframework:platform-service-framework:0.1.14")
    implementation("org.apache.kafka:kafka-clients:5.5.1-ccs")
    testImplementation("org.apache.kafka:kafka-streams-test-utils:5.5.1-ccs")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.mockito:mockito-core:3.6.0")
    testImplementation("org.hamcrest:hamcrest-core:1.3")
    constraints {
        implementation("com.google.guava:guava:30.0-jre") {
            because("https://snyk.io/vuln/SNYK-JAVA-COMGOOGLEGUAVA-1015415")
        }
        implementation("org.hibernate.validator:hibernate-validator:6.1.5.Final") {
            because("Cross-site Scripting (XSS) [Medium Severity][https://snyk.io/vuln/SNYK-JAVA-ORGHIBERNATEVALIDATOR-541187] in org.hibernate.validator:hibernate-validator@6.0.17.Final\n" +
                    "   introduced by io.confluent:kafka-avro-serializer@5.5.0 > io.confluent:kafka-schema-registry-client@5.5.0 > org.glassfish.jersey.ext:jersey-bean-validation@2.30 > org.hibernate.validator:hibernate-validator@6.0.17.Final")
        }
        implementation("org.yaml:snakeyaml:1.26") {
            because("Denial of Service (DoS) [Medium Severity][https://snyk.io/vuln/SNYK-JAVA-ORGYAML-537645] in org.yaml:snakeyaml@1.23\n" +
                    "   introduced by io.confluent:kafka-avro-serializer@5.5.0 > io.confluent:kafka-schema-registry-client@5.5.0 > io.swagger:swagger-core@1.5.3 > com.fasterxml.jackson.dataformat:jackson-dataformat-yaml@2.4.5 > org.yaml:snakeyaml@1.12")
        }
        implementation("org.glassfish.jersey.media:jersey-media-jaxb:2.31"){
            because("XML Entity Expansion [High Severity][https://snyk.io/vuln/SNYK-JAVA-ORGGLASSFISHJERSEYMEDIA-595972] in org.glassfish.jersey.media:jersey-media-jaxb@2.30\n" +
                    "    introduced by io.confluent:kafka-avro-serializer@5.5.0 > io.confluent:kafka-schema-registry-client@5.5.0 > org.glassfish.jersey.ext:jersey-bean-validation@2.30 > org.glassfish.jersey.core:jersey-server@2.30 > org.glassfish.jersey.media:jersey-media-jaxb@2.30");
        }
    }
}
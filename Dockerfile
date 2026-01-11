# 1. Start with a base OS that has Java installed(The Foundation)
FROM eclipse-temurin:17-jre-alpine
# 2.  Create a folder inside the box 
WORKDIR /app

# 3. Copy our built jar file form the "target" folder into the box
# (Note: We haven't built the jar yet,we will do that next)
COPY target/*.jar app.jar
# 4. Tell the box to open port 8080 so we can talk to it
EXPOSE 8080
# 5. The command to Run when the box opens
ENTRYPOINT [ "java", "-jar", "app.jar" ]
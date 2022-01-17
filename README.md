# Return of The Coder


# Build commands

```bash
# clean
mvn clean

# build
mvn install

# build skipping tests
mvn install -Dmaven.test.skip=true -Djacoco.skip=true

# start development server locally
mvn spring-boot:run

# swagger
http://localhost:9000/api/ui
```
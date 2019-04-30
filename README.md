This repository demonstrates a possible bug in Spring Framework, logged [here](https://github.com/spring-projects/spring-framework/issues/22857).

The project is a Spring Boot application providing a REST API. There is an abstract rest controller,
[AbstractRestController](./src/main/java/com/yg/springjacksonunwrapped/AbstractRestController.java) with two methods,
`handleUnnested` and `handleNested`. It is the latter that demonstrates the problem. There is a concrete subclass of
this rest controller, [UserRestController](./src/main/java/com/yg/springjacksonunwrapped/UserRestController.java),
with a method, `handleNestedInConcreteClass`, which shows that the issue doesn't occur when the method is implemented
in the concrete class.

There are three unit tests in [SpringJacksonUnwrappedApplicationTests](./src/test/java/com/yg/springjacksonunwrapped/SpringJacksonUnwrappedApplicationTests.java):
two of these pass, and one, `nestedHandledInAbstractClass`, fails.

Run the tests by running `./gradlew test` at the top level of the project.
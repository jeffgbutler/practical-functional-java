package exercises.basics.immutable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.stream.Collectors;

import org.junit.Test;

public class BasicImmutableTest {

//   @Test
//   public void testMissingFirstAndLastName() {
//       // should throw a NPE because required parameters are missing
//       assertThatExceptionOfType(NullPointerException.class).isThrownBy(() ->{
//           ImmutablePerson person = new ImmutablePerson.Builder()
//                   .build();
//           assertThat(person.getFirstName()).isNull();
//       });
//   }
//   
//   @Test
//   public void testMissingFirstName() {
//       // should throw a NPE because required parameters are missing
//       assertThatExceptionOfType(NullPointerException.class).isThrownBy(() ->{
//           ImmutablePerson person = new ImmutablePerson.Builder()
//                   .withLastName("Flintstone")
//                   .build();
//           assertThat(person.getFirstName()).isNull();
//       });
//   }
//
//   @Test
//   public void testMissingLastName() {
//       // should throw a NPE because required parameters are missing
//       assertThatExceptionOfType(NullPointerException.class).isThrownBy(() ->{
//           ImmutablePerson person = new ImmutablePerson.Builder()
//                   .withFirstName("Fred")
//                   .build();
//           assertThat(person.getLastName()).isNull();
//       });
//   }
//
//   @Test
//   public void testMinimalPerson() {
//       ImmutablePerson person = new ImmutablePerson.Builder()
//               .withFirstName("Fred")
//               .withLastName("Flintstone")
//               .build();
//       assertThat(person.getFirstName()).isEqualTo("Fred");
//       assertThat(person.getLastName()).isEqualTo("Flintstone");
//       assertThat(person.getMiddleName().isPresent()).isFalse();
//       assertThat(person.nickNames().count()).isEqualTo(0L);
//   }
//
//   @Test
//   public void testMiddleNameInBuilder() {
//       ImmutablePerson person = new ImmutablePerson.Builder()
//               .withFirstName("Fred")
//               .withMiddleName("Farnsworth")
//               .withLastName("Flintstone")
//               .build();
//       assertThat(person.getFirstName()).isEqualTo("Fred");
//       assertThat(person.getLastName()).isEqualTo("Flintstone");
//       assertThat(person.getMiddleName().get()).isEqualTo("Farnsworth");
//       assertThat(person.nickNames().count()).isEqualTo(0L);
//   }
//
//   @Test
//   public void testMiddleNameWithMethod() {
//       ImmutablePerson person = new ImmutablePerson.Builder()
//               .withFirstName("Fred")
//               .withLastName("Flintstone")
//               .build();
//       person = person.withMiddleName("Farnsworth");
//       assertThat(person.getFirstName()).isEqualTo("Fred");
//       assertThat(person.getLastName()).isEqualTo("Flintstone");
//       assertThat(person.getMiddleName().get()).isEqualTo("Farnsworth");
//       assertThat(person.nickNames().count()).isEqualTo(0L);
//   }
//
//   @Test
//   public void testMiddleNameInBuilderAndWithMethod() {
//       ImmutablePerson person = new ImmutablePerson.Builder()
//               .withFirstName("Fred")
//               .withMiddleName("Farnsworth")
//               .withLastName("Flintstone")
//               .build();
//       person = person.withMiddleName("Farnsworth");
//       assertThat(person.getFirstName()).isEqualTo("Fred");
//       assertThat(person.getLastName()).isEqualTo("Flintstone");
//       assertThat(person.getMiddleName().get()).isEqualTo("Farnsworth");
//       assertThat(person.nickNames().count()).isEqualTo(0L);
//   }
//
//   @Test
//   public void testNickNameInBuilder() {
//       ImmutablePerson person = new ImmutablePerson.Builder()
//               .withFirstName("Fred")
//               .withMiddleName("Farnsworth")
//               .withLastName("Flintstone")
//               .withNickName("Yabba Dabba Dude")
//               .build();
//       assertThat(person.getFirstName()).isEqualTo("Fred");
//       assertThat(person.getLastName()).isEqualTo("Flintstone");
//       assertThat(person.getMiddleName().get()).isEqualTo("Farnsworth");
//       assertThat(person.nickNames().collect(Collectors.joining())).isEqualTo("Yabba Dabba Dude");
//   }
//
//   @Test
//   public void testNickNameWithMethod() {
//       ImmutablePerson person = new ImmutablePerson.Builder()
//               .withFirstName("Fred")
//               .withMiddleName("Farnsworth")
//               .withLastName("Flintstone")
//               .build();
//       person = person.withNickName("Yabba Dabba Dude");
//       assertThat(person.getFirstName()).isEqualTo("Fred");
//       assertThat(person.getLastName()).isEqualTo("Flintstone");
//       assertThat(person.getMiddleName().get()).isEqualTo("Farnsworth");
//       assertThat(person.nickNames().collect(Collectors.joining())).isEqualTo("Yabba Dabba Dude");
//   }
}

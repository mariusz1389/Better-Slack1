//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertSame;
//
//public class InMemoryUserDatabaseTest {
//
//
//    private users.InMemoryUserDatabase userInMemoryDatabase;
//
//    @Before
//    public void setUp() {
//        users.InMemoryUserDatabase = new users.InMemoryUserDatabase();
//    }
//
//    @Test
//    public void addingOneUserShouldIncreaseTheAmountOfUsers() {
//        // Given
//        users.User user = new users.User("ASD", "sadasdas", "sad@asfaf.pl",
//                20, Sex.MALE);
//
//
//        // When
//        userInMemoryDatabase.add(user);
//
//        // Then
//        assertEquals(1, userInMemoryDatabase.getUsersCount());
//    }
//
//    @Test
//    public void addingOneUserShouldIncreaseTheAmountOfUsersNegative() {
//        // Given
//        userInMemoryDatabase = new UserInMemoryDatabase();
//        users.User user = new users.User("ASD", "sadasdas", "sad@asfaf.pl",
//                20, Sex.MALE);
//
//
//        // When
//        userInMemoryDatabase.add(user);
//
//        // Then
//        assertNotEquals(2, userInMemoryDatabase.getUsersCount());
//        assertFalse(userInMemoryDatabase.getUsersCount() != 1);
//    }
//
//    @Test
//    public void inMemoryDatabaseShouldInitiallyBeEmpty() {
//        // When
//        int currentUsersCount = userInMemoryDatabase.getUsersCount();
//
//        // Then
//        assertEquals(0, currentUsersCount);
//        assertFalse(userInMemoryDatabase.getUsersCount() != 0);
//    }
//
//    @Test
//    public void addingShouldNotBePossibleWhenTheUserIsNull() {
//        // Given
//        users.User user = null;
//
//        // When
//        userInMemoryDatabase.add(user);
//
//        // Then
//        assertEquals(0, userInMemoryDatabase.getUsersCount());
//    }
//
//    @Test
//    public void getByIdShouldReturnGivenUserByItsId() {
//        // Given
//        users.User user = new users.User("ASD", "sadasdas", "sad@asfaf.pl",
//                20, Sex.MALE);
//        userInMemoryDatabase.add(user);
//
//        // When
//        users.User returnedUser = userInMemoryDatabase.getById(user.getId());
//
//        // Then
//        assertSame(user, returnedUser);
//        assertEquals(user.getId(), returnedUser.getId());
//    }
//
//    @Test(expected = InvalidStateException.class)
//    public void ifTheresNoUserWithGivenIdExceptionShouldBeThrown() {
//        // Given
//        users.User user = new users.User("ASD", "sadasdas", "sad@asfaf.pl",
//                20, Sex.MALE);
//        userInMemoryDatabase.add(user);
//
//        // When
//        users.User returnedUser = userInMemoryDatabase.getById(UUID.randomUUID());
//
//        // Then
//        assertNull(returnedUser);
//    }
//}
//

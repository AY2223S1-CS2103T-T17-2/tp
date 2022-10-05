package seedu.address.model.food;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.food.exceptions.DuplicatePersonException;
import seedu.address.model.food.exceptions.PersonNotFoundException;
import seedu.address.testutil.PersonBuilder;

public class UniqueFoodListTest {

    private final UniqueFoodList uniqueFoodList = new UniqueFoodList();

    @Test
    public void contains_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFoodList.contains(null));
    }

    @Test
    public void contains_personNotInList_returnsFalse() {
        assertFalse(uniqueFoodList.contains(ALICE));
    }

    @Test
    public void contains_personInList_returnsTrue() {
        uniqueFoodList.add(ALICE);
        assertTrue(uniqueFoodList.contains(ALICE));
    }

    @Test
    public void contains_personWithSameIdentityFieldsInList_returnsTrue() {
        uniqueFoodList.add(ALICE);
        Food editedAlice = new PersonBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(uniqueFoodList.contains(editedAlice));
    }

    @Test
    public void add_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFoodList.add(null));
    }

    @Test
    public void add_duplicatePerson_throwsDuplicatePersonException() {
        uniqueFoodList.add(ALICE);
        assertThrows(DuplicatePersonException.class, () -> uniqueFoodList.add(ALICE));
    }

    @Test
    public void setPerson_nullTargetPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFoodList.setFoodItem(null, ALICE));
    }

    @Test
    public void setPerson_nullEditedPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFoodList.setFoodItem(ALICE, null));
    }

    @Test
    public void setPerson_targetPersonNotInList_throwsPersonNotFoundException() {
        assertThrows(PersonNotFoundException.class, () -> uniqueFoodList.setFoodItem(ALICE, ALICE));
    }

    @Test
    public void setPerson_editedPersonIsSamePerson_success() {
        uniqueFoodList.add(ALICE);
        uniqueFoodList.setFoodItem(ALICE, ALICE);
        UniqueFoodList expectedUniqueFoodList = new UniqueFoodList();
        expectedUniqueFoodList.add(ALICE);
        assertEquals(expectedUniqueFoodList, uniqueFoodList);
    }

    @Test
    public void setPerson_editedPersonHasSameIdentity_success() {
        uniqueFoodList.add(ALICE);
        Food editedAlice = new PersonBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
        uniqueFoodList.setFoodItem(ALICE, editedAlice);
        UniqueFoodList expectedUniqueFoodList = new UniqueFoodList();
        expectedUniqueFoodList.add(editedAlice);
        assertEquals(expectedUniqueFoodList, uniqueFoodList);
    }

    @Test
    public void setPerson_editedPersonHasDifferentIdentity_success() {
        uniqueFoodList.add(ALICE);
        uniqueFoodList.setFoodItem(ALICE, BOB);
        UniqueFoodList expectedUniqueFoodList = new UniqueFoodList();
        expectedUniqueFoodList.add(BOB);
        assertEquals(expectedUniqueFoodList, uniqueFoodList);
    }

    @Test
    public void setPerson_editedPersonHasNonUniqueIdentity_throwsDuplicatePersonException() {
        uniqueFoodList.add(ALICE);
        uniqueFoodList.add(BOB);
        assertThrows(DuplicatePersonException.class, () -> uniqueFoodList.setFoodItem(ALICE, BOB));
    }

    @Test
    public void remove_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFoodList.remove(null));
    }

    @Test
    public void remove_personDoesNotExist_throwsPersonNotFoundException() {
        assertThrows(PersonNotFoundException.class, () -> uniqueFoodList.remove(ALICE));
    }

    @Test
    public void remove_existingPerson_removesPerson() {
        uniqueFoodList.add(ALICE);
        uniqueFoodList.remove(ALICE);
        UniqueFoodList expectedUniqueFoodList = new UniqueFoodList();
        assertEquals(expectedUniqueFoodList, uniqueFoodList);
    }

    @Test
    public void setPersons_nullUniquePersonList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFoodList.setFoodItems((UniqueFoodList) null));
    }

    @Test
    public void setPersons_uniquePersonList_replacesOwnListWithProvidedUniquePersonList() {
        uniqueFoodList.add(ALICE);
        UniqueFoodList expectedUniqueFoodList = new UniqueFoodList();
        expectedUniqueFoodList.add(BOB);
        uniqueFoodList.setFoodItems(expectedUniqueFoodList);
        assertEquals(expectedUniqueFoodList, uniqueFoodList);
    }

    @Test
    public void setPersons_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFoodList.setFoodItems((List<Food>) null));
    }

    @Test
    public void setPersons_list_replacesOwnListWithProvidedList() {
        uniqueFoodList.add(ALICE);
        List<Food> foodList = Collections.singletonList(BOB);
        uniqueFoodList.setFoodItems(foodList);
        UniqueFoodList expectedUniqueFoodList = new UniqueFoodList();
        expectedUniqueFoodList.add(BOB);
        assertEquals(expectedUniqueFoodList, uniqueFoodList);
    }

    @Test
    public void setPersons_listWithDuplicatePersons_throwsDuplicatePersonException() {
        List<Food> listWithDuplicateFoods = Arrays.asList(ALICE, ALICE);
        assertThrows(DuplicatePersonException.class, () -> uniqueFoodList.setFoodItems(listWithDuplicateFoods));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueFoodList.asUnmodifiableObservableList().remove(0));
    }
}

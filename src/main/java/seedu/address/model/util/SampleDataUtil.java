package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Email;
import seedu.address.model.person.Food;
import seedu.address.model.person.MealType;
import seedu.address.model.person.Name;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Food[] getSamplePersons() {
        return new Food[] {
            new Food(new Name("Alex Yeoh"), new MealType("87438807"), new Email("alexyeoh@example.com"),
                getTagSet("friends")),
            new Food(new Name("Bernice Yu"), new MealType("99272758"), new Email("berniceyu@example.com"),
                getTagSet("colleagues", "friends")),
            new Food(new Name("Charlotte Oliveiro"), new MealType("93210283"), new Email("charlotte@example.com"),
                getTagSet("neighbours")),
            new Food(new Name("David Li"), new MealType("91031282"), new Email("lidavid@example.com"),
                getTagSet("family")),
            new Food(new Name("Irfan Ibrahim"), new MealType("92492021"), new Email("irfan@example.com"),
                getTagSet("classmates")),
            new Food(new Name("Roy Balakrishnan"), new MealType("92624417"), new Email("royb@example.com"),
                getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Food sampleFood : getSamplePersons()) {
            sampleAb.addPerson(sampleFood);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}

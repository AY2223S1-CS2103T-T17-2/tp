package seedu.nutrigoals.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.nutrigoals.model.meal.Food;
import seedu.nutrigoals.model.meal.UniqueFoodList;

/**
 * Wraps all data at the Nutrigoals level
 */
public class NutriGoals implements ReadOnlyNutriGoals {

    private final UniqueFoodList foods;
    private Calorie calorieTarget = new Calorie(); // defaults calorie to 2000 on the first edit to the book

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
    */ {
        foods = new UniqueFoodList();
    }

    public NutriGoals() {
    }

    /**
     * Creates NutriGoals using the Foods in the {@code toBeCopied}
     */
    public NutriGoals(ReadOnlyNutriGoals toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the food list with {@code foods}.
     */
    public void setFoods(List<Food> foods) {
        this.foods.setFood(foods);
    }

    /**
     * Resets the existing data of this {@code NutriGoals} with {@code newData}.
     */
    public void resetData(ReadOnlyNutriGoals newData) {
        requireNonNull(newData);
        setCalorieTarget(newData.getCalorieTarget());
        setFoods(newData.getFoodList());
    }

    //// food-level operations

    /**
     * Returns true if a food with the same name as {@code food} exists in the food list.
     */
    public boolean hasFood(Food food) {
        requireNonNull(food);
        return foods.contains(food);
    }

    /**
     * Adds a food item to the nutrigoals.
     */
    public void addFood(Food p) {
        foods.add(p);
    }

    /**
     * Replaces the given food {@code target} in the list with {@code editedFood}.
     * {@code target} must exist in the food list.
     */
    public void setFood(Food target, Food editedFood) {
        requireNonNull(editedFood);

        foods.setFood(target, editedFood);
    }

    /**
     * Removes {@code key} from this {@code NutriGoal}.
     * {@code key} must exist in the food list.
     */
    public void removeFood(Food key) {
        foods.remove(key);
    }

    public void setCalorieTarget(Calorie calorie) {
        requireNonNull(calorie);
        this.calorieTarget = calorie;
    }

    /**
     * @return Calorie
     */
    @Override
    public Calorie getCalorieTarget() {
        return this.calorieTarget;
    }

    //// util methods

    @Override
    public String toString() {
        return foods.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public ObservableList<Food> getFoodList() {
        return foods.asUnmodifiableObservableList();
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof NutriGoals // instanceof handles nulls
            && foods.equals(((NutriGoals) other).foods)
            && this.calorieTarget.equals(((NutriGoals) other).calorieTarget));
    }

    @Override
    public int hashCode() {
        return foods.hashCode();
    }
}

package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;

/**
 * Represents the date and time a Food was recorded.
 */
public class DateTime {
    private final LocalDateTime dateTime;

    /**
     * Constructs a {@code DateTime} at the current date and time.
     *
     */
    public DateTime() {
        dateTime = LocalDateTime.now();
    }

    /**
     * Constructs a {@code DateTime} at the given date and time.
     * @param dateTime A string representing the date and time.
     */
    public DateTime(String dateTime) {
        requireNonNull(dateTime);
        this.dateTime = LocalDateTime.parse(dateTime);
    }

    /**
     * Returns true if this {@code DateTime} represents a later time than the given {@code DateTime}.
     * @param otherDateTime The other {@code DateTime} to compare to.
     * @return True if this {@code DateTime} represents a later time than the given {@code DateTime}.
     */
    public boolean isAfter(DateTime otherDateTime) {
        return dateTime.isAfter(otherDateTime.dateTime);
    }


    /**
     * Checks if this {@code DateTime} was recorded on the same day as the given {@code DateTime}.
     * @param otherDateTime The other {@code DateTime} to compare to.
     * @return True if this {@code DateTime} was recorded on the same day as the given {@code DateTime}.
     */
    public boolean isOnSameDay(DateTime otherDateTime) {
        return dateTime.toLocalDate().isEqual(otherDateTime.dateTime.toLocalDate());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DateTime)) {
            return false;
        }
        return dateTime.equals(other);
    }

    @Override
    public String toString() {
        return dateTime.toString();
    }
}

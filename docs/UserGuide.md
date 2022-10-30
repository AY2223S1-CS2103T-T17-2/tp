---
layout: page
title: User Guide
---

NutriGoals is a desktop app that tracks a user’s diet and calorie consumption. Studies have shown the benefits of keeping track of your daily food consumption – the more consistent you are, the more likely you are to achieve the various fitness goals that you have set for yourself! However, without the right tools, tracking what you have consumed can be tedious and at times disorganised. With NutriGoals, you can keep track of your consumption quickly and easily, without worrying about organising your data.
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `nutrigoals.jar` from [here](https://github.com/AY2223S1-CS2103T-T17-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your NutriGoals.

4. Double-click the file to start the app. A screen similar to the below should appear in a few seconds. 
Note how the app contains some sample data.
![sampleUi](images/sampleUi.png)

5. Type the command in the command box and press Enter to execute it. For example, typing `help` and pressing Enter will open 
the help window.

6. Refer to the [Features](#features) below for details of each command.

<div markdown="block" class="alert alert-info">

:information_source: **Note:**<br>

For first-timer users, the app will contain sample data for these 3 days: 15 September 2022, 23 October 2022 and
the current day. For example, you can try entering `list 2022-09-15` to view the sample food items on 15 September 2022.
To delete food items from all days, enter `clear`.

</div>

<div markdown="block" class="alert alert-warning">

:exclamation: **Warning:**<br>

Upon launching the application, some files responsible for the storage of your data will be created in the same folder 
as `nutrigoals.jar`. Do not delete or edit these files. 

</div>

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Texts in UPPER_CASE are arguments provided by the user.
* Arguments in square brackets are optional.
* The `FOOD` parameter for commands `add`, `edit` and `find` can only take on alphanumeric values that contain at most 27 characters.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page and information about the commands usages.

![help message](images/helpMessage.png)

Format: `help`

### Adding the calorie content of a food item : `add`

Adds a food item with its calorie content.

Format: `add n/FOOD c/CALORIE t/MEAL_TYPE`

* Adds a food item into the food list for the current day, together with its calorie content and meal type.
* Each field can only be specified once.
* `MEAL_TYPE` can only take on three values: breakfast, lunch or dinner (case-insensitive).

Example:

* `add n/bread c/100 t/breakfast` adds bread into the food list, and tags it as a breakfast item with 100 calories.
* `add n/bubble tea c/300 t/lunch` adds bubble tea into the food list, and tags it as a lunch item with 300 calories.
* `add n/hotpot c/500 t/dinner` adds hotpot into the food list, and tags it as a dinner item with 500 calories.

### Deleting a food item : `delete`

Removes a food item from the displayed list of foods.

Format: `delete INDEX`

* Deletes a food item at the specified index.
* The index **must be a positive** number.

Example:

* `delete 1` deletes the first item in the food list.
* `list 2022-10-23` followed by `delete 1` will delete the first food item on the list for 23 October 2022.

### Editing a food item : `edit`

Edits a food item from the displayed list of foods.

Format: `edit INDEX n/FOOD c/CALORIES t/MEAL_TYPE`

* Edits a food item in the list displayed at the specified index.
* The index refers to the index shown in the displayed food lists.
* The index **must be a positive** number.
* Either the `FOOD`, `CALORIES`, or `MEAL_TYPE` must be supplied.

Example:

* `edit 2 n/rice c/300 t/dinner` edits the 2nd food item for dinner to rice with 300 calories.
* `edit 2 n/noodles` edits the name of 2nd food item to noodles.
* `edit 2 c/100 n/bread` edits the name and calorie content of the first item to bread and 100 respectively.
* `list 2022-09-15` followed by `edit 1 n/sushi` will edit the name of the first food item on the list for 15 September 2022 to sushi.

### Listing all foods for a day: `list`

Shows a list of all food items and their respective calories for the specified day (if any).

Format: `list [DATE]`

* Food items will be listed according to meal type, in the order: breakfast, lunch, dinner.
* Shows the food list for the current day if no `DATE` is supplied.
* `DATE` must be in the format `yyyy-MM-dd` if supplied.

<div markdown="block" class="alert alert-info">

**:information_source: Note:**<br>

`DATE` must be a valid date for the command to be executed.

* E.g. `list 2022-02-31` is an invalid command.

</div>

Example:

* `list` shows a list of all food items and their calories for the current day.
* `list 2022-10-23` shows a list of all food items and their calories recorded on 23 October 2022.

### Finding the calorie content of a food item: `find`

Finds the calorie content of a food item.

Format: `find FOOD`

* Only the calorie contents of some food items are included. Refer to the list of food items [here](#food-items).
* If the user has entered a specific food item before, the `find` command will return the average calories of 
that specific food item that the user has specified.

Example:

* `find chicken rice` finds and displays the calorie content of chicken rice.

<div markdown="block" class="alert alert-info">

:information_source: **Note:**<br>

`FOOD` is case-insensitive.

* E.g. `find rice` is the same as find `rIcE`.

</div>

### Setting a target daily calorie intake: `target`

Sets a target calorie intake for the current day.

Format: `target CALORIE`

* `CALORIE` can only take on integer values.
* The initial target calorie intake is set at 2000 calories.
* The percentage for the progress bar display will be based on the target calorie intake. 

Example:

* `target 2500` sets a target calorie intake of 2500 calories for the day and displays the list of foods for the day.

### Viewing a summary of the daily calorie intake: `review`

Shows the total calories consumed, the calorie target and the deficient or excess amount of calories for the day. 
The list of foods for the day will also be displayed.

Format: `review`

Example after entering `review`:
![review](images/review.png)

### Setting up a user profile: `setup`

Sets up a user profile.

Format: `setup g/GENDER w/WEIGHT h/HEIGHT i/IDEAL_WEIGHT a/AGE`

* Sets up the user profile using the information provided by the user.
* `GENDER` can only take 2 values: M or F (case-insensitive).
* `WEIGHT` and `IDEAL_WEIGHT` can only take on integer values less than 200 (in kg).
* `HEIGHT` can only take on integer values less than 220 (in cm).
* `AGE` can only take on integer values (in years).

Example:

* `setup g/f w/50 h/165 i/48 a/20` sets up a user profile for a 20-year-old female who is 50kg and 165cm, 
with an ideal weight of 48kg.
* `setup g/m w/70 h/175 i/70 a/20` sets up a user profile for a 20-year-old male who is 70kg and 175cm,
with an ideal weight of 70kg.

### Viewing the user's profile: `profile`

Displays the user's information stored during setup.

Format: `profile`

* A user can only view his/her profile after setup. 

### Suggesting a daily calorie intake: `suggest`

Suggests an estimated daily calorie intake to allow the user to attain his/her ideal weight.

Format: `suggest`

* A user can only get an estimated suggested daily calorie intake after setup.

### Locating the nearest gym in NUS: `locate`

Locates and ranks the nearest gyms to user's location in NUS.

Format: `locate LOCATION`

Example:

* `locate S17` returns a list of gyms sorted from nearest to furthest from S17.

### Suggesting a healthy-lifestyle tip: `tip`

Suggests a random tip to help the user adopt a healthier lifestyle.

Format: `tip`

### Clearing all food items: `clear`

Clears all food items on all days from NutriGoals.

Format: `clear`

### Exiting the program: `exit`

Exits the program.

Format: `exit`

### Saving the data

NutriGoals data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

--------------------------------------------------------------------------------------------------------------------

## Food items

List of food items for the [find](#finding-the-calorie-content-of-a-food-item-find) feature:
* ban mian
* bubble tea
* chicken rice
* fried rice
* laksa
* nasi lemak
* potato chips
* rice
* wanton noodles
* white bread

_More food items coming soon in a future release..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous NutriGoals home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action      | Format                                                  | Example                          |
|-------------|---------------------------------------------------------|----------------------------------|
| **Help**    | `help`                                                  | `help`                           |
| **Add**     | `add n/FOOD c/CALORIE t/MEAL_TYPE`                      | `add n/donut c/1000 t/breakfast` |
| **Delete**  | `delete INDEX`                                          | `delete 1`                       |
| **Edit**    | `edit INDEX n/UPDATED_FOOD c/CALORIES t/MEAL_TYPE`      | `edit 2 n/rice c/300 t/dinner`   |
| **Find**    | `find FOOD`                                             | `find chicken rice`              |
| **Target**  | `target`                                                | `target 2000`                    |
| **Review**  | `review`                                                | `review`                         |
| **List**    | `list [DATE]`                                           | `list`                           |
| **Setup**   | `setup g/GENDER w/WEIGHT h/HEIGHT i/IDEAL_WEIGHT a/AGE` | `setup g/m w/70 h/175 i/70 a/20` |
| **Profile** | `profile`                                               | `profile`                        |
| **Suggest** | `suggest`                                               | `suggest`                        |
| **Tip**     | `tip`                                                   | `tip`                            |
| **Clear**   | `clear`                                                 | `clear`                          |
| **Exit**    | `exit`                                                  | `exit`                           |

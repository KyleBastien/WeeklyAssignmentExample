package com.example.ad340kylebastienweeklyassignments;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.ad340kylebastienweeklyassignments.RecyclerViewMatcher.withRecyclerView;

import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SettingsScreenTest {
    @Rule
    public ActivityScenarioRule<WelcomeScreen> welcomeScreenActivity =
            new ActivityScenarioRule<>(WelcomeScreen.class);

    @Test
    public void canSaveSettings() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.select_matches_time_button)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName())))
                .perform(PickerActions.setTime(10, 0));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).perform(replaceText("50"));

        onView(withId(R.id.radio_he_him)).perform(click());

        onView(withId(R.id.radio_privacy)).perform(click());

        onView(withId(R.id.age_range_slider)).perform(HelpersViewMatcher.setValue(25.0F, 35.0F));

        onView(withId(R.id.saveButton)).perform(click());

        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.matches_menu_item)).perform(click());
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).check(matches(withText("50")));
    }

    @Test
    public void canSaveWithSheHer() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.select_matches_time_button)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName())))
                .perform(PickerActions.setTime(10, 0));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).perform(replaceText("50"));

        onView(withId(R.id.radio_she_her)).perform(click());

        onView(withId(R.id.radio_privacy)).perform(click());

        onView(withId(R.id.age_range_slider)).perform(HelpersViewMatcher.setValue(25.0F, 35.0F));

        onView(withId(R.id.saveButton)).perform(click());

        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.matches_menu_item)).perform(click());
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).check(matches(withText("50")));
    }

    @Test
    public void canSaveWithTheyThem() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.select_matches_time_button)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName())))
                .perform(PickerActions.setTime(10, 0));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).perform(replaceText("50"));

        onView(withId(R.id.radio_they_them)).perform(click());

        onView(withId(R.id.radio_privacy)).perform(click());

        onView(withId(R.id.age_range_slider)).perform(HelpersViewMatcher.setValue(25.0F, 35.0F));

        onView(withId(R.id.saveButton)).perform(click());

        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.matches_menu_item)).perform(click());
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).check(matches(withText("50")));
    }

    @Test
    public void canSaveWithNoAnswer() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.select_matches_time_button)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName())))
                .perform(PickerActions.setTime(10, 0));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).perform(replaceText("50"));

        onView(withId(R.id.radio_no_answer)).perform(click());

        onView(withId(R.id.radio_privacy)).perform(click());

        onView(withId(R.id.age_range_slider)).perform(HelpersViewMatcher.setValue(25.0F, 35.0F));

        onView(withId(R.id.saveButton)).perform(click());

        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.matches_menu_item)).perform(click());
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).check(matches(withText("50")));
    }

    @Test
    public void canSaveWithPublic() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.select_matches_time_button)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName())))
                .perform(PickerActions.setTime(10, 0));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).perform(replaceText("50"));

        onView(withId(R.id.radio_he_him)).perform(click());

        onView(withId(R.id.radio_public)).perform(click());

        onView(withId(R.id.radio_privacy)).perform(click());

        onView(withId(R.id.age_range_slider)).perform(HelpersViewMatcher.setValue(25.0F, 35.0F));

        onView(withId(R.id.saveButton)).perform(click());

        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.matches_menu_item)).perform(click());
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).check(matches(withText("50")));
    }

    @Test
    public void cannotSaveWithMissingTime() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).perform(replaceText(""));

        onView(withId(R.id.saveButton)).perform(click());

        onView(withId(R.id.edit_text_distance_in_miles)).check(matches(withText("")));
    }
}
